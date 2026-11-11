package arreglos.tienda.interfaz;

import arreglos.tienda.modelo.AppStore;
import arreglos.tienda.modelo.Juego;

import java.util.Scanner;

public class MainTienda {
    private static Scanner sc = new Scanner(System.in);
    private static AppStore tienda = new AppStore();
    // Instanciamos la validación para poder usarla en los cases
    private static Validacion val = new Validacion();

    public static void main(String[] args) {
        int opc;
        do {
            menu();
            // Aprovechamos la validación para asegurar que digite del 1 al 7
            opc = val.leerEnteroEntre("Ingrese una opcion", 1, 7);

            switch (opc) {
                case 1: {
                    System.out.println("\n--- INGRESAR NUEVO JUEGO ---");
                    String nombre = val.leerString("Nombre del juego");
                    String categoria = val.leerString("Categoría");
                    int tamanio = val.leerEnteroPositivo("Tamaño en MB");
                    double precio = val.leerFlotantePositivo("Precio en $");
                    int licencias = val.leerEnteroPositivo("Licencias iniciales");

                    Juego nuevo = new Juego(nombre, categoria, tamanio, precio, licencias);
                    tienda.agregarJuego(nuevo);
                    System.out.println("Juego registrado correctamente.");
                } break;

                case 2: {
                    System.out.println("\n--- LISTA DE JUEGOS ---");
                    System.out.println(tienda.sacarJuegos());
                } break;

                case 3: {
                    System.out.println("\n--- BUSCAR JUEGO ---");
                    String nombre = val.leerString("Nombre del juego a buscar");
                    Juego j = tienda.buscarJuego(nombre);
                    if(j != null) {
                        System.out.println("Encontrado: " + j.toString());
                    } else {
                        System.out.println("El juego no existe en la tienda.");
                    }
                } break;

                case 4: {
                    System.out.println("\n--- COMPRAR STOCK ---");
                    String nombre = val.leerString("Nombre del juego");
                    int cantidad = val.leerEnteroPositivo("Cantidad de licencias a añadir");
                    boolean ok = tienda.comprar(nombre, cantidad);
                    if(ok) {
                        System.out.println("Stock actualizado correctamente.");
                    } else {
                        System.out.println("Error: Juego no encontrado.");
                    }
                } break;

                case 5: {
                    System.out.println("\n--- VENDER JUEGO ---");
                    String nombre = val.leerString("Nombre del juego");
                    int cantidad = val.leerEnteroPositivo("Cantidad de licencias a vender");
                    double total = tienda.vender(nombre, cantidad);
                    if(total > 0) {
                        System.out.println("Venta exitosa. Total a cobrar: $" + total);
                    } else {
                        System.out.println("Error: Juego no encontrado o licencias insuficientes.");
                    }
                } break;

                case 6: {
                    System.out.println("\n--- ESTADÍSTICAS ---");
                    String masVendido = tienda.juegoMasVendido();
                    if(masVendido != null && !masVendido.isEmpty()) {
                        System.out.println("El juego más vendido es: " + masVendido);
                    } else {
                        System.out.println("Aún no hay ventas registradas.");
                    }
                } break;

                case 7: {
                    System.out.println("\nSaliendo del sistema...");
                    System.out.println("Gracias por usar nuestros servicios.");
                } break;
            }
        } while(opc != 7);
    }

    public static void menu() {
        System.out.println("\n**********AppStore Udla**********");
        System.out.println("1. Ingresar Juego");
        System.out.println("2. Mostrar juegos");
        System.out.println("3. Buscar juego");
        System.out.println("4. Comprar");
        System.out.println("5. Vender");
        System.out.println("6. Juego más vendido");
        System.out.println("7. Salir");
    }
}