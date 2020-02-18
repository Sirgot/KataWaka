package waka.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import waka.access.User;

import java.util.List;

public interface UserStore extends JpaRepository<User, Integer> { //extends CrudRepository<User, Integer> {

    @Repository
    public interface UserRepository extends CrudRepository<User, Long> {
        @Query("SELECT c FROM User.getTable c WHERE c.name LIKE CONCAT('%',:ending, '%') AND c.population < :num")
        List<User> findByNameEndingWithAndPopulationLessThan (@Param("ending") String ending,   @Param("num") Integer num);
    }
}
