/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad  de  los Andes   (Bogotá - Colombia)
 * Departamento de  Ingeniería  de  Sistemas    y   Computación
 * Licenciado   bajo    el  esquema Academic Free License versión 2.1
 *      
 * Proyecto Cupi2   (http://cupi2.uniandes.edu.co)
 * Ejercicio: n7_Parqueadero
 * Autor: Equipo Cupi2 2018
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.parqueadero.mundo;

/**
 * Esta clase representa un puesto en el parqueadero. <br>
 * <b>inv: </b> <br>
 *  numeroPuesto >= 0 <br>
 */
public class Puesto
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Carro parqueado en el puesto. Si no hay ninguno, carro == null.
     */
    private Carro carro;

    /**
     * Número del puesto dentro del parqueadero.
     */
    private int numeroPuesto;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea un puesto vacío. <br>
     * <b>post: </b> Se creó un puesto vacío y se le asignó su número de puesto.
     * @param pPuesto Número de puesto.
     */
    public Puesto( int pPuesto )
    {
        carro = null;
        numeroPuesto = pPuesto;
        
        verificarInvariante();
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Retorna el carro del puesto. Si no hay ningún carro retorna null.
     * @return El carro que ocupa el puesto.
     */
    public Carro darCarro( )
    {
        return carro;
    }
    

    /**
     * Retorna el número del puesto.
     * @return El número asignado al puesto.
     */
    public int darNumeroPuesto( )
    {
        return numeroPuesto;
    }

    /**
     * Indica si el puesto está ocupado.
     * @return Retorna true si el puesto está ocupado. Retorna false en caso contrario.
     */
    public boolean estaOcupado( )
    {
        boolean ocupado = carro != null;
        return ocupado;
    }

    /**
     * Ingresa un carro en el puesto. <br>
     * <b>pre: </b> El puesto está vacío. <br>
     * <b>post: </b> El puesto ahora está ocupado por el carro pCarro.
     * @param pCarro Carro que está ingresando. pCarro != null.
     */
    public void ingresarCarro( Carro pCarro )
    {
        carro = pCarro;
    }

    /**
     * Saca el carro del puesto. <br>
     * <b>post: </b> El puesto está vacío.
     */
    public void sacarCarro( )
    {
        carro = null;
    }
    
    /**
     * Indica si la placa del carro parqueado en el puesto coincide con la placa recibida.
     * @param pPlaca Placa a comparar.
     * @return Retorna true si las placas coinciden, false en caso contrario, o si no hay ningún carro en el puesto.
     */
    public boolean tieneCarroConPlaca( String pPlaca )
    {
        boolean tieneCarro = false;

        if( carro != null && carro.tienePlaca( pPlaca ) )
        {
            tieneCarro = true;
        }

        return tieneCarro;
    }

    // -----------------------------------------------------------------
    // Invariante
    // -----------------------------------------------------------------

    /**
     * Verifica que el invariante de la clase se cumpla. Si algo falla, lanza un AssertionError. <br>
     */
    private void verificarInvariante( )
    {
        assert numeroPuesto >= 0 : "EL valor del numero de puesto es invalido";
    }

}