package org.example;
import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        String nombre = sc.nextLine();   // leer una línea de texto
        int fechaIngreso = sc.nextInt();       // leer un número entero
        float fechaSalida = sc.nextFloat();  // leer un número decimal

        System.out.println("Registre la cantidad de dias que se quedo el paciente:");

        System.out.println("Registre el costo");

        if (costoDia < 0) {
            System.out.println("Ingresa un precio valido:");

        }
        if (diasEstancia < 0) {
            System.out.println("Ingresa un dia valido:");

        } else {
            System.out.println(costoDia * diasEstancia);


        }



        }
    }
