public class Book {

    String author;
    String title;
    int year;

    public Book (String author, String title, int year) {
        this.author = author;
        this.title = title;
        this.year = year;
    }

    public String getAuthor() {
        return this.author;
    }

    public String getTitle() {
        return this.title;
    }

    public int getYear() {
        return this.year;
    }

    public boolean equals(Object other) {
        // Your code here
    }

    public String toString() {
        // Your code here
    }
}