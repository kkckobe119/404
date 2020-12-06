import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ParseCSV
{      
    public ParseCSV()
    {
        String csvFile = "Datasets/KaggleData_the_oscar_award.csv";
        BufferedReader br = null;
        
        String line = "";
        String cvsSplitBy = ",";
        
        String[] oscarMovie = {"", "", "", "", "","",""};
        String[][] oscarMovies = new String[1000][];

        try 
        {
            br = new BufferedReader(new FileReader(csvFile));
            int i = 0;
            
            while ((line = br.readLine()) != null) 
            {

                // use comma as separator
                oscarMovie = line.split(cvsSplitBy);
                
                int count = 0;
                while (count < 7)
                {
                    oscarMovies[i][count] = oscarMovie[count];
                    count++;
                }
                
                i++;
                
                // System.out.println("Movies [year_film= " + oscarMovies[0] +
                                   // " , year_ceremony= " + oscarMovies[1] + 
                                   // " , category= " + oscarMovies[3] +
                                   // " , category_name= " + oscarMovies[4] +
                                   // " , film_name= " + oscarMovies[5] +
                                   // " , film_won= " + oscarMovies[6] +
                                   // "]");
                                   
                System.out.println("Movies [year_film= " + oscarMovies[0][0] +
                                   " , year_ceremony= " + oscarMovies[0][1] + 
                                   " , category= " + oscarMovies[0][3] +
                                   " , category_name= " + oscarMovies[0][4] +
                                   " , film_name= " + oscarMovies[0][5] +
                                   " , film_won= " + oscarMovies[0][6] +
                                   "]");

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
    }
}
