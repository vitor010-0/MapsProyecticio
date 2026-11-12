
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;


public class Grafo {
    
    public static List<Place> mapeameLaExistencia(Place from, Place to){
        if (from == null || to == null) return Collections.emptyList(); //Removible
        
        for (Place place : Place.values()){ //inicializar los cosos en limpio
            place.minDist = Double.POSITIVE_INFINITY;
            place.previo = null;
        }
        
        from.minDist = 0;
        PriorityQueue<Place> cocacola = new PriorityQueue<>(java.util.Comparator.comparingDouble(p -> p.minDist));
        cocacola.add(from);
        List<Place> vistos = new ArrayList<>();
        while (!cocacola.isEmpty()){
            Place actual = cocacola.poll();
            if (actual.equals(to)) break;
            if (vistos.contains(actual)) continue;
            vistos.add(actual);
            for (Linea line : actual.lines){
                Place cercano = line.from.equals(actual) ? line.to : line.from;
                if (vistos.contains(cercano)) continue;
                double otraDistancia = actual.minDist + line.length;
                if (otraDistancia < cercano.minDist){
                    cercano.minDist = otraDistancia;
                    cercano.previo = actual;
                    cocacola.add(cercano);
                }
            }
        }
        
        List<Place> ruta = new ArrayList<>();
        Place aux = to;
        while (aux != null){
            ruta.add(aux);
            aux = aux.previo;
        }
        Collections.reverse(ruta);
        if (ruta.isEmpty() || !ruta.get(0).equals(from)) return Collections.emptyList();
        return ruta;
    }
}
