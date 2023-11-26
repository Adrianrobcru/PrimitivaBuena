package es.juana.daw;

import java.util.Random;
import java.util.Scanner;


public  class Primitiva {
	/**
	 * variables para el historial
	 */
	private static int partidasJugadas=0;
	private static int partidasMaximas=6;/*número máximo de partidas que el usuario puede jugar*/
	private static Combinacion[]historial=new Combinacion[partidasMaximas];/*combinacion tiene el tamaño de partidasMaximas*/
	/**
	 * método para iniciar el programa
	 */
	public static  void iniciar() {
		Scanner sc=new Scanner(System.in);
		int eleccion;
		do {/*le damos a elegir al usuario que quiere hacer mientras que la eleccion siempre sea menor o igual a 3*/
			System.out.println("¿Qué quiere hacer usted?");
			System.out.println("1.Jugar");
			System.out.println("2.Ver historial ");
			System.out.println("3.Salir");
			eleccion=sc.nextInt();
			switch(eleccion) {
			case 1:/*en el caso de elegir 1, se crea el objeto combinacion que se añade al historial*/
				Combinacion combinacion=new Combinacion();
				anadirHistorial(combinacion);
				break;
			case 2:/* en el caso de elegir el nº 2, se le muestra al usuario el historial llamando al método mostrarHistorial()*/
				mostrarHistorial();
				break;
			}
			
		}while(eleccion<=3);
	
	}
	/**
	 * método que añade una combinacion al historial
	 * @param recibe como parametro combinacion
	 */
	private static void anadirHistorial(Combinacion combinacion) {
		do {
			if(partidasJugadas<partidasMaximas) {/*si el numero de partidas jugadas es menor que el de partidas máximas,asigna la combinacion actual a partidasJugadas del array historial*/
				historial[partidasJugadas]=combinacion;
				partidasJugadas++;/*aumenta el número de partidas jugadas*/
			}else {
				reiniciarHistorial();/*en el caso de que las partidas jugadas supere al número máximo de partidas,se reinicia el historial,llamando al método reiniciarHistorial()*/
			}
		}while(partidasJugadas>partidasMaximas);/*verifica si el número de partidas jugadas supera al de partidas maximas.Se repite el bucle si no se cumple esta condicion*/
		
	}
	/**
	 * método para mostrar el historial
	 */
	private static void mostrarHistorial() {
		System.out.println("Historial de las combinaciones");/*avisa de que se imprime el historial de la combinaciones*/
		for(int i = 0;i<partidasJugadas;i++) {/*el bucle se inicia en 0 e itera sobre el historial hasta el número de partidas jugadas*/
			historial[i].mostrarCombinacion();/*muestra la combinacion dentro del historial de la posicion i e imprime los datos de la combinación*/
		}
	}
	/**
	 * método que reinicia el historial
	 */
	private static void reiniciarHistorial() {
		// TODO Auto-generated method stub
		System.out.println("El historial está lleno y se está reiniciando.Espere unos minutos,porfavor");
		partidasJugadas = 0;//el nº de las partidas jugadas vuelve a ser cero
	}
	
}