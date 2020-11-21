import java.util.Scanner;
/**
 * Creates a list of available categories and searches for input category
 *
 * @author (Paul Marchitiello)
 * @version v0.1
 */
public class searchCategory
{
   
    public String[] categoryList = new String[30];
    public String[] selectedCategoryList;
    public searchCategory()
    {
        int y = 10;
    }
    /**
     * Constructor for objects of class searchCategory
     */
    public static void main(String args)
    {
         
    }
    
    /*
     * Creates a list of unique available categories
     */
    public void createCategoryList(String[] x)
    {
        int xCount = 0;
        int listCount = 0;
        while( xCount < x.length)
        {
            if ( x[xCount] == null ) //Checks if data entry is blank
                xCount++;
            else if ( categoryList[0] == null ) //Checks if categoryList is empty
            {
                categoryList[0] = x[xCount];
                listCount++;
                xCount++;
            }
            else if ( !(categoryList[listCount].equals(x[xCount]))) //Finds unique strings and adds them to CategoryList
            {
                categoryList[listCount++] = x[xCount];
                System.out.println(categoryList[listCount]);
                listCount++;
            }
            xCount++;
        } 
    }
    
    /*
     * Search and create list of input category
     */
    public void sortByCategory()
    {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter Category");
        String selectedCategory = userInput.nextLine();
        
        for(int i = 0; i < categoryList.length; i++)
        {
            if (categoryList[i].equals(selectedCategory))
            {
                break;
            }
        }
    }
}

