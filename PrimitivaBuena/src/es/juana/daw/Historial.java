package es.juana.daw;

public class Historial {
	//variables
	int aciertos;
	int dineroGanado;
	Combinacion combiancionGanadora;
	Combinacion combinacionUsuario;
	Primitiva dineroGanado2 = new Primitiva();
	//constructor
	public Historial(Combinacion combinacionPremiada,Combinacion combinacionIntroducida,int aciertos,int dineroGanador) {
		this.aciertos=aciertos;
		this.dineroGanado=dineroGanador;
		this.combiancionGanadora=combinacionPremiada;
		this.combinacionUsuario=combinacionIntroducida;
	}
	/**
	 * Devuelve el historial de las partidas que se han jugado
	 * @return una cadena de String que muestra el historial
	 */
	public String imprimirHistorial() {
		String stringReintegro=String.valueOf(combiancionGanadora.numReintegro);
		String stringPrimitiva = "";
		String stringReintegro2=String.valueOf(combinacionUsuario.numReintegro);
		String stringPrimitiva2 = "";
		//bucle que representa la combinacion ganadora
		for(int i=0;i<combiancionGanadora.numPrimitiva.length;i++) {
			stringPrimitiva=stringPrimitiva+" "+String.valueOf(combiancionGanadora.numPrimitiva[i]);//uso del metodo valueOf que devuelve el valor del String en forma de cadena
		}
		//bucle que representa la combinacion introducia por el usuario.
		for(int i=0;i<combiancionGanadora.numPrimitiva.length;i++) {
			stringPrimitiva2=stringPrimitiva2+" "+String.valueOf(combinacionUsuario.numPrimitiva[i]);
		}
		return "La primitiva es: "+stringPrimitiva+" y el reintegro es: "+stringReintegro+"\n"+
		"La primitiva que introduce el usuario es: "+stringPrimitiva2+" y el reintegro es: "+stringReintegro2
		+" \nLos aciertos son: "+ aciertos+ " por lo tanto el dinero ganado es: "+dineroGanado+"\n";
		
}
}