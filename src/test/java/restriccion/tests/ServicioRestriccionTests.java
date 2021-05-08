package restriccion.tests;

import org.junit.jupiter.api.Test;
import restriccion.FabricaServicio;
import restriccion.ServicioRestriccion;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class ServicioRestriccionTests {

    @Test
    public void Medellin_PuedeSalir()
    {
        ServicioRestriccion servicio = FabricaServicio.getServicio("Medellín");
        boolean resultado = servicio.puedeSalir("ABC123", LocalDateTime.now());

        assertTrue(resultado);
    }

    @Test
    public void Cali_LunesFueraHorario_PuedeSalir() {
        ServicioRestriccion servicio = FabricaServicio.getServicio("Cali");
        boolean resultado = servicio.puedeSalir("DEF012", LocalDateTime.of(2021, 3, 22, 11, 0, 0)); //Lunes 15 de marzo, 11 am.
        assertTrue(resultado);
    }

    @Test
    public void Cali_LunesEnHorario_NoPuedeSalir()
    {
        ServicioRestriccion servicio = FabricaServicio.getServicio("Cali");
        boolean resultado = servicio.puedeSalir("DEF012", LocalDateTime.of(2021, 3, 22, 8, 0, 0)); //Lunes 22 de marzo, 8 am.
        assertFalse(resultado);
    }

    @Test
    public void Cali_MartesEnHorario_NoPuedeSalir()
    {
        ServicioRestriccion servicio = FabricaServicio.getServicio("Cali");
        boolean resultado = servicio.puedeSalir("GHI234", LocalDateTime.of(2021, 3, 23, 8, 0, 0)); //Martes 23 de marzo, 8 am.
        assertFalse(resultado);
    }

    @Test
    public void CiudadNoSoportada() {
        assertThrows(UnsupportedOperationException.class, () -> FabricaServicio.getServicio("Cartagena"));
    }

    @Test
    public void Bogota_Domingo_PuedeSalir() {
        ServicioRestriccion servicio = FabricaServicio.getServicio("Bogotá");
        boolean resultado = servicio.puedeSalir("GHI234", LocalDateTime.of(2021, 3, 28, 8, 0, 0));
        assertTrue(resultado);
    }

    @Test
    public void Bogota_DiaImparEnHorario_PuedeSalir() {
        ServicioRestriccion servicio = FabricaServicio.getServicio("Bogotá");
        boolean resultado = servicio.puedeSalir("JKL567", LocalDateTime.of(2021, 3, 23, 8, 0, 0));
        assertFalse(resultado);
    }

    @Test
    public void Bogota_DiaParEnHorario_NoPuedeSalir() {
        ServicioRestriccion servicio = FabricaServicio.getServicio("Bogotá");
        boolean resultado = servicio.puedeSalir("GHI234", LocalDateTime.of(2021, 4, 14, 8, 0, 0));
        assertFalse(resultado);
    }

    @Test
    public void Bogota_DiaParFueraHorario_PuedeSalir() {
        ServicioRestriccion servicio = FabricaServicio.getServicio("Bogotá");
        boolean resultado = servicio.puedeSalir("GHI234", LocalDateTime.of(2021, 4, 14, 8, 45, 0));
        assertTrue(resultado);
    }

    @Test
    public void Medellin_ObtenerMulta() {
        ServicioRestriccion servicio = FabricaServicio.getServicio("Medellín");
        BigDecimal resultado = servicio.obtenerMulta();
        assertEquals(new BigDecimal(0), resultado);
    }

    @Test
    public void Bogota_ObtenerMulta() {
        ServicioRestriccion servicio = FabricaServicio.getServicio("Bogotá");
        BigDecimal resultado = servicio.obtenerMulta();
        assertEquals(new BigDecimal(447700), resultado);
    }

    @Test
    public void Cali_ObtenerMulta() {
        ServicioRestriccion servicio = FabricaServicio.getServicio("Cali");
        BigDecimal resultado = servicio.obtenerMulta();
        assertEquals(new BigDecimal(454260), resultado);
    }

}
