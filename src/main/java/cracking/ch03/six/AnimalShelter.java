package cracking.ch03.six;

import cracking.ch03.Queue;

import java.util.Random;

public class AnimalShelter {
    private Queue<Cat> catQueue;
    private Queue<Dog> dogQueue;

    public AnimalShelter() {
        this.catQueue = new Queue<>();
        this.dogQueue = new Queue<>();
    }

    public void enqueue(Animal animal) {
        if(!animal.isSheltered()) {
            throw new IllegalArgumentException();
        }

        if(animal instanceof Cat) {
            catQueue.add((Cat)animal);
        }

        if(animal instanceof Dog) {
            dogQueue.add((Dog)animal);
        }
    }

    public Animal dequeueAny() {
        if(catQueue.isEmpty() && dogQueue.isEmpty()) {
            throw new RuntimeException();
        }

        if(catQueue.isEmpty()) {
            return dogQueue.remove();
        }

        if(dogQueue.isEmpty()) {
            return catQueue.remove();
        }

        Random random = new Random();
        int rnd = random.nextInt(2);

        if(rnd == 1) {
            return catQueue.remove();
        } else {
            return dogQueue.remove();
        }
    }

    public Dog dequeueDog() {
        if(dogQueue.isEmpty()) {
            throw new RuntimeException();
        }

        return dogQueue.remove();
    }

    public Cat dequeueCat() {
        if(catQueue.isEmpty()) {
            throw new RuntimeException();
        }

        return catQueue.remove();
    }


}
