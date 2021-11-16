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
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;

import uniandes.cupi2.parqueadero.mundo.Carro;

/**
 * Panel para ver la información de los carros actuales en el parqueadero.
 */
@SuppressWarnings("serial")
public class PanelLista extends JPanel implements ActionListener, ListSelectionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Comando para ingresar un carro al parqueadero.
     */
    private final static String INGRESAR_CARRO = "Ingresar Carro";

    /**
     * Comando para sacar un carro del parqueadero.
     */
    public final static String SACAR_CARRO = "Sacar Carro";

    /**
     * Comando para ordenar los carros por su marca.
     */
    public final static String ORDENAR_POR_MARCA = "Ordenar por marca";

    /**
     * Comando para ordenar los carros por su modelo.
     */
    public final static String ORDENAR_POR_MODELO = "Ordenar por modelo";

    /**
     * Comando para ordenar los carros por su placa.
     */
    public final static String ORDENAR_POR_PLACA = "Ordenar por placa";

    /**
     * Comando para buscar un carro por su placa.
     */
    public final static String BUSCAR_POR_PLACA = "Buscar por placa";

    /**
     * Comando para buscar un carro por su hora de ingreso.
     */
    public final static String BUSCAR_POR_HORA = "Buscar por hora de ingreso";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Instancia principal de la aplicación.
     */
    private InterfazParqueadero interfaz;

    /**
     * Carro actual seleccionado.
     */
    private Carro carroActual;

    // -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------

    /**
     * Objeto scroll para la lista de carros del parqueadero.
     */
    private JScrollPane scroll;

    /**
     * Lista de las carros en el parqueadero.
     */
    private JList listaCarros;

    /**
     * Botón para ingresar un carro al parqueadero.
     */
    private JButton botonIngresarCarro;

    /**
     * Botón para sacar un carro del parqueadero.
     */
    private JButton btnSacarCarro;

    /**
     * Botón para ordenar los carros por marca.
     */
    private JButton btnOrdenarPorMarca;

    /**
     * Botón para ordenar los carros por modelo.
     */
    private JButton btnOrdenarPorModelo;

    /**
     * Botón para ordenar los carros por hora de ingreso.
     */
    private JButton btnOrdenarPorPlaca;

    /**
     * Botón para buscar un carro por su placa.
     */
    private JButton btnBuscarPorPlaca;

    /**
     * Botón para buscar un carro por su hora de ingreso.
     */
    private JButton btnBuscarPorHora;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea el panel con la información de los carros en el parqueadero.
     * @param pPrincipal Instancia principal de la aplicación. pPrincipal != null.
     */
    public PanelLista( InterfazParqueadero pPrincipal )
    {
        interfaz = pPrincipal;
        setLayout( new BorderLayout( ) );
        
        JPanel principal = new JPanel();
        principal.setLayout( new BorderLayout( ) );

        listaCarros = new JList();

        listaCarros.addListSelectionListener(this);
        
        scroll = new JScrollPane( );
        TitledBorder titulo = new TitledBorder( "Carros en el parqueadero" );
        principal.setBorder( titulo );
        scroll.setViewportView( listaCarros );
        scroll.setPreferredSize( new Dimension( 200, 200 ) );
        scroll.setVerticalScrollBarPolicy( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );
        scroll.setHorizontalScrollBarPolicy( ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS );
        principal.add( scroll, BorderLayout.CENTER );
        add( principal, BorderLayout.CENTER );

        JPanel botones = new JPanel( );
        botones.setLayout( new BorderLayout( ) );
        add( botones, BorderLayout.SOUTH );

        JPanel acciones = new JPanel( );
        acciones.setLayout( new GridLayout( 2, 1, 3, 3 ) );
        principal.add(acciones, BorderLayout.SOUTH);

        JPanel ordenar = new JPanel( );
        ordenar.setLayout( new GridLayout( 3, 1, 3, 3 ) );
        ordenar.setBorder( new TitledBorder( "Ordenamientos" ) );

        JPanel busquedas = new JPanel( );
        busquedas.setLayout( new GridLayout( 2, 1, 3, 3 ) );
        busquedas.setBorder( new TitledBorder( "Búsquedas" ) );

        botonIngresarCarro = new JButton( );
        botonIngresarCarro.setText( "Ingresar Carro" );
        botonIngresarCarro.setActionCommand( INGRESAR_CARRO );
        botonIngresarCarro.addActionListener( this );
        acciones.add( botonIngresarCarro );

        btnSacarCarro = new JButton( SACAR_CARRO );
        btnSacarCarro.setActionCommand( SACAR_CARRO );
        btnSacarCarro.addActionListener( this );
        acciones.add( btnSacarCarro );

        btnOrdenarPorMarca = new JButton( ORDENAR_POR_MARCA );
        btnOrdenarPorMarca.setActionCommand( ORDENAR_POR_MARCA );
        btnOrdenarPorMarca.addActionListener( this );
        ordenar.add( btnOrdenarPorMarca );

        btnOrdenarPorModelo = new JButton( ORDENAR_POR_MODELO );
        btnOrdenarPorModelo.setActionCommand( ORDENAR_POR_MODELO );
        btnOrdenarPorModelo.addActionListener( this );
        ordenar.add( btnOrdenarPorModelo );

        btnOrdenarPorPlaca = new JButton(ORDENAR_POR_PLACA);
        btnOrdenarPorPlaca.setActionCommand(ORDENAR_POR_PLACA);
        btnOrdenarPorPlaca.addActionListener( this );
        ordenar.add(btnOrdenarPorPlaca);

        btnBuscarPorPlaca = new JButton( BUSCAR_POR_PLACA );
        btnBuscarPorPlaca.setActionCommand( BUSCAR_POR_PLACA );
        btnBuscarPorPlaca.addActionListener( this );
        busquedas.add( btnBuscarPorPlaca );

        btnBuscarPorPlaca = new JButton( BUSCAR_POR_HORA );
        btnBuscarPorPlaca.setActionCommand( BUSCAR_POR_HORA );
        btnBuscarPorPlaca.addActionListener( this );
        busquedas.add( btnBuscarPorPlaca );

        botones.add( ordenar, BorderLayout.CENTER );
        botones.add( busquedas, BorderLayout.SOUTH );

    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Actualiza el panel con la información que entra por parámetro.
     * @param pcarros Carros actualmente en el parqueadero.
     */
    public void actualizar( ArrayList pcarros )
    {
        listaCarros.setListData(pcarros.toArray());
        if( carroActual != null )
        {
            cambiarSeleccionado( carroActual );
        }

    }

    /**
     * Actualiza el carro seleccionado.
     * @param pCarro Carro a seleccionar.
     */
    public void cambiarSeleccionado( Carro pCarro )
    {
        listaCarros.setSelectedValue( pCarro, true );
        carroActual = pCarro;
    }

    /**
     * Manejo de los eventos de la lista.
     * @param pEvento Acción que generó el evento.
     */
    public void valueChanged( ListSelectionEvent pEvento )
    {
        carroActual = ( Carro )listaCarros.getSelectedValue( );
        
    }

    /**
     * Manejo de los eventos de los botones.
     * @param pEvento Acción que generó el evento.
     */
    public void actionPerformed( ActionEvent pEvento )
    {
        String comando = pEvento.getActionCommand( );
        if( comando.equals( INGRESAR_CARRO ) )
        {
            interfaz.dialogoIngresar( );
        }
        else if( comando.equals( SACAR_CARRO ) )
        {
            interfaz.sacarCarro( carroActual );
        }
        else if( comando.equals( ORDENAR_POR_MARCA ) )
        {
            interfaz.ordenarPorMarca( );
        }
        else if( comando.equals( ORDENAR_POR_MODELO ) )
        {
            interfaz.ordenarPorModelo( );
        }
        else if( comando.equals(ORDENAR_POR_PLACA) )
        {
            interfaz.ordenarPorPlaca( );
        }
        else if( comando.equals( BUSCAR_POR_PLACA ) )
        {
            interfaz.buscarPorPlaca( );
        }
        else if( comando.equals( BUSCAR_POR_HORA ) )
        {
            interfaz.buscarPorHora( );
        }

    }

}
