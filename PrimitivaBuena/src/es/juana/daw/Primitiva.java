package es.juana.daw;

import java.util.Random;
import java.util.Scanner;


public  class Primitiva {
	/**
	 * variables para el historial
	 */
	public Primitiva() {
		// TODO Auto-generated constructor stub
	}
	private static int partidasJugadas=0;
	private static int partidasMaximas=10;/*número máximo de partidas que el usuario puede jugar*/
	private static Combinacion[]historial=new Combinacion[partidasMaximas];/*combinacion tiene el tamaño de partidasMaximas*/
	private static int contador=0;
	/**
	 * método para iniciar el programa
	 */
	public static  void iniciar() {


		boolean jugando = true;

		while(jugando) {

			Scanner sc=new Scanner(System.in);
			int eleccion;
			/*le damos a elegir al usuario que quiere hacer mientras que la eleccion siempre sea menor o igual a 3*/



			System.out.println("¿Qué quiere hacer usted?");
			System.out.println("1.Jugar");
			System.out.println("2.Ver historial ");
			System.out.println("3.Salir");

			contador++;
			eleccion=sc.nextInt();
			sc.nextLine();


			switch(eleccion) {

			case 1:/*en el caso de elegir 1, se crea el objeto combinacion que se añade al historial*/

				Combinacion combinacionUsuario = new Combinacion();
				combinacionUsuario.leerCombinacionUsuario();
				Combinacion combiPremiada = new Combinacion();
				combiPremiada.generarCombinacionAleatoria();
				System.out.println("En la primitiva premiada: "+combiPremiada.mostrarCombinacion());
				System.out.println("En la primitiva introducida: "+ combinacionUsuario.mostrarCombinacion());
				System.out.println("El numero de aciertos es: "+combiPremiada.compararCombinacionesArray(combinacionUsuario));
				Primitiva primitivaDineroGanado= new Primitiva();
				System.out.println("El dinero ganado es: "+primitivaDineroGanado.dineroGanado(combiPremiada.compararCombinacionesArray(combinacionUsuario), combiPremiada.compararCombinacionesReintegro(combinacionUsuario))+"€");


				//int numAciertos = combinacionUsuario.compararNumeros(combiPremiada); //CON ESTO SACO EL NÚMERO DE ACIERTOS


				//System.out.println(combinacionUsuario.mostrarCombinacion());
				//LO QUE SE IMPRIME YA LO PENSÁIS VOSOTROS

				//anadirHistorial(combinacionUsuario); //EN EL HISTORIAL YO GUARDARÍA TANTO LA COMBINACIÓN GANADORA COMO EL PREMIO O NUMERO DE ACIERTOS
				break;


			case 2:/* en el caso de elegir el nº 2, se le muestra al usuario el historial llamando al método mostrarHistorial()*/
				mostrarHistorial();
				
				break;

			case 3: 
				
				System.out.println("Hasta pronto!");
				jugando = false;
				break;
			}
		}

	}


	private int dineroGanado(int aciertos,boolean reintegroAcertado) {
		
	/*metodo que dependiendo de los aciertos y que si se acerta la primitiva se le asigna a 
	la variable dineroGanado y al final se devuelve dineroGanado*/
		
		int dineroGanado=0;
		if(reintegroAcertado==true) {
			if(aciertos==4) {
				dineroGanado=dineroGanado+1000+1;
			}
			
			if(aciertos==5) {
				dineroGanado=dineroGanado+10000+1;
			}
			
			if(aciertos==6) {
				dineroGanado=dineroGanado+1000000+1;
			}
			
		}
		
		else {
			
			if(aciertos==4) {
				dineroGanado=dineroGanado+1000;
			}
			
			if(aciertos==5) {
				dineroGanado=dineroGanado+10000;
			}
			
			if(aciertos==6) {
				dineroGanado=dineroGanado+1000000;
			}
		}
		return dineroGanado;
	}
	
	
	/**
	 * método que añade una combinacion al historial
	 * @param recibe como parametro combinacion
	 */
	
	private static void anadirHistorial(Combinacion combinacionPremiada,Combinacion combinacionIntroducida,int aciertos,int dineroganado) {
		do {
			
			if(partidasJugadas<partidasMaximas) {/*si el numero de partidas jugadas es menor que el de partidas máximas,asigna la combinacion actual a partidasJugadas del array historial*/
				historial[partidasJugadas]=combinacionHistorial;
				partidasJugadas++;/*aumenta el número de partidas jugadas*/
			}
			else {
				reiniciarHistorial();/*en el caso de que las partidas jugadas supere al número máximo de partidas,se reinicia el historial,llamando al método reiniciarHistorial()*/
			}
		}
		while(partidasJugadas>partidasMaximas);/*verifica si el número de partidas jugadas supera al de partidas maximas.Se repite el bucle si no se cumple esta condicion*/

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