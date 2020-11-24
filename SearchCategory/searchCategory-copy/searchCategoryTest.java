import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class searchCategoryTest.
 *
 * @author  Paul Marchitiello
 * @version v0.1
 */
public class searchCategoryTest
{
    /**
     * Default constructor for test class searchCategoryTest
     */
    // @Test
    // public void searchCategoryTest1()
    // {
        // String testArray[] = new String[10];
        // testArray[0] = "Director";
        // testArray[1] = "Directing (Dramatic Picture)";
        // testArray[2] = "WRITING (Title Writing)";
        // testArray[3] = "Director";
        // testArray[4] = "Directing (Dramatic Picture)";
        // testArray[5] = "WRITING (Title Writing)";
        // testArray[6] = "Director";
        // testArray[7] = "Directing (Dramatic Picture)";
        // testArray[8] = "WRITING (Title Writing)";
        // testArray[9] = "Director";
        // searchCategory sc = new searchCategory();
        // sc.createCategoryList(testArray);
        // assertEquals(3,testArray.length);
    // }
    
    /**
     * Default constructor for test class searchCategoryTest
     */
    @Test
    public void searchCategoryTest2()
    {
        String testArray[] = new String[10];
        testArray[0] = "Director";
        testArray[1] = "Directing (Dramatic Picture)";
        testArray[2] = "WRITING (Title Writing)";
        testArray[3] = "Director";
        testArray[4] = "Directing (Dramatic Picture)";
        testArray[5] = "WRITING (Title Writing)";
        testArray[6] = "Director";
        testArray[7] = "Directing (Dramatic Picture)";
        testArray[8] = "WRITING (Title Writing)";
        testArray[9] = "Director";
        searchCategory sc = new searchCategory();
        sc.sortByCategory(testArray);
        assertEquals(3,testArray.length);
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
}
