package waka.conta;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@ComponentScan
public class Movimiento {

    private Date fecha = new Date();
    private Double cuantia = 0.0;
    private String concepto = "";

    public Date getFecha () {
        return fecha;
    }

    public void setFecha (Date fecha) {
        this.fecha = fecha;
    }

    public double getCuantia () {
        return cuantia;
    }

    public void setCuantia (double cuantia) {
        this.cuantia = cuantia;
    }


    public String getConcepto () {
        return concepto;
    }

    public void setConcepto (String concepto) {
        this.concepto = concepto;
    }
}
