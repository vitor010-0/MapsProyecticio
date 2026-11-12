
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
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
    private Library.Place from;
    private Library.Place to;
    public int length;
    
    public Linea(Library.Place from, Library.Place to, int length){
        this.from = from;
        this.to = to;
        this.length = length;
        setOpaque(false);
    }
    
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        int[] c1 = new int[]{from.x + 7, from.y + 7}; //o 8 creo podria haber quedado mejor 
        int[] c2 = new int[]{to.x + 7, to.y + 7};
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
}
