package com.test.sampledata.book;

import java.util.Map;


public class Test {
    
    public static void main(String[] args) {
        int numberOfBooksToGenerate = 100;
        Map<String, Book> books = BookGenerator.generateBooks(numberOfBooksToGenerate);
        for (Map.Entry<String, Book> book : books.entrySet()) {
            System.out.println(book.getValue());            
        }
    }

}
