package restriccion;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ServicioRestriccionMedellin extends ServicioRestriccion{

    @Override
    public boolean puedeSalir(String placa, LocalDateTime fechaHora) {
        return true;
    }

    @Override
    public BigDecimal obtenerMulta() {
        return new BigDecimal(0);
    }
}
