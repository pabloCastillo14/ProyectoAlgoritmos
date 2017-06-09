/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Bussines.ArchivoBussines;
import Data.Archivo;
import Data.ListaCircular;
import Data.MyNodeCountry;
import Domain.Pelicula;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hanse
 */
public class InternaTablaSola extends JFrame {

    JTable jtbPrueba;
    DefaultTableModel dtmModeloPrueba;
    Pelicula peli = new Pelicula();
    Archivo ar = new Archivo();
    ListaCircular listaNueva;
    ArchivoBussines archivoBusines = new ArchivoBussines();
    String ruta;
    String nom;

    public InternaTablaSola(String ruta, String nombre) {
        super("Lista completa de Peliculas");
        this.ruta = ruta;
        this.nom = nombre;
        this.dispose();
        this.setSize(800, 600);
        this.setVisible(true);
        ListaCircular vector[] = archivoBusines.leerArchivoBussiness(ruta);
        int cont = 0;
        for (int i = 0; i < vector.length; i++) {
            cont += vector[i].getSize();
        }//for
        generarTabla(vector, nom);
    }//constructor

    public void generarTabla(ListaCircular[] listaListas, String nombre) {
        this.dtmModeloPrueba = new DefaultTableModel();
        this.dtmModeloPrueba.addColumn("Codigo");
        this.dtmModeloPrueba.addColumn("Titulo");
        this.dtmModeloPrueba.addColumn("Genero");
        this.dtmModeloPrueba.addColumn("Total");
        this.dtmModeloPrueba.addColumn("Subtitulo");
        this.dtmModeloPrueba.addColumn("Premier");
        for (int j = 0; j < listaListas.length; j++) {
            MyNodeCountry head = null;
            MyNodeCountry tail = listaListas[j].getTail();
            int size = 0;
            MyNodeCountry temp = listaListas[j].getHead();
            if (tail != null) {
                while (temp != tail) {
                    if (nombre.equalsIgnoreCase(temp.getPelicula().getTitle().trim())) {
                        this.dtmModeloPrueba.addRow(new Object[]{temp.getPelicula().getCode(), temp.getPelicula().getTitle(),
                            temp.getPelicula().getGendeer(), temp.getPelicula().getTotal(), temp.getPelicula().getSubtitle(),
                            temp.getPelicula().getPremier()});
                        temp = temp.getNext();
                    } else {
                        temp = temp.getNext();
                    }//if-else
                }//while
                if (temp == tail) {
                    if (nombre.equalsIgnoreCase(temp.getPelicula().getSubtitle())) {
                        this.dtmModeloPrueba.addRow(new Object[]{temp.getPelicula().getCode(), temp.getPelicula().getTitle(),
                            temp.getPelicula().getGendeer(), temp.getPelicula().getTotal(), temp.getPelicula().getSubtitle(),
                            temp.getPelicula().getPremier()});
                    }//if
                }//if
                this.jtbPrueba = new JTable(this.dtmModeloPrueba);
                JScrollPane scrollPane = new JScrollPane(this.jtbPrueba);
                this.getContentPane().add(scrollPane);
            } else {
                JOptionPane.showMessageDialog(null, "no existe la pelicula");
            }//if-else
        }// for j 
    }//generarTabla
}//fin clase
