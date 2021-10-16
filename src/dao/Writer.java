package dao;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Writer {
    protected FileWriter writerPath(String path) {
        FileWriter fr = null;
        try {
            fr = new FileWriter(path);
        } catch (FileNotFoundException ex){
            System.err.println("File not found.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fr;
    }
}
