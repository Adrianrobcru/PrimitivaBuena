package es.juana.daw;

import java.util.Scanner;

public class Combinacion {
	
	private int[] numero = new int[6];
	private int reintegro;
	int acierto=0;
	int dineroGando;
	public void leerNumeros() {
		Scanner sc = new Scanner(System.in);
		reintegro = sc.nextInt();
		for(int i =0;i<6;i++) {
			numero[i]=sc.nextInt();
		}		
	}
	public int compararNumeros() {
		Primitiva primitava= new Primitiva();
		int[] comparacion=primitava.getPrimitiva();
		if(reintegro==primitava.getReintegro()) {
			dineroGando=dineroGando+1;
		}
		for(int j=0;j<6;j++) {
			for(int t=0;t<6;t++) {
				if(numero[j]==comparacion[t]) {
					 acierto++;
				}
			}
		
		}
		if(acierto==4) {
			dineroGando=dineroGando+1000;
			return dineroGando;
		}
		if(acierto==5) {
			dineroGando=dineroGando+10000;
			return dineroGando;
		}
		if(acierto==6) {
			dineroGando=dineroGando+1000000;
			return dineroGando;
		}
		if(acierto<4 && acierto>6) {
			dineroGando=dineroGando+0;
			return dineroGando;
		}
		return dineroGando;
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
			
		}
		case 2:{
			
		}
		case 3:
		}
	}
}
