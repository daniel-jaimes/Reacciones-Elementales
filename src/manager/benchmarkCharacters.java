package manager;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

public class benchmarkCharacters {
    private int totalCharacters;
    private int totalElementsUsed;
    private String[][] charactersByElements;
    public benchmarkCharacters(ArrayList<model.Character> characters){
        ArrayList<String> elementsUsed;
        ArrayList<String> elements = new ArrayList<>();
        ArrayList<String> counterByElement = new ArrayList<>();
        this.totalCharacters = characters.size();
        //Guradamos todos los elementos del array de personaje
        characters.forEach(character -> {
            char type = character.getType();
            switch (type){
                case 'F':
                case 'R':
                case 'A':
                case 'H':
                case 'T':
                case 'V':
                case 'N':
                    elements.add(String.valueOf(character.getType()));
                    break;
            }
        });
        //Filtramos los elementos que se repiten
        elementsUsed = (ArrayList<String>) elements
                .stream()
                .distinct().collect(Collectors.toList());
        this.totalElementsUsed = elementsUsed.size();
        //Inicalizamos una matrix de 2 fila por la cantidad de letras que se usen.
        this.charactersByElements = new String[2][this.totalElementsUsed];

        //Counter of each element
        elementsUsed.forEach(element -> {
            counterByElement.add(String.valueOf(Collections.frequency(elements, element)));
        });
        //Order alphabetically and set value
        this.charactersByElements = orderAlphabetically(elementsUsed, counterByElement);
    }

    private String[][] orderAlphabetically(ArrayList<String> elementsUsed, ArrayList<String> counterByElement) {
        ArrayList<String> orderedElements = new ArrayList<String>();
        ArrayList<String> orderedValues = new ArrayList<String>();
        String[][] charactersByElements = new String[2][elementsUsed.size()];
        do{
            int j = 0;
            char char1 = elementsUsed.get(j).charAt(0);
            int index1 = j;
            for (int k = j + 1; k < elementsUsed.size(); k++) {
                char char2 = elementsUsed.get(k).charAt(0);
                if (char2 < char1){
                    char1 = char2;
                    index1 = k;
                }
            }
            orderedElements.add(elementsUsed.get(index1));
            elementsUsed.remove(index1);
            orderedValues.add(counterByElement.get(index1));
            counterByElement.remove(index1);
        }while(elementsUsed.size() > 0);
        charactersByElements[0] = orderedElements.toArray(new String[0]);
        charactersByElements[1] = orderedValues.toArray(new String[0]);
        return charactersByElements;
    }

    @Override
    public String toString() {
        String str = "Total de personajes: " + this.totalCharacters +
                "\nTotal de elementos utilizados: " + this.totalElementsUsed +
                "\nTotal de personajes por elemento:";
        for (int i = 0; i < this.charactersByElements[0].length; i++) {
            if(Integer.parseInt(this.charactersByElements[1][i]) > 0) {
                str += "\n\t- " + this.charactersByElements[0][i] + " : " + this.charactersByElements[1][i];
            }
        }
        return str;
    }

    void write(FileWriter RW) {
        try{
            RW.write(this.toString());
            RW.flush();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

}
