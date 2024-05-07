package siguiete_matricula;

import java.util.Scanner;

public class Ejercicio_3_1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Ingrese el número de matrícula (por ejemplo, 1111 AAA): ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("9999 ZZZ")) {
                System.out.println("ERROR EN LA SECUENCIA");
                break;
            }

            String[] partes = input.split("\\s+");
            if (partes.length != 2) {
                System.out.println("Formato de entrada inválido. Por favor, inténtelo de nuevo.");
                continue;
            }

            String parteNumerica = partes[0];
            String parteAlfabetica = partes[1];

            try {
                int valorNumerico = Integer.parseInt(parteNumerica);
                valorNumerico++; // Incrementar la parte numérica

                if (valorNumerico > 9999) {
                    valorNumerico = 0; // Reiniciar si supera 9999
                    parteAlfabetica = obtenerSiguienteSecuenciaAlfabetica(parteAlfabetica);
                }

                System.out.printf("%04d %s", valorNumerico, parteAlfabetica);
            } catch (NumberFormatException e) {
                System.out.println("Parte numérica inválida. Por favor, ingrese un número válido.");
            }
        }

        scanner.close();
    }

    public static String obtenerSiguienteSecuenciaAlfabetica(String parteAlfabetica) {
        char[] caracteresAlfabeticos = parteAlfabetica.toCharArray();

        // Actualizar la secuencia alfabética según reglas específicas
        if (caracteresAlfabeticos.length == 3) {
            char primerChar = caracteresAlfabeticos[0];
            char segundoChar = caracteresAlfabeticos[1];
            char tercerChar = caracteresAlfabeticos[2];

            if (tercerChar < 'Z') {
                tercerChar++;
            } else {
                tercerChar = 'A'; 
                if (segundoChar < 'Z') {
                    segundoChar++;
                } else {
                    segundoChar = 'A'; 
                    if (primerChar < 'Z') {
                        primerChar++;
                    } else {
                        primerChar = 'A';
                    }
                }
            }

            caracteresAlfabeticos[0] = primerChar;
            caracteresAlfabeticos[1] = segundoChar;
            caracteresAlfabeticos[2] = tercerChar;
        }

        return new String(caracteresAlfabeticos);
    }
}