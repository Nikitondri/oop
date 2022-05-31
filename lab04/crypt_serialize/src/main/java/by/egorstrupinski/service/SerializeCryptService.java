package by.egorstrupinski.service;

import java.io.IOException;

public interface SerializeCryptService {
    void save(String path, Object obj) throws IOException;
    Object load(String path) throws IOException, ClassNotFoundException;

}
