package cracking.ch03.six;

public class Dog extends Animal{
    @Override
    public boolean isSheltered() {
        return true;
    }

    public Dog(Integer number) {
        super(number);
    }
}
