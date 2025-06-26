package org.agoncal.quarkus.starting;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class BookRepository {

    public List<Book> getAllBooks() {
        return List.of(
                new Book(1, "Book 1", "Author 1", 2020, "IT"),
                new Book(2, "Book 2", "Author 2", 2020, "IT"),
                new Book(3, "Book 3", "Author 3", 2020, "IT"),
                new Book(4, "Book 4", "Author 4", 2020, "IT")
        );
    }

    public int countAllBooks() {
        return getAllBooks().size();
    }

    public Optional<Book> getBook(int id) {
        return getAllBooks().stream().filter(book -> book.id == id).findFirst();
    }
}
