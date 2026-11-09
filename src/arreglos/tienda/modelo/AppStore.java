package arreglos.tienda.modelo;

public class AppStore {
    private static final int MAX = 4;
    private Juego juegos[];
    private int indice;

    public AppStore(){
        juegos = new Juego[4];
        indice = -1;
        cargarDatos();
    }
    private void cargarDatos(){
        juegos[++indice] = new Juego("Fifa26",  "Deportes",  15,  45,  50);
        juegos[++indice] = new Juego("Roblox", "Acción", 23, 59, 50);
    }

    public Juego[] getJuegos() {
        return juegos;
    }

    public void agregarJuego(Juego j){
        if (j != null && indice < MAX -1) {
            juegos[++indice] = j;
        }
    }
    public Juego buscarJuego(String nombre){
        for (int i = 0; i <= indice; i++){
            if (juegos[i].getNombre().equalsIgnoreCase(nombre)){
                return juegos[i];
            }
        }
        return null;
    }

    public double comprar(String nombre, int cantidad){
        Juego j1 = buscarJuego(nombre);
        if(j1 != null){
            if(j1.comprar(cantidad)){
                return cantidad * j1.getPrecio();
            }
        }
        return 0;
    }
    public String sacarJuegos(){
        String juegoS = "";
        for (int i = 0; i < indice; i++){
            juegoS += juegos[i];
            juegoS += "?\n";
        }
        return !juegoS.trim().isBlank()?juegoS:"No hay juegos a mostrar";
    }
}
