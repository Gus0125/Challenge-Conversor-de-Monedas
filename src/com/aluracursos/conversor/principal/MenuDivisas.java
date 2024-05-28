package com.aluracursos.conversor.principal;

import com.aluracursos.conversor.modelos.DivisasExchange;

import java.text.DecimalFormat;
import java.util.Scanner;

public class MenuDivisas {
    public static void mostrarMenuDivisas(String divisa, double cantidad) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        while (true) {
            System.out.println("***********************************************************");
            System.out.println("Cantidad a convertir: " + formatearCantidad(cantidad) + " " + divisa);
            System.out.print("Seleccione a qué divisa convertir: \n");
            System.out.println("1. Peso Mexicano");
            System.out.println("2. Peso Argentino");
            System.out.println("3. Peso Chileno");
            System.out.println("4. Euro");
            System.out.println("5. Dólar Estadounidense");
            System.out.println("6. Dólar Canadiense");
            System.out.println("7. Yen Japonés");
            System.out.println("8. Regresar");
            System.out.println("***********************************************************");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    convertirDivisa("MXN", divisa, cantidad);
                    break;
                case 2:
                    convertirDivisa("ARS", divisa, cantidad);
                    break;
                case 3:
                    convertirDivisa("CLP", divisa, cantidad);
                    break;
                case 4:
                    convertirDivisa("EUR", divisa, cantidad);
                    break;
                case 5:
                    convertirDivisa("USD", divisa, cantidad);
                    break;
                case 6:
                    convertirDivisa("CAD", divisa, cantidad);
                    break;
                case 7:
                    convertirDivisa("JPY", divisa, cantidad);
                    break;
                case 8:
                    System.out.println("Regresando al menú principal...");
                    return;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción del 1 al 8.");
            }
        }
    }

    private static void convertirDivisa(String divisaDestino, String divisaOrigen, double cantidad) {
        // Hacer la solicitud a la API para obtener la tasa de conversión
        DivisasExchange divisasExchange = Api.obtenerConversionRates(divisaOrigen, divisaDestino, cantidad);
        if (divisasExchange != null) {
            double cantidadConvertida = divisasExchange.conversionResult();
            System.out.println("La conversión de: " + cantidad + " " + divisaOrigen + " a " + divisaDestino + " es de: " + formatearCantidad(cantidadConvertida));
        } else {
            System.out.println("No se pudo obtener la tasa de conversión para " + divisaDestino);
        }
    }


    private static String formatearCantidad(double cantidad) {
        DecimalFormat df = new DecimalFormat("#.##");
        return df.format(cantidad);
    }
}
