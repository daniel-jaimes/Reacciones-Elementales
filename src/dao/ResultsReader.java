package dao;

import java.io.FileReader;

public class ResultsReader {
    public FileReader getResults(){
        System.out.println("SE ESTA LEYENDO EN EL FICHERO \"resultadosElementales.txt\"...");
        return new Reader().readerPath("files/resultadoElemental.txt");
    }

}
