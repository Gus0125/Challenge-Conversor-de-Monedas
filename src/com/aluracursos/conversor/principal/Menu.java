package com.aluracursos.conversor.principal;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int opcion;

        while (true) {
            mostrarMenu();
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Ha seleccionado la Opción 1.");
                    break;
                case 2:
                    System.out.println("Ha seleccionado la Opción 2.");
                    break;
                case 3:
                    System.out.println("Ha seleccionado la Opción 3.");
                    break;
                case 4:
                    System.out.println("Ha seleccionado la Opción 4.");
                    break;
                case 5:
                    System.out.println("Ha seleccionado la Opción 5.");
                    break;
                case 6:
                    System.out.println("Ha seleccionado la Opción 6.");
                    break;
                case 7:
                    System.out.println("Ha seleccionado la Opción 7.");
                    break;
                case 8:
                    System.out.println("Saliendo del programa...");
                    return;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción del 1 al 8.");
            }
        }
    }

    public static void mostrarMenu() {
        System.out.println("Bienvenido al menú:");
        System.out.println("1. Opción 1");
        System.out.println("2. Opción 2");
        System.out.println("3. Opción 3");
        System.out.println("4. Opción 4");
        System.out.println("5. Opción 5");
        System.out.println("6. Opción 6");
        System.out.println("7. Opción 7");
        System.out.println("8. Salir");
        System.out.print("Seleccione una opción: ");
    }
}

