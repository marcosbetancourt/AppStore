package arreglos.tienda.interfaz;

import arreglos.tienda.modelo.AppStore;
import arreglos.tienda.modelo.Juego;

public class MainTienda {
    public static void main() {


        System.out.println("=== PRUEBA INICIAL DE LA PROFE ===");
        Juego j1 = new Juego("Fifa26", "Deportes", 15, 45, 50);
        System.out.println(j1);
        System.out.println("--------------------------------------------------\n");


        AppStore miTienda = new AppStore();

        System.out.println("=== INVENTARIO INICIAL ===");
        System.out.println(miTienda.sacarJuegos());


        Juego j3 = new Juego("Minecraft", "Aventura", 10, 29.99, 100);
        Juego j4 = new Juego("Call of Duty", "Acción", 50, 60.00, 30);

        miTienda.agregarJuego(j3);
        miTienda.agregarJuego(j4);

        System.out.println("=== INVENTARIO DESPUÉS DE AGREGAR JUEGOS ===");
        System.out.println(miTienda.sacarJuegos());


        System.out.println("=== BUSCANDO JUEGO ===");
        String nombreBuscado = "Roblox";
        Juego encontrado = miTienda.buscarJuego(nombreBuscado);

        if (encontrado != null) {
            System.out.println("Juego encontrado con éxito: " + encontrado.getNombre());

            // Probamos vender licencias
            System.out.println("Vendiendo 5 licencias de " + encontrado.getNombre() + "...");
            boolean ventaExitosa = encontrado.vender(5);
            if (ventaExitosa) {
                System.out.println("Venta realizada. Licencias restantes: " + encontrado.getLicenciasDisponibles());
            } else {
                System.out.println("Error: No hay suficientes licencias.");
            }
        } else {
            System.out.println("El juego '" + nombreBuscado + "' no existe en la tienda.");
        }


        System.out.println("\n=== COMPRANDO STOCK ===");
        double costo = miTienda.comprar("Fifa26", 20);
        if (costo > 0) {
            System.out.println("Se compró nuevo stock de Fifa26. Costo total de la inversión: $" + costo);
        }


        System.out.println("\n=== ESTADO FINAL DE LA TIENDA ===");
        System.out.println(miTienda.sacarJuegos());
    }
}