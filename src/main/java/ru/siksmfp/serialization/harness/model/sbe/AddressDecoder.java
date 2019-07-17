/* Generated SBE (Simple Binary Encoding) message codec */
package ru.siksmfp.serialization.harness.model.sbe;

import org.agrona.DirectBuffer;

@SuppressWarnings("all")
public class AddressDecoder
{
    public static final int SCHEMA_ID = 1;
    public static final int SCHEMA_VERSION = 1;
    public static final int ENCODED_LENGTH = 116;
    public static final java.nio.ByteOrder BYTE_ORDER = java.nio.ByteOrder.LITTLE_ENDIAN;

    private int offset;
    private DirectBuffer buffer;

    public AddressDecoder wrap(final DirectBuffer buffer, final int offset)
    {
        if (buffer != this.buffer)
        {
            this.buffer = buffer;
        }
        this.offset = offset;

        return this;
    }

    public DirectBuffer buffer()
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

    public static int idSinceVersion()
    {
        return 0;
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

    public long id()
    {
        return buffer.getLong(offset + 0, java.nio.ByteOrder.LITTLE_ENDIAN);
    }


    public static int cityEncodingOffset()
    {
        return 8;
    }

    public static int cityEncodingLength()
    {
        return 100;
    }

    public static int citySinceVersion()
    {
        return 0;
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

    public byte city(final int index)
    {
        if (index < 0 || index >= 100)
        {
            throw new IndexOutOfBoundsException("index out of range: index=" + index);
        }

        final int pos = this.offset + 8 + (index * 1);

        return buffer.getByte(pos);
    }


    public static String cityCharacterEncoding()
    {
        return "US-ASCII";
    }

    public int getCity(final byte[] dst, final int dstOffset)
    {
        final int length = 100;
        if (dstOffset < 0 || dstOffset > (dst.length - length))
        {
            throw new IndexOutOfBoundsException("Copy will go out of range: offset=" + dstOffset);
        }

        buffer.getBytes(this.offset + 8, dst, dstOffset, length);

        return length;
    }

    public String city()
    {
        final byte[] dst = new byte[100];
        buffer.getBytes(this.offset + 8, dst, 0, 100);

        int end = 0;
        for (; end < 100 && dst[end] != 0; ++end);

        return new String(dst, 0, end, java.nio.charset.StandardCharsets.US_ASCII);
    }


    public int getCity(final Appendable value)
    {
        for (int i = 0; i < 100; ++i)
        {
            final int c = buffer.getByte(this.offset + 8 + i) & 0xFF;
            if (c == 0)
            {
                return i;
            }

            try
            {
                value.append(c > 127 ? '?' : (char)c);
            }
            catch (final java.io.IOException ex)
            {
                throw new java.io.UncheckedIOException(ex);
            }
        }

        return 100;
    }


    public static int populationEncodingOffset()
    {
        return 108;
    }

    public static int populationEncodingLength()
    {
        return 4;
    }

    public static int populationSinceVersion()
    {
        return 0;
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

    public int population()
    {
        return buffer.getInt(offset + 108, java.nio.ByteOrder.LITTLE_ENDIAN);
    }


    public static int blockLengthEncodingOffset()
    {
        return 112;
    }

    public static int blockLengthEncodingLength()
    {
        return 2;
    }

    public static int blockLengthSinceVersion()
    {
        return 0;
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

    public int blockLength()
    {
        return (buffer.getShort(offset + 112, java.nio.ByteOrder.LITTLE_ENDIAN) & 0xFFFF);
    }


    public static int numInGroupEncodingOffset()
    {
        return 114;
    }

    public static int numInGroupEncodingLength()
    {
        return 2;
    }

    public static int numInGroupSinceVersion()
    {
        return 0;
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

    public int numInGroup()
    {
        return (buffer.getShort(offset + 114, java.nio.ByteOrder.LITTLE_ENDIAN) & 0xFFFF);
    }


    public String toString()
    {
        return appendTo(new StringBuilder(100)).toString();
    }

    public StringBuilder appendTo(final StringBuilder builder)
    {
        builder.append('(');
        //Token{signal=ENCODING, name='id', referencedName='null', description='null', id=-1, version=0, deprecated=0, encodedLength=8, offset=0, componentTokenCount=1, encoding=Encoding{presence=REQUIRED, primitiveType=INT64, byteOrder=LITTLE_ENDIAN, minValue=null, maxValue=null, nullValue=null, constValue=null, characterEncoding='null', epoch='null', timeUnit=null, semanticType='null'}}
        builder.append("id=");
        builder.append(id());
        builder.append('|');
        //Token{signal=ENCODING, name='city', referencedName='null', description='null', id=-1, version=0, deprecated=0, encodedLength=100, offset=8, componentTokenCount=1, encoding=Encoding{presence=REQUIRED, primitiveType=CHAR, byteOrder=LITTLE_ENDIAN, minValue=null, maxValue=null, nullValue=null, constValue=null, characterEncoding='US-ASCII', epoch='null', timeUnit=null, semanticType='null'}}
        builder.append("city=");
        for (int i = 0; i < cityLength() && city(i) > 0; i++)
        {
            builder.append((char)city(i));
        }
        builder.append('|');
        //Token{signal=ENCODING, name='population', referencedName='null', description='null', id=-1, version=0, deprecated=0, encodedLength=4, offset=108, componentTokenCount=1, encoding=Encoding{presence=REQUIRED, primitiveType=INT32, byteOrder=LITTLE_ENDIAN, minValue=null, maxValue=null, nullValue=null, constValue=null, characterEncoding='null', epoch='null', timeUnit=null, semanticType='null'}}
        builder.append("population=");
        builder.append(population());
        builder.append('|');
        //Token{signal=ENCODING, name='blockLength', referencedName='null', description='null', id=-1, version=0, deprecated=0, encodedLength=2, offset=112, componentTokenCount=1, encoding=Encoding{presence=REQUIRED, primitiveType=UINT16, byteOrder=LITTLE_ENDIAN, minValue=null, maxValue=null, nullValue=null, constValue=null, characterEncoding='null', epoch='null', timeUnit=null, semanticType='null'}}
        builder.append("blockLength=");
        builder.append(blockLength());
        builder.append('|');
        //Token{signal=ENCODING, name='numInGroup', referencedName='null', description='null', id=-1, version=0, deprecated=0, encodedLength=2, offset=114, componentTokenCount=1, encoding=Encoding{presence=REQUIRED, primitiveType=UINT16, byteOrder=LITTLE_ENDIAN, minValue=null, maxValue=null, nullValue=null, constValue=null, characterEncoding='null', epoch='null', timeUnit=null, semanticType='null'}}
        builder.append("numInGroup=");
        builder.append(numInGroup());
        builder.append(')');

        return builder;
    }
}
