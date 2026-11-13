import java.util.*;

public class Grafo {
    public static List<Place> mapeameLaExistencia(Place from, Place to) {
        if (from == null || to == null) return Collections.emptyList();

        for (Place p : Place.values()) {
            p.minDist = Double.POSITIVE_INFINITY;
            p.previo = null;
        }

        PriorityQueue<Place> pendientes =
            new PriorityQueue<>(Comparator.comparingDouble(p -> p.minDist));
        Set<Place> visitados = new HashSet<>();
        from.minDist = 0;
        pendientes.add(from);

        while (!pendientes.isEmpty()) {
            Place actual = pendientes.poll();
            if (!visitados.add(actual)) continue;
            if (actual == to) break;

            for (Linea arista : actual.lines) {
                Place vecino = arista.from == actual ? arista.to : arista.from;
                if (visitados.contains(vecino)) continue;

                double nuevaDistancia = actual.minDist + arista.length;
                if (nuevaDistancia < vecino.minDist) {
                    vecino.minDist = nuevaDistancia;
                    vecino.previo = actual;
                    pendientes.add(vecino);
                }
            }
        }

        if (Double.isInfinite(to.minDist)) return Collections.emptyList();

        LinkedList<Place> ruta = new LinkedList<>();
        for (Place actual = to; actual != null; actual = actual.previo) {
            ruta.addFirst(actual);
        }
        return ruta;
    }

    public static int obtenerDistancia(List<Place> ruta) {
        if (ruta == null || ruta.size() < 2) return 0;
        int total = 0;
        for (int i = 0; i < ruta.size() - 1; i++) {
            Place a = ruta.get(i);
            Place b = ruta.get(i + 1);
            boolean encontrada = false;
            for (Linea l : a.lines) {
                if ((l.from == a && l.to == b) || (l.from == b && l.to == a)) {
                    total += l.length;
                    encontrada = true;
                    break;
                }
            }
            if (!encontrada) return -1;
        }
        return total;
    }
}
