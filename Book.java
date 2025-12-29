import java.util.*;
public class Book implements Media, Comparable<Book> {
    private String title;
    private List<String> authors;
    private List<String> bookText;
    private List<Integer> ratings;

    public Book(String title, List<String> authors, Scanner content) {
        this.title = title;
        this.authors = authors;
        bookText = new ArrayList<>();
        ratings = new ArrayList<>();
        while(content.hasNext()){
            bookText.add(content.next());
        }
    }
    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public List<String> getArtists() {
        List<String> temp = new ArrayList<>();
        for(String author : authors){
            temp.add(author);
        }
        return temp;
    }

    @Override
    public void addRating(int score) {
        if(score < 0) {
            throw new IllegalArgumentException();
        }
        ratings.add(score);
    }

    @Override
    public int getNumRatings(){
        return ratings.size();
    }

    @Override
    public double getAverageRating() {
        if(ratings.isEmpty()){
            return 0;
        }
        double sum = 0;
        for(int rating : ratings){
            sum += rating;
        }
        return sum/ratings.size();
    }

    @Override
    public List<String> getContent() {
       List<String> temp = new ArrayList<>();
       for(String word : bookText){
        temp.add(word);
       }
       return temp;
    }

    @Override
    public String toString() {
        if(ratings.isEmpty()) {
            return title + " by " + authors.toString();
        } else {
            return
            title + " by " + authors.toString() + ": " +
            Double.toString(getAverageRating()) + " (" + getNumRatings() + " ratings)";
        }
    }

    @Override
    public int compareTo(Book other) {
        return this.title.compareTo(other.title);
    }
}