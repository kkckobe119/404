import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.text.Collator; 

public class ParseCSV
{   
    private KaggleStructure ks;
    private KaggleStructure[] ksa;

    public ParseCSV()
    {
        String csvFile = "Datasets/KaggleData_the_oscar_award.csv";
        BufferedReader br = null;
        
        String line = "";
        String cvsSplitBy = ",";
        
        String[] oscarMovie;
        String[][] oscarMovies = new String[10396][];
        
        ksa = new KaggleStructure[10395];
        
        try 
        {
            br = new BufferedReader(new FileReader(csvFile));
            int i = 0;
                        
            while ((line = br.readLine()) != null) 
            {
               // use comma as separator
               oscarMovie = line.split(cvsSplitBy);
                
               oscarMovies[i] = new String[] {oscarMovie[0],  oscarMovie[1],  oscarMovie[2], 
                                              oscarMovie[3],  oscarMovie[4],  oscarMovie[5], 
                                              oscarMovie[6]};
                                               
               i++;
            }
    
        } 
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } 
        catch (IOException e) {
            e.printStackTrace();
        } 
        finally 
        {
            if (br != null) 
            {
                try 
                {
                    br.close();
                } catch (IOException e) 
                {
                    e.printStackTrace();
                }
            }
        }
        
        int j = 1;
        while(j < oscarMovies.length)
        {
            ksa[j-1] = new KaggleStructure(oscarMovies[j][3], oscarMovies[j][4], 
                                           Boolean.parseBoolean(oscarMovies[j][6]), 
                                           Integer.parseInt(oscarMovies[j][0]), oscarMovies[j][5]);
            
            j++;
        }
    }
    
    public KaggleStructure[] getList()
    {
        return ksa;
    }
}
