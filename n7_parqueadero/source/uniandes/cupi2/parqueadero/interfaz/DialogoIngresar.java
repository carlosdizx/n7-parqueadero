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
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 * Diálogo para ingresar un carro al parqueadero
 */
@SuppressWarnings("serial")
public class DialogoIngresar extends JDialog implements ActionListener
{

    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Comando para ingresar el carro.
     */
    public final static String INGRESAR = "Ingresar Carro";

    /**
     * Comando para cancelar el proceso.
     */
    public final static String CANCELAR = "Cancelar";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Instancia principal de la aplicación.
     */
    private InterfazParqueadero interfaz;

    // -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------

    /**
     * Etiqueta de la marca.
     */
    private JLabel lblMarca;

    /**
     * Campo de texto para la marca.
     */
    private JTextField txtMarca;

    /**
     * Etiqueta del modelo.
     */
    private JLabel lblModelo;

    /**
     * Campo de texto para el modelo.
     */
    private JTextField txtModelo;

    /**
     * Etiqueta de la placa.
     */
    private JLabel lblPlaca;

    /**
     * Campo de texto para la placa.
     */
    private JTextField txtPlaca;

    /**
     * Botón para ingresar el carro.
     */
    private JButton btnIngresar;

    /**
     * Botón para cancelar el proceso.
     */
    private JButton btnCancelar;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea la ventana de diálogo para el ingreso al parqueadero.
     * @param pPrincipal Instancia principal de la aplicación.
     */
    public DialogoIngresar( InterfazParqueadero pPrincipal )
    {
        interfaz = pPrincipal;
        setLayout( new BorderLayout( ) );
        setSize( 400, 300 );
        setTitle( "Ingresar Carro" );
        setLocationRelativeTo( null );

        JPanel campos = new JPanel( );
        campos.setLayout( new GridLayout( 6, 2 ) );
        campos.setBorder( new EmptyBorder( 30, 30, 30, 30 ) );
        add( campos, BorderLayout.CENTER );

        lblMarca = new JLabel( "Marca: " );
        campos.add( lblMarca );
        txtMarca = new JTextField( );
        campos.add( txtMarca );
        lblModelo = new JLabel( "Modelo: " );
        campos.add( lblModelo );
        txtModelo = new JTextField( );
        campos.add( txtModelo );
        lblPlaca = new JLabel( "Placa: " );
        campos.add( lblPlaca );
        txtPlaca = new JTextField( );
        campos.add( txtPlaca );

        JPanel botones = new JPanel( );
        botones.setBorder( new EmptyBorder( 0, 30, 20, 30 ) );
        botones.setLayout( new GridLayout( 1, 2 ) );
        add( botones, BorderLayout.SOUTH );

        btnIngresar = new JButton( "Agregar" );
        btnIngresar.setActionCommand( INGRESAR );
        btnIngresar.addActionListener( this );
        botones.add( btnIngresar );

        btnCancelar = new JButton( "Cancelar" );
        btnCancelar.addActionListener( this );
        btnCancelar.setActionCommand( CANCELAR );
        botones.add( btnCancelar );

    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Manejo de eventos del usuario.
     * @param pEvento Evento de usuario. pEvento != null.
     */
    public void actionPerformed( ActionEvent pEvento )
    {
        String comando = pEvento.getActionCommand( );

        if( comando.equals( INGRESAR ) )
        {
            interfaz.ingresarCarro( txtMarca.getText( ), txtModelo.getText( ), txtPlaca.getText( ), this );
        }
        else if( comando.equals( CANCELAR ) )
        {
            this.dispose( );
        }

    }
}
