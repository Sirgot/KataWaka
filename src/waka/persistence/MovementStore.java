package waka.persistence;

import org.springframework.data.repository.CrudRepository;
import waka.conta.Movimiento;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.Optional;


@Entity
@Table(name = "T_MOVEMENT")
public class MovementStore  implements CrudRepository<Movimiento, Integer> {

    @Id
    private String id;
    private Date fecha = new Date();
    private Double cuantia = 0.0;

    public Date getFecha () {
        return fecha;
    }

    public void setFecha (Date fecha) {
        this.fecha = fecha;
    }

    public Double getCuantia () {
        return cuantia;
    }

    public void setCuantia (Double cuantia) {
        this.cuantia = cuantia;
    }

    @Override
    public <S extends Movimiento> S save (S s) {
        return null;
    }

    @Override
    public <S extends Movimiento> Iterable<S> saveAll (Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Movimiento> findById (Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById (Integer integer) {
        return false;
    }

    @Override
    public Iterable<Movimiento> findAll () {
        return null;
    }

    @Override
    public Iterable<Movimiento> findAllById (Iterable<Integer> iterable) {
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
    public void delete (Movimiento movimiento) {

    }

    @Override
    public void deleteAll (Iterable<? extends Movimiento> iterable) {

    }

    @Override
    public void deleteAll () {

    }
}

