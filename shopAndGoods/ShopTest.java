package shopAndGoods;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class ShopTest {

    private Shop shop;
    private Goods good;

    @Before
    public void setShop() {
        this.shop = new Shop();
        this.good = new Goods("good1", "1");
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testGetShelvesShouldReturnExceptionForModifyingCollection() {
        shop.getShelves().clear();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddGoodsShouldThrowExceptionForInvalidShelf() throws OperationNotSupportedException {
        shop.addGoods("Invalid Shelf", good);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddGoodsShouldThrowExceptionForOccupiedShelf() throws OperationNotSupportedException {
        shop.addGoods("Shelves1", good);
        Goods good2 = new Goods("Good2", "2");
        shop.addGoods("Shelves1", good2);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddGoodsShouldThrowExceptionForAlreadyAddedGood() throws OperationNotSupportedException {
        shop.addGoods("Shelves1", good);
        shop.addGoods("Shelves2", good);
    }

    @Test
    public void testAddGoodsRunsSuccessfully() throws OperationNotSupportedException {
        shop.addGoods("Shelves1", good);
        Goods addedGood = shop.getShelves().get("Shelves1");
        Assert.assertEquals(good, addedGood);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveShouldThrowExceptionForInvalidShelf() throws IllegalArgumentException{
        shop.removeGoods("Invalid Shelf", good);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveShouldThrowExceptionForRemovingInvalidGood() throws OperationNotSupportedException, IllegalArgumentException {
        shop.addGoods("Shelves1",good);
        Goods differentGood = new Goods("DifferentGood", "2");
        shop.removeGoods("Shelves1",differentGood);
    }

    @Test
    public void testRemoveMethodRemovesSuccessfully() throws OperationNotSupportedException {
        shop.addGoods("Shelves1",good);
        shop.removeGoods("Shelves1",good);
        Goods removedGood = shop.getShelves().get("Shelves1");
        Assert.assertNull(removedGood);

    }

    @Test
    public void testRemoveMethodShouldReturnCorrectMessage() throws OperationNotSupportedException {
        shop.addGoods("Shelves1",good);
        String actualMessage = shop.removeGoods("Shelves1",good);
        Assert.assertEquals("Goods: 1 is removed successfully!", actualMessage);
    }
    @Test
    public void testAddGoodsShouldReturnCorrectMessage() throws OperationNotSupportedException {
        String actualMessage = shop.addGoods("Shelves1",good);
        Assert.assertEquals("Goods: 1 is placed successfully!", actualMessage);

    }

}