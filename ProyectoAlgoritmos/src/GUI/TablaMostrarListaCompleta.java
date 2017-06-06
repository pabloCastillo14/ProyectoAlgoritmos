/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Bussines.ArchivoBussines;
import Data.Action;
import Data.Archivo;
import Data.MyNodeCountry;
import Domain.Pelicula;
import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hansel
 */
public class TablaMostrarListaCompleta extends JFrame{
    JTable jtbPrueba;
    DefaultTableModel dtmModeloPrueba;
    Pelicula peli= new Pelicula();
    Archivo ar= new Archivo();
    
    public TablaMostrarListaCompleta(){
        super("Lista de todas las Peliculas");
        this.dispose();
        this.setSize(800, 600);
        init();
    }
    
    private void init(){
        
        Object[][] datos = {
            {},
            {2,"A Time to Killer",1000,30,0,1},
            {3,"Airplane",2000,25,0,0},
            {4,"Aladdin",3000,20,0,0},
            {5,"Amistad",1000,50,0,1},
            {6,"Antz",3000,40,0,0},
            {7,"Armageddon",4000,25,1,1},
        };
        String[] nombreColumnas = {"Codigo","Titulo","Genero","Total","Sutitulos","Premier"};
        this.dtmModeloPrueba=new DefaultTableModel(datos, nombreColumnas);
        
        
//        this.dtmModeloPrueba=new DefaultTableModel();
//        this.dtmModeloPrueba.addColumn("Codigo");
//        this.dtmModeloPrueba.addColumn("Titulo");
//        this.dtmModeloPrueba.addColumn("Genero");
//        this.dtmModeloPrueba.addColumn("Total");
//        this.dtmModeloPrueba.addColumn("Subtitulo");
//        this.dtmModeloPrueba.addColumn("Premier");
        
//        this.dtmModeloPrueba.addRow(new Object[]{4,"Art4",5000});


        this.jtbPrueba=new JTable(this.dtmModeloPrueba);
        JScrollPane scrollPane = new JScrollPane(this.jtbPrueba);
        this.getContentPane().add(scrollPane);
        System.out.println("tablajava.Ventana.init()");
    } // init
}
