package com.example.Movie404;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;

public class AccessOMDB
{
    private String omdbKey = "9982ab9c";
    
    private JsonElement json;
    //private JsonArray ja;
    
    @SuppressWarnings("deprecation")
	public AccessOMDB(String userInput)  //, int queryToken)
    {
        String[] omdbParameters = {"&s=", "&type=", "&y=", "&r=", "&page=", "&callback=", "&v="};
        
            // s 	      Yes 		                 <empty> 	Movie title to search for.
            // type       No 	movie, series, episode 	 <empty> 	Type of result to return.
            // y 	      No 		                 <empty> 	Year of release.
            // r 	      No 	json, xml 	         json 	        The data type to return.
            // page       No 	1-100 	                 1 	        Page number to return.
            // callback   No 		                 <empty> 	JSONP callback name.
            // v 	      No 		                 1 	        API version (reserved for future use).
            
            // Example URL: http://www.omdbapi.com/?apikey=9982ab9c&s=Jaws&r=json
            
        try
        {
            //Encode the user-supplied data to neutralize any special chars
            String encodedInput = URLEncoder.encode(userInput, "utf-8");

            // Construct API URL
            String apiURL = "http://www.omdbapi.com/?apikey=" +
                    omdbKey + omdbParameters[0] + encodedInput + omdbParameters[1] + "movie" + omdbParameters[3] + "json";
                    
            System.out.println(apiURL);
            
            // Construct Poster API URL     
            //String apiPosterURL = "http://img.omdbapi.com/?apikey=" +
            //        omdbKey + queryToken + encodedInput;
                    
            // Create URL object
            URL omdbURL = new URL(apiURL);

            // Create InputStream Object
            InputStream is = omdbURL.openStream();

            // Create InputStreamReader
            InputStreamReader isr = new InputStreamReader(is);

            // Parse input stream into a JsonElement
            JsonParser parser = new JsonParser();
            json = parser.parse(isr);
            
            // Close the stream
            is.close();
            
    }
    catch (java.net.MalformedURLException mue)
    {
        System.out.println("Malformed URL");
    }
    catch (java.io.IOException ioe)
    {
        System.out.println("IO Error");
    }
}

public String getTopMovie() //Returns the top movie's Title from the search
{
    //System.out.println(json.getAsJsonObject().get("Search").getAsJsonArray().get(0).getAsJsonObject().get("Title").getAsString());
    
    return json.getAsJsonObject().get("Search").getAsJsonArray().get(0).getAsJsonObject().get("Title").getAsString();
}

public String getTopIMDB() //Returns the top movie's IMDB ID from the search
{
    String imdbID = json.getAsJsonObject().get("Search").getAsJsonArray().get(0).getAsJsonObject().get("imdbID").getAsString();
    
    System.out.println("https://www.imdb.com/title/" + imdbID + "/");
    
    return "https://www.imdb.com/title/" + imdbID + "/";
}
}

