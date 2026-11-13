
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.JFrame;
import javax.swing.KeyStroke;
import java.awt.Color;
import java.awt.Component;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author jacqu
 */
public class Maps extends JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Maps.class.getName());
    private static Place from = null;
    private static Place to = null;
    public static BackgroundImage bg;

    /**
     * Creates new form Maps
     */
    
    public Maps() {
        initComponents();
        setTitle("Mapeneitor 3500");
        setSize(835, 568);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(true);
        bg = new BackgroundImage("imgMaps.jpeg");
        bg.setLayout(null);

        for (PrettyButton pb : getButtons()) {
            bg.add(pb);
        }
        for (Linea line : getLines()) {
            bg.add(line);
        }

        setContentPane(bg);
        setupKeys();
    }

   public void limpiarRutas() {

    for (Place p : Place.values()) {
        p.marked = false;
    }

    for (Component comp : bg.getComponents()) {

        if (comp instanceof Linea) {
            Linea linea = (Linea) comp;

            linea.marked = false;
            linea.colorRuta = Color.BLUE;

            linea.repaint();
        }

        if (comp instanceof PrettyButton) {
            comp.repaint();
        }
    }

    bg.repaint();
}
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new Maps().setVisible(true));
    }

    private ArrayList<PrettyButton> getButtons() {
        ArrayList<PrettyButton> list = new ArrayList<>();
        for (Place p : Place.values()) {
            PrettyButton pb = new PrettyButton(p);
            pb.setBounds(p.x, p.y, 15, 15);
            pb.setToolTipText(p.name);
            pb.addActionListener(e -> {
                if (from == null) {
                    from = pb.place;
                } else {
                    to = pb.place;
                }
            });
            list.add(pb);
        }
        return list;
    }

    private ArrayList<Linea> getLines() {
        ArrayList<Linea> lines = Library.lines;

        for (Linea line : lines) {
            line.setBounds(0, 0, getWidth(), getHeight());
        }
        return lines;
    }

    private void setupKeys() {
        KeyStroke comb = KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, InputEvent.CTRL_DOWN_MASK | InputEvent.SHIFT_DOWN_MASK);
        javax.swing.InputMap map = getRootPane().getInputMap(javax.swing.JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap action = getRootPane().getActionMap();
        map.put(comb, "restartScene");
        action.put("restartScene", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Maps newMap = new Maps();
                newMap.setLocation(getLocation());
                newMap.setVisible(true);
                dispose();
            }
        });
    }

   public static void paintPath(List<Place> ruta, Color color) {

    if (bg == null || ruta == null || ruta.size() < 2) {
        return;
    }

    for (int i = 0; i < ruta.size() - 1; i++) {

        Place a = ruta.get(i);
        Place b = ruta.get(i + 1);

        for (Component comp : bg.getComponents()) {

            if (comp instanceof Linea) {

                Linea line = (Linea) comp;

                if ((line.from == a && line.to == b) ||
                    (line.from == b && line.to == a)) {

                    line.routeColor = color;
                    line.repaint();
                }
            }
        }
    }

    bg.repaint();
}
    public void setRuta(List<Place> ruta, Color color) {

    if (ruta == null || ruta.size() < 2) {
        return;
    }

    for (Component comp : bg.getComponents()) {

        if (comp instanceof Linea) {
            Linea linea = (Linea) comp;

            for (int i = 0; i < ruta.size() - 1; i++) {

                Place a = ruta.get(i);
                Place b = ruta.get(i + 1);

                if ((linea.from == a && linea.to == b) ||
                    (linea.from == b && linea.to == a)) {

                    linea.marked = true;
                    linea.colorRuta = color;
                    linea.repaint();
                }
            }
        }
    }

    bg.repaint();
}
}
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

