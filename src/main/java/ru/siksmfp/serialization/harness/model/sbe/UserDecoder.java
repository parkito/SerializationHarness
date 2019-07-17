/* Generated SBE (Simple Binary Encoding) message codec */
package ru.siksmfp.serialization.harness.model.sbe;

import org.agrona.MutableDirectBuffer;
import org.agrona.DirectBuffer;

/**
 * User model
 */
@SuppressWarnings("all")
public class UserDecoder
{
    public static final int BLOCK_LENGTH = 208;
    public static final int TEMPLATE_ID = 1;
    public static final int SCHEMA_ID = 1;
    public static final int SCHEMA_VERSION = 1;
    public static final java.nio.ByteOrder BYTE_ORDER = java.nio.ByteOrder.LITTLE_ENDIAN;

    private final UserDecoder parentMessage = this;
    private DirectBuffer buffer;
    protected int offset;
    protected int limit;
    protected int actingBlockLength;
    protected int actingVersion;

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

    public DirectBuffer buffer()
    {
        return buffer;
    }

    public int offset()
    {
        return offset;
    }

    public UserDecoder wrap(
        final DirectBuffer buffer, final int offset, final int actingBlockLength, final int actingVersion)
    {
        if (buffer != this.buffer)
        {
            this.buffer = buffer;
        }
        this.offset = offset;
        this.actingBlockLength = actingBlockLength;
        this.actingVersion = actingVersion;
        limit(offset + actingBlockLength);

        return this;
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

    public long id()
    {
        return buffer.getLong(offset + 0, java.nio.ByteOrder.LITTLE_ENDIAN);
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

    public byte name(final int index)
    {
        if (index < 0 || index >= 100)
        {
            throw new IndexOutOfBoundsException("index out of range: index=" + index);
        }

        final int pos = this.offset + 8 + (index * 1);

        return buffer.getByte(pos);
    }


    public static String nameCharacterEncoding()
    {
        return "US-ASCII";
    }

    public int getName(final byte[] dst, final int dstOffset)
    {
        final int length = 100;
        if (dstOffset < 0 || dstOffset > (dst.length - length))
        {
            throw new IndexOutOfBoundsException("Copy will go out of range: offset=" + dstOffset);
        }

        buffer.getBytes(this.offset + 8, dst, dstOffset, length);

        return length;
    }

    public String name()
    {
        final byte[] dst = new byte[100];
        buffer.getBytes(this.offset + 8, dst, 0, 100);

        int end = 0;
        for (; end < 100 && dst[end] != 0; ++end);

        return new String(dst, 0, end, java.nio.charset.StandardCharsets.US_ASCII);
    }


    public int getName(final Appendable value)
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

    public byte signature(final int index)
    {
        if (index < 0 || index >= 100)
        {
            throw new IndexOutOfBoundsException("index out of range: index=" + index);
        }

        final int pos = this.offset + 108 + (index * 1);

        return buffer.getByte(pos);
    }


    public static String signatureCharacterEncoding()
    {
        return "US-ASCII";
    }

    public int getSignature(final byte[] dst, final int dstOffset)
    {
        final int length = 100;
        if (dstOffset < 0 || dstOffset > (dst.length - length))
        {
            throw new IndexOutOfBoundsException("Copy will go out of range: offset=" + dstOffset);
        }

        buffer.getBytes(this.offset + 108, dst, dstOffset, length);

        return length;
    }

    public String signature()
    {
        final byte[] dst = new byte[100];
        buffer.getBytes(this.offset + 108, dst, 0, 100);

        int end = 0;
        for (; end < 100 && dst[end] != 0; ++end);

        return new String(dst, 0, end, java.nio.charset.StandardCharsets.US_ASCII);
    }


    public int getSignature(final Appendable value)
    {
        for (int i = 0; i < 100; ++i)
        {
            final int c = buffer.getByte(this.offset + 108 + i) & 0xFF;
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


    private final AddressesDecoder addresses = new AddressesDecoder(this);

    public static long addressesDecoderId()
    {
        return 4;
    }

    public static int addressesDecoderSinceVersion()
    {
        return 0;
    }

    public AddressesDecoder addresses()
    {
        addresses.wrap(buffer);
        return addresses;
    }

    public static class AddressesDecoder
        implements Iterable<AddressesDecoder>, java.util.Iterator<AddressesDecoder>
    {
        public static final int HEADER_SIZE = 116;
        private final UserDecoder parentMessage;
        private DirectBuffer buffer;
        private int count;
        private int index;
        private int offset;
        private int blockLength;

        AddressesDecoder(final UserDecoder parentMessage)
        {
            this.parentMessage = parentMessage;
        }

        public void wrap(final DirectBuffer buffer)
        {
            if (buffer != this.buffer)
            {
                this.buffer = buffer;
            }
            index = -1;
            final int limit = parentMessage.limit();
            parentMessage.limit(limit + HEADER_SIZE);
            blockLength = (int)(buffer.getShort(limit + 112, java.nio.ByteOrder.LITTLE_ENDIAN) & 0xFFFF);
            count = (int)(buffer.getShort(limit + 114, java.nio.ByteOrder.LITTLE_ENDIAN) & 0xFFFF);
        }

        public static int sbeHeaderSize()
        {
            return HEADER_SIZE;
        }

        public static int sbeBlockLength()
        {
            return 112;
        }

        public int actingBlockLength()
        {
            return blockLength;
        }

        public int count()
        {
            return count;
        }

        public java.util.Iterator<AddressesDecoder> iterator()
        {
            return this;
        }

        public void remove()
        {
            throw new UnsupportedOperationException();
        }

        public boolean hasNext()
        {
            return (index + 1) < count;
        }

        public AddressesDecoder next()
        {
            if (index + 1 >= count)
            {
                throw new java.util.NoSuchElementException();
            }

            offset = parentMessage.limit();
            parentMessage.limit(offset + blockLength);
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

        public long id()
        {
            return buffer.getLong(offset + 0, java.nio.ByteOrder.LITTLE_ENDIAN);
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

        public int population()
        {
            return buffer.getInt(offset + 108, java.nio.ByteOrder.LITTLE_ENDIAN);
        }



        public String toString()
        {
            return appendTo(new StringBuilder(100)).toString();
        }

        public StringBuilder appendTo(final StringBuilder builder)
        {
            builder.append('(');
            //Token{signal=BEGIN_FIELD, name='id', referencedName='null', description='null', id=5, version=0, deprecated=0, encodedLength=8, offset=0, componentTokenCount=3, encoding=Encoding{presence=REQUIRED, primitiveType=null, byteOrder=LITTLE_ENDIAN, minValue=null, maxValue=null, nullValue=null, constValue=null, characterEncoding='null', epoch='null', timeUnit=null, semanticType='null'}}
            //Token{signal=ENCODING, name='int64', referencedName='null', description='null', id=-1, version=0, deprecated=0, encodedLength=8, offset=0, componentTokenCount=1, encoding=Encoding{presence=REQUIRED, primitiveType=INT64, byteOrder=LITTLE_ENDIAN, minValue=null, maxValue=null, nullValue=null, constValue=null, characterEncoding='null', epoch='null', timeUnit=null, semanticType='null'}}
            builder.append("id=");
            builder.append(id());
            builder.append('|');
            //Token{signal=BEGIN_FIELD, name='city', referencedName='null', description='null', id=6, version=0, deprecated=0, encodedLength=100, offset=8, componentTokenCount=3, encoding=Encoding{presence=REQUIRED, primitiveType=null, byteOrder=LITTLE_ENDIAN, minValue=null, maxValue=null, nullValue=null, constValue=null, characterEncoding='null', epoch='null', timeUnit=null, semanticType='null'}}
            //Token{signal=ENCODING, name='string100', referencedName='null', description='null', id=-1, version=0, deprecated=0, encodedLength=100, offset=8, componentTokenCount=1, encoding=Encoding{presence=REQUIRED, primitiveType=CHAR, byteOrder=LITTLE_ENDIAN, minValue=null, maxValue=null, nullValue=null, constValue=null, characterEncoding='US-ASCII', epoch='null', timeUnit=null, semanticType='null'}}
            builder.append("city=");
            for (int i = 0; i < cityLength() && city(i) > 0; i++)
            {
                builder.append((char)city(i));
            }
            builder.append('|');
            //Token{signal=BEGIN_FIELD, name='population', referencedName='null', description='null', id=7, version=0, deprecated=0, encodedLength=4, offset=108, componentTokenCount=3, encoding=Encoding{presence=REQUIRED, primitiveType=null, byteOrder=LITTLE_ENDIAN, minValue=null, maxValue=null, nullValue=null, constValue=null, characterEncoding='null', epoch='null', timeUnit=null, semanticType='null'}}
            //Token{signal=ENCODING, name='int32', referencedName='null', description='null', id=-1, version=0, deprecated=0, encodedLength=4, offset=108, componentTokenCount=1, encoding=Encoding{presence=REQUIRED, primitiveType=INT32, byteOrder=LITTLE_ENDIAN, minValue=null, maxValue=null, nullValue=null, constValue=null, characterEncoding='null', epoch='null', timeUnit=null, semanticType='null'}}
            builder.append("population=");
            builder.append(population());
            builder.append(')');
            return builder;
        }
    }


    public String toString()
    {
        return appendTo(new StringBuilder(100)).toString();
    }

    public StringBuilder appendTo(final StringBuilder builder)
    {
        final int originalLimit = limit();
        limit(offset + actingBlockLength);
        builder.append("[User](sbeTemplateId=");
        builder.append(TEMPLATE_ID);
        builder.append("|sbeSchemaId=");
        builder.append(SCHEMA_ID);
        builder.append("|sbeSchemaVersion=");
        if (parentMessage.actingVersion != SCHEMA_VERSION)
        {
            builder.append(parentMessage.actingVersion);
            builder.append('/');
        }
        builder.append(SCHEMA_VERSION);
        builder.append("|sbeBlockLength=");
        if (actingBlockLength != BLOCK_LENGTH)
        {
            builder.append(actingBlockLength);
            builder.append('/');
        }
        builder.append(BLOCK_LENGTH);
        builder.append("):");
        //Token{signal=BEGIN_FIELD, name='id', referencedName='null', description='null', id=1, version=0, deprecated=0, encodedLength=8, offset=0, componentTokenCount=3, encoding=Encoding{presence=REQUIRED, primitiveType=null, byteOrder=LITTLE_ENDIAN, minValue=null, maxValue=null, nullValue=null, constValue=null, characterEncoding='null', epoch='null', timeUnit=null, semanticType='null'}}
        //Token{signal=ENCODING, name='int64', referencedName='null', description='null', id=-1, version=0, deprecated=0, encodedLength=8, offset=0, componentTokenCount=1, encoding=Encoding{presence=REQUIRED, primitiveType=INT64, byteOrder=LITTLE_ENDIAN, minValue=null, maxValue=null, nullValue=null, constValue=null, characterEncoding='null', epoch='null', timeUnit=null, semanticType='null'}}
        builder.append("id=");
        builder.append(id());
        builder.append('|');
        //Token{signal=BEGIN_FIELD, name='name', referencedName='null', description='null', id=2, version=0, deprecated=0, encodedLength=100, offset=8, componentTokenCount=3, encoding=Encoding{presence=REQUIRED, primitiveType=null, byteOrder=LITTLE_ENDIAN, minValue=null, maxValue=null, nullValue=null, constValue=null, characterEncoding='null', epoch='null', timeUnit=null, semanticType='null'}}
        //Token{signal=ENCODING, name='string100', referencedName='null', description='null', id=-1, version=0, deprecated=0, encodedLength=100, offset=8, componentTokenCount=1, encoding=Encoding{presence=REQUIRED, primitiveType=CHAR, byteOrder=LITTLE_ENDIAN, minValue=null, maxValue=null, nullValue=null, constValue=null, characterEncoding='US-ASCII', epoch='null', timeUnit=null, semanticType='null'}}
        builder.append("name=");
        for (int i = 0; i < nameLength() && name(i) > 0; i++)
        {
            builder.append((char)name(i));
        }
        builder.append('|');
        //Token{signal=BEGIN_FIELD, name='signature', referencedName='null', description='null', id=3, version=0, deprecated=0, encodedLength=100, offset=108, componentTokenCount=3, encoding=Encoding{presence=REQUIRED, primitiveType=null, byteOrder=LITTLE_ENDIAN, minValue=null, maxValue=null, nullValue=null, constValue=null, characterEncoding='null', epoch='null', timeUnit=null, semanticType='null'}}
        //Token{signal=ENCODING, name='string100', referencedName='null', description='null', id=-1, version=0, deprecated=0, encodedLength=100, offset=108, componentTokenCount=1, encoding=Encoding{presence=REQUIRED, primitiveType=CHAR, byteOrder=LITTLE_ENDIAN, minValue=null, maxValue=null, nullValue=null, constValue=null, characterEncoding='US-ASCII', epoch='null', timeUnit=null, semanticType='null'}}
        builder.append("signature=");
        for (int i = 0; i < signatureLength() && signature(i) > 0; i++)
        {
            builder.append((char)signature(i));
        }
        builder.append('|');
        //Token{signal=BEGIN_GROUP, name='addresses', referencedName='null', description='null', id=4, version=0, deprecated=0, encodedLength=112, offset=208, componentTokenCount=18, encoding=Encoding{presence=REQUIRED, primitiveType=null, byteOrder=LITTLE_ENDIAN, minValue=null, maxValue=null, nullValue=null, constValue=null, characterEncoding='null', epoch='null', timeUnit=null, semanticType='null'}}
        builder.append("addresses=[");
        AddressesDecoder addresses = addresses();
        if (addresses.count() > 0)
        {
            while (addresses.hasNext())
            {
                addresses.next().appendTo(builder);
                builder.append(',');
            }
            builder.setLength(builder.length() - 1);
        }
        builder.append(']');

        limit(originalLimit);

        return builder;
    }
}
