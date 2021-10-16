package manager;

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
            elements.add(String.valueOf(character.getType()));
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
        //Le damos valor
        this.charactersByElements[0] = elementsUsed.toArray(new String[0]);
        this.charactersByElements[1] = counterByElement.toArray(new String[0]);

    }
    @Override
    public String toString() {
        return "";
    }
}
