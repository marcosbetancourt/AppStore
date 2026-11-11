package arreglos.tienda.interfaz;

import java.util.Scanner;

public class Validacion {
    private static Scanner sc = new Scanner(System.in);

    public String leerString(String mensaje) {
        String texto;
        do {
            System.out.print(mensaje + ": ");
            texto = sc.nextLine();
        } while (texto == null || texto.trim().isEmpty());
        return texto;
    }

    // ==========================================
    // VALIDACIONES PARA ENTEROS (int)
    // ==========================================
    public int leerEnteroPositivo(String mensaje) {
        int num = -1;
        do {
            try {
                System.out.print(mensaje + " (Positivo): ");
                num = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingrese un número entero válido.");
            }
        } while (num <= 0);
        return num;
    }

    public int leerEnteroMayorQue(String mensaje, int limite) {
        int num = limite - 1;
        do {
            try {
                System.out.print(mensaje + " (Mayor a " + limite + "): ");
                num = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingrese un número entero válido.");
            }
        } while (num <= limite);
        return num;
    }

    public int leerEnteroMenorQue(String mensaje, int limite) {
        int num = limite + 1;
        do {
            try {
                System.out.print(mensaje + " (Menor a " + limite + "): ");
                num = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingrese un número entero válido.");
            }
        } while (num >= limite);
        return num;
    }

    public int leerEnteroEntre(String mensaje, int min, int max) {
        int num = min - 1;
        do {
            try {
                System.out.print(mensaje + " (Entre " + min + " y " + max + "): ");
                num = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingrese un número entero válido.");
            }
        } while (num < min || num > max);
        return num;
    }

    // ==========================================
    // VALIDACIONES PARA FLOTANTES (double)
    // ==========================================
    public double leerFlotantePositivo(String mensaje) {
        double num = -1;
        do {
            try {
                System.out.print(mensaje + " (Positivo): ");
                num = Double.parseDouble(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingrese un número decimal válido.");
            }
        } while (num <= 0);
        return num;
    }

    public double leerFlotanteMayorQue(String mensaje, double limite) {
        double num = limite - 1;
        do {
            try {
                System.out.print(mensaje + " (Mayor a " + limite + "): ");
                num = Double.parseDouble(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingrese un número decimal válido.");
            }
        } while (num <= limite);
        return num;
    }

    public double leerFlotanteMenorQue(String mensaje, double limite) {
        double num = limite + 1;
        do {
            try {
                System.out.print(mensaje + " (Menor a " + limite + "): ");
                num = Double.parseDouble(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingrese un número decimal válido.");
            }
        } while (num >= limite);
        return num;
    }

    public double leerFlotanteEntre(String mensaje, double min, double max) {
        double num = min - 1;
        do {
            try {
                System.out.print(mensaje + " (Entre " + min + " y " + max + "): ");
                num = Double.parseDouble(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingrese un número decimal válido.");
            }
        } while (num < min || num > max);
        return num;
    }
}