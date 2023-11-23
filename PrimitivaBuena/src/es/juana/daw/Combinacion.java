package es.juana.daw;

import java.util.Random;
import java.util.Scanner;

public class Combinacion {
	
	/*inicializamos dos variables,numReintegro que es un int donde ira el numero reintegro y un array de tipo int que se guardara los numeros de a primitiva*/
	int numReintegro;
	int[] numPrimitiva= new int[6];
	/*Este metodo nos permite generar numeros aleatorios y asignarlos en la variable numReintegro y en el array numPrimitiva*/
	
	
	
	
	public  Combinacion(){
		Random randomReintegro=new Random();
		this.numReintegro= randomReintegro.nextInt(9);/*Genera un numero aleatorio de cero hasta el numero puesto en el parentesis*/
		for(int i=0;i<this.numPrimitiva.length;i++) {/*Este for nos permite asignar a cada espacio de memoria un numero aleatorio*/
			Random randomPrimitiva= new Random();
			this.numPrimitiva[i]=randomPrimitiva.nextInt(19)+1;/*lo que va entre parentesis seria el numero maximo y el numero despues del mas seria el minimo*/
		}
		
	}
	
	public Combinacion(int reintegro, int[] primitiva) {
		primitiva = new int[6];
		this.numReintegro = reintegro;
		for(int i = 0; i < primitiva.length; i++) {
			this.numPrimitiva[i] = primitiva[i];
		}
	}
	
	public void compararNumeros() {
		Combinacion combinacionPrimtiva = new Combinacion();
		Scanner sc = new Scanner(System.in);
		int reintegroLeer= sc.nextInt();
		int [] primitivaLeer = new int[numPrimitiva.length];
		for(int i = 0; i< this.numPrimitiva.length; i++) {
			primitivaLeer[i]= sc.nextInt();
			}
		Combinacion combinacionLeer = new Combinacion();
		
		
		
		}
	
}