package es.juana.daw;

import java.util.Random;
import java.util.Scanner;


public  class Primitiva {

	private int[] numero = new int[6];
	private int reintegro;
	int acierto=0;
	int dinero = 0;
	public void leerNumeros() {
		System.out.println("----");
		Scanner sc = new Scanner(System.in);
		
		for(int i =0;i<6;i++) {
			System.out.println("primitiva "+i);
			numero[i]=sc.nextInt();
			
		}	
		
		System.out.println("reintegro");
		reintegro = sc.nextInt();
	}
	public void dineroGanado() {
		int dineroGanado = 0;
		if (compararNumeros()==4) {
			dineroGanado=1000;
		}
		
		if (compararNumeros()==5) {
			dineroGanado=10000;
		}
		
		if (compararNumeros()==6) {
			dineroGanado=1000000;
		}
		System.out.println("Has ganado " +dineroGanado+ "€");
		
	}
	public int compararNumeros() {
		Primitiva primitava= new Primitiva();
		int[] comparacion=primitava.();
		if(reintegro==primitava.getReintegro()) {
			dinero=dinero+1;
		}
		for(int j=0;j<6;j++) {
			for(int t=0;t<6;t++) {
				if(numero[j]==comparacion[t]) {
					 acierto++;
				}
			}
		
		}
		if(acierto==4) {
			dinero=dinero+1000;
			return 1; 
		}
		if(acierto==5) {
			dinero=dinero+10000;
			return 2; 
		}
		if(acierto==6) {
			dinero=dinero+1000000;
			return 3; 
		}
		if(acierto<4 && acierto>6) {
			dinero=dinero+0;
			return 4; 
		}
		return dinero;
		
	}

	public  void iniciar() {
		int a;
		Scanner sc = new Scanner (System.in);
		System.out.println("---La Primitiva---");
		System.out.println("   1. Jugar");
		System.out.println("   2. Ver Historial");
		System.out.println("   3. Salir");
		a= sc.nextInt();
		switch (a) {
		case 1: {
			leerNumeros();
			compararNumeros();
			dineroGanado();
			System.out.println();
			
		}
		case 2:{
			
		}
		case 3:
		}
	}
}