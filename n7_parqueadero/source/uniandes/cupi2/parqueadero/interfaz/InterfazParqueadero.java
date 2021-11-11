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
package uniandes.cupi2.parqueadero.interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

import uniandes.cupi2.parqueadero.mundo.Carro;
import uniandes.cupi2.parqueadero.mundo.Parqueadero;

/**
 * Esta clase representa la ventana de interacción del parqueadero.
 */
@SuppressWarnings("serial")
public class InterfazParqueadero extends JFrame
{

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Parqueadero que se está administrando.
     */
    private Parqueadero parqueadero;

    // -----------------------------------------------------------------
    // Componentes de la interfaz
    // -----------------------------------------------------------------

    /**
     * Panel que muestra el banner de la aplicación.
     */
    private PanelImagen panelImagen;

    /**
     * Panel que muestra la lista de los carros en el parqueadero.
     */
    private PanelLista panelLista;

    /**
     * Panel que muestra el parqueadero.
     */
    private PanelParqueadero panelParqueadero;

    /**
     * Panel donde se realizan las operaciones.
     */
    private PanelOperaciones panelOperaciones;

    /**
     * Panel que muestra información sobre el parqueadero.
     */
    private PanelInformacion panelInformacion;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Sirve para construir la interfaz.
     */
    public InterfazParqueadero( )
    {
        setTitle( "Parqueadero" );
        setSize( 750, 700 );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

        // Crea el parqueadero con tarifa por hora de 1200
        parqueadero = new Parqueadero( );

        // Construir los paneles
        panelImagen = new PanelImagen( );
        panelLista = new PanelLista( this );
        panelParqueadero = new PanelParqueadero( this );
        panelOperaciones = new PanelOperaciones( this );
        panelOperaciones.setPreferredSize( new Dimension( 570, 100 ) );
        panelInformacion = new PanelInformacion( this );
        JPanel centro = new JPanel( );
        centro.setLayout( new BorderLayout( ) );
        JPanel sur = new JPanel( );
        sur.setLayout( new BorderLayout( ) );

        // Organizar el panel principal
        getContentPane( ).setLayout( new BorderLayout( ) );
        getContentPane( ).add( panelImagen, BorderLayout.NORTH );
        getContentPane( ).add( panelLista, BorderLayout.EAST );
        getContentPane( ).add( centro, BorderLayout.CENTER );
        centro.add( panelParqueadero, BorderLayout.CENTER );
        centro.add( sur, BorderLayout.SOUTH );
        sur.add( panelOperaciones, BorderLayout.CENTER );
        sur.add( panelInformacion, BorderLayout.SOUTH );

        setLocationRelativeTo( null );
        setResizable( false );

        actualizar( );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Avanza una hora el reloj del parqueadero.
     */
    public void avanzar( )
    {
        parqueadero.avanzarHora( );
        actualizar( );
        if(!parqueadero.estaAbierto( ))
        {
            panelOperaciones.deshabilitarAvanzar();
        }
        
    }

    /**
     * Muestra un mensaje con la placa del carro que se encuentra en el puesto indicado.
     * @param pPuesto Puesto del que se desea conocer la placa.
     */
    public void darPlacaPorPuesto( int pPuesto )
    {
        String placa = parqueadero.darPlacaCarro( pPuesto );
        JOptionPane.showMessageDialog( this, placa, "Placa", JOptionPane.INFORMATION_MESSAGE );
    }

    /**
     * Crea una ventana de diálogo para ingresar un carro al parqueadero.
     */
    public void dialogoIngresar( )
    {
        DialogoIngresar dialogo = new DialogoIngresar( this );
        dialogo.setVisible( true );
    }

    /**
     * Este método sirve para ingresar un carro al parqueadero. Debe preguntar la placa, la marca y el modelo del carro e informar la posición donde debe estacionarse. <br>
     * Si no se puede parquear, porque el parqueadero está cerrado o porque no hay ningún lugar disponible, debe informar del error.
     * @param pMarca Marca del carro a ingresar.
     * @param pModelo Modelo del carro a ingresar.
     * @param pPlaca Placa del carro a ingresar.
     * @param pVentana Ventana de diálogo.
     */
    public void ingresarCarro( String pMarca, String pModelo, String pPlaca, DialogoIngresar pVentana )
    {
        try
        {
            if(pPlaca.length( ) != 6)
            {
                JOptionPane.showMessageDialog( this, "El formato de la placa no es válido", "Ingresar Carro", JOptionPane.ERROR_MESSAGE );
            }
            else
            {
                int puesto = parqueadero.ingresarCarro( pPlaca, pMarca, pModelo );
                actualizar( );
                pVentana.dispose( );
                JOptionPane.showMessageDialog( this, "Bienvenido:\n Su carro quedó parqueado en el puesto: " + ( puesto + 1 ) );
            }
        }
        catch( Exception e )
        {
            JOptionPane.showMessageDialog( this, e.getMessage( ) );
        }

    }

    /**
     * Cambia la tarifa del parqueadero. Pide una tarifa al usuario, si esta tarifa no es válida informa al usuario.
     */
    public void cambiar( )
    {
        String tarifa = JOptionPane.showInputDialog( this, "Por favor digite la nueva tarifa", "Nueva tarifa", JOptionPane.QUESTION_MESSAGE );
        if( tarifa != null )
        {
            try
            {
                int tarifaNumero = Integer.parseInt( tarifa );
                if( tarifaNumero <= 0 )
                {
                    JOptionPane.showMessageDialog( this, "Ingrese una tarifa válida", "Tarifa inválida", JOptionPane.ERROR_MESSAGE );
                }
                else
                {
                    parqueadero.cambiarTarifa( tarifaNumero );
                    panelOperaciones.cambiarTarifa( tarifaNumero );
                    JOptionPane.showMessageDialog( this, "Se ha cambiado la tarifa", "Nueva tarifa", JOptionPane.INFORMATION_MESSAGE );
                }
            }
            catch( Exception e )
            {
                JOptionPane.showMessageDialog( this, "Ingrese una tarifa válida", "Tarifa inválida", JOptionPane.ERROR_MESSAGE );
            }
        }

    }

    /**
     * Este método sirve para sacar un carro del parqueadero. Debe pedir la placa y luego contactar al parqueadero para sacar el carro y saber <br>
     * cuánto debe cancelar. Si la placa no corresponde a un carro que está en el parqueadero entonces debe informar al usuario.
     * @param pCarro Carro al cual se dará salida.
     */
    public void sacarCarro( Carro pCarro )
    {
        if( pCarro != null )
        {
            try
            {
                String placa = pCarro.darPlaca( );
                parqueadero.sacarCarro( placa );
                actualizar( );
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog( this, e.getMessage( ), "Sacar Carro", JOptionPane.ERROR_MESSAGE );
            }            
        }
        else
        {
            JOptionPane.showMessageDialog( this, "Debes seleccionar un carro para darle salida", "Sacar Carro", JOptionPane.ERROR_MESSAGE );
        }
    }

    /**
     * Ordena los carros de forma ascendente en el parqueadero por su marca.
     */
    public void ordenarPorMarca( )
    {
        parqueadero.ordenarPorMarca( );
        actualizar( );
    }

    /**
     * Ordena los carros de forma descendente en el parqueadero por su modelo.
     */
    public void ordenarPorModelo( )
    {
        parqueadero.ordenarPorModelo( );
        actualizar( );
    }

    /**
     * Ordena los carros de forma ascendente en el parqueadero por su hora de ingreso.
     */
    public void ordenarPorHora( )
    {
        parqueadero.ordenarPorHoraIngreso( );
        actualizar( );
    }

    /**
     * Busca un carro por su placa. Pide una placa al usuario, si esta placa no pertenece a ningún carro se informa al usuario.
     */
    public void buscarPorPlaca( )
    {
        String placa = JOptionPane.showInputDialog( this, "Por favor digite la placa", "Buscar por placa", JOptionPane.QUESTION_MESSAGE );
        if( placa != null )
        {
            Carro carro = parqueadero.buscarCarroPorPlaca( placa );
            if( carro != null )
            {
                panelLista.cambiarSeleccionado( carro );
                panelParqueadero.iluminarCarro( parqueadero.buscarPuestoCarroPorPlaca( carro.darPlaca( ) ) );
            }
            else
            {
                JOptionPane.showMessageDialog( this, "No se encontró un carro con esta placa", "Buscar por placa", JOptionPane.ERROR_MESSAGE );

            }
        }

    }

    /**
     * Busca un carro por su hora de ingreso. Pide la hora al usuario, si esta hora de ingreso no pertenece a ningún carro se informa al usuario.
     */
    public void buscarPorHora( )
    {
        String hora = JOptionPane.showInputDialog( this, "Por favor digite la hora de ingreso (valor de 0 a 23)", "Buscar por hora de ingreso", JOptionPane.QUESTION_MESSAGE );
        if( hora != null )
        {
            try
            {
                int horaIngreso = Integer.parseInt( hora );
                if( horaIngreso <= 0 )
                {
                    JOptionPane.showMessageDialog( this, "Ingrese una hora válida", "Hora inválida", JOptionPane.ERROR_MESSAGE );
                }
                else
                {
                    Carro carro = parqueadero.buscarPorHoraIngreso( horaIngreso );
                    if( carro != null )
                    {
                        panelLista.cambiarSeleccionado( carro );
                        panelParqueadero.iluminarCarro( parqueadero.buscarPuestoCarroPorPlaca( carro.darPlaca( ) ) );

                    }
                    else
                    {
                        JOptionPane.showMessageDialog( this, "No se encontró un carro con esta hora", "Buscar por hora de ingreso", JOptionPane.ERROR_MESSAGE );

                    }
                }
            }
            catch( Exception e )
            {
                JOptionPane.showMessageDialog( this, "Ingrese una hora válida", "Hora inválida", JOptionPane.ERROR_MESSAGE );
            }
        }

    }

    /**
     * Actualiza los datos que se presentan en la interfaz.
     */
    public void actualizar( )
    {
        panelParqueadero.refrescarParqueadero( parqueadero.darPuestos( ) );
        panelOperaciones.cambiarHora( parqueadero.darHoraActual( ) );
        panelOperaciones.cambiarTarifa( parqueadero.darTarifa( ) );
        panelInformacion.actualizarDatos( parqueadero.calcularCantidadPuestosLibres( ), parqueadero.darMontoCaja( ) );
        panelLista.actualizar( parqueadero.darCarros( ) );
    }

    // -----------------------------------------------------------------
    // Puntos de Extensión
    // -----------------------------------------------------------------

    /**
     * Este método ejecuta la opción 1.
     */
    public void reqFuncOpcion1( )
    {
        String respuesta = parqueadero.metodo1( );
        actualizar( );
        JOptionPane.showMessageDialog( this, respuesta, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    /**
     * Este método ejecuta la opción 2.
     */
    public void reqFuncOpcion2( )
    {
        String respuesta = parqueadero.metodo2( );
        actualizar( );
        JOptionPane.showMessageDialog( this, respuesta, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    // -----------------------------------------------------------------
    // Main
    // -----------------------------------------------------------------

    /**
     * Ejecuta la aplicación.
     * @param pArgs Parámetros de la ejecución. No son necesarios.
     */
    public static void main( String[] pArgs )
    {
        try
        {
            // Unifica la interfaz para Mac y para Windows.
            UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName( ) );

            InterfazParqueadero manejador = new InterfazParqueadero( );
            manejador.setVisible( true );
        }
        catch( Exception e )
        {
            e.printStackTrace( );
        }
    }
}