package test.com.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.com.library.models.Book;
import test.com.library.repository.BookRepo;

import java.util.List;
import java.util.Optional;


@Service
public class BookServiceImpl implements BookService {

    @Autowired
    public BookRepo bookRepo;


    @Override
    public List<Book> getAllBook() {
        return bookRepo.findAll();
    }

    @Override
    public void saveBook(Book book) {
        bookRepo.save(book);
    }

    @Override
    public Book getBook(int id) {
        Book book = null;
        Optional<Book> optional = bookRepo.findById(id);
        if(optional.isPresent()){
            book = optional.get();
        }
        return book;
    }

    @Override
    public List<Book> findAllByAuthor(String author) {
        List<Book> books = bookRepo.findAllByAuthor(author);
        return books;
    }

    @Override
    public void deleteBook(int id) {
        bookRepo.deleteById(id);

    }

    @Override
    public List<Book> findAllByTitle(String title) {
        List<Book> books = bookRepo.findAllByTitle(title);
        return books;
    }
}
