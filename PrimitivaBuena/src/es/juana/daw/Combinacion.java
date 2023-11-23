package es.juana.daw;

import java.util.Random;
import java.util.Scanner;

public class Combinacion {
	
	/*inicializamos dos variables,numReintegro que es un int donde ira el numero reintegro y un array de tipo int que se guardara los numeros de a primitiva*/
	int numReintegro;
	int[] numPrimitiva= new int[6];
	/*Este constructor nos permite generar numeros aleatorios y asignarlos en la variable numReintegro y en el array numPrimitiva*/
	
	
	
	
	public  Combinacion(){/*El constructor que genera el numero premiado*/
		Random randomReintegro=new Random();
		this.numReintegro= randomReintegro.nextInt(9);/*Genera un numero aleatorio de cero hasta el numero puesto en el parentesis*/
		for(int i=0;i<this.numPrimitiva.length;i++) {/*Este for nos permite asignar a cada espacio de memoria un numero aleatorio*/
			Random randomPrimitiva= new Random();
			this.numPrimitiva[i]=randomPrimitiva.nextInt(19)+1;/*lo que va entre parentesis seria el numero maximo y el numero despues del mas seria el minimo*/
		}
		
	}
	
	public Combinacion(int reintegro, int[] primitiva) {/*El constructor que genera el numero que introduce el usuario*/
		primitiva = new int[numPrimitiva.length];/*Indica las posiciones de memoria que va a tener el array primitiva*/
		this.numReintegro = reintegro;/*Añade el numero reintegro a numReintegro*/
		for(int i = 0; i < primitiva.length; i++) {/*Añade numeros al array posicion por posicion*/
			this.numPrimitiva[i] = primitiva[i];
		}
	}
	
	public void dineroGanado() {
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
		System.out.println("Has ganado " +dineroGanado+ "€");
	}
	
	public int compararNumeros() {
		Combinacion combinacionPrimtiva = new Combinacion();/*Se crea un objeto de tipo combinacion en este caso sera el numero premiado*/
		Scanner sc = new Scanner(System.in);/*se llama al escaner*/
		
		int [] primitivaLeer = new int[numPrimitiva.length];/*se inicializa el array el cual va a ser el que introduzca el usuario*/
		for(int i = 0; i< this.numPrimitiva.length; i++) {/*for que mete cada numero introducido por el usario en cada posicion de memoria del for*/
			System.out.println("Introduce el "+i+"º numero de la primitiva");
			int a=sc.nextInt();
			if(a>0 && a<20) {/*Comprobador para ver si el numero introducido es valido*/
			primitivaLeer[i]=a;}
			else {
				System.out.println("Ese numero no esta permitido,porfarvor introduzca un numero del 1 al 20");
				i=i-1;
			}
			
			}
		boolean reintegrVal=false;
		System.out.println("Introduce el numero de reintegro");
		while (reintegrVal==false) {/*comprobacion de que el reintegro es correcto*/
			int b=sc.nextInt();
		
			if (b>9 && b<0) {
				System.out.println("Ese numero no esta permitido,porfavor introduzca un numero del 1 al 20");
			}else {
				int reintegroLeer= b;
				reintegrVal=true;
			}
			
		}
		
		Combinacion combinacionLeer = new Combinacion();
		int acierto=0;
		
		for(int i =0;i<this.numPrimitiva.length;i++) {/*este for que dentro tiene otro for lo que hace es comparar una posicion de memoria con el resto de posiciones de memoria*/
			for(int j =0;j<this.numPrimitiva.length;j++) {
				if(combinacionPrimtiva.numPrimitiva[i]==combinacionLeer.numPrimitiva[j]) {
					acierto=acierto+1;
				}
			}
		}
		if(combinacionPrimtiva.numReintegro==combinacionLeer.numReintegro) {/*dependiendo de los aciertos que haya y si se ha acertado el reintegro o no se devuelve un numero que con la funcion dineroGanado()'que hay que crear'*/
			if(acierto==4) {
				return 1;
			}
			if(acierto==5) {
				return 2;
			}
			if(acierto==6) {
				return 3;
			}
			if(acierto<4) {
				return 4;
			}
		}else {
			if(acierto==4) {
				return 5;
			}
			if(acierto==5) {
				return 6;
			}
			if(acierto==6) {
				return 7;
			}
			if(acierto<4) {
				return 8;
			}
		}
		return 0;
		}
	
}