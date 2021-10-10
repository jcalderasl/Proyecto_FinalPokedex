
package ventanas;



import Datos.ClspokemonJDBC;
import Datos.ClsFav;
import Datos.ClsFavJDBC;
import com.mycompany.Pokedex_Proyect.usuarioJDBC;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.sql.*;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author PC
 */
public class Pokemon extends javax.swing.JFrame {
   
    
    
    BufferedImage  buffer1 = null;
    Image imagen1 = null;
    int contador = 0;
    Statement estado;
    ResultSet resultadoConsulta;
    Connection conexion;
    
    @Override
    public void paint (Graphics g){
        super.paintComponents(g);
        Graphics2D g2 = (Graphics2D) imagenPoke.getGraphics();
        
        g2.drawImage(buffer1, 0, 0,imagenPoke.getWidth(),imagenPoke.getHeight(),null);
    
    }
    public Pokemon() {
        
        
     initComponents();
   
        this.setLocationRelativeTo(null);
        this.setTitle("Ventana_pokedex");
        
        try {
          imagen1 = ImageIO.read(new File("C:\\Users\\PC\\Pictures\\Imagenes\\black-white.png"));
        } catch (IOException ex) {
           ex.printStackTrace(System.out);
        }
        
        buffer1 = (BufferedImage) imagenPoke.createImage(imagenPoke.getWidth(),imagenPoke.getHeight());
        
        Graphics2D g2 = buffer1.createGraphics();
        dibujaElPokemonQueEstaEnLaPosicion(30);
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String JDBC_URL="jdbc:mysql://localhost:3306/test?zeroDateTimeBehavior=convertToNull&useSSL=false&useTimezone=true&serverTimezone=UTC";
            
            conexion = DriverManager.getConnection(JDBC_URL,"root","Jesus21%");
            estado = (Statement) conexion.createStatement();
            
     
        } catch (ClassNotFoundException ex) {
           ex.printStackTrace(System.out);
           System.out.println("Hay error de Base de Datos");
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Hay error de Base de Datos");
        }
        
     
        
    }
     private void dibujaElPokemonQueEstaEnLaPosicion(int posicion){
        int fila = posicion/31;
        int columna = posicion % 31;
        Graphics2D g2 = (Graphics2D) buffer1.getGraphics();
        g2.setColor(Color.pink);
        g2.fillRect(0, 0, //pinta el fondo del jpanel negro
                imagenPoke .getWidth(),
                imagenPoke.getHeight());
        g2.drawImage(imagen1,
                0, //posicion X inicial dentro del jpanel
                0, // posicion Y inicial dentro del jpanel
                imagenPoke.getWidth(), //ancho del jpanel
                imagenPoke.getHeight(), //alto del jpanel
                columna*96, //posicion inicial X dentro de la imagen de todos los pokemon
                fila*96, //posicion inicial Y dentro de la imagen de todos los pokemon
                columna*96 + 96, //posicion final X
                fila*96 + 96, //posicion final Y
                null //si no lo pones no va
                );
        repaint();
    
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nombrepoke = new javax.swing.JLabel();
        lblprueba = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        verHabitat = new javax.swing.JButton();
        jcomboHabitats = new javax.swing.JComboBox<>();
        jcomboPokemones = new javax.swing.JComboBox<>();
        verColor = new javax.swing.JButton();
        jcombocolor = new javax.swing.JComboBox<>();
        ButtonBuscar_pornombre = new javax.swing.JButton();
        jcomboNombres = new javax.swing.JComboBox<>();
        JButtonfavoritos = new javax.swing.JButton();
        labelSpecies = new javax.swing.JLabel();
        labelColor = new javax.swing.JLabel();
        labelCapture_rate = new javax.swing.JLabel();
        labelExperience = new javax.swing.JLabel();
        labelId = new javax.swing.JLabel();
        imagenPoke = new javax.swing.JPanel();
        jButtonInformacion = new javax.swing.JButton();
        jButtonImprimir = new javax.swing.JButton();
        labelIzquierda = new javax.swing.JButton();
        labelUsuario = new javax.swing.JLabel();
        labelDerecha = new javax.swing.JButton();
        labelNombre = new javax.swing.JLabel();
        labelHabitat = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButtonVerInformacionUsuario = new javax.swing.JToggleButton();
        txtnom = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jButtoninformaciondeUsuarios = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(778, 790));

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        verHabitat.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        verHabitat.setText("Ver habitat \t→ \t");
        verHabitat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verHabitatActionPerformed(evt);
            }
        });

        jcomboHabitats.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jcomboHabitats.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Habitats" }));
        jcomboHabitats.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcomboHabitatsActionPerformed(evt);
            }
        });

        jcomboPokemones.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jcomboPokemones.setMaximumRowCount(800);
        jcomboPokemones.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pokemones" }));
        jcomboPokemones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcomboPokemonesActionPerformed(evt);
            }
        });

        verColor.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        verColor.setText("Ver color → ");
        verColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verColorActionPerformed(evt);
            }
        });

        jcombocolor.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jcombocolor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Colores" }));
        jcombocolor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcombocolorActionPerformed(evt);
            }
        });

        ButtonBuscar_pornombre.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        ButtonBuscar_pornombre.setText("Buscar por nombre ↓ ");
        ButtonBuscar_pornombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonBuscar_pornombreActionPerformed(evt);
            }
        });

        jcomboNombres.setFont(new java.awt.Font("Calibri Light", 1, 12)); // NOI18N
        jcomboNombres.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nombres" }));
        jcomboNombres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcomboNombresActionPerformed(evt);
            }
        });

        JButtonfavoritos.setText("agregar a favoritos");
        JButtonfavoritos.setActionCommand("");
        JButtonfavoritos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JButtonfavoritosActionPerformed(evt);
            }
        });

        labelSpecies.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        labelSpecies.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Species", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Yu Gothic Medium", 1, 12))); // NOI18N

        labelColor.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        labelColor.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Color", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tw Cen MT", 1, 12))); // NOI18N

        labelCapture_rate.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        labelCapture_rate.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Capture_rate", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Trebuchet MS", 1, 12))); // NOI18N

        labelExperience.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        labelExperience.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Base_experience", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tw Cen MT", 1, 12))); // NOI18N

        labelId.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        labelId.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Id", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Yu Gothic Medium", 1, 12))); // NOI18N

        imagenPoke.setBackground(new java.awt.Color(255, 153, 255));
        imagenPoke.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout imagenPokeLayout = new javax.swing.GroupLayout(imagenPoke);
        imagenPoke.setLayout(imagenPokeLayout);
        imagenPokeLayout.setHorizontalGroup(
            imagenPokeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 215, Short.MAX_VALUE)
        );
        imagenPokeLayout.setVerticalGroup(
            imagenPokeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 174, Short.MAX_VALUE)
        );

        jButtonInformacion.setText("Ver Informacion de pokemones");
        jButtonInformacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInformacionActionPerformed(evt);
            }
        });

        jButtonImprimir.setText("Generar Reporte");
        jButtonImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonImprimirActionPerformed(evt);
            }
        });

        labelIzquierda.setFont(new java.awt.Font("Calibri Light", 1, 30)); // NOI18N
        labelIzquierda.setText("←");
        labelIzquierda.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        labelIzquierda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                labelIzquierdaActionPerformed(evt);
            }
        });

        labelDerecha.setFont(new java.awt.Font("Calibri Light", 1, 30)); // NOI18N
        labelDerecha.setText("→");
        labelDerecha.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        labelDerecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                labelDerechaActionPerformed(evt);
            }
        });

        labelNombre.setBackground(new java.awt.Color(51, 0, 102));
        labelNombre.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        labelNombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelNombre.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nombre", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tw Cen MT", 1, 12))); // NOI18N

        labelHabitat.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        labelHabitat.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Habitat", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 12))); // NOI18N

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Name", "Species", "Color", "Habitat", "Capture_rate", "Base_Experience"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButtonVerInformacionUsuario.setText("Ver pokemones Favoritos");
        jButtonVerInformacionUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVerInformacionUsuarioActionPerformed(evt);
            }
        });

        jLabel1.setText("Ingrese su nombre:");

        jLabel2.setText("Id Usuario:");

        jButtoninformaciondeUsuarios.setText("Ver Usuarios");
        jButtoninformaciondeUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtoninformaciondeUsuariosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelHabitat, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelId, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelSpecies, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(labelIzquierda, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelDerecha, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(imagenPoke, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(verHabitat, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(verColor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcomboHabitats, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcombocolor, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(181, 181, 181)
                                .addComponent(ButtonBuscar_pornombre))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelCapture_rate, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelColor, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelExperience, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(121, 121, 121)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jcomboNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelUsuario, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addContainerGap(38, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(198, 198, 198)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtId, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                            .addComponent(txtnom)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(230, 230, 230)
                        .addComponent(labelNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButtonImprimir)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButtonInformacion, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButtoninformaciondeUsuarios, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 683, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(jButtonVerInformacionUsuario)
                        .addGap(18, 18, 18)
                        .addComponent(JButtonfavoritos)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jcomboPokemones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(138, 138, 138))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(ButtonBuscar_pornombre, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jcomboNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(151, 151, 151))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(labelNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(labelId, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(labelSpecies, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(labelHabitat, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(imagenPoke, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(labelColor, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(labelExperience, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(labelUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(labelCapture_rate, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(16, 16, 16)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelDerecha)
                            .addComponent(labelIzquierda))
                        .addGap(5, 5, 5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(verHabitat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcomboHabitats, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(verColor)
                            .addComponent(jcombocolor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addComponent(jcomboPokemones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtnom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonVerInformacionUsuario)
                            .addComponent(JButtonfavoritos))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonImprimir)
                            .addComponent(jButtoninformaciondeUsuarios)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 32, Short.MAX_VALUE)
                        .addComponent(jButtonInformacion)
                        .addGap(31, 31, 31)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblprueba)
                    .addComponent(nombrepoke)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(nombrepoke)
                .addGap(88, 88, 88)
                .addComponent(lblprueba)
                .addGap(711, 711, 711))
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void labelIzquierdaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_labelIzquierdaActionPerformed
        
      
             
             contador --;
             if(contador<=0){
             contador = 1;
             }
             dibujaElPokemonQueEstaEnLaPosicion(contador-1);
             try {
             int id = contador;
             String qr = "select * from pokemon where id="+id;
             
             resultadoConsulta = estado.executeQuery(qr);
             
             if(resultadoConsulta.next()){
                labelNombre.setText(resultadoConsulta.getString(2));
                labelId.setText(resultadoConsulta.getString("id"));
                labelNombre.setText(resultadoConsulta.getString("name"));
                labelColor.setText(resultadoConsulta.getString("color"));
                labelHabitat.setText(resultadoConsulta.getString("habitat"));
                labelSpecies.setText(resultadoConsulta.getString("species"));
                labelCapture_rate.setText(resultadoConsulta.getString("capture_rate"));
                labelExperience.setText(resultadoConsulta.getString("base_experience")); 
             }else{
             labelNombre.setText("El pokemon no esta o no existe en el pokedex");
             
             }
             } catch (SQLException ex) {
             Logger.getLogger(Pokemon.class.getName()).log(Level.SEVERE, null, ex);
             }
        
    }//GEN-LAST:event_labelIzquierdaActionPerformed

    private void labelDerechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_labelDerechaActionPerformed
        
        
       dibujaElPokemonQueEstaEnLaPosicion(contador);
       
        String cuerito = "Select * from pokemon where id="+(contador+1);
        
        
        try {
            resultadoConsulta = estado.executeQuery(cuerito);
            if (resultadoConsulta.next()){
                labelNombre.setText(resultadoConsulta.getString(2));
                labelId.setText(resultadoConsulta.getString("id"));
                labelNombre.setText(resultadoConsulta.getString("name"));
                labelColor.setText(resultadoConsulta.getString("color"));
                labelHabitat.setText(resultadoConsulta.getString("habitat"));
                labelSpecies.setText(resultadoConsulta.getString("species"));
                labelCapture_rate.setText(resultadoConsulta.getString("capture_rate"));
                labelExperience.setText(resultadoConsulta.getString("base_experience"));    
            } else {
                labelNombre.setText("no existe");
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Clavo con sql");
        }
        
        contador++;
        if (contador >=649){
            contador = 649;
        }
      
    }//GEN-LAST:event_labelDerechaActionPerformed
      
    private void verHabitatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verHabitatActionPerformed
         // String cuerito2 = "SELECT distinct(habitat) as habitat FROM pokemon order by 1";
        String cuerito2 = "SELECT distinct(habitat) as habitat FROM pokemon order by 1";
        try {
            resultadoConsulta = estado.executeQuery(cuerito2);
            
          while (resultadoConsulta.next()){
                jcomboHabitats.remove(this);
                jcomboHabitats.addItem(resultadoConsulta.getString("habitat"));
            }
           
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Clavo con sql");       
    }//GEN-LAST:event_verHabitatActionPerformed
    }        
    private void jcomboHabitatsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcomboHabitatsActionPerformed
         String habit=(String)jcomboHabitats.getSelectedItem();    
       
             jcomboPokemones.removeAllItems();
              String cuerito1 ="SELECT  name from pokemon where habitat='"+habit+"'" ;
             
                         
        try {
            resultadoConsulta = estado.executeQuery(cuerito1);
            
            
          while (resultadoConsulta.next()){
                 jcomboPokemones.remove(this);
                jcomboPokemones.addItem(resultadoConsulta.getString("name"));
            }
           
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Clavo con sql");        
                }    
        
        
    }//GEN-LAST:event_jcomboHabitatsActionPerformed

    private void verColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verColorActionPerformed
       String cuerito3 = "SELECT DISTINCT (color) as color FROM pokemon order by 1";//ordena alfabeticamente los colores
        try {
            resultadoConsulta = estado.executeQuery(cuerito3);
            
          while (resultadoConsulta.next()){
                 jcombocolor.remove(this);
                jcombocolor.addItem(resultadoConsulta.getString("color"));
            }
           
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Clavo con sql");
                    }
// TODO add your handling code here:
    }//GEN-LAST:event_verColorActionPerformed

    private void jcombocolorActionPerformed(java.awt.event.ActionEvent evt) {                                            
        
        String habit=(String)jcombocolor.getSelectedItem();    
         jcomboPokemones.removeAllItems();
              String cuerito1 ="SELECT  name from pokemon where color='"+habit+"'" ;
              
           try {
                resultadoConsulta = estado.executeQuery(cuerito1);
            } catch (SQLException ex) {
                Logger.getLogger(Pokemon.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            try {
                while (resultadoConsulta.next()){
                     jcomboPokemones.remove(this);
                    jcomboPokemones.addItem(resultadoConsulta.getString("name"));
                }
           
            } catch (SQLException ex) {
                Logger.getLogger(Pokemon.class.getName()).log(Level.SEVERE, null, ex);
            
    }                                                                                      
    }
    private void ButtonBuscar_pornombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonBuscar_pornombreActionPerformed
          String cuerito3 = "SELECT DISTINCT (name) as name FROM pokemon order by 1";//ordena alfabeticamente 
        try {
            resultadoConsulta = estado.executeQuery(cuerito3);
            
          while (resultadoConsulta.next()){
                 jcomboNombres.remove(this);
                jcomboNombres.addItem(resultadoConsulta.getString("name"));
            }
           
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Clavo con sql");
                    }   
                     
    }//GEN-LAST:event_ButtonBuscar_pornombreActionPerformed

    private void jcomboPokemonesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcomboPokemonesActionPerformed
           
        
    }//GEN-LAST:event_jcomboPokemonesActionPerformed
             
    private void jcomboNombresActionPerformed(java.awt.event.ActionEvent evt) {                                              
               String habit=(String)jcomboNombres.getSelectedItem();  
                jcombocolor.removeAllItems();
              
              String cuerito1 ="SELECT  id, name, habitat,color,species,capture_rate,base_experience from pokemon where name='"+habit+"'" ;
              
           try {
                resultadoConsulta = estado.executeQuery(cuerito1);
            } catch (SQLException ex) {
                Logger.getLogger(Pokemon.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            try {
                while (resultadoConsulta.next()){
                     jcombocolor.remove(this);
                   
                    String f;
                   f=(resultadoConsulta.getString("id"));
                   
                   contador= Integer.parseInt(f) ;
                     dibujaElPokemonQueEstaEnLaPosicion(contador-1);
            
                    labelId.setText(resultadoConsulta.getString("id"));
                    labelNombre.setText(resultadoConsulta.getString("name"));
                    labelColor.setText(resultadoConsulta.getString("color"));
                    labelHabitat.setText(resultadoConsulta.getString("habitat"));
                    labelSpecies.setText(resultadoConsulta.getString("species"));
                    labelCapture_rate.setText(resultadoConsulta.getString("capture_rate"));
                    labelExperience.setText(resultadoConsulta.getString("base_experience"));
                    labelColor.setVisible(true);
                    labelSpecies.setVisible(true);
                    labelCapture_rate.setVisible(true);
                    labelExperience.setVisible(true);
        
        contador++;
        if (contador >=649){
            contador = 649;
        }
      
                }
        
            } catch (SQLException ex) {
                Logger.getLogger(Pokemon.class.getName()).log(Level.SEVERE, null, ex);       
    }                                                                                          
    }
    private void JButtonfavoritosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JButtonfavoritosActionPerformed
    
         ClsFav agregar=new ClsFav();
               
                   agregar.setId_usuario(Integer.parseInt(txtId.getText()));
                   agregar.setNombre(txtnom.getText());
                   agregar.setFavoritos(labelNombre.getText());
                 
                   ClsFavJDBC favJDBC=new ClsFavJDBC();
                   
                   favJDBC.Insertar(agregar);//llamamos a la función Insertar con el parametro agregar
                   
                   JOptionPane.showMessageDialog(null,"Listo, se ha agregado");
            
       
    }//GEN-LAST:event_JButtonfavoritosActionPerformed

    private void jButtonInformacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInformacionActionPerformed
        ClspokemonJDBC todos = new ClspokemonJDBC();

        DefaultTableModel modelo = todos.verInformacion();

        jTable1.setModel(modelo);
    }//GEN-LAST:event_jButtonInformacionActionPerformed

    private void jButtonImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonImprimirActionPerformed

           try{
          
            JasperReport reporte = null;
            String path = "C:\\Users\\PC\\Music\\reporte\\report1.jasper";
            reporte = (JasperReport)JRLoader.loadObjectFromFile(path);
            JasperPrint jprint = JasperFillManager.fillReport(reporte, null, conexion);
            JasperViewer viewer = new JasperViewer(jprint, false);
            viewer.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            viewer.setVisible(true);
        }catch (JRException ex){
            Logger.getLogger(Pokemon.class.getName()).log(Level.SEVERE,null,ex);
        }
        
  
    }//GEN-LAST:event_jButtonImprimirActionPerformed

    private void jButtonVerInformacionUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVerInformacionUsuarioActionPerformed
        ClsFavJDBC todos = new ClsFavJDBC();

        DefaultTableModel modelo = todos.verInformacion();

        jTable1.setModel(modelo);
    }//GEN-LAST:event_jButtonVerInformacionUsuarioActionPerformed

    private void jButtoninformaciondeUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtoninformaciondeUsuariosActionPerformed
        usuarioJDBC todos = new usuarioJDBC();

        DefaultTableModel modelo = todos.verInformacionDeUsuario();

        jTable1.setModel(modelo);
    }//GEN-LAST:event_jButtoninformaciondeUsuariosActionPerformed

        
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Pokemon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pokemon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pokemon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pokemon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Pokemon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pokemon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pokemon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pokemon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pokemon().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonBuscar_pornombre;
    private javax.swing.JButton JButtonfavoritos;
    private javax.swing.JPanel imagenPoke;
    private javax.swing.JButton jButtonImprimir;
    private javax.swing.JButton jButtonInformacion;
    private javax.swing.JToggleButton jButtonVerInformacionUsuario;
    private javax.swing.JButton jButtoninformaciondeUsuarios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox<String> jcomboHabitats;
    private javax.swing.JComboBox<String> jcomboNombres;
    private javax.swing.JComboBox<String> jcomboPokemones;
    private javax.swing.JComboBox<String> jcombocolor;
    private javax.swing.JLabel labelCapture_rate;
    javax.swing.JLabel labelColor;
    private javax.swing.JButton labelDerecha;
    private javax.swing.JLabel labelExperience;
    private javax.swing.JLabel labelHabitat;
    private javax.swing.JLabel labelId;
    private javax.swing.JButton labelIzquierda;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel labelSpecies;
    public static javax.swing.JLabel labelUsuario;
    private javax.swing.JLabel lblprueba;
    private javax.swing.JLabel nombrepoke;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtnom;
    private javax.swing.JButton verColor;
    private javax.swing.JButton verHabitat;
    // End of variables declaration//GEN-END:variables
}
