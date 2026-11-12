

public class Main {
    
    public static void main(String[] args) {
        Library.fill(); //Dinamicamente
        HelouScreen hs = new HelouScreen();
        hs.setVisible(true);
        System.out.println(Place.fondita.nearPlaces);
        System.out.println(Place.fondita.lines);
        Grafo bee = new Grafo();
        System.out.println(bee.mapeameLaExistencia(Place.bib, Place.park));
    }
}
