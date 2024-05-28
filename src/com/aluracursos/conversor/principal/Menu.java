package com.aluracursos.conversor.principal;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        double cantidad;

        while (true) {
            mostrarMenu();
            opcion = scanner.nextInt();

            // Salir del programa si la opción es 8
            if (opcion == 8) {
                System.out.println("Saliendo del programa...");
                return;
            }

            // Validar opción seleccionada
            if (opcion < 1 || opcion > 7) {
                System.out.println("Opción no válida. Por favor, seleccione una opción del 1 al 8.");
                continue;
            }

            // Obtener nombre de la divisa
            String divisa = obtenerNombreDivisa(opcion);
            System.out.println("Ha seleccionado la opción: " + divisa + ".");

            // Ingresar cantidad a convertir
            System.out.print("Ingrese la cantidad que desea convertir: ");
            cantidad = scanner.nextDouble();

            // Mostrar menú de divisas
            MenuDivisas.mostrarMenuDivisas(divisa, cantidad);
        }
    }

    public static void mostrarMenu() {
        System.out.println("***********************************************************");
        System.out.println("Bienvenido al menú:");
        System.out.println("Seleccione una divisa para convertir:");
        System.out.println("1. Peso Mexicano");
        System.out.println("2. Peso Argentino");
        System.out.println("3. Peso Chileno");
        System.out.println("4. Euro");
        System.out.println("5. Dólar Estadounidense");
        System.out.println("6. Dólar Canadiense");
        System.out.println("7. Yen Japonés");
        System.out.println("8. Salir");
        System.out.println("***********************************************************");
    }

    public static String obtenerNombreDivisa(int opcion) {
        switch (opcion) {
            case 1: return "MXN";
            case 2: return "ARS";
            case 3: return "CLP";
            case 4: return "EUR";
            case 5: return "USD";
            case 6: return "CAD";
            case 7: return "JPY";
            default: return "Desconocido";
        }
    }
}
