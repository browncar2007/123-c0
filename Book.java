// Caronn Brown
// 11/21/2025
// CSE 123
// C0: Search Engine
// TA: 

import java.util.*;
// Class Comment: 
// This class creates a Book object that stores the title, authors, and the book's content.
// With the book object you can get the title of the book, get the artists who made it,
// give the book a rating, get the average rating, get the content of the book, get a string
// reprsentation of the book, and compare other books. 
// This class implements Media and Comparable interfaces.

public class Book implements Media, Comparable<Book> {
    private String title;
    private List<String> authors;
    private List<String> bookText;
    private List<Integer> ratings;

// B: 
// E: 
// R: 
// P: 
    public Book(String title, List<String> authors, Scanner content) {
        this.title = title;
        this.authors = authors;
        bookText = new ArrayList<>();
        ratings = new ArrayList<>();
        while(content.hasNext()){
            bookText.add(content.next());
        }
    }

// B: 
// E: 
// R: 
// P: 
    @Override
    public String getTitle() {
        return title;
    }

// B: 
// E: 
// R: 
// P: 
    @Override
    public List<String> getArtists() {
        List<String> temp = new ArrayList<>();
        for(String author : authors){
            temp.add(author);
        }
        return temp;
    }

// B: 
// E: 
// R: 
// P: 
    @Override
    public void addRating(int score) {
        if(score < 0) {
            throw new IllegalArgumentException();
        }
        ratings.add(score);
    }
// B: 
// E: 
// R: 
// P: 
    @Override
    public int getNumRatings(){
        return ratings.size();
    }


// B: 
// E: 
// R: 
// P: 
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

// B: 
// E: 
// R: 
// P: 
    @Override
    public List<String> getContent() {
       List<String> temp = new ArrayList<>();
       for(String word : bookText){
        temp.add(word);
       }
       return temp;
    }

// B: 
// E: 
// R: 
// P: 
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

// B: 
// E: 
// R: 
// P: 
    public int compareTo(Book other) {
        return this.title.compareTo(other.title);
    }
}