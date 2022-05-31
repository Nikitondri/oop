package by.egorstrupinski.serializer;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class BinaryDeserializer {
    public Object deserialize(byte[] data) throws IOException, ClassNotFoundException {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(data);
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        Object obj = objectInputStream.readObject();
        objectInputStream.close();
        inputStream.close();
        return obj;
    }

    public BinaryDeserializer() {
    }
}
