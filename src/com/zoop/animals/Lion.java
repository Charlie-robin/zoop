package com.zoop.animals;

public class Lion extends Animal{
    private boolean isSleeping;

    public Lion(String name) {
        super(name, AnimalTypes.LION, "Rooooooaarrrrr");
        this.isSleeping = true;
    }

    public boolean isSleeping() {
        return isSleeping;
    }
}
