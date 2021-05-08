package restriccion;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public abstract class ServicioRestriccion {

    public abstract BigDecimal obtenerMulta();

    public abstract boolean puedeSalir(String placa, LocalDateTime fechaHora);
}
