package manager;

import dao.ElementsReader;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ElementsController {
    void init(FileWriter RW) {
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
                    if(combination.equals("")) ch1 = ch2;
                    else write(combination, RW);
                } while (content != -1 && combination.equals(""));
            } while (content != -1);
            ER.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void write(String combination, FileWriter RW) {
        try{
            RW.write("\n" + combination);
            RW.flush();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    private String whichCombination(char ch1, char ch2) {
        String str = ch1 + "" +  ch2;
        if(str.equals("FA") || str.equals("AF")) return "Evaporacion";
        if(str.equals("FH") || str.equals("HF")) return "Derretido";
        if(str.equals("FR") || str.equals("RF")) return "Sobrecarga";
        if(str.equals("RA") || str.equals("AR")) return "Electro-carga";
        if(str.equals("RH") || str.equals("HR")) return "Superconductor";
        if(str.equals("AH") || str.equals("HA")) return "Congelar";
        if(ch1 == 'V' && (ch2 == 'F' || ch2 == 'R' || ch2 == 'A' || ch2 == 'H')) return "Torbellino";
        if(ch2 == 'V' && (ch1 == 'F' || ch1 == 'R' || ch1 == 'A' || ch1 == 'H')) return "Torbellino";
        if(ch1 == 'T' && (ch2 == 'F' || ch2 == 'R' || ch2 == 'A' || ch2 == 'H')) return "Cristalizar";
        if(ch2 == 'T' && (ch1 == 'F' || ch1 == 'R' || ch1 == 'A' || ch1 == 'H')) return "Cristalizar";
        if(ch1 == 'F' && ch2 == 'N') return "Quemadura";
        else return "";
    }


}
