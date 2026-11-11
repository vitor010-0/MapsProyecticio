/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author jacqu
 */
public class Arista {
    private Lugar destino;
    private double distancia;

    public Arista(Lugar destino, double distancia) {
        this.destino = destino;
        this.distancia = distancia;
    }

    public Lugar getDestino() {
        return destino;
    }

    public double getDistancia() {
        return distancia;
    }
}
