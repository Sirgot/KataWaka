package waka.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import waka.conta.Movimiento;

import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "T_MOVEMENT")
public interface MovementStore extends JpaRepository<Movimiento, Long>, JpaSpecificationExecutor<Movimiento> { // extends JpaRepository<Movimiento, Integer> //extends CrudRepository<User, Integer> {

}

