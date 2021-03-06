/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad  de  los Andes   (Bogot? - Colombia)
 * Departamento de  Ingenier?a  de  Sistemas    y   Computaci?n
 * Licenciado   bajo    el  esquema Academic Free License versi?n 2.1
 *      
 * Proyecto Cupi2   (http://cupi2.uniandes.edu.co)
 * Ejercicio: n7_Parqueadero
 * Autor: Equipo Cupi2 2018
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.parqueadero.mundo;

import java.util.ArrayList;

/**
 * Esta clase representa un parqueadero con TAMANO puestos. <br>
 * <b>inv: </b> <br>
 *  puestos != null <br>
 *  puestos.length == TAMANO <br>
 *  carros != null <br>
 *  tarifa > 0 <br>
 *  valorEnCaja >= 0 <br>
 *  horaActual >= 6 && horaActual <= 21 <br>
 */
public class Parqueadero
{

    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Indica la cantidad de puestos en el parqueadero.
     */
    public static final int TAMANO = 40;

    /**
     * Es la hora a la que se abre el parqueadero.
     */
    public static final int HORA_INICIAL = 6;

    /**
     * Es la hora a la que se cierra el parqueadero.
     */
    public static final int HORA_CIERRE = 20;

    /**
     * Es la tarifa inicial del parqueadero.
     */
    public static final int TARIFA_INICIAL = 1200;

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Lista de puestos.
     */
    private Puesto puestos[];

    /**
     * Lista de carros.
     */
    private ArrayList<Carro> carros;

    /**
     * Tarifa por hora en el parqueadero.
     */
    private int tarifa;

    /**
     * Cantidad de dinero en la caja del parqueadero.
     */
    private double valorEnCaja;

    /**
     * Hora actual en el parqueadero.
     */
    private int horaActual;

    /**
     * Indica si el parqueadero est? abierto.
     */
    private boolean abierto;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea un parqueadero con su informaci?n b?sica. <br>
     * <b>post: </b> Se cre? el parqueadero abierto con la tarifa establecida, la hora actual es la hora inicial y el valor en caja es 0. <br>
     * Se inicializ? la lista de carros y la lista de puestos. La lista de puestos fue configurada con los n?meros de los puestos.
     */
    public Parqueadero( )
    {
        horaActual = HORA_INICIAL;
        abierto = true;
        tarifa = TARIFA_INICIAL;
        valorEnCaja = 0;

        puestos = new Puesto[TAMANO];
        for( int i = 0; i < TAMANO; i++ )
        {
            puestos[ i ] = new Puesto( i );
        }

        carros = new ArrayList<Carro>( );

        verificarInvariante();
    }

    // -----------------------------------------------------------------
    // M?todos
    // -----------------------------------------------------------------

    /**
     * Indica si el parqueadero est? abierto.
     * @return Retorna true si el parqueadero est? abierto, false en caso contrario.
     */
    public boolean estaAbierto( )
    {
        return abierto;
    }

    /**
     * Retorna la lista de puestos en el parqueadero.
     * @return La lista de puestos.
     */
    public Puesto[] darPuestos( )
    {
        return puestos;
    }

    /**
     * Retorna la lista de carros que se encuentran en el parqueadero.
     * @return La lista de carros que se encuentran en el parqueadero.
     */
    public ArrayList<Carro> darCarros( )
    {
        return carros;
    }

    /**
     * Retorna la tarifa por hora que maneja el parqueadero.
     * @return La tarifa que se est? aplicando en el parqueadero.
     */
    public int darTarifa( )
    {
        return tarifa;
    }

    /**
     * Retorna la hora actual.
     * @return La hora actual en el parqueadero.
     */
    public int darHoraActual( )
    {
        return horaActual;
    }

    /**
     * Indica la cantidad de dinero que hay en la caja.
     * @return Los ingresos totales en la caja.
     */
    public double darMontoCaja( )
    {
        return valorEnCaja;
    }

    /**
     * Cambia la tarifa del parqueadero.
     * <b>post: </b> Se cambi? la tarifa con la cual se cobran las horas en el parqueadero.
     * @param pTarifa Nueva tarifa del parqueadero. pTarifa > 0.
     */
    public void cambiarTarifa( int pTarifa )
    {
        tarifa = pTarifa;
        verificarInvariante();
    }

    /**
     * Indica si un puesto est? ocupado.
     * @param pPuesto El puesto que se desea saber si est? ocupado. pPuesto >= 0 && pPuesto < puestos.length.
     * @return Retorna true si el puesto especificado est? ocupado, false en caso contrario.
     */
    public boolean estaOcupado( int pPuesto )
    {
        boolean ocupado = puestos[ pPuesto ].estaOcupado( );
        return ocupado;
    }

    /**
     * Avanza una hora en el parqueadero. Si la hora actual es igual a la hora de cierre, el parqueadero se cierra.
     * <b>post: </b> Se avanz? una hora la hora actual del parqueadero. En caso de alcanzarse la hora de cierre se cerr? el parqueadero. <br>
     */
    public void avanzarHora( )
    {
        if( horaActual < HORA_CIERRE )
        {
            horaActual = ( horaActual + 1 );
        }
        if( horaActual == HORA_CIERRE )
        {
            abierto = false;
        }
        verificarInvariante();
    }

    /**
     * Retorna un mensaje con la placa del carro que se encuentra en la posici?n indicada.
     * @param pPosicion Posici?n del carro. pPosicion >= 0 && pPosicion < puestos.length.
     * @return Mensaje con la placa. Si no hay un carro en dicha posici?n retorna un mensaje indicando que no hay un carro en esa posici?n.
     */
    public String darPlacaCarro( int pPosicion )
    {
        String respuesta = "";
        if( estaOcupado( pPosicion ) )
        {
            respuesta = "Placa: " + puestos[ pPosicion ].darCarro( ).darPlaca( );
        }
        else
        {
            respuesta = "No hay un carro en esta posici?n";
        }

        return respuesta;
    }

    /**
     * Ingresa un carro al parqueadero. <br>
     * <b>pre: </b> La lista de carros y la lista de puestos est?n inicializadas. <br>
     * <b>post: </b>El carro fue ingresado y agregado a la lista de carros.
     * @param pPlaca Placa del carro que ingresa. pPlaca != null && pPlaca != "".
     * @param pMarca Marca del carro. pMarca != null && pMarca != "".
     * @param pModelo Modelo del carro. != null && pModelo != "".
     * @return Puesto en el que fue parqueado el carro. <br>
     * @throws Exception Si el parqueadero se encuentra cerrado. <br>
     *         Si no hay puestos libres en el parqueadero. <br>
     *         Si ya existe un carro en el parqueadero con la placa especificada.
     */
    public int ingresarCarro( String pPlaca, String pMarca, String pModelo ) throws Exception
    {
        int resultado = 0;
        if( !abierto )
        {
            throw new Exception( "El parqueadero se encuentra cerrado." );
        }
        else
        {
            if( buscarPuestoCarroPorPlaca( pPlaca.toUpperCase( ) ) != -1 )
            {
                throw new Exception( "Ya se encuentra un carro en el parqueadero con la placa especificada." );
            }
            resultado = buscarPuestoLibre( );

            Carro carroIngresa = new Carro( pPlaca, horaActual, pMarca, pModelo );
            puestos[ resultado ].ingresarCarro( carroIngresa );
            carros.add( carroIngresa );
        }
        

        return resultado;
    }

    /**
     * Saca un carro del parqueadero e informa la cantidad de dinero que debe pagar. <br>
     * <b>pre: </b> La lista de puestos y la lista de carros est?n inicializadas. <br>
     * <b>post: </b> El puesto fue desocupado y el carro sali? del parqueadero.
     * @param pPlaca Placa del carro que va a salir. pPlaca != null && pPlaca != "".
     * @return El valor a pagar.
     * @throws Exception Si el parqueadero se encuentra cerrado o el carro especificado no se encuentra en el parqueadero.
     */
    public int sacarCarro( String pPlaca ) throws Exception
    {
        int resultado = 0;

        if( !abierto )
        {
            throw new Exception( "El parqueadero se encuentra cerrado." );
        }

        int numPuesto = buscarPuestoCarroPorPlaca( pPlaca.toUpperCase( ) );
        if(numPuesto == -1)
        {
            throw new Exception( "El carro con la placa especificada no se encuentra en el parqueadero." );
        }

        Carro carro = puestos[ numPuesto ].darCarro( );
        int nHoras = carro.darTiempoEnParqueadero( horaActual );
        int porPagar = nHoras * tarifa;
        valorEnCaja = valorEnCaja + porPagar;
        puestos[ numPuesto ].sacarCarro( );
        carros.remove( carro );
        resultado = porPagar;


        verificarInvariante();
        return resultado;
    }

    /**
     * Indica la cantidad de puestos libres que hay.
     * @return La cantidad de puestos vac?os en el parqueadero.
     */
    public int calcularCantidadPuestosLibres( )
    {
        int puestosLibres = 0;
        for( Puesto puesto : puestos )
        {
            if( !puesto.estaOcupado( ) )
            {
                puestosLibres = puestosLibres + 1;
            }
        }
        return puestosLibres;
    }

    /**
     * Busca un puesto libre en el parqueadero y lo retorna.
     * @return N?mero del puesto libre encontrado.
     * @throws Exception Si no hay ning?n puesto libre en el parqueadero.
     */
    private int buscarPuestoLibre( ) throws Exception
    {
        int puesto = -1;
        for( int i = 0; i < TAMANO && puesto < 0; i++ )
        {
            if( !puestos[ i ].estaOcupado( ) )
            {
                puesto = i;
            }
        }

        if( puesto < 0 )
        {
            throw new Exception( "No hay puestos en el parqueadero." );
        }

        return puesto;
    }

    /**
     * Indica el n?mero de puesto en el que se encuentra el carro con una placa dada.
     * @param pPlaca Placa del carro que se busca. pPlaca != null && pPlaca != "".
     * @return N?mero del puesto en el que se encuentra el carro. Retorna -1 en caso de que el carro no se encuentre en ning?n puesto.
     */
    public int buscarPuestoCarroPorPlaca( String pPlaca )
    {
        int puesto = -1;
        for( int i = 0; i < TAMANO && puesto < 0; i++ )
        {
            if( puestos[ i ].tieneCarroConPlaca( pPlaca ) )
            {
                puesto = i;
            }
        }
        return puesto;
    }
    
    /**
     * Ordena ascendentemente los carros en el parqueadero por su marca, utilizando el algoritmo de selecci?n. <br>
     * <b> post: </b> Los carros en el parqueadero fueron ordenados alfab?ticamente por su marca.
     */
    public void ordenarPorMarca( )
    {
        for (int i = 0; i < carros.size()-1 ; i++) 
        {
            for (int j = i + 1; j < carros.size(); j++)
            {
                if (carros.get(i).compararPorMarca(carros.get(j)) > 0) 
                {
                    Carro temporal = carros.get(i);
                    carros.set(i,carros.get(j));
                    carros.set(j,temporal);
                }
            }
        }
    }

    /**
     * Ordena descendentemente los carros por su modelo, utilizando el algoritmo de inserci?n. <br>
     * <b> post: </b> Las carros fueron ordenados seg?n su modelo.
     */
    public void ordenarPorModelo( )
    {
        for (int i = 1; i < carros.size(); i++)
        {
            int pos = i;
            Carro actual = carros.get(i);
            while (pos>0 && actual.compararPorModelo(carros.get(pos-1))<0)
            {
                carros.set(pos,carros.get(pos-1));
                pos--;
            }
            carros.set(pos,actual);
        }
    }

    /**
     * Ordena las carros ascendentemente por su hora de ingreso, utilizando el algoritmo de burbuja. <br>
     * <b> post: </b> Las carros fueron ordenados seg?n su hora de ingreso.
     */
    public void ordenarPorHoraIngreso( )
    {
        for (int i = 1; i < carros.size()-1; i++)
        {
            for (int j = 0 ; j < carros.size()-1 ; j++)
            {
                Carro actual = carros.get(j);
                Carro siguiente = carros.get(j+1);
                if (actual.compararPorHoraIngreso(siguiente)>0)
                {
                    carros.set(j,siguiente);
                    carros.set(j+1,actual);
                }
            }
        }
    }

    /**
     * Ordena descendentemente los carros en el parqueadero por su placa, utilizando el algoritmo de selecci?n. <br>
     * <b> post: </b> Los carros en el parqueadero fueron ordenados alfab?ticamente por su placa descendentemente.
     */
    public void ordenarDescendentePorPlaca( )
    {
        for (int i = 0; i < carros.size()-1 ; i++)
        {
            Carro actual = carros.get(i);
            for (int j = i + 1; j < carros.size(); j++)
            {
                Carro siguiente = carros.get(j);
                if (actual.compararPorPlaca(siguiente) < 0)
                {
                    carros.set(i,siguiente);
                    carros.set(j,actual);
                }
            }
        }
    }


    /**
     * Busca un carro por su placa en la lista de carros.
     * @param pPlaca Placa del carro buscado. pPlaca != null && pPlaca != "".
     * @return Carro buscado, null si no hay ning?n carro con la placa especificada.
     */
    public Carro buscarCarroPorPlaca( String pPlaca )
    {
        for (int i = 0; i < carros.size(); i++)
        {
            final Carro carro = carros.get(i);
            if (carro.darPlaca().equals(pPlaca))
            {
                return carro;
            }
        }
        return null;
    }

    /**
     * Encuentra el primer carro que tiene la hora de ingreso especificada por par?metro, utilizando b?squeda binaria.
     * @param pHoraIngreso Hora de ingreso por la que se realizar? la b?squeda. pHoraIngreso > 0.
     * @return El primer carro encontrado que tiene la hora de ingreso especificada. Si ning?n carro satisface esta condici?n retorna null.
     */
    public Carro buscarPorHoraIngreso( int pHoraIngreso )
    {
        if (!carros.isEmpty())
        {
            ordenarPorHoraIngreso();
            int inferior = 0;
            int superior = carros.size()-1;
            Carro buscado = new Carro("",pHoraIngreso,"","");
            while(inferior<=superior)
            {
                int centro = (inferior+superior)/2;
                Carro carro = carros.get( centro );
                if (carro.compararPorHoraIngreso(buscado)==0)
                {
                    return carro;
                }
                else if (carro.compararPorHoraIngreso(buscado)>0)
                {
                    superior = centro -1;
                }
                else
                {
                    inferior = centro +1;
                }
            }
        }
        return null;
    }

    /**
     * Encuentra el primer carro que tiene la placa especificada por par?metro, utilizando b?squeda binaria.
     * @param pPlaca placa por la que se realizar? la b?squeda. pPlaca != null.
     * @return El primer carro encontrado que tiene la placa especificada. Si ning?n carro satisface esta condici?n retorna null.
     */
    public Carro buscarBinarioPorPlaca( String pPlaca )
    {
        if (!carros.isEmpty())
        {
            ordenarDescendentePorPlaca();
            int inferior = 0;
            int superior = carros.size()-1;
            Carro buscado = new Carro(pPlaca,12,"","");
            while(inferior<=superior)
            {
                int centro = (inferior+superior)/2;
                Carro carro = carros.get( centro );
                if (carro.compararPorPlaca(buscado)==0)
                {
                    return carro;
                }
                else if (carro.compararPorPlaca(buscado)<0)
                {
                    superior = centro -1;
                }
                else
                {
                    inferior = centro +1;
                }
            }
        }
        return null;
    }

    // -----------------------------------------------------------------
    // Puntos de Extensi?n
    // -----------------------------------------------------------------

    /**
     * M?todo de extensi?n 1.
     * @return Respuesta 1.
     */
    public String metodo1( )
    {
        return "respuesta 1";
    }

    /**
     * M?todo de extensi?n 2.
     * @return Respuesta 2.
     */
    public String metodo2( )
    {
        return "respuesta 2";
    }

    // -----------------------------------------------------------------
    // Invariante
    // -----------------------------------------------------------------

    /**
     * Verifica que el invariante de la clase se cumpla. Si algo falla, lanza un AssertionError. <br>
     */
    private void verificarInvariante()
    {
        assert puestos != null : "Los puestos no se inicializaron";
        assert puestos.length == TAMANO : "Los puestos no tienen los valores correctos";
        assert carros != null : "Los carros no se inicializaron";
        assert tarifa > 0 : "EL valor de la tarifa es invalido";
        assert valorEnCaja >= 0 : "EL valor en caja es invalido";
        assert horaActual >= 6 && horaActual <= 21 : "EL valor la hora actual es invalido";
    }
}