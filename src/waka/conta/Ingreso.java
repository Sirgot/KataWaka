package waka.conta;

import org.springframework.stereotype.Component;

@Component
public class Ingreso extends Movimiento {
    public Ingreso () {
        super();
    }

    public Ingreso (double pcuantia, String pconcepto) {
        super(pcuantia, pconcepto);
    }
}
