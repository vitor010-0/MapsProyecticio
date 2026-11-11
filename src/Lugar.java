
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author jacqu
 */
public class Lugar implements Comparable<Lugar>{
    private String nombre;
    private List<Arista> cercanos;
    private Lugar previo;
    private double distanciaMinima = Double.POSITIVE_INFINITY;

    public Lugar(String nombre) {
        this.nombre = nombre;
    }
    
    public void addArista(Arista arista){
        this.cercanos.add(arista);
    }

    public String getNombre() {
        return nombre;
    }

    public List<Arista> getCercanos() {
        return cercanos;
    }

    public Lugar getPrevio() {
        return previo;
    }

    public double getDistanciaMinima() {
        return distanciaMinima;
    }
    

    public void setPrevio(Lugar previo) {
        this.previo = previo;
    }

    @Override
    public String toString() {
        return this.nombre;
    }
    
    @Override
    public int compareTo(Lugar comparado){
        return Double.compare(this.distanciaMinima, comparado.distanciaMinima);
    }

    public void setDistanciaMinima(double distanciaMinima) {
        this.distanciaMinima = distanciaMinima;
    }
}
