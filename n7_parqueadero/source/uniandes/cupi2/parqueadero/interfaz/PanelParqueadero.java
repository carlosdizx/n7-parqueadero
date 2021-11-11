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
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import uniandes.cupi2.parqueadero.mundo.Parqueadero;
import uniandes.cupi2.parqueadero.mundo.Puesto;

/**
 * Este panel sirve para mostrar el estado actual del parqueadero.
 */
@SuppressWarnings("serial")
public class PanelParqueadero extends JPanel implements ActionListener
{
    // -----------------------------------------------------------------
    // Atributos de la Interfaz
    // -----------------------------------------------------------------

    /**
     * Botones que componen los puestos de parqueo.
     */
    private JButton puestos[];

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Referencia a la clase principal.
     */
    private InterfazParqueadero principal;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el panel. <br>
     * <b>post: </b> Se construyó el panel.
     * @param pParqueadero Referencia a la ventana principal de la aplicación.
     */
    public PanelParqueadero( InterfazParqueadero pParqueadero )
    {
        principal = pParqueadero;
        inicializar( );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Organiza los componentes que se usan para representar el parqueadero.
     */
    private void inicializar( )
    {
        setLayout( new GridLayout( 4, 10 ) );
        setBorder( new CompoundBorder( new EmptyBorder( 0, 0, 5, 0 ), new TitledBorder( "Parqueadero" ) ) );
        setPreferredSize( new Dimension( 10, 170 ) );
        puestos = new JButton[Parqueadero.TAMANO];
        for( int i = 0; i < puestos.length; i++ )
        {
            puestos[ i ] = new JButton( );
            puestos[ i ].setActionCommand( i + "" );
            puestos[ i ].addActionListener( this );
            puestos[ i ].setHorizontalTextPosition( JButton.CENTER );
            puestos[ i ].setVerticalTextPosition( JButton.CENTER );
            puestos[ i ].setForeground( Color.WHITE );
            add( puestos[ i ] );
        }
    }

    /**
     * Actualiza la representación del parqueadero. <br>
     * <b>post: </b> Se actualizó la información mostrada del parqueadero.
     * @param pInfoPuestos Lista con la información de los puestos para actualizar. pInfoPuestos != null.
     */
    public void refrescarParqueadero( Puesto[] pInfoPuestos )
    {
        limpiar( );
        for( int i = 0; i < pInfoPuestos.length; i++ )
        {
            if( pInfoPuestos[ i ].estaOcupado( ) )
            {
                char caracter = pInfoPuestos[ i ].darCarro( ).darPlaca( ).charAt( 0 );
                int indice = ( ( ( int )caracter ) % 4 ) + 1;
                puestos[ i ].setIcon( new ImageIcon( "data/carro" + indice + ".png" ) );
                puestos[ i ].setText( "" );
            }
            else
            {
                puestos[ i ].setIcon( new ImageIcon( "data/vacio.png" ) );
                puestos[ i ].setText( ( i + 1 ) + "" );
            }
        }
    }

    /**
     * Ilumina el puesto especificado.
     * @param pPuesto El puesto a iluminar.
     */
    public void iluminarCarro( int pPuesto )
    {
        for( JButton puesto : puestos )
        {
            puesto.setBorder( new LineBorder( Color.GRAY ) );
        }
        puestos[ pPuesto ].setBorder( new LineBorder( Color.ORANGE, 5 ) );
    }

    /**
     * Limpia los bordes de todos los puestos
     */
    public void limpiar( )
    {
        for( JButton puesto : puestos )
        {
            puesto.setBorder( new LineBorder( Color.GRAY ) );
        }
    }

    /**
     * Este método se encarga de manejar los eventos de la clase.
     * @param pEvento Evento accionado.
     */
    public void actionPerformed( ActionEvent pEvento )
    {
        String numero = pEvento.getActionCommand( );
        int indice = Integer.parseInt( numero );
        principal.darPlacaPorPuesto( indice );
    }
}
