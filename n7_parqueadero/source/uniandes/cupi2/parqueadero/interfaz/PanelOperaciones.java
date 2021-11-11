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

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 * Este panel sirve para mostrar la hora actual y realizar las diferentes operaciones sobre el parqueadero.
 */
@SuppressWarnings("serial")
public class PanelOperaciones extends JPanel implements ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Comando avanzar.
     */
    private final static String AVANZAR = "AVANZAR";

    /**
     * Comando cambiar.
     */
    private final static String CAMBIAR = "CAMBIAR";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Es una referencia a la ventana principal de la aplicación.
     */
    private InterfazParqueadero principal;

    // -----------------------------------------------------------------
    // Atributos de la Interfaz
    // -----------------------------------------------------------------

    /**
     * Campo de texto usado para mostrar la hora.
     */
    private JTextField txtHora;

    /**
     * Campo de texto usado para mostrar la tarifa.
     */
    private JTextField txtTarifa;

    /**
     * Botón para hacer avanzar una hora el reloj del parqueadero.
     */
    private JButton botonAvanzarHora;

    /**
     * Botón para cambiar la tarifa.
     */
    private JButton botonCambiar;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el panel. <br>
     * <b>post: </b> Se construyó el panel.
     * @param pPrincipal Es una referencia a la ventana principal de la aplicación. pPrincipal != null.
     */
    public PanelOperaciones( InterfazParqueadero pPrincipal )
    {
        principal = pPrincipal;
        inicializar( );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Inicializar y organizar los componentes del panel.
     */
    private void inicializar( )
    {
        setLayout( new GridLayout( 2, 2, 3, 3 ) );
        setBorder( new EmptyBorder( 5, 5, 30, 5 ) );

        JPanel panelHora = new JPanel( );
        panelHora.setLayout( new GridLayout( 1, 2 ) );
        add( panelHora );
        panelHora.add( new JLabel( "Hora actual: " ) );

        txtHora = new JTextField( );
        txtHora.setEditable( false );
        txtHora.setForeground( Color.BLUE );
        panelHora.add( txtHora );

        botonAvanzarHora = new JButton( );
        botonAvanzarHora.setText( "Avanzar" );
        botonAvanzarHora.setActionCommand( AVANZAR );
        botonAvanzarHora.addActionListener( this );
        add( botonAvanzarHora );

        JPanel panelTarifa = new JPanel( );
        panelTarifa.setLayout( new GridLayout( 1, 2 ) );
        add( panelTarifa );

        panelTarifa.add( new JLabel( "Tarifa: " ) );
        txtTarifa = new JTextField( );
        txtTarifa.setEditable( false );
        txtTarifa.setForeground( Color.BLUE );
        panelTarifa.add( txtTarifa );

        botonCambiar = new JButton( );
        botonCambiar.setText( "Cambiar" );
        botonCambiar.setActionCommand( CAMBIAR );
        botonCambiar.addActionListener( this );
        add( botonCambiar );
    }

    /**
     * Cambia la hora presentada. <br>
     * <b>post: </b> Se está mostrando la nueva hora.
     * @param pHora Nueva hora que debe mostrarse.
     */
    public void cambiarHora( int pHora )
    {
        txtHora.setText( pHora + ":00" );
    }

    /**
     * Cambia la tarifa presentada. <br>
     * <b>post: </b> Se está mostrando la nueva tarifa.
     * @param pTarifa Nueva tarifa que debe mostrarse.
     */
    public void cambiarTarifa( int pTarifa )
    {
        txtTarifa.setText( "$" + pTarifa );
    }

    /**
     * Ejecuta las acciones adecuadas según el botón que haya sido presionado.
     * @param pEvento Evento del click sobre el botón.
     */
    public void actionPerformed( ActionEvent pEvento )
    {
        String command = pEvento.getActionCommand( );
        if( command.equals( AVANZAR ) )
        {
            principal.avanzar( );
        }
        else if( command.equals( CAMBIAR ) )
        {
            principal.cambiar( );
        }
    }
    


    /**
     * Deshabilita el botón avanzar ya que el parqueadero ha cerrado.
     */
    public void deshabilitarAvanzar( )
    {
        botonAvanzarHora.setEnabled( false );        
    }
}
