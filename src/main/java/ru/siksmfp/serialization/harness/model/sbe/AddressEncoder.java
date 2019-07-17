/* Generated SBE (Simple Binary Encoding) message codec */
package ru.siksmfp.serialization.harness.model.sbe;

import org.agrona.MutableDirectBuffer;

@SuppressWarnings("all")
public class AddressEncoder
{
    public static final int SCHEMA_ID = 1;
    public static final int SCHEMA_VERSION = 1;
    public static final int ENCODED_LENGTH = 116;
    public static final java.nio.ByteOrder BYTE_ORDER = java.nio.ByteOrder.LITTLE_ENDIAN;

    private int offset;
    private MutableDirectBuffer buffer;

    public AddressEncoder wrap(final MutableDirectBuffer buffer, final int offset)
    {
        if (buffer != this.buffer)
        {
            this.buffer = buffer;
        }
        this.offset = offset;

        return this;
    }

    public MutableDirectBuffer buffer()
    {
        return buffer;
    }

    public int offset()
    {
        return offset;
    }

    public int encodedLength()
    {
        return ENCODED_LENGTH;
    }

    public int sbeSchemaId()
    {
        return SCHEMA_ID;
    }

    public int sbeSchemaVersion()
    {
        return SCHEMA_VERSION;
    }

    public static int idEncodingOffset()
    {
        return 0;
    }

    public static int idEncodingLength()
    {
        return 8;
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

    public AddressEncoder id(final long value)
    {
        buffer.putLong(offset + 0, value, java.nio.ByteOrder.LITTLE_ENDIAN);
        return this;
    }


    public static int cityEncodingOffset()
    {
        return 8;
    }

    public static int cityEncodingLength()
    {
        return 100;
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

    public AddressEncoder city(final int index, final byte value)
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

    public AddressEncoder putCity(final byte[] src, final int srcOffset)
    {
        final int length = 100;
        if (srcOffset < 0 || srcOffset > (src.length - length))
        {
            throw new IndexOutOfBoundsException("Copy will go out of range: offset=" + srcOffset);
        }

        buffer.putBytes(this.offset + 8, src, srcOffset, length);

        return this;
    }

    public AddressEncoder city(final String src)
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

    public AddressEncoder city(final CharSequence src)
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

    public static int populationEncodingOffset()
    {
        return 108;
    }

    public static int populationEncodingLength()
    {
        return 4;
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

    public AddressEncoder population(final int value)
    {
        buffer.putInt(offset + 108, value, java.nio.ByteOrder.LITTLE_ENDIAN);
        return this;
    }


    public static int blockLengthEncodingOffset()
    {
        return 112;
    }

    public static int blockLengthEncodingLength()
    {
        return 2;
    }

    public static int blockLengthNullValue()
    {
        return 65535;
    }

    public static int blockLengthMinValue()
    {
        return 0;
    }

    public static int blockLengthMaxValue()
    {
        return 65534;
    }

    public AddressEncoder blockLength(final int value)
    {
        buffer.putShort(offset + 112, (short)value, java.nio.ByteOrder.LITTLE_ENDIAN);
        return this;
    }


    public static int numInGroupEncodingOffset()
    {
        return 114;
    }

    public static int numInGroupEncodingLength()
    {
        return 2;
    }

    public static int numInGroupNullValue()
    {
        return 65535;
    }

    public static int numInGroupMinValue()
    {
        return 0;
    }

    public static int numInGroupMaxValue()
    {
        return 65534;
    }

    public AddressEncoder numInGroup(final int value)
    {
        buffer.putShort(offset + 114, (short)value, java.nio.ByteOrder.LITTLE_ENDIAN);
        return this;
    }


    public String toString()
    {
        return appendTo(new StringBuilder(100)).toString();
    }

    public StringBuilder appendTo(final StringBuilder builder)
    {
        AddressDecoder writer = new AddressDecoder();
        writer.wrap(buffer, offset);

        return writer.appendTo(builder);
    }
}
