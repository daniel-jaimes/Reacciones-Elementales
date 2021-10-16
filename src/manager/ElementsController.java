package manager;

import dao.ElementsReader;
import dao.ResultsWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ElementsController {
    void init() {
        FileReader ER = new ElementsReader().getElements();
        try{
            int content;
            char ch1, ch2;
            String combination;
            do {
                content = ER.read();
                ch1 = (char) content;
                do {
                    content = ER.read();
                    ch2 = (char) content;
                    combination = whichCombination(ch1, ch2);
                    write(combination);
                    if(combination.equals("")) ch1 = ch2;
                } while (content != -1 && combination.equals(""));
            } while (content != -1 );
            ER.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void write(String combination) {
        FileWriter RW = new ResultsWriter().setResults();

    }
    private String whichCombination(char ch1, char ch2) {
        if(ch1 == 'F' && ch2 == 'A') return "Evaporacion";
        if(ch1 == 'F' && ch2 == 'H') return "Derretido";
        if(ch1 == 'F' && ch2 == 'R') return "Sobrecarga";
        if(ch1 == 'R' && ch2 == 'A') return "Electro-carga";
        if(ch1 == 'R' && ch2 == 'H') return "Superconductor";
        if(ch1 == 'A' && ch2 == 'H') return "Congelar";
        if(ch1 == 'V' && (ch2 == 'F' || ch2 == 'R' || ch2 == 'A' || ch2 == 'H')) return "Torbellino";
        if(ch1 == 'T' && (ch2 == 'F' || ch2 == 'R' || ch2 == 'A' || ch2 == 'H')) return "Cristalizar";
        if(ch1 == 'F' && ch2 == 'N') return "Quemadura";
        else return "";
    }


}
