package GUI;

import Bussines.ArchivoBussines;
import Domain.Pelicula;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class InsertMovie extends JInternalFrame implements ActionListener {

    private JLabel jlblIdGenero, jlblTitle, jlblTotal, jlblSubtitle, jlblPremier;
    private JTextField txtTitle, txtTolal;
    private JComboBox jcbGender, jcbPremier, jcbSubtitle;
    private JButton btnInsertar;
    String ruta;

    public InsertMovie(String ruta) {
        super("Insertar Pelicula");
        this.ruta = ruta;
        Init();
        this.setLayout(null);
        this.setPreferredSize(new Dimension(350, 310));
        this.pack();
        this.setClosable(true);
        this.setVisible(true);
    }//constructor

    public void Init() {
        this.jlblIdGenero = new JLabel("Id de Genero");
        this.jcbGender = new JComboBox();
        this.jcbGender.addItem("Drama");
        this.jcbGender.addItem("Comedy");
        this.jcbGender.addItem("Childish");
        this.jcbGender.addItem("Action");
        this.jcbGender.addItem("Romance");
        this.jcbGender.addItem("Fiction");
        
        this.jlblTitle = new JLabel("Pelicula:");
        this.txtTitle = new JTextField();
        
        this.jlblTotal = new JLabel("Total a Pagar:");
        this.txtTolal = new JTextField();
        
        this.jlblSubtitle = new JLabel("Subtitulos:");
        this.jcbSubtitle = new JComboBox();
        this.jcbSubtitle.addItem("si");
        this.jcbSubtitle.addItem("no");
        
        this.jlblPremier = new JLabel("Premier:");
        this.jcbPremier = new JComboBox();
        this.jcbPremier.addItem("si");
        this.jcbPremier.addItem("no");

        this.btnInsertar = new JButton("Insertar");

        this.jlblIdGenero.setBounds(15, 15, 150, 50);
        this.jcbGender.setBounds(150, 30, 150, 20);

        this.jlblTitle.setBounds(15, 55, 120, 60);
        this.txtTitle.setBounds(150, 70, 150, 20);

        this.jlblTotal.setBounds(15, 95, 130, 50);
        this.txtTolal.setBounds(150, 110, 150, 20);

        this.jlblSubtitle.setBounds(15, 135, 130, 50);
        this.jcbSubtitle.setBounds(150, 150, 150, 20);

        this.jlblPremier.setBounds(15, 175, 130, 50);
        this.jcbPremier.setBounds(150, 190, 150, 20);

        this.btnInsertar.setBounds(125, 225, 100, 40);
        this.btnInsertar.addActionListener(this);

        this.add(this.jlblIdGenero);
        this.add(this.jcbGender);
        this.add(this.jlblTitle);
        this.add(this.txtTitle);
        this.add(this.jlblTotal);
        this.add(this.txtTolal);
        this.add(this.jlblSubtitle);
        this.add(this.jcbSubtitle);
        this.add(this.jlblPremier);
        this.add(this.jcbPremier);
        this.add(this.btnInsertar);

    }//Init
    
    public String clasificarGenero() {
        String combo = (String) this.jcbGender.getSelectedItem();
        if (combo.equals("Drama")) {
            combo = "1000";
        } else if (combo.equals("Comedy")) {
            combo = "2000";
        } else if (combo.equals("Childish")) {
            combo = "3000";
        } else if (combo.equals("Action")) {
            combo = "4000";
        } else if (combo.equals("Romance")) {
            combo = "5000";
        } else if (combo.equals("Fiction")) {
            combo = "6000";
        }//if-else/s
        return combo;
    }//clasificarGenero

    public String clasificarBooleanos(String combo) {
        if (combo.equals("si")) {
            combo = "1";
        } else if (combo.equals("no")) {
            combo = "0";
        }//if-else
        return combo;
    }//clasificarBooleanos

    @Override
    public void actionPerformed(ActionEvent e) {
        Pelicula peliNueva;
        if (e.getSource() == btnInsertar) {
            String genero = clasificarGenero();
            String comboPremier = (String) this.jcbPremier.getSelectedItem();
            String premier = clasificarBooleanos(comboPremier);
            String comboSubs = (String) this.jcbSubtitle.getSelectedItem();
            String subtitle = clasificarBooleanos(comboSubs);
            String titulo = this.txtTitle.getText();
            String valor = this.txtTolal.getText();
            if (!(txtTitle.getText().equals("")) && !(txtTolal.getText().equals(""))) {
                char primero;
                primero = titulo.charAt(0);
                titulo = Character.toUpperCase(primero) + titulo.substring(1, titulo.length());
                peliNueva = new Pelicula("0", titulo, genero, valor, subtitle, premier);
                ArchivoBussines bussiness = new ArchivoBussines();
                bussiness.leerArchivoBussiness(ruta);
                bussiness.insertarArchivoBussiness(peliNueva, ruta);
                bussiness.leerArchivoBussiness(ruta);
                JOptionPane.showMessageDialog(null, "se inserto");

            } else {
                JOptionPane.showMessageDialog(null, "vacio");
            }//if-else
        }//if
    }//actionPerformed
}//fin clase
