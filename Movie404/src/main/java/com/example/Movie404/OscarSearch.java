package com.example.Movie404;

import java.util.Scanner;

public class OscarSearch
{
    static ParseJSON pj = new ParseJSON("");
    static HubioStructure[] hs; 
    
    public static int dataCount = 11057;
    
    public static String[] categoryList = new String[1000];
    public String[] selectedCategoryList = new String[1000];
    static HubioStructure[] selectedHS = new HubioStructure[10000];
    
    
    
    public static ParseJSON getPj() {
		return pj;
	}

	public static void setPj(ParseJSON pj) {
		OscarSearch.pj = pj;
	}

	public static HubioStructure[] getHs() {
		return hs;
	}

	public static void setHs(HubioStructure[] hs) {
		hs = pj.getList();
	}

	public static int getDataCount() {
		return dataCount;
	}

	public static void setDataCount(int dataCount) {
		OscarSearch.dataCount = dataCount;
	}

	public static String[] getCategoryList() {
		return categoryList;
	}

	public static void setCategoryList(String[] categoryList) {
		OscarSearch.categoryList = categoryList;
	}

	public String[] getSelectedCategoryList() {
		return selectedCategoryList;
	}

	public void setSelectedCategoryList(String[] selectedCategoryList) {
		this.selectedCategoryList = selectedCategoryList;
	}

	public static HubioStructure[] getSelectedHS() {
		return selectedHS;
	}

	public static void setSelectedHS(HubioStructure[] selectedHS) {
		OscarSearch.selectedHS = selectedHS;
	}

	// Prompts user for search type and calls appropriate method
    public static void Start()
    {
        hs = pj.getList();
        
        @SuppressWarnings("resource")
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
    
    //Search for movies based on date
    public static void searchDate()
    {
        int count = 0;
        
        @SuppressWarnings("resource")
		Scanner userInput = new Scanner(System.in);
        System.out.println("Enter date");
        int selectedDate = userInput.nextInt();
        System.out.println();
        
        //Find movies and add to array
        for ( int i = 0; i <= dataCount; i++)
        {
            if ( hs[i].year == selectedDate )
            {
                selectedHS[count] = hs[i];
                System.out.println(count + ": " 
                + "Category " + selectedHS[count].category 
                + " Entity " + selectedHS[count].entity 
                + " Winner " + selectedHS[count].winner 
                + " Year " + selectedHS[count].year);
                count++;
            }  
        }
        
        //Error check if date not found
        if ( count == 0 )
        {
            System.out.println("Could not find " + selectedDate + ", please try again.");
            searchDate();
        }
    }
    
    //Search for movies based on date range with upper and lower bound
    public static void searchDateRange ()
    {
        int count = 0;
        
        @SuppressWarnings("resource")
		Scanner userInput = new Scanner(System.in);
        System.out.println("Enter starting date");
        int startDate = userInput.nextInt();
        System.out.println();
        System.out.println("Enter end date");
        int endDate = userInput.nextInt();
        System.out.println();
        
        //Find movies that are within the given date range
        for ( int i = 0; i <= dataCount; i++)
        {
            if ( hs[i].year >= startDate && hs[i].year <= endDate )
            {
                selectedHS[count] = hs[i];
                System.out.println(count + ": " 
                + "Category " + selectedHS[count].category 
                + " Entity " + selectedHS[count].entity 
                + " Winner " + selectedHS[count].winner 
                + " Year " + selectedHS[count].year);
                count++;
            }  
        }
        
        //Error check if no movies found within date range
        if ( count == 0 )
        {
            System.out.println("Could not find " + startDate + " - " + endDate + ", please try again.");
            searchDate();
        }
    }
    
    /*
     * Creates a list of unique available categories
     */
    public static void CreateCategoryList()
    {        
        int xCount = 0;
        int listCount = 0;
        Boolean unique = true;
        
        while ( xCount <= dataCount ) 
        {
            //Checks if data entry is blank
            if ( hs[xCount].category != null )
            {
                //Checks if categoryList is empty
                if ( listCount == 0/*categoryList[0] == null*/ ) 
                {
                    categoryList[0] = hs[xCount].category;
                    System.out.println(listCount + ": " + categoryList[listCount]);
                    listCount++;
                }
                //Finds unique strings and adds them to CategoryList
                else  
                {
                    for ( int i = 0; i < listCount && unique == true; i++)
                    {
                        if ( categoryList[i].equals(hs[xCount].category))
                        {
                            unique = false;
                        }
                    }
                    if (unique)
                    {
                        categoryList[listCount] = hs[xCount].category;
                        System.out.println(listCount + ": " + categoryList[listCount]);
                        listCount++;
                    }
                    unique = true;
                }
            }
            xCount++;
        }
    }
    
    /*
     * Search and create list of input category
     */
    public static void searchCategory()
    {        
        int count = 0;
        Boolean valid = false;
        
        /* Create category list */
        System.out.println("Category List "); 
        CreateCategoryList();
        
        /* Prompt user for category selection */
        @SuppressWarnings("resource")
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
            for ( int i = 0; i <= dataCount; i++ )
            {
                if (hs[i].category.equals(selectedCategory))
                {
                    selectedHS[count] = hs[i];
                    System.out.println(count + ": " 
                    + "Category " + selectedHS[count].category 
                    + " Entity " + selectedHS[count].entity 
                    + " Winner " + selectedHS[count].winner 
                    + " Year " + selectedHS[count].year);
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
    }
}

