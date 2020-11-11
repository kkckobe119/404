import java.util.Scanner;
/**
 * Write a description of class searchCategory here.
 *
 * @author (Paul Marchitiello)
 * @version v0.1
 */
public class searchCategory
{
    private String[] categoryList;
    private String[] selectedCategoryList;

    /**
     * Constructor for objects of class searchCategory
     */
    public static void main(String args)
    {
        //createCategoryList( Insert String Array );
    }
    
    public void createCategoryList(String[] x)
    {
        int xCount = 0;
        int listCount = 0;
        while( xCount < x.length)
        {
            if ( x[xCount] == null )
                xCount++;
            else if ( categoryList[0] == null )
            {
                categoryList[0] = x[xCount];
                listCount++;
            }
            else if ( !categoryList[listCount].equals(x[xCount]))
            {
                categoryList[listCount] = x[xCount];
                System.out.println(categoryList[listCount]);
                listCount++;
            }
            xCount++;
        } 
    }
    
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
