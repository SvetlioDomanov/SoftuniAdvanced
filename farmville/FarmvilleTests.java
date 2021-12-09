package farmville;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FarmvilleTests {
    //TODO: TEST ALL THE FUNCTIONALITY OF THE PROVIDED CLASS Farm

    Farm farm;

    @Before
    public void setUp() {
        farm = new Farm("Farm", 2);
    }

    @Test(expected = NullPointerException.class)
    public void testConstructorThrowsExceptionForInvalidName() {
        Farm farm = new Farm(null, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorShouldThrowExceptionForInvalidCapacity() {
        Farm farm = new Farm("name", -1);
    }

    @Test
    public void testConstructorCreatesFarmSuccessfully() {
        Assert.assertEquals("Farm", farm.getName());
        Assert.assertEquals(2, farm.getCapacity());
        Assert.assertEquals(0, farm.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddMethodThrowExceptionForAddingMoreAnimalsThanCapacity() {
        Animal animal1 = new Animal("Car", 2);
        Animal animal2 = new Animal("Dog", 4);
        Animal animal3 = new Animal("Cow", 5);
        farm.add(animal1);
        farm.add(animal2);
        farm.add(animal3);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddMethodThrowsExceptionForAddingSameAnimalTwice(){
        Animal animal = new Animal("Cat", 5);
        farm.add(animal);
        farm.add(animal);
    }

    @Test
    public void testAddMethodAddsAnimalSuccessfully(){
        Animal animal = new Animal("Car",5);
        Assert.assertEquals(0,farm.getCount());
        farm.add(animal);
        Assert.assertEquals(1,farm.getCount());
    }

    //remove method returns true
    //remove method returns false

    @Test
    public void testRemoveMethodRemovesAnimalAndReturnsTrue(){
        Animal animal = new Animal("Cat",5);
        farm.add(animal);
        Assert.assertEquals(1,farm.getCount());
        Assert.assertTrue(farm.remove(animal.getType()));
        Assert.assertEquals(0,farm.getCount());
    }

    @Test
    public void testRemoveMethodReturnsFalseForAnimalTypeNotFound(){
        Assert.assertFalse(farm.remove("Invalid Type"));
    }

}
