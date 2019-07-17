/* Generated SBE (Simple Binary Encoding) message codec */
package ru.siksmfp.serialization.harness.model.sbe;

import org.agrona.MutableDirectBuffer;
import org.agrona.DirectBuffer;

/**
 * User model
 */
@SuppressWarnings("all")
public class UserEncoder
{
    public static final int BLOCK_LENGTH = 208;
    public static final int TEMPLATE_ID = 1;
    public static final int SCHEMA_ID = 1;
    public static final int SCHEMA_VERSION = 1;
    public static final java.nio.ByteOrder BYTE_ORDER = java.nio.ByteOrder.LITTLE_ENDIAN;

    private final UserEncoder parentMessage = this;
    private MutableDirectBuffer buffer;
    protected int offset;
    protected int limit;

    public int sbeBlockLength()
    {
        return BLOCK_LENGTH;
    }

    public int sbeTemplateId()
    {
        return TEMPLATE_ID;
    }

    public int sbeSchemaId()
    {
        return SCHEMA_ID;
    }

    public int sbeSchemaVersion()
    {
        return SCHEMA_VERSION;
    }

    public String sbeSemanticType()
    {
        return "";
    }

    public MutableDirectBuffer buffer()
    {
        return buffer;
    }

    public int offset()
    {
        return offset;
    }

    public UserEncoder wrap(final MutableDirectBuffer buffer, final int offset)
    {
        if (buffer != this.buffer)
        {
            this.buffer = buffer;
        }
        this.offset = offset;
        limit(offset + BLOCK_LENGTH);

        return this;
    }

    public UserEncoder wrapAndApplyHeader(
        final MutableDirectBuffer buffer, final int offset, final MessageHeaderEncoder headerEncoder)
    {
        headerEncoder
            .wrap(buffer, offset)
            .blockLength(BLOCK_LENGTH)
            .templateId(TEMPLATE_ID)
            .schemaId(SCHEMA_ID)
            .version(SCHEMA_VERSION);

        return wrap(buffer, offset + MessageHeaderEncoder.ENCODED_LENGTH);
    }

    public int encodedLength()
    {
        return limit - offset;
    }

    public int limit()
    {
        return limit;
    }

    public void limit(final int limit)
    {
        this.limit = limit;
    }

    public static int idId()
    {
        return 1;
    }

    public static int idSinceVersion()
    {
        return 0;
    }

    public static int idEncodingOffset()
    {
        return 0;
    }

    public static int idEncodingLength()
    {
        return 8;
    }

    public static String idMetaAttribute(final MetaAttribute metaAttribute)
    {
        switch (metaAttribute)
        {
            case EPOCH: return "";
            case TIME_UNIT: return "";
            case SEMANTIC_TYPE: return "";
            case PRESENCE: return "required";
        }

        return "";
    }

    public static long idNullValue()
    {
        return -9223372036854775808L;
    }

    public static long idMinValue()
    {
        return -9223372036854775807L;
    }

    public static long idMaxValue()
    {
        return 9223372036854775807L;
    }

    public UserEncoder id(final long value)
    {
        buffer.putLong(offset + 0, value, java.nio.ByteOrder.LITTLE_ENDIAN);
        return this;
    }


    public static int nameId()
    {
        return 2;
    }

    public static int nameSinceVersion()
    {
        return 0;
    }

    public static int nameEncodingOffset()
    {
        return 8;
    }

    public static int nameEncodingLength()
    {
        return 100;
    }

    public static String nameMetaAttribute(final MetaAttribute metaAttribute)
    {
        switch (metaAttribute)
        {
            case EPOCH: return "";
            case TIME_UNIT: return "";
            case SEMANTIC_TYPE: return "";
            case PRESENCE: return "required";
        }

        return "";
    }

    public static byte nameNullValue()
    {
        return (byte)0;
    }

    public static byte nameMinValue()
    {
        return (byte)32;
    }

    public static byte nameMaxValue()
    {
        return (byte)126;
    }

    public static int nameLength()
    {
        return 100;
    }

    public UserEncoder name(final int index, final byte value)
    {
        if (index < 0 || index >= 100)
        {
            throw new IndexOutOfBoundsException("index out of range: index=" + index);
        }

        final int pos = this.offset + 8 + (index * 1);
        buffer.putByte(pos, value);

        return this;
    }

    public static String nameCharacterEncoding()
    {
        return "US-ASCII";
    }

    public UserEncoder putName(final byte[] src, final int srcOffset)
    {
        final int length = 100;
        if (srcOffset < 0 || srcOffset > (src.length - length))
        {
            throw new IndexOutOfBoundsException("Copy will go out of range: offset=" + srcOffset);
        }

        buffer.putBytes(this.offset + 8, src, srcOffset, length);

        return this;
    }

    public UserEncoder name(final String src)
    {
        final int length = 100;
        final int srcLength = null == src ? 0 : src.length();
        if (srcLength > length)
        {
            throw new IndexOutOfBoundsException("String too large for copy: byte length=" + srcLength);
        }

        buffer.putStringWithoutLengthAscii(this.offset + 8, src);

        for (int start = srcLength; start < length; ++start)
        {
            buffer.putByte(this.offset + 8 + start, (byte)0);
        }

        return this;
    }

    public UserEncoder name(final CharSequence src)
    {
        final int length = 100;
        final int srcLength = null == src ? 0 : src.length();
        if (srcLength > length)
        {
            throw new IndexOutOfBoundsException("CharSequence too large for copy: byte length=" + srcLength);
        }

        for (int i = 0; i < srcLength; ++i)
        {
            final char charValue = src.charAt(i);
            final byte byteValue = charValue > 127 ? (byte)'?' : (byte)charValue;
            buffer.putByte(this.offset + 8 + i, byteValue);
        }

        for (int i = srcLength; i < length; ++i)
        {
            buffer.putByte(this.offset + 8 + i, (byte)0);
        }

        return this;
    }

    public static int signatureId()
    {
        return 3;
    }

    public static int signatureSinceVersion()
    {
        return 0;
    }

    public static int signatureEncodingOffset()
    {
        return 108;
    }

    public static int signatureEncodingLength()
    {
        return 100;
    }

    public static String signatureMetaAttribute(final MetaAttribute metaAttribute)
    {
        switch (metaAttribute)
        {
            case EPOCH: return "";
            case TIME_UNIT: return "";
            case SEMANTIC_TYPE: return "";
            case PRESENCE: return "required";
        }

        return "";
    }

    public static byte signatureNullValue()
    {
        return (byte)0;
    }

    public static byte signatureMinValue()
    {
        return (byte)32;
    }

    public static byte signatureMaxValue()
    {
        return (byte)126;
    }

    public static int signatureLength()
    {
        return 100;
    }

    public UserEncoder signature(final int index, final byte value)
    {
        if (index < 0 || index >= 100)
        {
            throw new IndexOutOfBoundsException("index out of range: index=" + index);
        }

        final int pos = this.offset + 108 + (index * 1);
        buffer.putByte(pos, value);

        return this;
    }

    public static String signatureCharacterEncoding()
    {
        return "US-ASCII";
    }

    public UserEncoder putSignature(final byte[] src, final int srcOffset)
    {
        final int length = 100;
        if (srcOffset < 0 || srcOffset > (src.length - length))
        {
            throw new IndexOutOfBoundsException("Copy will go out of range: offset=" + srcOffset);
        }

        buffer.putBytes(this.offset + 108, src, srcOffset, length);

        return this;
    }

    public UserEncoder signature(final String src)
    {
        final int length = 100;
        final int srcLength = null == src ? 0 : src.length();
        if (srcLength > length)
        {
            throw new IndexOutOfBoundsException("String too large for copy: byte length=" + srcLength);
        }

        buffer.putStringWithoutLengthAscii(this.offset + 108, src);

        for (int start = srcLength; start < length; ++start)
        {
            buffer.putByte(this.offset + 108 + start, (byte)0);
        }

        return this;
    }

    public UserEncoder signature(final CharSequence src)
    {
        final int length = 100;
        final int srcLength = null == src ? 0 : src.length();
        if (srcLength > length)
        {
            throw new IndexOutOfBoundsException("CharSequence too large for copy: byte length=" + srcLength);
        }

        for (int i = 0; i < srcLength; ++i)
        {
            final char charValue = src.charAt(i);
            final byte byteValue = charValue > 127 ? (byte)'?' : (byte)charValue;
            buffer.putByte(this.offset + 108 + i, byteValue);
        }

        for (int i = srcLength; i < length; ++i)
        {
            buffer.putByte(this.offset + 108 + i, (byte)0);
        }

        return this;
    }

    private final AddressesEncoder addresses = new AddressesEncoder(this);

    public static long addressesId()
    {
        return 4;
    }

    public AddressesEncoder addressesCount(final int count)
    {
        addresses.wrap(buffer, count);
        return addresses;
    }

    public static class AddressesEncoder
    {
        public static final int HEADER_SIZE = 116;
        private final UserEncoder parentMessage;
        private MutableDirectBuffer buffer;
        private int count;
        private int index;
        private int offset;

        AddressesEncoder(final UserEncoder parentMessage)
        {
            this.parentMessage = parentMessage;
        }

        public void wrap(final MutableDirectBuffer buffer, final int count)
        {
            if (count < 0 || count > 65534)
            {
                throw new IllegalArgumentException("count outside allowed range: count=" + count);
            }

            if (buffer != this.buffer)
            {
                this.buffer = buffer;
            }

            index = -1;
            this.count = count;
            final int limit = parentMessage.limit();
            parentMessage.limit(limit + HEADER_SIZE);
            buffer.putShort(limit + 112, (short)(int)112, java.nio.ByteOrder.LITTLE_ENDIAN);
            buffer.putShort(limit + 114, (short)(int)count, java.nio.ByteOrder.LITTLE_ENDIAN);
        }

        public static int sbeHeaderSize()
        {
            return HEADER_SIZE;
        }

        public static int sbeBlockLength()
        {
            return 112;
        }

        public AddressesEncoder next()
        {
            if (index + 1 >= count)
            {
                throw new java.util.NoSuchElementException();
            }

            offset = parentMessage.limit();
            parentMessage.limit(offset + sbeBlockLength());
            ++index;

            return this;
        }

        public static int idId()
        {
            return 5;
        }

        public static int idSinceVersion()
        {
            return 0;
        }

        public static int idEncodingOffset()
        {
            return 0;
        }

        public static int idEncodingLength()
        {
            return 8;
        }

        public static String idMetaAttribute(final MetaAttribute metaAttribute)
        {
            switch (metaAttribute)
            {
                case EPOCH: return "";
                case TIME_UNIT: return "";
                case SEMANTIC_TYPE: return "";
                case PRESENCE: return "required";
            }

            return "";
        }

        public static long idNullValue()
        {
            return -9223372036854775808L;
        }

        public static long idMinValue()
        {
            return -9223372036854775807L;
        }

        public static long idMaxValue()
        {
            return 9223372036854775807L;
        }

        public AddressesEncoder id(final long value)
        {
            buffer.putLong(offset + 0, value, java.nio.ByteOrder.LITTLE_ENDIAN);
            return this;
        }


        public static int cityId()
        {
            return 6;
        }

        public static int citySinceVersion()
        {
            return 0;
        }

        public static int cityEncodingOffset()
        {
            return 8;
        }

        public static int cityEncodingLength()
        {
            return 100;
        }

        public static String cityMetaAttribute(final MetaAttribute metaAttribute)
        {
            switch (metaAttribute)
            {
                case EPOCH: return "";
                case TIME_UNIT: return "";
                case SEMANTIC_TYPE: return "";
                case PRESENCE: return "required";
            }

            return "";
        }

        public static byte cityNullValue()
        {
            return (byte)0;
        }

        public static byte cityMinValue()
        {
            return (byte)32;
        }

        public static byte cityMaxValue()
        {
            return (byte)126;
        }

        public static int cityLength()
        {
            return 100;
        }

        public AddressesEncoder city(final int index, final byte value)
        {
            if (index < 0 || index >= 100)
            {
                throw new IndexOutOfBoundsException("index out of range: index=" + index);
            }

            final int pos = this.offset + 8 + (index * 1);
            buffer.putByte(pos, value);

            return this;
        }

        public static String cityCharacterEncoding()
        {
            return "US-ASCII";
        }

        public AddressesEncoder putCity(final byte[] src, final int srcOffset)
        {
            final int length = 100;
            if (srcOffset < 0 || srcOffset > (src.length - length))
            {
                throw new IndexOutOfBoundsException("Copy will go out of range: offset=" + srcOffset);
            }

            buffer.putBytes(this.offset + 8, src, srcOffset, length);

            return this;
        }

        public AddressesEncoder city(final String src)
        {
            final int length = 100;
            final int srcLength = null == src ? 0 : src.length();
            if (srcLength > length)
            {
                throw new IndexOutOfBoundsException("String too large for copy: byte length=" + srcLength);
            }

            buffer.putStringWithoutLengthAscii(this.offset + 8, src);

            for (int start = srcLength; start < length; ++start)
            {
                buffer.putByte(this.offset + 8 + start, (byte)0);
            }

            return this;
        }

        public AddressesEncoder city(final CharSequence src)
        {
            final int length = 100;
            final int srcLength = null == src ? 0 : src.length();
            if (srcLength > length)
            {
                throw new IndexOutOfBoundsException("CharSequence too large for copy: byte length=" + srcLength);
            }

            for (int i = 0; i < srcLength; ++i)
            {
                final char charValue = src.charAt(i);
                final byte byteValue = charValue > 127 ? (byte)'?' : (byte)charValue;
                buffer.putByte(this.offset + 8 + i, byteValue);
            }

            for (int i = srcLength; i < length; ++i)
            {
                buffer.putByte(this.offset + 8 + i, (byte)0);
            }

            return this;
        }

        public static int populationId()
        {
            return 7;
        }

        public static int populationSinceVersion()
        {
            return 0;
        }

        public static int populationEncodingOffset()
        {
            return 108;
        }

        public static int populationEncodingLength()
        {
            return 4;
        }

        public static String populationMetaAttribute(final MetaAttribute metaAttribute)
        {
            switch (metaAttribute)
            {
                case EPOCH: return "";
                case TIME_UNIT: return "";
                case SEMANTIC_TYPE: return "";
                case PRESENCE: return "required";
            }

            return "";
        }

        public static int populationNullValue()
        {
            return -2147483648;
        }

        public static int populationMinValue()
        {
            return -2147483647;
        }

        public static int populationMaxValue()
        {
            return 2147483647;
        }

        public AddressesEncoder population(final int value)
        {
            buffer.putInt(offset + 108, value, java.nio.ByteOrder.LITTLE_ENDIAN);
            return this;
        }

    }


    public String toString()
    {
        return appendTo(new StringBuilder(100)).toString();
    }

    public StringBuilder appendTo(final StringBuilder builder)
    {
        UserDecoder writer = new UserDecoder();
        writer.wrap(buffer, offset, BLOCK_LENGTH, SCHEMA_VERSION);

        return writer.appendTo(builder);
    }
}
