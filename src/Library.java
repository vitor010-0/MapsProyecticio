
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashSet;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author jacqu
 */
public class Library {

    public static ArrayList<Linea> lines = new ArrayList<>();

    public static void fill() {
    lines.clear();
    setLines();
    setNearThingies();
}

    public static void setLines() {
        lines.add(new Linea(Place.fondita, Place.vigMain, 58)); //son metros
        lines.add(new Linea(Place.b, Place.vigMain, 118));
        lines.add(new Linea(Place.a, Place.vigMain, 96));
        lines.add(new Linea(Place.vigPark, Place.vigMain, 68));
        lines.add(new Linea(Place.bib, Place.vigMain, 50));
        lines.add(new Linea(Place.palaponchas, Place.vigMain, 50));
        lines.add(new Linea(Place.park, Place.vigPark, 28));
        lines.add(new Linea(Place.b, Place.vigPark, 96));
        lines.add(new Linea(Place.b, Place.park, 72));
        lines.add(new Linea(Place.a, Place.b, 61));
        lines.add(new Linea(Place.fucho, Place.b, 91));
        lines.add(new Linea(Place.tics, Place.b, 51));
        lines.add(new Linea(Place.cope, Place.b, 91));
        lines.add(new Linea(Place.e, Place.b, 89));
        lines.add(new Linea(Place.park, Place.fucho, 123));
        lines.add(new Linea(Place.tics, Place.fucho, 93)); //asumiendo que la puerta de atras si abre
        lines.add(new Linea(Place.cope, Place.fucho, 137));
        lines.add(new Linea(Place.cope, Place.tics, 47));
        lines.add(new Linea(Place.e, Place.tics, 65));
        lines.add(new Linea(Place.cope, Place.e, 40));
        lines.add(new Linea(Place.cope, Place.a, 87));
        lines.add(new Linea(Place.basket, Place.e, 46));
        lines.add(new Linea(Place.a, Place.e, 66));
        lines.add(new Linea(Place.palaponchas, Place.e, 62));
        lines.add(new Linea(Place.audMain, Place.e, 90));
        lines.add(new Linea(Place.vinc, Place.bib, 66));
        lines.add(new Linea(Place.direc, Place.bib, 72));
        lines.add(new Linea(Place.vinc, Place.palaponchas, 41)); //asumiendo que se vuelan la ventana
        lines.add(new Linea(Place.bib, Place.palaponchas, 40));
        lines.add(new Linea(Place.direc, Place.vinc, 19));
        lines.add(new Linea(Place.gastroKitchen, Place.vinc, 17));
        lines.add(new Linea(Place.gastroRelajadera, Place.vinc, 36));
        lines.add(new Linea(Place.audMain, Place.vinc, 84));
        lines.add(new Linea(Place.audMain, Place.palaponchas, 115));
        lines.add(new Linea(Place.a, Place.palaponchas, 36));
        lines.add(new Linea(Place.audMain, Place.basket, 30));
        lines.add(new Linea(Place.audMain, Place.gastroRelajadera, 58));
        lines.add(new Linea(Place.audVinc, Place.gastroKitchen, 18));
        lines.add(new Linea(Place.audVinc, Place.direc, 13));
        lines.add(new Linea(Place.audVinc, Place.gastroRelajadera, 52)); //Pasando por afuera
        lines.add(new Linea(Place.vigPark, Place.fondita, 120)); //Con curvitas y todo
        lines.add(new Linea(Place.tics, Place.a, 80));
        lines.add(new Linea(Place.e, Place.vinc, 80)); //Ventanaaaaaaaaaaaa por la 
        lines.add(new Linea(Place.a, Place.vigPark, 60));
        lines.add(new Linea(Place.a, Place.audMain, 108));
        lines.add(new Linea(Place.cope, Place.basket, 68));
    }

    public static void setNearThingies() {
        ArrayList<Place> list;
        for (Place p : Place.values()) {
            p.nearPlaces = EnumSet.noneOf(Place.class);
            p.lines = new HashSet<>();
            for (Linea line : lines) {
                if (line.from.name.equals(p.name)) {
                    p.lines.add(line);
                    p.nearPlaces.add(line.to);
                } else if (line.to.name.equals(p.name)) {
                    p.lines.add(line);
                    p.nearPlaces.add(line.from);
                }
            }
        }

    }
}
