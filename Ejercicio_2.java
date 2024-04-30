package los_dalton;

import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio_2 {

    public static String verificarOrden(String cadenaNumeros) {
        String[] numerosString = cadenaNumeros.split(",");
        int[] numeros = new int[numerosString.length];

        for (int i = 0; i < numerosString.length; i++) {
            numeros[i] = Integer.parseInt(numerosString[i].trim());
        }

        boolean ascendente = true;
        boolean descendente = true;

        for (int i = 1; i < numeros.length; i++) {
            if (numeros[i] > numeros[i - 1]) {
                descendente = false;
            } else if (numeros[i] < numeros[i - 1]) {
                ascendente = false;
            }

            if (!ascendente && !descendente) {
                return "DESCONOCIDO";
            }
        }

        if (ascendente) {
            return "ASCENDENTE";
        } else if (descendente) {
            return "DESCENDENTE";
        } else {
            return "DESCONOCIDO";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese los numeros que quieras verificar de tal forma que (3,1,8,5,9)");
        String cadenaNumeros = scanner.nextLine();
        String resultado = verificarOrden(cadenaNumeros);
        System.out.println("El orden es: " + resultado);
    }
}