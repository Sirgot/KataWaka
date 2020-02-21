package waka.conta;

import org.springframework.stereotype.Component;

@Component
public class Gasto extends Movimiento{
    public Gasto(){
        super();
    }

    public Gasto (double pcuantia, String pconcepto) {
        super(pcuantia, pconcepto);
    }
}
