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

	public int[] getArray(){
		return numPrimitiva;
	}


	/**public int dineroGanado() { //TODO Los premios los maneja el juego. Una combinación solo compara número de aciertos. Esto no iria aquí.
		int dineroGanado = 0;
		if (compararNumeros()==1) {
			dineroGanado=1000 + 1;
		}

		if (compararNumeros()==2) {
			dineroGanado=10000 +1;
		}

		if (compararNumeros()==3) {
			dineroGanado=1000000 + 1 ;
		}
		if (compararNumeros()==4) {
			dineroGanado= 1 ;
		}
		if (compararNumeros()==5) {
			dineroGanado=1000 ;
		}

		if (compararNumeros()==6) {
			dineroGanado=10000 ;
		}

		if (compararNumeros()==7) {
			dineroGanado=1000000 ;
		}
		if (compararNumeros()==8) {
			dineroGanado= 0 ;
		}
		return dineroGanado;
	}**/

	public int compararCombinacionesArray(Combinacion combinacionUsuario) { 

		int[] combiUsuarioArray = combinacionUsuario.getArray();
		int aciertos=0;
		for(int i=0;i<6;i++) {
			for(int j=0;j<6;j++) {
				if(this.numPrimitiva[i]==combiUsuarioArray[j]) {
					aciertos++;
				}
			}
		}
		return aciertos;
	}
	public boolean compararCombinacionesReintegro(Combinacion combinacionUsuario) {
		int combinacionUsuarioReintegro=combinacionUsuario.getNumReintegro();
		if (this.numReintegro==combinacionUsuarioReintegro) {
			return true;
		}else {
			return false;
		}

	}
	public void leerCombinacionUsuario() {
	
		Scanner scanner= new Scanner(System.in);
		for(int i=0;i<numPrimitiva.length;i++) {
			System.out.println("Dime el numero "+(i+1)+"º de la primitiva");
			boolean comprobarRepetidos=false;
			int a=scanner.nextInt();

			while(a<1 || a>20) {
				System.out.println("Ese numero no es valido,porfavor introduzca otro");
				a=scanner.nextInt();
			}

			for(int j=0;j<numPrimitiva.length;j++) {
				if(a==numPrimitiva[j]) {
					comprobarRepetidos=true;
				}
			}

			if(comprobarRepetidos==false) {
				numPrimitiva[i]=a;
			}else {
				System.out.println("El numero repetido ya esta introducido");
				i=i-1;

			}
		}
		System.out.println("Introduce el reintegro");
		int b=scanner.nextInt();
		while(b<0 || b>9){
			System.out.println("El reintegro introducido no es válido.Introduzca otro, por favor");
			b=scanner.nextInt();
			
		}
		numReintegro=b;
		
		Arrays.sort(numPrimitiva);


	}


	public void generarCombinacionAleatoria() {
		Random randomReintegro=new Random();
		this.numReintegro= randomReintegro.nextInt(9);/*Genera un numero aleatorio de cero hasta el numero puesto en el parentesis*/
		for(int i=0;i<this.numPrimitiva.length;i++) {/*Este for nos permite asignar a cada espacio de memoria un numero aleatorio*/
			Random randomPrimitiva= new Random();
			boolean validarRandom=false;
			int guardarRandom= randomPrimitiva.nextInt(19)+1;/*lo que va entre parentesis seria el numero maximo y el numero despues del mas seria el minimo*/
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




	public int getNumReintegro() {
		return numReintegro;
	}

	public String mostrarCombinacion() {
		//TODO Rehacer
		String stringReintegro=String.valueOf(numReintegro);
		String stringPrimitiva = "";
		for(int i=0;i<numPrimitiva.length;i++) {
			stringPrimitiva=stringPrimitiva+String.valueOf(numPrimitiva[i]);
		}
		return "La primitiva es "+stringPrimitiva+" y el reintegro es: "+stringReintegro;
	}

}