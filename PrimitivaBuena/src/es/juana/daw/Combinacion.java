package es.juana.daw;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Combinacion {

	/*inicializamos dos variables,numReintegro que es un int donde ira el numero reintegro y un array de tipo int que se guardara los numeros de a primitiva*/
	int numReintegro;
	int[] numPrimitiva;

	/*Este constructor nos permite generar numeros aleatorios y asignarlos en la variable numReintegro y en el array numPrimitiva*/




	public  Combinacion(){ /*El constructor que genera el numero premiado*/
		numPrimitiva = new int[6];
	}

	public Combinacion(int reintegro, int[] primitiva) {/*El constructor que genera el numero que introduce el usuario*/
		numReintegro = reintegro;
		numPrimitiva = primitiva;
	}
	/**
	 * Este metodo devuelve 
	 * @numPrimitiva
	 *de un objeto que llama de tipo combinacion
	 */
	public int[] getArray(){
		return numPrimitiva;
	}

/**
 * El método compara el objeto 
 * @param combinacionUsuario
 * @return el número de aciertos
 */


	public int compararCombinacionesArray(Combinacion combinacionUsuario) { 

		int[] combiUsuarioArray = combinacionUsuario.getArray();
		int aciertos=0;
		for(int i=0;i<numPrimitiva.length;i++) {
			for(int j=0;j<6;j++) {
				if(this.numPrimitiva[i]==combiUsuarioArray[j]) {
					aciertos++;
				}
			}
		}
		return aciertos;
	}
	/**
	 * método que compara las combinaciones del reintegro
	 * @param combinacionUsuario
	 * @return false o true
	 */
	public boolean compararCombinacionesReintegro(Combinacion combinacionUsuario) {
		int combinacionUsuarioReintegro=combinacionUsuario.numReintegro;
		if (this.numReintegro==combinacionUsuarioReintegro) {
			return true;
		}else {
			return false;
		}

	}
	/**
	 * Este objeto lee un array y un int que mete el usuario y lo introduce a a un objeto de tipo combinacion
	 */
	public void leerCombinacionUsuario() {
	
		Scanner scanner= new Scanner(System.in);
		for(int i=0;i<numPrimitiva.length;i++) {
			System.out.println("Dime el numero "+(i+1)+"º de la primitiva");
			boolean comprobarRepetidos=false;
			int primitivaUsuarioValidacion=scanner.nextInt();

			while(primitivaUsuarioValidacion<1 || primitivaUsuarioValidacion>20) {
				System.out.println("Ese numero no es valido,porfavor introduzca otro");
				primitivaUsuarioValidacion=scanner.nextInt();
			}

			for(int j=0;j<numPrimitiva.length;j++) {
				if(primitivaUsuarioValidacion==numPrimitiva[j]) {
					comprobarRepetidos=true;
				}
			}

			if(comprobarRepetidos==false) {
				numPrimitiva[i]=primitivaUsuarioValidacion;
			}else {
				System.out.println("El numero repetido ya esta introducido");
				i=i-1;

			}
		}
		System.out.println("Introduce el reintegro");
		int reintegroUsuarioValidacion=scanner.nextInt();
		while(reintegroUsuarioValidacion<0 || reintegroUsuarioValidacion>9){
			System.out.println("El reintegro introducido no es válido.Introduzca otro, por favor");
			reintegroUsuarioValidacion=scanner.nextInt();
			
		}
		numReintegro=reintegroUsuarioValidacion;
		
		Arrays.sort(numPrimitiva);/*ordena de menor a mayor el array*/


	}
/**
 * Objeto que genera una combinacion de manera aleatoria
 */

	public void generarCombinacionAleatoria() {
		
		Random randomReintegro=new Random();
		this.numReintegro= randomReintegro.nextInt(9);//Genera un numero aleatorio de cero hasta el numero puesto en el parentesis
		for(int i=0;i<this.numPrimitiva.length;i++) {//Este for nos permite asignar a cada espacio de memoria un numero aleatorio
			Random randomPrimitiva= new Random();
			boolean validarRandom=false;
			int guardarRandom= randomPrimitiva.nextInt(19)+1;//lo que va entre parentesis seria el numero maximo y el numero despues del mas seria el minimo
			for(int j=0;j<numPrimitiva.length;j++) {
				if(numPrimitiva[j]==guardarRandom) {
					validarRandom=true;
				}
			}
			if(validarRandom==true) {
				i--;
			}else {
			this.numPrimitiva[i]=guardarRandom;}
		}
		
		Arrays.sort(numPrimitiva);
		
	}


/**
 * Este metodo devuelve:
 * @numReintegro
 * de un objeto de tipo combinacion
 */
	public int getNumReintegro() {
		return numReintegro;
	}
/**
 * método que muestra la combinación 
 * @return un string de Primitiva y otro de Reintegro
 */
	public String mostrarCombinacion() {
		
		String stringReintegro=String.valueOf(numReintegro);
		String stringPrimitiva = "";
		for(int i=0;i<numPrimitiva.length;i++) {
			stringPrimitiva=stringPrimitiva+" "+String.format("%02d", numPrimitiva[i]);
		}
		return "\n"+"╔══════════════════════════════════════════════════════════════╗" + "\n"
				  + "║     "+"La primitiva es" +stringPrimitiva+ "                        ║" +"\n"
				   +"║                                                              ║" + "\n"
				  + "║      Y el reintegro es: "+stringReintegro+ "                                    ║" +"\n"
				  + "╚══════════════════════════════════════════════════════════════╝";
	}

}