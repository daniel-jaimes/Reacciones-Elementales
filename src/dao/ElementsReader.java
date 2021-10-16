package dao;


import java.io.FileReader;

public class ElementsReader {
    public FileReader getElements(){
        System.out.println("LEIENDO ELEMENTOS...");
        return new dao.Reader().readerPath("files/elementos.txt");
    }
}
