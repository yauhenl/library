package com.yauhenl.library.service;

import com.yauhenl.library.domain.Book;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LibraryService {
    private static LibraryService instance;
    private static Map<String, Book> books = new ConcurrentHashMap<>();


    public static LibraryService getInstance() {
        if (instance == null) {
            instance = new LibraryService();
            for (int i = 0; i < 5; i++) {
                books.put(String.valueOf(i), new Book(String.valueOf(i), String.valueOf(i)));
            }
        }
        return instance;
    }

    public Map<String, Book> getBooks() {
        return books;
    }

    public void addBook(Book book) {
        books.put(book.getTitle(), book);
    }

    public void remove(String title) {
        books.remove(title);
    }
}
