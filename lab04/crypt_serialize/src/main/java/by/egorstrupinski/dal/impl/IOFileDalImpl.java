package by.egorstrupinski.dal.impl;


import by.egorstrupinski.dal.IOFileDal;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOFileDalImpl implements IOFileDal {
    @Override
    public byte[] readFile(String path) {
        try {
            FileInputStream fis = new FileInputStream(path);
            return fis.readAllBytes();
        } catch (IOException e) {
            return null;
        }
    }

    @Override
    public void writeFile(String path, byte[] byteArr) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            fos.write(byteArr);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
