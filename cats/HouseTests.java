package cats;

import org.junit.Assert;
import org.junit.Test;

public class HouseTests {

    House house;

    @Test (expected = IllegalArgumentException.class)
    public void testConstructorThrowsExceptionForInvalidCapacity(){
        house = new House("Name",-1);
    }

    @Test (expected = NullPointerException.class)
    public void testConstructorThrowsExceptionForInvalidName(){
        house = new House(null,1);
    }

    @Test
    public void testConstructorCreatesHouseSuccessfully(){
        house = new House("Name",2);
        Assert.assertEquals("Name",house.getName());
        Assert.assertEquals(2,house.getCapacity());
        Assert.assertEquals(0,house.getCount());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddCatThrowsExceptionForFullCapacity(){
        house = new House("Name",1);
        Cat cat = new Cat("catName");
        house.addCat(cat);
        house.addCat(cat);
    }

    @Test
    public void testAddCatAddsCatSuccessfully(){
        house = new House("Name",1);
        Assert.assertEquals(0,house.getCount());
        Cat cat = new Cat("catName");
        house.addCat(cat);
        Assert.assertEquals(1,house.getCount());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testRemoveCatThrowsExceptionForInvalidName(){
        house = new House("Name",1);
        Cat cat = new Cat("Cat");
        house.addCat(cat);
        house.removeCat("Invalid Name");
    }

    @Test
    public void testRemoveCatRemovesCatSuccessfully(){
        house = new House("Name",1);
        Cat cat = new Cat("Cat");
        house.addCat(cat);
        Assert.assertEquals(1,house.getCount());
        house.removeCat("Cat");
        Assert.assertEquals(0,house.getCount());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testCatForSaleThrowsExceptionForInvalidName(){
        house = new House("Name",1);
        house.catForSale("Invalid Name");
    }

    @Test
    public void testCatForSaleReturnsCorrectCat(){
        house = new House("Name",2);
        Cat cat1= new Cat("Cat1");
        Cat cat2= new Cat("Cat2");
        house.addCat(cat1);
        house.addCat(cat2);
        Cat returnedCat = house.catForSale("Cat2");
        Assert.assertFalse(returnedCat.isHungry());
    }

    @Test
    public void testStatisticsReturnsCorrectMessage(){
        house = new House("Name",2);
        Cat cat1= new Cat("Cat1");
        Cat cat2= new Cat("Cat2");
        house.addCat(cat1);
        house.addCat(cat2);
        String returnedMessage = house.statistics();
        Assert.assertEquals("The cat Cat1, Cat2 is in the house Name!",returnedMessage);
    }


}
