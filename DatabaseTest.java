import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import p01_Database.Database;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {

    private static final Integer[] NUMBERS = {1, 2, 3, 4};
    private Database database;
    private static final int LARGER_THAN_SIZE_NUMBER = 17;
    private static final int SMALLER_THAN_SIZE_NUMBER = 0;
    private static final int LAST_ADDED_ELEMENT =5;


    @Before
    public void setup() throws OperationNotSupportedException {
        database = new Database(NUMBERS);
    }

    @Test
    public void testConstructorShouldReturnValidDatabase() {
        Integer[] dbElements = database.getElements();

        Assert.assertEquals("Count of dbElements is incorrect!", dbElements.length, NUMBERS.length);
        Assert.assertArrayEquals("dbElements do not match actual elements!", dbElements, NUMBERS);

    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorShouldThrowExceptionWhenSizeGreaterThan16Elements() throws OperationNotSupportedException {
        Integer[] largeArray = new Integer[LARGER_THAN_SIZE_NUMBER];

        database = new Database(largeArray);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorShouldThrowExceptionWhenSizeLessThan1Elements() throws OperationNotSupportedException {
        Integer[] smallArray = new Integer[SMALLER_THAN_SIZE_NUMBER];
        database = new Database(smallArray);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddMethodThrowsExceptionForNullElement() throws OperationNotSupportedException {
        database.add(null);
    }

    @Test
    public void testAddMethodAddsElementSuccessfully() throws OperationNotSupportedException {
        database.add(LAST_ADDED_ELEMENT);
        Integer[] dbElements = database.getElements();
        Assert.assertEquals(dbElements.length,NUMBERS.length+1);
        Assert.assertEquals(Integer.valueOf(LAST_ADDED_ELEMENT),dbElements[dbElements.length-1]);
    }

    @Test (expected = OperationNotSupportedException.class)
    public void testRemoveMethodOnEmptyDataBaseThrowsException() throws OperationNotSupportedException {
        Integer[] smallArray = {1};
        database = new Database(smallArray);
        database.remove();
        database.remove();
    }
    @Test
    public void testRemoveMethodRemovesLastElementSuccessfully() throws OperationNotSupportedException {
        database.remove();
        Integer[] dbElements = database.getElements();
        Assert.assertEquals(NUMBERS.length-1,dbElements.length);
        Assert.assertEquals(NUMBERS[NUMBERS.length-2], dbElements[dbElements.length-1]);

    }

}
