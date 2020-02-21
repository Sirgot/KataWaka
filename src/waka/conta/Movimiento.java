package waka.conta;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@ComponentScan
public class Movimiento {

    protected Date fecha = new Date();
    protected double cuantia = 0.0;
    protected String concepto = "";

    public Movimiento () {
        fecha = new Date();
        cuantia = 0.0;
        concepto = "";
    }

    public Movimiento (double pcuantia, String pconcepto) {
        cuantia = pcuantia;
        concepto = pconcepto;
        fecha = new Date();
    }

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
