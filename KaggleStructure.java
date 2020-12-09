public class KaggleStructure
{
    public String category;
    public String entity;
    public Boolean winner;
    public int year;
    public String film_name;
    String imdbLink;

    KaggleStructure(String category, String entity,
                    Boolean winner, int year, String film_name)
    {
        this.category = category;
        this.entity = entity;
        this.winner = winner;
        this.year = year;
        this.film_name = film_name;
    }
    KaggleStructure(String category, String entity,
                    Boolean winner, int year, String film_name, String imdbLink)
    {
        this.category = category;
        this.entity = entity;
        this.winner = winner;
        this.year = year;
        this.film_name = film_name;
        this.imdbLink = imdbLink;
    }
}