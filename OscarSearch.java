import java.util.Scanner;
import java.util.Arrays;

/**
 * Search by category, date or date range
 *
 * @author (Paul Marchitiello)
 * @version v0.2
 */
public class OscarSearch
{
    ParseJSON pj = new ParseJSON();
    HubioStructure[] hs;

    ParseCSV pc = new ParseCSV();
    KaggleStructure[] ks;

    public int hsCount = 11057;
    public int ksCount = 10395;

    public String[] categoryList = new String[1000];
    public String[] selectedCategoryList = new String[1000];

    HubioStructure[] selectedHS = new HubioStructure[12000];
    KaggleStructure[] selectedKS = new KaggleStructure[12000];

    KaggleStructure[] selectOutput;

    // Prompts user for search type and calls appropriate method
    public void Start()
    {
        hs = pj.getList();
        ks = pc.getList();

        Scanner userInput = new Scanner(System.in);
        System.out.println();
        System.out.println("Would you like to search by 'category', 'date' or 'date range'?");
        String searchType = userInput.nextLine();
        System.out.println();

        if ( searchType.equals("category") )
            searchCategory();
        else if ( searchType.equals("date") )
            searchDate();
        else if ( searchType.equals("date range"))
            searchDateRange();
        else
        {
            System.out.println("Invalid entry: " + searchType );
            System.out.println();
            Start();
        }
    }

    //Seach for movies based on date
    public void searchDate()
    {
        int count = 0;

        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter date");
        int selectedDate = userInput.nextInt();
        System.out.println();

        //Find movies and add to array
        for ( int i = 0; i < ks.length; i++)
        {
            //System.out.println(ks[i].category);
            //System.out.println(selectedDate);
            if (java.util.Objects.equals(ks[i].year, selectedDate) )
            {
                //AccessOMDB ao = new AccessOMDB(ks[i].film_name);
                String imdbLink = "Test";//ao.getTopIMDB();

                selectedKS[count] = new KaggleStructure(ks[i].category, ks[i].entity,
                        ks[i].winner, ks[i].year, ks[i].film_name, imdbLink);

                System.out.println(count + ": "
                        + "Category " + selectedKS[count].category
                        + " Entity " + selectedKS[count].entity
                        + " Winner " + selectedKS[count].winner
                        + " Year " + selectedKS[count].year
                        + " Film Name " + selectedKS[count].film_name
                        + " IMDB Link " + selectedKS[count].imdbLink);

                count++;
            }
        }

        //Error check if date not found
        if ( count == 0 )
        {
            System.out.println("Could not find " + selectedDate + ", please try again.");
            searchDate();
        }

        // //Create a copy of the array the size of returned results
        // int count2 = 0;
        // selectOutput = new KaggleStructure[count];
        // while(count2 < count)
        // {
        // selectOutput[count2] = new KaggleStructure(selectedKS[count2].category, selectedKS[count2].entity,
        // selectedKS[count2].winner, selectedKS[count2].year,
        // selectedKS[count2].film_name, selectedKS[count2].imdbLink);



        // count2++;
        // }

        //pj.toJSON(selectOutput);

        pj.toJSON(selectedKS);
    }

    //Search for movies based on date range with upper and lower bound
    public void searchDateRange ()
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
        for ( int i = 0; i < ksCount; i++)
        {
            if ( ks[i].year >= startDate && ks[i].year <= endDate )
            {
                selectedKS[count] = new KaggleStructure(ks[i].category, ks[i].entity,
                        ks[i].winner, ks[i].year, ks[i].film_name);

                System.out.println(count + ": "
                        + "Category " + selectedKS[count].category
                        + " Entity " + selectedKS[count].entity
                        + " Winner " + selectedKS[count].winner
                        + " Year " + selectedKS[count].year
                        + " Film Name " + selectedKS[count].film_name);

                count++;
            }
        }

        //Error check if no movies found within date range
        if ( count == 0 )
        {
            System.out.println("Could not find " + startDate + " - " + endDate + ", please try again.");
            searchDate();
        }

        pj.toJSON(selectedKS);
    }

    /*
     * Creates a list of unique available categories
     */
    public void CreateCategoryList()
    {
        int xCount = 0;
        int listCount = 0;
        Boolean unique = true;

        while ( xCount < ksCount )
        {
            //Checks if data entry is blank
            if ( ks[xCount].category != null )
            {
                //Checks if categoryList is empty
                if ( listCount == 0/*categoryList[0] == null*/ )
                {
                    categoryList[0] = ks[xCount].category;
                    System.out.println(listCount + ": " + categoryList[listCount]);
                    listCount++;
                }
                //Finds unique strings and adds them to CategoryList
                else
                {
                    for ( int i = 0; i < listCount && unique == true; i++)
                    {
                        if ( categoryList[i].equals(ks[xCount].category))
                        {
                            unique = false;
                        }
                    }
                    if (unique)
                    {
                        categoryList[listCount] = ks[xCount].category;
                        System.out.println(listCount + ": " + categoryList[listCount]);
                        listCount++;
                    }
                    unique = true;
                }
            }
            xCount++;
        }

        pj.toJSON(selectedKS);
    }

    /*
     * Search and create list of input category
     */
    public void searchCategory()
    {
        int count = 0;
        Boolean valid = false;

        /* Create category list */
        System.out.println("Category List ");
        CreateCategoryList();

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
            for ( int i = 0; i < ksCount; i++ )
            {
                if (ks[i].category.equals(selectedCategory))
                {
                    selectedKS[count] = new KaggleStructure(ks[i].category, ks[i].entity,
                            ks[i].winner, ks[i].year, ks[i].film_name);

                    System.out.println(count + ": "
                            + "Category " + selectedKS[count].category
                            + " Entity " + selectedKS[count].entity
                            + " Winner " + selectedKS[count].winner
                            + " Year " + selectedKS[count].year
                            + " Film Name " + selectedKS[count].film_name);

                    count++;
                }
            }
        }
        else
        {
            System.out.println();
            System.out.println("Invalid Category: " + selectedCategory);
            System.out.println();
            searchCategory();
        }

        pj.toJSON(selectedKS);
    }
}

