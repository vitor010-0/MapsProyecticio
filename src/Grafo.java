
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;


public class Grafo {
    private Map<String, Lugar> nodos = new HashMap<>();
    public void agregarNodo(String nombre){
        nodos.put(nombre, new Lugar(nombre));
    }
    
    public void agregarRuta(String from, String to, double distancia){
        Lugar origen = nodos.get(from);
        Lugar destino = nodos.get(to);
        if (origen != null && destino != null){
            origen.addArista(new Arista(destino, distancia));
            destino.addArista(new Arista(origen, distancia));
        }
    }
    
    public List<Lugar> mapeameLaExistencia(String from, String to){
        Lugar origen = nodos.get(from);
        Lugar destino = nodos.get(to);
        if (origen == null || destino == null) return Collections.emptyList();
        
        for (Lugar nodo : nodos.values()){ //inicializar los cosos en limpio
            nodo.setDistanciaMinima(Double.POSITIVE_INFINITY);
            nodo.setPrevio(null);
        }
        
        origen.setDistanciaMinima(0);
        PriorityQueue<Lugar> cocacola = new PriorityQueue<>();
        cocacola.add(origen);
        List<Lugar> vistos = new ArrayList<>();
        while (!cocacola.isEmpty()){
            Lugar actual = cocacola.poll();
            if (actual.equals(destino)) break;
            if (vistos.contains(actual)) continue;
            vistos.add(actual);
            for (Arista arista : actual.getCercanos()){
                Lugar cercano = arista.getDestino();
                if (!vistos.contains(cercano));
                double otraDistancia = actual.getDistanciaMinima() + arista.getDistancia();
                if (otraDistancia < cercano.getDistanciaMinima()){
                    cercano.setDistanciaMinima(otraDistancia);
                    cercano.setPrevio(actual);
                    cocacola.add(cercano);
                }
            }
        }
        
        List<Lugar> ruta = new ArrayList<>();
        Lugar aux = destino;
        while (aux != null){
            ruta.add(aux);
            aux = aux.getPrevio();
        }
        Collections.reverse(ruta);
        if (ruta.isEmpty() || !ruta.get(0).equals(origen)) return Collections.emptyList();
        return ruta;
    }
}
