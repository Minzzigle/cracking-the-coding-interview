package cracking.ch03.six;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class AnimalShelterTest {
    private AnimalShelter animalShelter;

    @Before
    public void setUp() throws Exception {
        animalShelter = new AnimalShelter();
        animalShelter.enqueue(new Cat(1));
        animalShelter.enqueue(new Cat(2));
        animalShelter.enqueue(new Cat(3));
        animalShelter.enqueue(new Dog(4));
        animalShelter.enqueue(new Dog(5));
        animalShelter.enqueue(new Dog(6));
        animalShelter.enqueue(new Dog(7));
    }

    @Test(expected = IllegalArgumentException.class)
    public void enqueue() throws Exception {

        // when
        animalShelter.enqueue(new Pig(10));
    }

    @Test
    public void dequeueAny() throws Exception {

        // when
        Animal animal = animalShelter.dequeueAny();

        // then
    }

    @Test
    public void dequeueDog() throws Exception {
        // when
        Animal result = animalShelter.dequeueDog();

        // then
        assertThat(result.number, is(4));
        assertThat(result instanceof Dog, is(true));
    }

    @Test
    public void dequeueCat() throws Exception {
        // when
        Animal result = animalShelter.dequeueCat();

        // then
        assertThat(result.number, is(1));
        assertThat(result instanceof Cat, is(true));
    }

}