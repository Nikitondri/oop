package by.egorstrupinski.serializer;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class BinarySerializer {
    public byte[] serialize(Object list) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ObjectOutputStream objOutputStream = new ObjectOutputStream(outputStream);
        objOutputStream.writeObject(list);
        byte[] result = outputStream.toByteArray();
        outputStream.close();
        objOutputStream.close();
        return result;
    }

    public BinarySerializer() {
    }
}
