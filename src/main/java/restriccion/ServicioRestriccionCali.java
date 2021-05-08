package restriccion;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ServicioRestriccionCali extends ServicioRestriccion{

    @Override
    public BigDecimal obtenerMulta() {
        return new BigDecimal(454260);
    }

    @Override
    public boolean puedeSalir(String placa, LocalDateTime fechaHora) {
        boolean estaEnHoraRestriccion = (fechaHora.getHour() >= 6 && fechaHora.getHour() <= 10)
                || (fechaHora.getHour() >= 16 && fechaHora.getHour() <= 20);

        char ultimoDigito = placa.charAt(placa.length() - 1);

        switch (fechaHora.getDayOfWeek()) {
            case MONDAY:
                if ((ultimoDigito == '1' || ultimoDigito == '2') && estaEnHoraRestriccion) {
                    return false;
                }
                break;
            case TUESDAY:
                if ((ultimoDigito == '3' || ultimoDigito == '4') && estaEnHoraRestriccion)
                {
                    return false;
                }
                break;
            case WEDNESDAY:
                if ((ultimoDigito == '5' || ultimoDigito == '6') && estaEnHoraRestriccion)
                {
                    return false;
                }
                break;
            case THURSDAY:
                if ((ultimoDigito == '7' || ultimoDigito == '8') && estaEnHoraRestriccion)
                {
                    return false;
                }
                break;
            case FRIDAY:
                if ((ultimoDigito == '9' || ultimoDigito == '0') && estaEnHoraRestriccion)
                {
                    return false;
                }
                break;
        }

        return true;
    }
}
