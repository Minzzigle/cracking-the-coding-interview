package cracking.ch03.six;

public abstract class Animal {
    public Integer number = 0;

    public abstract boolean isSheltered();

    public Animal(Integer number) {
        this.number = number;
    }
}
