package com.alurachallenge.conversor;

import com.alurachallenge.conversor.modelos.Divisas;
import com.alurachallenge.conversor.modelos.consultaApi;

import java.io.IOException;
import java.util.Scanner;

public class ConversorDeMonedas {

    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner scanner = new Scanner(System.in);
        consultaApi consultaTasa = new consultaApi();

        int opcionIngresado = 0;
        double montoIngresado = 0.00;



        do{
            System.out.println("**************************************\n");
            System.out.println("Bienvenido al conversor de monedas\n");
            System.out.println("**************************************\n");
            System.out.println("1) Dólar => Peso argentino");
            System.out.println("2) Peso argentino => Dólar");
            System.out.println("3) Dólar => Real brasileño");
            System.out.println("4) Real brasileño => Dólar");
            System.out.println("5) Dólar => Peso colombiano");
            System.out.println("6) Peso colombiano => Dólar\n");
            System.out.println("7) Salir\n");
            System.out.println("Elija una opcion valida: ");
            int opcion = scanner.nextInt();
            System.out.println("***************************************");


            opcionIngresado = opcion;

            if (opcionIngresado >= 1 && opcionIngresado <= 6){
                System.out.println("Por Favor ingrese el monto a convertir");
                int montoDeseado = scanner.nextInt();
                montoIngresado = montoDeseado;
            }

            switch (opcion){
                case 1:

                    consultaTasa.buscadorDeMoneda(Divisas.USD, Divisas.ARS, Divisas.ARS, montoIngresado);
                    break;
                case 2:
                    consultaTasa.buscadorDeMoneda(Divisas.ARS, Divisas.USD, Divisas.ARS, montoIngresado);

                    break;
                case 3:
                    consultaTasa.buscadorDeMoneda(Divisas.USD, Divisas.BRL, Divisas.BRL , montoIngresado);
                    break;
                case 4:
                    consultaTasa.buscadorDeMoneda(Divisas.BRL, Divisas.USD, Divisas.BRL , montoIngresado);
                    break;
                case 5:
                    consultaTasa.buscadorDeMoneda(Divisas.USD, Divisas.COP, Divisas.COP , montoIngresado);
                    break;
                case 6:
                    consultaTasa.buscadorDeMoneda(Divisas.COP, Divisas.USD, Divisas.COP , montoIngresado);
                    break;
                case 7:
                    System.out.println("Gracias por usar Conversor");
                    break;
                default:
                    System.out.println("Opción no valida intente de nuevo");
            }

        }while(opcionIngresado != 7);
    }

}
