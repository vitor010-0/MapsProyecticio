

public class Main {
    
    public static void main(String[] args) {
        Library.fill();
        crearMapaHardcodeado();
        HelouScreen hs = new HelouScreen();
        hs.setVisible(true);
    }
    
    public static void crearMapaHardcodeado(){
        Grafo bee = new Grafo();
        for (String place : Library.places) bee.agregarNodo(place);
    }
}
