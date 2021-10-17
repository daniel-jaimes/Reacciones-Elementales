package dao;


import model.Character;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class CharacterReader {
    public ArrayList<Character> getCharacters() {
        BufferedReader CR;
        ArrayList<Character> characters = new ArrayList<>();
        System.out.println("LEIENDO PERSONAJES...");
        CR = new BufferedReader(new dao.Reader().readerPath("files/personajes.txt"));
        String line = null;
        try {
            line = CR.readLine();
            while (line != null) {
                String[] str = line.split(" ");
                characters.add(new Character(str[0], str[1].charAt(0)));
                line = CR.readLine();
            }
            CR.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return characters;
    }
}
