/*
  Trabalho Interdisciplinar II
  Exercicio1  - v0.1. - 21 / 08 / 2021
  Author: Lucas Morato de Oliveira Xavier
  Matricula : 541509
 */

import java.util.*;

class SomarDois {
	
public static  Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
	    //Declaracao de variaveis
		int num1, num2, soma;
		
		//leitura do primeiro int
		System.out.println("Digite um número");
		num1 = sc.nextInt();
	
		//leitura do segundo int
		System.out.println("Digite outro número");
		num2 = sc.nextInt();
		
		//Somar
		soma = num1 + num2;
		
		//Mostrar na tela
		System.out.println("Soma:" +soma);
	}

}
