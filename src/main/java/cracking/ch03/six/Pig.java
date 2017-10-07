package cracking.ch03.six;

public class Pig extends Animal{

    public Pig(Integer number) {
        super(number);
    }

    @Override
    public boolean isSheltered() {
        return false;
    }
}
