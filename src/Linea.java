
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.util.Objects;
import javax.swing.JComponent;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author jacqu
 */
public class Linea extends JComponent{
    public Place from;
    public Place to;
    public int length;
    
    public Linea(Place from, Place to, int length){
        this.from = from;
        this.to = to;
        this.length = length;
        setOpaque(false);
        setToolTipText(length + "m");
        setBounds(Math.min(from.x, to.x), Math.min(from.y, to.y), Math.abs(from.x - to.x), Math.abs(from.y - to.y));
    }
    
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        int[] c1 = new int[]{from.x + 7 - getX(), from.y + 7 - getY()}; //o 8 creo podria haber quedado mejor 
        int[] c2 = new int[]{to.x + 7 - getX(), to.y + 7 - getY()};
        if (c1 == null || c2 == null) return;
        
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        g2.setColor(new Color(180, 120, 0));
        g2.setStroke(new BasicStroke(6.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        g2.drawLine(c1[0], c1[1], c2[0], c2[1]);
        
        g2.setColor(new Color(255, 204, 0));
        g2.setStroke(new BasicStroke(3.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        g2.drawLine(c1[0], c1[1], c2[0], c2[1]);
        
        g2.dispose();
    }
    
    @Override
    public Point getToolTipLocation(java.awt.event.MouseEvent event){
        return new Point(event.getX(), event.getY() - 30);
    }
    
    @Override
    public String toString(){
        return from + " -> " + to;
    }
    
    @Override
    public boolean contains(int x, int y){
        double x1 = (from.x + 7) - getX();
        double y1 = (from.y + 7) - getY();
        double x2 = (to.x + 7) - getX();
        double y2 = (to.y + 7) - getY();
        double distance = java.awt.geom.Line2D.ptSegDist(x1, y1, x2, y2, x, y);
        return distance <= 6.0;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.from);
        hash = 23 * hash + Objects.hashCode(this.to);
        hash = 23 * hash + this.length;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Linea other = (Linea) obj;
        if (this.length != other.length) {
            return false;
        }
        if (this.from != other.from) {
            return false;
        }
        return this.to == other.to;
    }
    
    
}
