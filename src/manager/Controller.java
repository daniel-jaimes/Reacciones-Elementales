package manager;

import dao.CharacterReader;
import dao.ResultsReader;
import dao.ResultsWriter;
import model.Character;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Controller {
    public void init() {
        writeResults(readCharacters());
        printStatisticsTerminal();
    }

    private void writeResults(ArrayList<Character> characters) {
        benchmarkCharacters bmC = new benchmarkCharacters(characters);
        ElementsController EC = new ElementsController();
        FileWriter RW = new ResultsWriter().setResults();
        bmC.write(RW);
        EC.init(RW);
        try {
            RW.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private ArrayList<model.Character> readCharacters() {
        return new CharacterReader().getCharacters();
    }

    private void printStatisticsTerminal() {
        System.out.println("IMPRIMIENDO RESULTADOS...");
        try (BufferedReader BR_RR = new BufferedReader(new ResultsReader().getResults())){
            String thisLine;
            while ((thisLine = BR_RR.readLine()) != null) {
                System.out.println(thisLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
