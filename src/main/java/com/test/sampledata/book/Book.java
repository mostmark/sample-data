package com.test.sampledata.book;

public class Book {
    
    String isbn;
    String title;
    String description;    
    int publicationYear;
    String author;

    public Book(String isbn, String title, String description, int publicationYear, String author) {
        this.title = title;
        this.description = description;
        this.publicationYear = publicationYear;
        this.author = author;
    }
    
    public Book() {
    }

    @Override
    public String toString() {
        return "Book{" + "isbn=" + isbn + ", title=" + title + ", description=" + description + ", publicationYear=" + publicationYear + ", author=" + author + '}';
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

}
