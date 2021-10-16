package dao;


import java.io.FileWriter;

public class ResultsWriter {
    public FileWriter setResults(){
        System.out.println("SE ESTA ESCRIBIENDO EN EL FICHERO...");
        return new Writer().writerPath("files/resultadoElementales.txt");
    }
}
