package es.juana.daw;

public class Historial {
	int aciertos;
	int dineroGanado;
	Combinacion combiancionGanadora;
	Combinacion combinacionUsuario;
	public Historial(Combinacion combinacionPremiada,Combinacion combinacionIntroducida,int aciertos,int dineroGanado) {
		this.aciertos=aciertos;
		this.dineroGanado=dineroGanado;
		this.combiancionGanadora=combinacionPremiada;
		this.combinacionUsuario=combinacionIntroducida;
	}
	public String imprimirHistorial() {
		String stringReintegro=String.valueOf(combiancionGanadora.numReintegro);
		String stringPrimitiva = "";
		for(int i=0;i<numPrimitiva.length;i++) {
			stringPrimitiva=stringPrimitiva+" "+String.valueOf(numPrimitiva[i]);
		}
		return "la primitiva es "+stringPrimitiva+" y el reintegro es: "+stringReintegro;
}
