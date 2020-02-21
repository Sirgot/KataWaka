package waka.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import util.RandomizerAssistant;
import waka.conta.Gasto;
import waka.conta.Ingreso;
import waka.conta.Movimiento;
import waka.persistence.JPAWakaRepository;
import waka.persistence.MovementStore;

import java.util.concurrent.atomic.AtomicLong;


@RestController
public class WakaInRest {

    private static final Logger log = LoggerFactory.getLogger(WakaInRest.class);
        //    @Inject
//    MovementStore store;
    private JPAWakaRepository store;

    @Autowired
    private Gasto gasto;
    @Autowired
    private Ingreso input;

    @GetMapping(value = "/Movimiento/{cuantia}/{concepto}")
    public ResponseEntity<Movimiento> getMovimiento (@PathVariable("cuantia") double pcuantia, @PathVariable("concepto") String pconcepto) {

        log.debug("get user data @" + pcuantia + "with concept " + pconcepto);

        Movimiento mov = new Movimiento(pcuantia, pconcepto);

        store.saveMovement(mov);

        return new ResponseEntity<>(mov, HttpStatus.OK);
    }

    @GetMapping("/Movimiento")
    public Movimiento Movimiento (@RequestParam(value = "cuantia", defaultValue = "0.0") String pcuantia, @RequestParam(value = "concepto", defaultValue = "Unspecified") String pconcepto) {
        return new Movimiento(RandomizerAssistant.nextDouble(), String.format(pcuantia, pconcepto));
    }
}
