package restriccion;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class ServicioRestriccionBogota extends ServicioRestriccion{

    @Override
    public boolean puedeSalir(String placa, LocalDateTime fechaHora) {
        if(fechaHora.getDayOfWeek() == DayOfWeek.SATURDAY || fechaHora.getDayOfWeek() == DayOfWeek.SUNDAY) {
            return true;
        }

        boolean esDiaPar = fechaHora.getDayOfMonth() % 2 == 0;
        boolean esPlacaPar = Character.getNumericValue(placa.charAt(placa.length() - 1)) % 2 == 0;

        if(esDiaPar && esPlacaPar) {
            if((fechaHora.getHour() >= 6 && fechaHora.getHour() <= 8 && fechaHora.getMinute() <= 30) || // mañana
                    (fechaHora.getHour() >= 15 && fechaHora.getHour() <= 19 && fechaHora.getMinute() <= 30)) { //tarde
                return false;
            }
        }

        if(!esDiaPar && !esPlacaPar) {
            if((fechaHora.getHour() >= 6 && fechaHora.getHour() <= 8 && fechaHora.getMinute() <= 30) || // mañana
                    (fechaHora.getHour() >= 15 && fechaHora.getHour() <= 19 && fechaHora.getMinute() <= 30)) { //tarde
                return false;
            }
        }

        return true;
    }

    @Override
    public BigDecimal obtenerMulta() {
        return new BigDecimal(447700);
    }

}
