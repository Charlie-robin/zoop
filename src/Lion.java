public class Lion extends Animal{

    private boolean isSleeping;

    public Lion(String name, String id) {
        super(name, "lion", id, "Rooooooaarrrrr");
        this.isSleeping = true;
    }

    public boolean isSleeping() {
        return isSleeping;
    }
}
