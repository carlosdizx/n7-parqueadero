/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n3_parqueadero
 * Autor: Equipo Cupi2 2017
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.parqueadero.test;

import org.junit.Test;
import static org.junit.Assert.*;
import uniandes.cupi2.parqueadero.mundo.Carro;
import uniandes.cupi2.parqueadero.mundo.Puesto;

/**
 * Pruebas para la clase Puesto
 */
public class PuestoTest
{

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * El puesto para el escenario 1
     */
    private Puesto puesto1;

    /**
     * El carro para escenario 1
     */
    private Carro carro1;

    /**
     * El puesto para el escenario 2
     */
    private Puesto puesto2;

    /**
     * El carro para el escenario 2
     */
    private Carro carro2;

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Inicializa el escenario 1: un puesto y un carro, pero el puesto está vacío
     */
    private void setupEscenario1( )
    {
        carro1 = new Carro( "aaa111", 6, "marca111", "modelo111" );
        puesto1 = new Puesto( 1 );
    }

    /**
     * Inicializa el escenario 2: un puesto y un carro parqueado en el puesto
     */
    private void setupEscenario2( )
    {
        carro2 = new Carro( "bbb222", 6, "marca222", "modelo222" );
        puesto2 = new Puesto( 2 );
        puesto2.ingresarCarro( carro2 );
    }

    /**
     * Probar que el método darCarro retorna lo esperado para un puesto vacío
     */
    @Test
    public void testDarCarro1( )
    {
        setupEscenario1( );

        assertNull( "El puesto1 está vacío pero darCarro no retornó null", puesto1.darCarro( ) );
    }

    /**
     * Probar que el método darCarro retorna lo esperado para un puesto ocupado
     */
    @Test
    public void testDarCarro2( )
    {
        setupEscenario2( );

        assertTrue( "El puesto 2 no retornó el carro que se esperaba", carro2 == puesto2.darCarro( ) );
    }

    /**
     * Probar el método darNumeroPuesto
     */
    @Test
    public void testDarNumeroPuesto( )
    {
        setupEscenario1( );

        assertEquals( "El número retornado es incorrecto", 1, puesto1.darNumeroPuesto( ) );
    }

    /**
     * Probar el método estaOcupado
     */
    @Test
    public void testEstaOcupado( )
    {
        setupEscenario1( );
        setupEscenario2( );

        assertFalse( "El puesto 1 debería estar desocupado", puesto1.estaOcupado( ) );
        assertTrue( "El puesto 2 debería estar ocupado", puesto2.estaOcupado( ) );
    }

    /**
     * Probar a parquear un carro en un puesto vacío
     */
    @Test
    public void testParquearCarro( )
    {
        setupEscenario1( );

        assertNull( "El puesto 1 está vacío pero darCarro no retornó null", puesto1.darCarro( ) );
        puesto1.ingresarCarro( carro1 );
        assertTrue( "El puesto 1 no retornó el carro que se esperaba: el carro no quedó parqueado", carro1 == puesto1.darCarro( ) );
        assertTrue( "El puesto 1 debería estar ocupado", puesto1.estaOcupado( ) );
    }

    /**
     * Probar a sacar un carro del puesto
     */
    @Test
    public void testSacarCarro( )
    {
        setupEscenario2( );

        assertTrue( "El puesto 2 no retornó el carro que se esperaba", carro2 == puesto2.darCarro( ) );
        puesto2.sacarCarro( );
        assertNull( "El puesto 2 debería estar vacío pero darCarro no retornó null", puesto2.darCarro( ) );
        assertFalse( "El puesto 2 debería estar desocupado", puesto2.estaOcupado( ) );
    }

    /**
     * Probar el método tieneCarroConPlaca
     */
    @Test
    public void testTieneCarroConPlaca( )
    {
        setupEscenario2( );

        assertFalse( "El puesto encontró la placa de un carro que no está parqueado ahí", puesto2.tieneCarroConPlaca( "aaa111" ) );
        assertTrue( "El puesto no encontró la placa del carro que está parqueado ahí", puesto2.tieneCarroConPlaca( "bbb222" ) );
    }
}
