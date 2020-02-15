package waka.persistence;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import waka.access.User;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;
import java.util.Optional;

@Entity
@Table(name = "T_USER")
public class UserStore implements CrudRepository<User, Integer> {

    @Id
    private String id;

    public static String getTable () {
        return table;
    }

    public static void setTable (String param) {
        table = param;
    }

    private static String table = "" ;

    @Override
    public <S extends User> S save (S s) {
        return null;
    }

    @Override
    public <S extends User> Iterable<S> saveAll (Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<User> findById (Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById (Integer integer) {
        return false;
    }

    @Override
    public Iterable<User> findAll () {
        return null;
    }

    @Override
    public Iterable<User> findAllById (Iterable<Integer> iterable) {
        return null;
    }

    @Override
    public long count () {
        return 0;
    }

    @Override
    public void deleteById (Integer integer) {

    }

    @Override
    public void delete (User user) {

    }

    @Override
    public void deleteAll (Iterable<? extends User> iterable) {

    }

    @Override
    public void deleteAll () {

    }

    @Repository
    public interface UserRepository extends CrudRepository<User, Long> {
        @Query("SELECT c FROM UserStore.getTable c WHERE c.name LIKE CONCAT('%',:ending, '%') AND c.population < :num")
        List<User> findByNameEndingWithAndPopulationLessThan(@Param("ending") String ending,
                                                             @Param("num") Integer num);
    }
}
