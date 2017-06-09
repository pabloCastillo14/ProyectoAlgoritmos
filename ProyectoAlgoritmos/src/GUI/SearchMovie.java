/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Bussines.ArchivoBussines;

import Data.ListaCircular;

import Domain.Pelicula;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;

/**
 *
 * @author hanse
 */
public class SearchMovie extends JInternalFrame implements ActionListener {

    private JLabel jlblGender;
    private JComboBox jcbGender;
    private JButton btnBuscar;
    private Object desktopPane;
    ListaCircular drama, action, comedia, fiction, chilidish, romance, ListaGeneral;
    String ruta;

    public SearchMovie(String ruta) {

        super("Buscar Pelicula");
        this.ruta = ruta;
        this.drama = new ListaCircular();
        comedia = new ListaCircular();
        chilidish = new ListaCircular();
        action = new ListaCircular();
        romance = new ListaCircular();
        fiction = new ListaCircular();

        this.desktopPane = new JDesktopPane();
        this.setClosable(true);
        this.setLayout(null);
        this.setSize(300, 300);
        init();
        this.setVisible(true);
    }//constructor

    public void init() {
        this.jlblGender = new JLabel("Genero:");
        this.jcbGender = new JComboBox();
        this.btnBuscar = new JButton("Buscar");
        this.btnBuscar.addActionListener(this);

        this.btnBuscar.setBounds(90, 200, 100, 30);

        this.jlblGender.setBounds(20, 70, 100, 30);
        this.jcbGender.setBounds(140, 75, 130, 20);

        this.jcbGender.addItem("Drama");
        this.jcbGender.addItem("Comedy");
        this.jcbGender.addItem("Childish");
        this.jcbGender.addItem("Action");
        this.jcbGender.addItem("Romance");
        this.jcbGender.addItem("Fiction");

        this.add(this.btnBuscar);
        this.add(this.jlblGender);
        this.add(this.jcbGender);
    }//public void init()

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnBuscar) {
            ArchivoBussines archivo = new ArchivoBussines();
            ArrayList<Pelicula> lista1 = new ArrayList<>();
            ListaCircular vector[] = archivo.leerArchivoBussiness(ruta);
            if (jcbGender.getSelectedItem() == "Drama") {
                drama = vector[0];
                TablaMostrar mostrar = new TablaMostrar(drama);
                mostrar.setFocusable(true);
                mostrar.setVisible(true);
            } else if (jcbGender.getSelectedItem() == "Comedy") {
                comedia = vector[1];
                TablaMostrar mostrar = new TablaMostrar(comedia);
                mostrar.setFocusable(true);
                mostrar.setVisible(true);
            } else if (jcbGender.getSelectedItem() == "Childish") {
                chilidish = vector[2];
                TablaMostrar mostrar = new TablaMostrar(chilidish);
                mostrar.setFocusable(true);
                mostrar.setVisible(true);
            } else if (jcbGender.getSelectedItem() == "Action") {
                action = vector[3];
                TablaMostrar mostrar = new TablaMostrar(action);
                mostrar.setFocusable(true);
                mostrar.setVisible(true);
            } else if (jcbGender.getSelectedItem() == "Romance") {
                romance = vector[4];
                TablaMostrar mostrar = new TablaMostrar(romance);
                mostrar.setFocusable(true);
                mostrar.setVisible(true);
            } else if (jcbGender.getSelectedItem() == "Fiction") {
                fiction = vector[5];
                TablaMostrar mostrar = new TablaMostrar(fiction);
                mostrar.setFocusable(true);
                mostrar.setVisible(true);
            }//if-else
        }//if
    }//actionPerformed(ActionEvent e)
}//fin clase Entrar
