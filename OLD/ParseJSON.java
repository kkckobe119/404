import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.JsonObject;
import com.google.gson.Gson;
import com.google.gson.JsonArray;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.util.Scanner;

public class ParseJSON<T>
{
    private JsonArray ja;
    private HubioStructure[] hs;
       
    public ParseJSON(String userInput)
    {
        String hubioData = "Datasets/datahubio_oscar_data_json.json";
        try
        {
            // Create InputStream Object
            InputStream fis = new FileInputStream(hubioData);

            // Create InputStreamReader
            InputStreamReader isr = new InputStreamReader(fis);
            
            // Turns InputStream into a String
            Scanner s = new Scanner(isr).useDelimiter("\\A");
            String jsonString = s.hasNext() ? s.next() : "";
            
            // Parse String into a JsonElement using Wrapper Class
            Gson gson = new Gson();
            hs = gson.fromJson(jsonString, HubioStructure[].class);
            
            ja = (JsonArray) new JsonParser().parse(jsonString);

        }
        catch (java.io.IOException ioe)
        {
            System.out.println("IO Error");
        }
    }

    /**
     * Returns the category
     */
    public String getCategory()
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
}