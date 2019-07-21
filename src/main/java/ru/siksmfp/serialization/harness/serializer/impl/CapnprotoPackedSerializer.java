package ru.siksmfp.serialization.harness.serializer.impl;

import org.capnproto.ArrayInputStream;
import org.capnproto.ArrayOutputStream;
import org.capnproto.MessageBuilder;
import org.capnproto.MessageReader;
import org.capnproto.SerializePacked;
import ru.siksmfp.serialization.harness.model.converter.api.Converter;
import ru.siksmfp.serialization.harness.model.converter.impl.CapnprotoBuilderConverter;
import ru.siksmfp.serialization.harness.model.converter.impl.CapnprotoReaderConverter;
import ru.siksmfp.serialization.harness.model.standart.User;
import ru.siksmfp.serialization.harness.serializer.api.Serializer;

import java.io.IOException;
import java.nio.ByteBuffer;

public class CapnprotoPackedSerializer implements Serializer<User> {

    private Converter<MessageBuilder, User> messageConverter = new CapnprotoBuilderConverter();
    private Converter<MessageReader, User> readerConverter = new CapnprotoReaderConverter();

    @Override
    public byte[] serialize(User user) {
        try (ArrayOutputStream os = new ArrayOutputStream(ByteBuffer.allocate(1024))) {
            MessageBuilder messageBuilder = messageConverter.toModel(user);
            SerializePacked.write(os, messageBuilder);
            return os.getWriteBuffer().array();
        } catch (IOException e) {
            e.printStackTrace();
            throw new IllegalStateException("Capnproto packed serialization finished unsuccessfully");
        }
    }

    @Override
    public User deSerialize(byte[] bytes) {
        try {
            MessageReader read = SerializePacked.read(new ArrayInputStream(ByteBuffer.wrap(bytes)));
            return readerConverter.toDto(read);
        } catch (IOException e) {
            e.printStackTrace();
            throw new IllegalStateException("Capnproto packed de serialization finished unsuccessfully");
        }
    }
}
