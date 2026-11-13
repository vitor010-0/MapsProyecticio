
import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.event.KeyEvent;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

public class Menu extends JFrame {

    private final Color azulMarino = new Color(8, 43, 104);
    private final Color azul = new Color(7, 86, 201);
    private final Color azulElectrico = new Color(22, 139, 255);
    private final Color fondo = new Color(240, 247, 255);
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Menu.class.getName());

    /**
     * Creates new form Menu
     */
    private int contadorRutas = 0;
    private Color[] coloresRutas = {
        Color.GREEN,
        Color.RED,
        new Color(160, 32, 240),
        Color.ORANGE,
        Color.MAGENTA,
        Color.CYAN
    };
 private Maps mapa;

    public Menu() {
        setTitle("Rutas y Recorridos");
        setSize(430, 540);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        crearInterfaz();
        prepararElementos();
    }

        public Menu(Maps mapa) {
            this.mapa = mapa;
            this();
    }

     private void crearInterfaz() {

        JPanel principal = new JPanel();
        principal.setBackground(fondo);
        principal.setLayout(new BoxLayout(principal, BoxLayout.Y_AXIS));
        principal.setBorder(BorderFactory.createEmptyBorder(35, 30, 30, 30));

        JLabel titulo = new JLabel("RUTAS Y RECORRIDOS");
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 23));
        titulo.setForeground(azulMarino);
        titulo.setAlignmentX(CENTER_ALIGNMENT);

        JLabel subtitulo = new JLabel("ESTRUCTURA DE DATOS");
        subtitulo.setFont(new Font("Segoe UI", Font.BOLD, 12));
        subtitulo.setForeground(azulElectrico);
        subtitulo.setAlignmentX(CENTER_ALIGNMENT);

        JLabel icono = new JLabel("◎");
        icono.setFont(new Font("Segoe UI", Font.BOLD, 75));
        icono.setForeground(azulElectrico);
        icono.setAlignmentX(CENTER_ALIGNMENT);

        JLabel lblFrom = new JLabel("ORIGEN");
        lblFrom.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblFrom.setForeground(azulMarino);
        lblFrom.setAlignmentX(LEFT_ALIGNMENT);

        cbxFrom = new JComboBox<>();
        personalizarCombo(cbxFrom);

        JLabel lblTo = new JLabel("DESTINO");
        lblTo.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblTo.setForeground(azulMarino);
        lblTo.setAlignmentX(LEFT_ALIGNMENT);

        cbxTo = new JComboBox<>();
        personalizarCombo(cbxTo);

        btnCalc = new JButton("▶   COMENZAR");
        btnCalc.setFont(new Font("Segoe UI", Font.BOLD, 17));
        btnCalc.setForeground(Color.WHITE);
        btnCalc.setBackground(azul);
        btnCalc.setFocusPainted(false);
        btnCalc.setBorderPainted(false);
        btnCalc.setOpaque(true);
        btnCalc.setCursor(new java.awt.Cursor(
            java.awt.Cursor.HAND_CURSOR
        ));
         btnCalc.setAlignmentX(CENTER_ALIGNMENT);
        btnCalc.setMaximumSize(new Dimension(280, 48));

        btnCalc.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                btnCalc.setBackground(azulElectrico);
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                btnCalc.setBackground(azul);
            }
        });
         btnCalc.addActionListener(this::btnCalcActionPerformed);
         JButton btnLimpiar = new JButton("LIMPIAR RUTAS");

        btnLimpiar.setFont(new Font("Segoe UI", Font.BOLD, 15));
        btnLimpiar.setForeground(Color.WHITE);
        btnLimpiar.setBackground(new Color(220, 70, 70));
        btnLimpiar.setFocusPainted(false);
        btnLimpiar.setBorderPainted(false);
        btnLimpiar.setOpaque(true);
        btnLimpiar.setCursor(new java.awt.Cursor(
            java.awt.Cursor.HAND_CURSOR
        ));

        btnLimpiar.setAlignmentX(CENTER_ALIGNMENT);
        btnLimpiar.setMaximumSize(new Dimension(280, 45));

        btnLimpiar.addActionListener(e -> {
            if (mapa != null) {
                mapa.limpiarRutas();
                contadorRutas = 0;

                JOptionPane.showMessageDialog(this,
                    "Todas las rutas han sido limpiadas.");
            } else {
                JOptionPane.showMessageDialog(this,
                    "No se encontró el mapa.");
            }
        });

        JLabel pie = new JLabel("Encuentra la mejor ruta");
        pie.setFont(new Font("Segoe UI", Font.ITALIC, 14));
        pie.setForeground(azulMarino);
        pie.setAlignmentX(CENTER_ALIGNMENT);

        principal.add(titulo);
        principal.add(javax.swing.Box.createVerticalStrut(5));
        principal.add(subtitulo);
        principal.add(javax.swing.Box.createVerticalStrut(15));
        principal.add(icono);
        principal.add(javax.swing.Box.createVerticalStrut(15));
        principal.add(lblFrom);
        principal.add(javax.swing.Box.createVerticalStrut(8));
        principal.add(cbxFrom);
        principal.add(javax.swing.Box.createVerticalStrut(20));
        principal.add(lblTo);
        principal.add(javax.swing.Box.createVerticalStrut(8));
        principal.add(cbxTo);
        principal.add(javax.swing.Box.createVerticalStrut(30));
        principal.add(btnCalc);
        principal.add(javax.swing.Box.createVerticalStrut(12));
        principal.add(btnLimpiar);
        principal.add(javax.swing.Box.createVerticalStrut(20));
        principal.add(pie);

        setContentPane(principal);
    }

    private void personalizarCombo(JComboBox<Place> combo) {

        combo.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        combo.setForeground(azulMarino);
        combo.setBackground(Color.WHITE);
        combo.setMaximumSize(new Dimension(350, 42));
        combo.setPreferredSize(new Dimension(350, 42));
    }

    private void prepararElementos() {

        for (Place p : Place.values()) {
            cbxFrom.addItem(p);
            cbxTo.addItem(p);
        }
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cbxFrom = new javax.swing.JComboBox<>();
        lblFrom = new javax.swing.JLabel();
        lblTo = new javax.swing.JLabel();
        cbxTo = new javax.swing.JComboBox<>();
        btnCalc = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblFrom.setText("Origen:");

        lblTo.setText("Destino:");

        btnCalc.setText("Comenzar");
        btnCalc.addActionListener(this::btnCalcActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lblFrom)
                            .addGap(31, 31, 31)
                            .addComponent(cbxFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lblTo)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbxTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnCalc))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFrom))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTo)
                    .addComponent(cbxTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnCalc)
                .addContainerGap(204, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCalcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcActionPerformed
         
    Place origen = (Place) cbxFrom.getSelectedItem();
    Place destino = (Place) cbxTo.getSelectedItem();

    if (origen == null || destino == null) { //Creo no puede pasar en runtime pero igual
        JOptionPane.showMessageDialog(this,
            "Selecciona un origen y un destino.");
        return;
    }

    if (origen == destino) {
        JOptionPane.showMessageDialog(this,
            "Distancia: 0 m\nYa estás en tu destino.");
        return;
    }

    if (mapa == null) {
        JOptionPane.showMessageDialog(this,
            "El mapa no está conectado.");
        return;
    }

    List<Place> ruta = Grafo.mapeameLaExistencia(origen, destino);

    if (ruta == null || ruta.isEmpty()) {
        JOptionPane.showMessageDialog(this,
            "No se encontró una ruta disponible.");
        return;
    }

    Color color = coloresRutas[
        contadorRutas % coloresRutas.length
    ];

    mapa.setRuta(ruta, color);

    contadorRutas++;

    int distancia = Grafo.obtenerDistancia(ruta);

    JOptionPane.showMessageDialog(this,
        "Ruta encontrada correctamente.\n"
        + "Distancia total: " + distancia + " metros.");
    }//GEN-LAST:event_btnCalcActionPerformed

    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info :
                    javax.swing.UIManager.getInstalledLookAndFeels()) {

                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(
                        info.getClassName()
                    );
                
                    break;
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCalc;
    private javax.swing.JComboBox<Place> cbxFrom;
    private javax.swing.JComboBox<Place> cbxTo;
    private javax.swing.JLabel lblFrom;
    private javax.swing.JLabel lblTo;
    // End of variables declaration//GEN-END:variables
}
