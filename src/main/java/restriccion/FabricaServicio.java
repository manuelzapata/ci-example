package restriccion;

import java.math.BigDecimal

public class FabricaServicio {

    public static ServicioRestriccion getServicio(String ciudad) {
        ServicioRestriccion resultado = null;
        switch (ciudad) {
            case "Medellín":
                resultado = new ServicioRestriccionMedellin();
                break;
            case "Cali":
                resultado = new ServicioRestriccionCali();
                break;
            case "Bogotá":
                resultado = new ServicioRestriccionBogota();
                break;
            default:
                throw new UnsupportedOperationException("La ciudad " + ciudad + " no es soportada.");
        }
        return resultado;
    }

}
