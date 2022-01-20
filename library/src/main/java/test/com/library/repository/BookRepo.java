package test.com.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import test.com.library.models.Book;


import java.util.List;

public interface BookRepo extends JpaRepository<Book,Integer> {

    public List<Book> findAllByTitle(String title);

    public List<Book> findAllByAuthor(String title);

}
