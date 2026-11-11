
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author jacqu
 */
public class Library {

    public static ArrayList<String> places = new ArrayList<>();
    public static ArrayList<int[]> btnCoords = new ArrayList<>();

    public static void fill() {
        places.add("Biblioteca"); btnCoords.add(new int[]{306, 215});
        places.add("Cafeteria"); btnCoords.add(new int[]{285, 420});
        places.add("Direccion"); btnCoords.add(new int[]{184, 251});
        places.add("Edificio A"); btnCoords.add(new int[]{320, 310});
        places.add("Edificio B"); btnCoords.add(new int[]{424, 343});
        places.add("Edificio E"); btnCoords.add(new int[]{254, 375});
        places.add("Edificio de Vinculacion"); btnCoords.add(new int[]{209, 268});
        places.add("Palapas"); btnCoords.add(new int[]{286, 268});
        places.add("Edificio de TICS"); btnCoords.add(new int[]{369, 403});
        places.add("Cancha de Futbol"); btnCoords.add(new int[]{530, 422});
        places.add("Canchas de basketball"); btnCoords.add(new int[]{172, 403});
        places.add("Estacionamiento"); btnCoords.add(new int[]{506, 276});
        places.add("Auditorio de vinculacion"); btnCoords.add(new int[]{166, 237});
        places.add("Auditorio principal"); btnCoords.add(new int[]{142, 368});
        places.add("Caseta de vigilancia del estacionamiento"); btnCoords.add(new int[]{497, 237});
        places.add("Caseta de vigilancia de la puerta principal"); btnCoords.add(new int[]{378, 205});
        places.add("Cocinas de Gastronomia"); btnCoords.add(new int[]{171, 263});
        places.add("Cabaña de Gastronomia"); btnCoords.add(new int[]{148, 293});
        places.add("Fondita"); btnCoords.add(new int[]{457, 141});
    }
}
