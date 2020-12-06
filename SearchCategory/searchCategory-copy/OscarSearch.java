import java.util.Scanner;
/**
 * Search by category, date or date range
 *
 * @author (Paul Marchitiello)
 * @version v0.2
 */
public class OscarSearch
{
   
    public String[] categoryList = new String[100];
    public String[] selectedCategoryList = new String[100];
    public int[] dateList = new int[100];
    
    // Prompts user for search type and calls appropriate method
    public void Start(String[] x, int[] y)
    {
        Scanner userInput = new Scanner(System.in);
        System.out.println();
        System.out.println("Would you like to search by 'category', 'date' or 'date range'?");
        String searchType = userInput.nextLine();
        System.out.println();
        
        if ( searchType == "category" )
            searchCategory(x);
        else if ( searchType == "date" )
            searchDate(y);
        else if ( searchType == "date range")
            searchDateRange(y);
        else
        {
            System.out.println("Invalid entry: " + searchType );
            System.out.println();
            Start(x,y);
        }    
    }
    
    //Seach for movies based on date
    public void searchDate(int[] y)
    {
        int count = 0;
        
        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter date");
        int selectedDate = userInput.nextInt();
        System.out.println();
        
        //Find movies and add to array
        for ( int i = 0; i < y.length; i++)
        {
            if ( y[i] == selectedDate )
            {
                dateList[count] = y[i];
                System.out.println(count + ": " + dateList[count]);
                count++;
            }  
        }
        
        //Error check if date not found
        if ( count == 0 )
        {
            System.out.println("Could not find " + selectedDate + ", please try again.");
            searchDate(y);
        }
    }
    
    //Search for movies based on date range with upper and lower bound
    public void searchDateRange (int[] y)
    {
        int count = 0;
        
        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter starting date");
        int startDate = userInput.nextInt();
        System.out.println();
        System.out.println("Enter end date");
        int endDate = userInput.nextInt();
        System.out.println();
        
        //Find movies that are within the given date range
        for ( int i = 0; i < y.length; i++)
        {
            if ( y[i] >= startDate && y[i] <= endDate )
            {
                dateList[count] = y[i];
                System.out.println(count + ": " + dateList[count]);
                count++;
            }  
        }
        
        //Error check if no movies found within date range
        if ( count == 0 )
        {
            System.out.println("Could not find " + startDate + " - " + endDate + ", please try again.");
            searchDate(y);
        }
    }
    
    /*
     * Creates a list of unique available categories
     */
    public String[] CreateCategoryList(String[] x)
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
    public void searchCategory(String[] x)
    {        
        int count = 0;
        Boolean valid = false;
        
        CreateCategoryList(x);
        
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
        System.out.println();
        System.out.println("Enter Category");
        String selectedCategory = userInput.nextLine();
        System.out.println();
        
        /* Checks for valid selection */
        System.out.println("Validating");
        for(int i = 0; i < categoryList.length; i++) 
        {
            //System.out.println("Compare: " + selectedCategory + " and " + categoryList[i]);
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
            /* Print list of selected categories to console */
            System.out.println();
            System.out.println("Category: " + selectedCategory);
            for (int i = 0; i < selectedCategoryList.length; i++)
            {
                if (selectedCategoryList[i] != null)
                {
                    System.out.println(i + ": " + selectedCategoryList[i]);
                }
            }
        }
        else
        {
            System.out.println();
            System.out.println("Invalid Category: " + selectedCategory);
            System.out.println();
            searchCategory(x);
        }
    }
}

