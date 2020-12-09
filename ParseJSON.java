//import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.JsonObject;
import com.google.gson.Gson;
import com.google.gson.JsonArray;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.util.Scanner;
//import java.util.Arrays;

public class ParseJSON
{
    //private JsonArray ja;
    private HubioStructure[] hs;
    
       
    public ParseJSON()
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
            
            // Parse String into a Wrapper Class array using a JSON Element
            Gson gson = new Gson();
            hs = gson.fromJson(jsonString, HubioStructure[].class);
            
            // Parse the string into a JSON Array object
            //ja = (JsonArray) new JsonParser().parse(jsonString);
            
            // Close the stream
            fis.close();
        }
        catch (java.io.IOException ioe)
        {
            System.out.println("IO Error");
        }
    }

    /*
    public String getCategory()
    {
        if(ja.isJsonArray()) 
        {
            return ( (JsonObject)ja.get(0) ).get("category").getAsString();
        }
        return null;
    }*/
    public HubioStructure[] getList()
    {
        return hs;
    }
    
    public void toJSON(KaggleStructure[] dataStruct)
    {
        try
        {
        String filePath = "Datasets/output.json";
        Gson gsonOutput = new Gson();
        
        gsonOutput.toJson(dataStruct, new FileWriter(filePath));
        }
        catch (java.io.IOException ioe)
        {
            System.out.println("IO Error");
        }
    }
    
    // public static void main(String[] args)
    // {
        // ParseJSON pj = new ParseJSON();
        // HubioStructure[] hs = pj.getList();
        
        // pj.toJSON();
        
        // AccessOMDB ao = new AccessOMDB("");
        
        // //System.out.println(hs[1].film_name);
        // //System.out.println(pj.getList());
    // }
}