package Cuantos_dias_faltan;

import java.util.Scanner;

public class Ejercicio_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int casos = scanner.nextInt(); 
        
        for (int i = 0; i < casos; i++) {
            int dia = scanner.nextInt(); 
            int mes = scanner.nextInt(); 

            int diasHastaNochevieja = calcularDiasHastaNochevieja(dia, mes);
            System.out.println(diasHastaNochevieja);
        }
    }

    public static int calcularDiasHastaNochevieja(int dia, int mes) {
        int diasEnMeses[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int diasHastaNochevieja = 0;
        diasHastaNochevieja += diasEnMeses[mes - 1] - dia;

        for (int i = mes; i < 12; i++) {
            diasHastaNochevieja += diasEnMeses[i];
        }

        return diasHastaNochevieja;
    }
}
