package restriccion;

import java.math.BigDecimal;

public class FabricaServicio {

    public static ServicioRestriccion getServicio(String ciudad) {
        ServicioRestriccion resultado = switch (ciudad) {
            case "Medellín" -> new ServicioRestriccionMedellin();
            case "Cali" -> new ServicioRestriccionCali();
            case "Bogotá" -> new ServicioRestriccionBogota();
            default -> throw new UnsupportedOperationException("La ciudad " + ciudad + " no es soportada.");
        };
        return resultado;
    }

}
