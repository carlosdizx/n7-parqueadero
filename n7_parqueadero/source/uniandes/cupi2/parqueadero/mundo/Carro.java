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
 * Esta clase representa un carro dentro del parqueadero. <br>
 * <b>inv: </b> <br>
 *  placa != null <br>
 *  !placa.equals( "" ) <br>
 *  horaIngreso != null <br>
 *  marca != null <br>
 *  !marca.equals( "" ) <br>
 *  modelo != null <br>
 *  !modelo.equals( "" ) <br>
 */
public class Carro
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Placa del carro.
     */
    private String placa;

    /**
     * Hora de ingreso del carro al parqueadero: valor entre 6 y 20.
     */
    private int horaIngreso;

    /**
     * Marca del carro.
     */
    private String marca;

    /**
     * Modelo del carro.
     */
    private String modelo;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea un carro con la información básica.
     * @param pPlaca Placa del carro. pPlaca != null && pPlaca != "".
     * @param pHora Hora de ingreso. pHora >= 6 && pHora < 20.
     * @param pMarca Marca del carro. pMarca != null && pMarca != "".
     * @param pModelo Modelo del carro. pModelo != null && pModelo != "".
     * <b>post: </b> Se creó un carro con la información recibida por parámetro de su placa, marca, modelo y hora de ingreso al parqueadero.
     */
    public Carro( String pPlaca, int pHora, String pMarca, String pModelo )
    {
        placa = pPlaca;
        horaIngreso = pHora;
        marca = pMarca;
        modelo = pModelo;
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Retorna la placa del carro.
     * @return La placa del carro.
     */
    public String darPlaca( )
    {
        return placa;
    }

    /**
     * Retorna la hora de ingreso del carro.
     * @return La hora en la que ingresó el carro al parqueadero.
     */
    public int darHoraIngreso( )
    {
        return horaIngreso;
    }

    /**
     * Retorna la marca del carro.
     * @return La marca del carro.
     */
    public String darMarca( )
    {
        return marca;
    }

    /**
     * Retorna el modelo del carro.
     * @return El modelo del carro.
     */
    public String darModelo( )
    {
        return modelo;
    }

    /**
     * Indica si la placa del carro es igual a la recibida por parámetro.
     * @param pPlaca Placa contra la que se está comparando. pPlaca != null && pPlaca != "".
     * @return Retorna true si las placas son iguales, false en caso contrario.
     */
    public boolean tienePlaca( String pPlaca )
    {
        boolean tienePlaca = false;
        if( placa.equalsIgnoreCase( pPlaca ) )
        {
            tienePlaca = true;
        }
        return tienePlaca;
    }

    /**
     * Calcula la cantidad de horas que debe pagar el carro según el tiempo que lleva en el parqueadero.
     * @param pHoraSalida Hora a la que el carro sale del parqueadero. pHoraSalida >= horaIngreso.
     * @return Tiempo que ha estado el carro en el parqueadero.
     */
    public int darTiempoEnParqueadero( int pHoraSalida )
    {
        int tiempoParqueadero = pHoraSalida - horaIngreso + 1;
        return tiempoParqueadero;
    }

    /**
     * Compara el carro actual y el carro que entra por parámetro por su marca.
     * @param pCarro Carro a comparar. pCarro != null.
     * @return 0 si tienen la misma marca, 1 si la marca del carro recibido por parámetro es menor, -1 si es mayor.
     */
    public int compararPorMarca( Carro pCarro )
    {
        // TODO Parte 2 Punto A: Completar el método según su documentación.
    }

    /**
     * Compara el carro actual y el carro que entra por parámetro por su modelo.
     * @param pCarro Carro a comparar. pCarro != null.
     * @return 0 si tienen el mismo modelo, 1 si el modelo del carro recibido por parámetro es menor, -1 si es mayor.
     */
    public int compararPorModelo( Carro pCarro )
    {
        // TODO Parte 2 Punto B: Completar el método según su documentación.
    }

    /**
     * Compara el carro actual y el carro por parámetro por su hora de ingreso.
     * @param pCarro Carro a comparar. pCarro != null.
     * @return 0 si tienen la misma hora de ingreso, 1 si la placa del carro recibido por parámetro es menor, -1 si es mayor.
     */
    public int compararPorHoraIngreso( Carro pCarro )
    {
        // TODO Parte 2 Punto C: Completar el método según su documentación.
    }

    /**
     * Retorna una cadena con la marca, el modelo, la placa y la hora de ingreso del carro, con el siguiente formato: <br>
     * <marca> <modelo> - <placa> <horaIngreso>:00.
     */
    public String toString( )
    {
        return marca + " " + modelo + " - " + placa + " " + horaIngreso + ":00";
    }

    // -----------------------------------------------------------------
    // Invariante
    // -----------------------------------------------------------------

    // TODO Parte 1 Punto B: Implemente y documente el método verificarInvariante.
}