package dao;


import java.io.FileWriter;

public class ResultsWriter {
    public FileWriter setResults(){
        System.out.println("SE ESTA ESCRIBIENDO EN EL FICHERO \"resultadosElementales.txt\"...");
        return new Writer().writerPath("files/resultadoElemental.txt");
    }
}
