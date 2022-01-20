package test.com.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import test.com.library.models.User;

import java.util.List;
import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Integer> {
//    List<User> findByFullName(@Param("fullName") String fullName);
//
//    Optional<User> findById(String filter);
//
////    @Query("select u from User u where u.fullName = 'Петров Петр'")
////    User findMyUser();
}