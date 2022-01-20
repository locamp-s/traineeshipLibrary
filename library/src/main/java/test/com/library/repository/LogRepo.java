package test.com.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import test.com.library.models.Log;

public interface LogRepo extends JpaRepository<Log, Integer>{
}
