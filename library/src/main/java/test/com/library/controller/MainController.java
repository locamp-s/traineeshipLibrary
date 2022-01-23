package test.com.library.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import test.com.library.models.Book;
import test.com.library.service.BookService;

import java.util.List;

@RestController
@RequestMapping
public class MainController {

    private final BookService bookService;

    public MainController(BookService bookService) {
        this.bookService = bookService;
    }


    @GetMapping("/api/hello")
    public String hello(){
        return "Highload";
    }

    @GetMapping("/books")
    public List<Book> showAllBook() {
        List<Book> allBook = bookService.getAllBook();
        return allBook;
    }

    @GetMapping("/book/{id}")
    public Book getBook(@PathVariable int id) {
        Book book = bookService.getBook(id);
//
//        if(employees == null){
//            throw new NoSuchEmployeesException("Работника c ID = " + id + "нет в БД");
//        }
        return book;
    }

    @PostMapping("/add")
    public Book addNewBook(@RequestBody Book book) {
        bookService.saveBook(book);
        return book;
    }

    @PutMapping("/update")
    public Book updateEmployees(@RequestBody Book book){
        bookService.saveBook(book);
        return book;
    }

    @DeleteMapping("/book/{id}")
    public String deleteBook(@PathVariable int id) {
        Book book = bookService.getBook(id);
        bookService.deleteBook(id);
        return "Книга с ID = " + id + " удалена из БД";
    }

    @GetMapping("/book/search/{author}")
    public List<Book> showAllBookByAuthor(@PathVariable String author) {
        List<Book> books = bookService.findAllByAuthor(author);
        return books;
    }

    @GetMapping("/book/search/{title}")
    public List<Book> showAllBookByTitle(@PathVariable String title) {
        List<Book> books = bookService.findAllByTitle(title);
        return books;
    }
}