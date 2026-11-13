
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.util.Objects;
import javax.swing.JComponent;

public class Linea extends JComponent {

    public Place from;
    public Place to;
    public int length;
    public boolean marked;
    public Color routeColor = null;
    public Color colorRuta = Color.BLUE;

    public Linea(Place from, Place to, int length, boolean marked) {
    this.from = from;
    this.to = to;
    this.length = length;
    this.marked = marked;

    setOpaque(false);
    setToolTipText(length + " m");
}

public Linea(Place from, Place to, int length) {
    this(from, to, length, false);
}

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g.create();

        g2.setRenderingHint(
            RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON
        );

        int x1 = from.x + 7 - getX();
        int y1 = from.y + 7 - getY();

        int x2 = to.x + 7 - getX();
        int y2 = to.y + 7 - getY();

       if (marked) {

            g2.setColor(new Color(
                colorRuta.getRed(),
                colorRuta.getGreen(),
                colorRuta.getBlue(),
                70
            ));
            g2.setStroke(new BasicStroke(10f));
            g2.drawLine(x1, y1, x2, y2);

            g2.setColor(colorRuta);
            g2.setStroke(new BasicStroke(5f));
            g2.drawLine(x1, y1, x2, y2);

            g2.setColor(Color.WHITE);
            g2.setStroke(new BasicStroke(1.5f));
            g2.drawLine(x1, y1, x2, y2);

        } else {
            g2.setColor(new Color(8, 43, 104));
            g2.setStroke(new BasicStroke(5f));
            g2.drawLine(x1, y1, x2, y2);

            g2.setColor(new Color(169, 217, 255));
            g2.setStroke(new BasicStroke(2f));
            g2.drawLine(x1, y1, x2, y2);
        }

                g2.dispose();
            }

    @Override
    public Point getToolTipLocation(
        java.awt.event.MouseEvent event
    ) {
        return new Point(event.getX(), event.getY() - 30);
    }

    @Override
    public String toString() {
        return from + " -> " + to;
    }

    @Override
    public boolean contains(int x, int y) {

        double x1 = (from.x + 7) - getX();
        double y1 = (from.y + 7) - getY();

        double x2 = (to.x + 7) - getX();
        double y2 = (to.y + 7) - getY();

        double distance = java.awt.geom.Line2D.ptSegDist(
            x1, y1, x2, y2, x, y
        );

        return distance <= 6.0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, to, length);
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Linea other = (Linea) obj;

        return length == other.length
            && from == other.from
            && to == other.to;
    }
}
