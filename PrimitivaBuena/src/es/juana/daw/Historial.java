package es.juana.daw;

public class Historial {
	int aciertos;
	int dineroGanado;
	Combinacion combiancionGanadora;
	Combinacion combinacionUsuario;
	Primitiva dineroGanado2 = new Primitiva();
	public Historial(Combinacion combinacionPremiada,Combinacion combinacionIntroducida,int aciertos,int dineroGanador) {
		this.aciertos=aciertos;
		this.dineroGanado=dineroGanador;
		this.combiancionGanadora=combinacionPremiada;
		this.combinacionUsuario=combinacionIntroducida;
	}
	public String imprimirHistorial() {
		String stringReintegro=String.valueOf(combiancionGanadora.numReintegro);
		String stringPrimitiva = "";
		String stringReintegro2=String.valueOf(combinacionUsuario.numReintegro);
		String stringPrimitiva2 = "";
		for(int i=0;i<combiancionGanadora.numPrimitiva.length;i++) {
			stringPrimitiva=stringPrimitiva+" "+String.valueOf(combiancionGanadora.numPrimitiva[i]);
		}
		for(int i=0;i<combiancionGanadora.numPrimitiva.length;i++) {
			stringPrimitiva2=stringPrimitiva2+" "+String.valueOf(combinacionUsuario.numPrimitiva[i]);
		}
		return "La primitiva es: "+stringPrimitiva+" y el reintegro es: "+stringReintegro+"\n"+
		"La primitiva que introduce el usuario es: "+stringPrimitiva2+" y el reintegro es: "+stringReintegro2
		+" \nLos aciertos son: "+ aciertos+ " por lo tanto el dinero ganado es: "+dineroGanado+"\n";
		
}
}