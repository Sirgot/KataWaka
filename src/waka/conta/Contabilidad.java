package waka.conta;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Contabilidad implements ContabilidadOperations {


    private List<Gasto> gastos = new ArrayList<>();
    private List<Ingreso> ingresos = new ArrayList<>();
    private double totalIngresos = 0.0;
    private double totalGastos = 0.0;
    private double total;

    public List<Gasto> getGastos () {
        return gastos;
    }

    public void setGastos (List<Gasto> gastos) {
        this.gastos = gastos;
    }

    public List<Ingreso> getIngresos () {
        return ingresos;
    }

    public void setIngresos (List<Ingreso> ingresos) {
        this.ingresos = ingresos;
    }

    public double getTotalIngresos () {
        return totalIngresos;
    }

    public void setTotalIngresos (double totalIngresos) {
        this.totalIngresos = totalIngresos;
    }

    public double getTotalGastos () {
        return totalGastos;
    }

    public void setTotalGastos (double totalGastos) {
        this.totalGastos = totalGastos;
    }

    public double getTotal () {
        return total;
    }

    public void setTotal (double total) {
        this.total = total;
    }


    @Override
    public boolean addMovimiento (Movimiento param) {
        if (param != null) {
            if (param instanceof Ingreso)
            {
                if (this.ingresos.add((Ingreso)param)) {
                    totalIngresos += param.getCuantia();
                }
            }
            if (param instanceof Gasto)
            {
               if ( this.gastos.add((Gasto)param))
               {
                   totalGastos += param.getCuantia();
               }
            }
            total = totalIngresos - totalGastos;
//            updateAccount();
        }
        return true;
    }
}
