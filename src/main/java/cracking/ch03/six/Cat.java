package cracking.ch03.six;

public class Cat extends Animal{

    @Override
    public boolean isSheltered() {
        return true;
    }

    public Cat(Integer number) {
        super(number);
    }
}
