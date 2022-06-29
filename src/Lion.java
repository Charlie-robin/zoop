public class Lion extends Animal{
    private boolean isSleeping;

    public Lion(String name) {
        super(name, "lion", "Rooooooaarrrrr");
        this.isSleeping = true;
    }

    public boolean isSleeping() {
        return isSleeping;
    }
}
