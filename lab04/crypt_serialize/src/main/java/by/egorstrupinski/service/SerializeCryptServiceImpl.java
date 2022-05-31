package by.egorstrupinski.service;

import by.egorstrupinski.crypt.CryptService;
import by.egorstrupinski.dal.IOFileDal;
import by.egorstrupinski.dal.impl.IOFileDalImpl;
import by.egorstrupinski.serializer.BinaryDeserializer;
import by.egorstrupinski.serializer.BinarySerializer;

import java.io.IOException;

public class SerializeCryptServiceImpl implements SerializeCryptService{

    private final CryptService cryptService;
    private final BinarySerializer binarySerializer;
    private final BinaryDeserializer binaryDeserializer;
    private final IOFileDal ioFileDal;

    public SerializeCryptServiceImpl() {
        cryptService = new CryptService();
        binarySerializer = new BinarySerializer();
        binaryDeserializer = new BinaryDeserializer();
        ioFileDal = new IOFileDalImpl();
    }

    @Override
    public void save(String path, Object obj) throws IOException {
        byte[] bytes = binarySerializer.serialize(obj);
        byte[] cryptBytes = cryptService.encrypt(bytes);
        ioFileDal.writeFile(path, cryptBytes);
    }

    @Override
    public Object load(String path) throws IOException, ClassNotFoundException {
        byte[] bytes = ioFileDal.readFile(path);
        byte[] plainBytes = cryptService.decrypt(bytes);
        return binaryDeserializer.deserialize(plainBytes);
    }
}
