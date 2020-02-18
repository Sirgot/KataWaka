package waka.persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import waka.access.User;
import waka.conta.Movimiento;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.Optional;


@Entity
@Table(name = "T_MOVEMENT")
public interface MovementStore  extends JpaRepository<Movimiento, Integer> { //extends CrudRepository<User, Integer> {

    @Id
    String id ="";
    Date fecha = new Date();
    Double cuantia = 0.0;

}

