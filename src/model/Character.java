package model;

public class Character {
    private String name;
    private char element;
    public Character(String name, char element) {
        this.name = name;
        this.element = element;
    }
    public char getType() {
        return this.element;
    }

}
