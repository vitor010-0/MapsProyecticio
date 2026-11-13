
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import javax.swing.JButton;

public class PrettyButton extends JButton {

    public Place place;

    public PrettyButton(Place place) {

        super();

        this.place = place;

        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorderPainted(false);
        setOpaque(false);
        setCursor(new java.awt.Cursor(
            java.awt.Cursor.HAND_CURSOR
        ));
        setToolTipText(place.name);
    }

    @Override
    protected void paintComponent(Graphics g) {

        Graphics2D g2 = (Graphics2D) g.create();

        g2.setRenderingHint(
            RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON
        );

        int w = getWidth();
        int h = getHeight();

        Color azulOscuro = new Color(8, 43, 104);
        Color azulClaro = new Color(22, 139, 255);
        Color turquesa = new Color(0, 225, 255);

        if (place.marked) {

            g2.setColor(new Color(0, 225, 255, 80));
            g2.fillOval(-4, -4, w + 8, h + 8);

            g2.setPaint(new GradientPaint(
                0, 0, Color.WHITE,
                w, h, turquesa
            ));

        } else {

            g2.setPaint(new GradientPaint(
                0, 0, azulClaro,
                w, h, azulOscuro
            ));
        }

        g2.fillOval(1, 1, w - 2, h - 2);

        g2.setColor(Color.WHITE);
        g2.setStroke(new BasicStroke(2.5f));
        g2.drawOval(1, 1, w - 2, h - 2);

        g2.dispose();

    }

    @Override
    public boolean contains(int x, int y) {

        int radius = getWidth() / 2;

        return Math.pow(x - radius, 2)
            + Math.pow(y - radius, 2)
            <= Math.pow(radius, 2) + 5;
    }

    @Override
    public Point getToolTipLocation(
        java.awt.event.MouseEvent event
    ) {
        return new Point(0, -30);
    }
}
