
import java.util.Set;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */

/**
 *
 * @author vic
 */
public enum Place {
        bib("Biblioteca", 306, 215),
        cope("Cafeteria", 285, 420),
        direc("Direccion", 184, 251),
        a("Edificio A", 320, 310),
        b("Edificio B", 424, 343),
        e("Edificio E", 254, 375),
        vinc("Edificio de Vinculacion", 209, 268),
        palaponchas("Palapas", 286, 268),
        tics("Edificio de TICS", 369, 403),
        fucho("Cancha de Futbol", 530, 422),
        basket("Canchas de Basketball", 172, 403),
        park("Estacionamiento", 506, 276),
        audVinc("Auditorio de vinculacion", 166, 237),
        audMain("Auditorio principal", 142, 368),
        vigPark("Caseta de vigilancia del estacionamiento", 497, 237),
        vigMain("Caseta de vigilancia de la puerta principal", 378, 205),
        gastroKitchen("Cocinas de Gastronomia", 171, 263),
        gastroRelajadera("Cabaña de Gastronomia", 148, 293),
        fondita("Fondita", 457, 141);

        public final String name;
        public final int x;
        public final int y;
        public Place previo; //aux de Grafo
        public Set<Place> nearPlaces;
        public Set<Linea> lines;
        public double minDist = Double.POSITIVE_INFINITY;

        Place(String name, int x, int y) {
            this.name = name;
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return this.name;
        }
    }
