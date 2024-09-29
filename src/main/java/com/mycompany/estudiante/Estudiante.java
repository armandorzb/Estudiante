/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.estudiante;

import java.util.Scanner;

public class Estudiante {
    private String nombre;
    private int[] calificaciones;

    // Constructor
    public Estudiante(String nombre, int[] calificaciones) {
        this.nombre = nombre;
        this.calificaciones = calificaciones;
    }

    // Método para calcular el promedio
    public double calcularPromedio() {
        int suma = 0;
        for (int calificacion : calificaciones) {
            suma += calificacion;
        }
        return (double) suma / calificaciones.length;
    }

    // Método para obtener la calificación final
    public char obtenerCalificacionFinal(double promedio) {
        if (promedio <= 5) {
            return 'F';
        } else if (promedio <= 6) {
            return 'E';
        } else if (promedio <= 7) {
            return 'D';
        } else if (promedio <= 8) {
            return 'C';
        } else if (promedio <= 9) {
            return 'B';
        } else {
            return 'A';
        }
    }

    // Método para imprimir los resultados
    public void imprimirResultados() {
        double promedio = calcularPromedio();
        char calificacionFinal = obtenerCalificacionFinal(promedio);

        System.out.println("Nombre del estudiante: " + nombre);
        for (int i = 0; i < calificaciones.length; i++) {
            System.out.println("Calificación " + (i + 1) + ": " + calificaciones[i]);
        }
        System.out.println("Promedio: " + promedio);
        System.out.println("Calificación: " + calificacionFinal);
        System.out.println("-----------------------------------");
    }

    // Método principal para ejecutar el programa
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Arreglo para almacenar 5 estudiantes
        Estudiante[] estudiantes = new Estudiante[5];

        // Recolección de datos para 5 estudiantes
        for (int i = 0; i < estudiantes.length; i++) {
            System.out.println("Introduce el nombre del estudiante " + (i + 1) + ": ");
            String nombre = scanner.nextLine();

            int[] calificaciones = new int[5];
            for (int j = 0; j < calificaciones.length; j++) {
                System.out.println("Introduce la calificación " + (j + 1) + " para " + nombre + " (1-10): ");
                calificaciones[j] = scanner.nextInt();
                while (calificaciones[j] < 1 || calificaciones[j] > 10) {
                    System.out.println("Calificación inválida. Introduce una calificación entre 1 y 10.");
                    calificaciones[j] = scanner.nextInt();
                }
            }
            scanner.nextLine(); // Limpiar el buffer

            // Crear un objeto Estudiante y agregarlo al arreglo
            estudiantes[i] = new Estudiante(nombre, calificaciones);
        }

        // Imprimir resultados para todos los estudiantes
        for (Estudiante estudiante : estudiantes) {
            estudiante.imprimirResultados();
        }

        scanner.close();
    }
}


