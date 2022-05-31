package by.egorstrupinski.dal;


public interface IOFileDal {
    byte[] readFile(String path);
    void writeFile(String path, byte[] byteArr);
}
