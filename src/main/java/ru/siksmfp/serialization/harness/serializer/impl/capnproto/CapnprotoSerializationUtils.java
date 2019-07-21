package ru.siksmfp.serialization.harness.serializer.impl.capnproto;

import org.capnproto.DecodeException;
import org.capnproto.MessageBuilder;
import org.capnproto.MessageReader;
import org.capnproto.ReaderOptions;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class CapnprotoSerializationUtils {

    public static byte[] write(MessageBuilder message) {
        ByteBuffer[] segments = message.getSegmentsForOutput();
        int tableSize = (segments.length + 2) & (~1);

        ByteBuffer table = ByteBuffer.allocate(4 * tableSize);
        table.order(ByteOrder.LITTLE_ENDIAN);

        table.putInt(0, segments.length - 1);
        int messageSize = 0;

        for (int i = 0; i < segments.length; ++i) {
            int segmentLimit = segments[i].limit();
            table.putInt(4 * (i + 1), segmentLimit / 8);
            messageSize += segmentLimit;
        }

        messageSize += table.limit();

        // Any padding is already zeroed.
        int messageOffset = 0;
        byte[] serializedMessage = new byte[messageSize];

        for (int i = 0; i < table.limit(); i++) {
            serializedMessage[messageOffset] = table.get(i);
            messageOffset++;
        }

        for (ByteBuffer buffer : segments) {
            for (int i = 0; i < buffer.limit(); i++) {
                serializedMessage[messageOffset] = buffer.get(i);
                messageOffset++;
            }
        }
        return serializedMessage;
    }

    public static MessageReader read(byte[] bc) {
        ReaderOptions options = ReaderOptions.DEFAULT_READER_OPTIONS;
        int offsetB = 8;
        int segmentCount = 1 + bc[0];

        int segment0Size = 0;
        if (segmentCount > 0) {
            segment0Size = bc[4];
        }

        int totalWords = segment0Size;

        // in words
        int[] moreSizes;
        int sizeOffset = 0;

        if (segmentCount > 1) {
            offsetB += 4 * (segmentCount & ~1);
            moreSizes = new int[segmentCount - 1];
            for (int ii = 0; ii < segmentCount - 1; ++ii) {
                int size = bc[(ii * 4) + offsetB];
                moreSizes[sizeOffset++] = size;
                totalWords += size;
            }
        } else {
            moreSizes = new int[0];
        }

        if (totalWords > options.traversalLimitInWords) {
            throw new DecodeException("Message size exceeds traversal limit.");
        }

        ByteBuffer allSegments = makeByteBuffer(totalWords * 8);
        fillBuffer(allSegments, bc, offsetB);

        ByteBuffer[] segmentSlices = new ByteBuffer[segmentCount];

        allSegments.rewind();
        segmentSlices[0] = allSegments.slice();
        segmentSlices[0].limit(segment0Size * 8);
        segmentSlices[0].order(ByteOrder.LITTLE_ENDIAN);

        int offset = segment0Size;
        for (int ii = 1; ii < segmentCount; ++ii) {
            allSegments.position(offset * 8);
            segmentSlices[ii] = allSegments.slice();
            segmentSlices[ii].limit(moreSizes[ii - 1] * 8);
            segmentSlices[ii].order(ByteOrder.LITTLE_ENDIAN);
            offset += moreSizes[ii - 1];
        }

        return new MessageReader(segmentSlices, options);
    }

    private static int fillBuffer(ByteBuffer buffer, byte[] array, int offset) {
        final int offSetSize = offset + buffer.limit();
        for (int i = offset; i < offSetSize; i++) {
            buffer.put(array[i]);
        }
        return offSetSize;
    }

    private static ByteBuffer makeByteBuffer(int bytes) {
        ByteBuffer result = ByteBuffer.allocate(bytes);
        result.order(ByteOrder.LITTLE_ENDIAN);
        result.mark();
        return result;
    }
}
