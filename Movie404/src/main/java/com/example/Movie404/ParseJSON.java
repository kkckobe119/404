package com.example.Movie404;


import com.google.gson.Gson;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.util.Scanner;

public class ParseJSON
{
    //private JsonArray ja;
    public static HubioStructure[] hs;
       
	@SuppressWarnings("resource")
	public ParseJSON(String userInput)
    {
        String hubioData = "src/main/resources/datahubio_oscar_data_json.json";
        try
        {
            // Create InputStream Object
            InputStream fis = new FileInputStream(hubioData);

            // Create InputStreamReader
            InputStreamReader isr = new InputStreamReader(fis);
            
            // Turns InputStream into a String
            Scanner s = new Scanner(isr).useDelimiter("\\A");
            String jsonString = s.hasNext() ? s.next() : "";

            // Parse String into a Wrapper Class array using a JSON Element
            Gson gson = new Gson();
            hs = gson.fromJson(jsonString, HubioStructure[].class);

            // Parse the string into a JSON Array object
            //ja = (JsonArray) new JsonParser().parse(jsonString);
        }
        catch (java.io.IOException ioe)
        {
            System.out.println("IO Error");
        }
    }



    public HubioStructure[] getList() //Returns an array of the complete HubioStructures pulled from the database
    {
        return hs;
    }

    /**

    public String getCategory()  // Returns the category

    {
        if(ja.isJsonArray()) 
        {
            return ( (JsonObject)ja.get(0) ).get("category").getAsString();
        }
        return null;
    }

        public static void main(String[] args)
    {
        ParseJSON pj = new ParseJSON("");
        System.out.println(pj.getCategory());
    }
    **/
}