package test.com.library.service;

import test.com.library.models.Book;

import java.util.List;

public interface BookService {

    public List<Book> getAllBook();

    public void saveBook(Book book);

    public void deleteBook(int id);

    public List<Book> findAllByTitle(String title);

    public Book getBook(int id);

    public List<Book> findAllByAuthor(String author);
}
