

public class Main {
    
    public static void main(String[] args) {
        crearMapaHardcodeado();
        HelouScreen hs = new HelouScreen();
        hs.setVisible(true);
    }
    
    public static void crearMapaHardcodeado(){
        Grafo bee = new Grafo();
        for (Library.Place place : Library.Place.values()) bee.agregarNodo(place.toString());
    }
}
