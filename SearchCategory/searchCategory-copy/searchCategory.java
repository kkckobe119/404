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
    public String[] selectedCategoryList = new String[100];
    
    /*
     * Creates a list of unique available categories
     */
    public String[] createCategoryList(String[] x)
    {        
        int xCount = 0;
        int listCount = 0;
        Boolean unique = true;
        
        while ( xCount < x.length ) 
        {
            //Checks if data entry is blank
            if ( x[xCount] != null )
            {
                //Checks if categoryList is empty
                if ( categoryList[0] == null ) 
                {
                    categoryList[0] = x[xCount];                    
                    listCount++;
                }
                //Finds unique strings and adds them to CategoryList
                else  
                {
                    for ( int i = 0; i < listCount; i++)
                    {
                        if ( categoryList[i].equals(x[xCount]))
                        {
                            unique = false;
                            break;
                        }
                    }
                    if (unique)
                    {
                        categoryList[listCount] = x[xCount];
                        listCount++;
                        unique = true;
                    }
                }
            }
            xCount++;
        }
        
        return categoryList;
    }
    
    /*
     * Search and create list of input category
     */
    public void sortByCategory(String[] x)
    {        
        int count = 0;
        Boolean valid = false;
        
        createCategoryList(x);
        
        /* Print category list to console */
        System.out.println("Category List "); 
        for (int i = 0; i < categoryList.length; i++) 
        {
            if (categoryList[i] != null)
            {
                System.out.println(i + ": " + categoryList[i]);
            }
            else 
                break;
        }
        
        /* Prompt user for category selection */
        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter Category");
        String selectedCategory = userInput.nextLine();
        
        /* Checks for valid selection */
        System.out.println("Validating");
        for(int i = 0; i < categoryList.length; i++) 
        {
            System.out.println("Compare: " + selectedCategory + " and " + categoryList[i]);
            if (categoryList[i] == null)
                break;
            if ( categoryList[i].equals(selectedCategory))
            {
                valid = true;
                break;
            }
        }
        
        /* If selected category valid, create list, 
         * else output error and call sortByCategory*/  
        if ( valid ) 
        {
            for ( int i = 0; i < x.length; i++ )
            {
                if (x[i].equals(selectedCategory))
                {
                    selectedCategoryList[count] = x[i];
                    count++;
                }
            }
        }
        else
        {
            System.out.println("Invalid Category");
            sortByCategory(x);
        }
        
        /* Print list of selected categories to console */
        System.out.println("Category: " + selectedCategory);
        for (int i = 0; i < selectedCategoryList.length; i++)
        {
            if (selectedCategoryList[i] != null)
            {
                System.out.println(i + ": " + selectedCategoryList[i]);
            }
        }
    }
}

