package manager;

import dao.CharacterReader;
import model.Character;

import java.util.ArrayList;

public class Controller {
    public void init() {
        writeResults(readCharacters());
        printStatistics();
    }

    private void writeResults(ArrayList<Character> characters) {
        benchmarkCharacters bmC = new benchmarkCharacters(characters);
        ElementsController EC = new ElementsController();

        EC.init();
    }
    private ArrayList<model.Character> readCharacters() {
        return new CharacterReader().getCharacters();
    }

    private void printStatistics() {

    }

}
