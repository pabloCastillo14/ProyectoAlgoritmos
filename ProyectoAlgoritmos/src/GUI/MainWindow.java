/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author hansel
 */
public class MainWindow extends JFrame implements ActionListener{
    private JDesktopPane desktopPane;
    private JMenuBar jmbMenu;
    private JMenu jmOpciones;
    private JMenuItem jmiInsertarPelicula,jmiBuscarPelicula, jmiMostrarPeliculas;
    public MainWindow(){
        super("Renta de Peliculas");
        this.setSize(800,600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.desktopPane=new JDesktopPane();
        this.desktopPane.setLayout(null);
        this.init();
        this.add(this.desktopPane);
        this.setVisible(true);
    } //constructor
    
    public void init(){
        this.jmbMenu=new JMenuBar();
        this.setJMenuBar(this.jmbMenu);
        
        this.jmOpciones=new JMenu("Menu");
        this.jmbMenu.add(this.jmOpciones);
        
        this.jmiInsertarPelicula=new JMenuItem("Insetar Pelicula"); 
        this.jmiInsertarPelicula.addActionListener(this);
        this.jmOpciones.add(this.jmiInsertarPelicula);
        
        this.jmiBuscarPelicula=new JMenuItem("Buscar Pelicula");
        this.jmiBuscarPelicula.addActionListener(this);
        this.jmOpciones.add(this.jmiBuscarPelicula);
        
        this.jmiMostrarPeliculas=new JMenuItem("Mostrar todas las Pelicula");
        this.jmiMostrarPeliculas.addActionListener(this);
        this.jmOpciones.add(this.jmiMostrarPeliculas);
        
    }//public void init()
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==this.jmiInsertarPelicula){
            InsertMovie insert=new InsertMovie();
            insert.setFocusable(true);
            insert.setVisible(true);
            this.desktopPane.add(insert);
        }
        else if(e.getSource()==this.jmiBuscarPelicula){
            SearchMovie search=new SearchMovie();
            search.setFocusable(true);
            search.setVisible(true);
            this.desktopPane.add(search);
        }
        else if(e.getSource()==this.jmiMostrarPeliculas){
            TablaMostrarListaCompleta listaPelis=new TablaMostrarListaCompleta();
            listaPelis.setFocusable(true);
            listaPelis.setVisible(true);
//            this.desktopPane.add(listaPelis);
        }
        
//else if(e.getSource()==this.jmiLogin)
    }//public void actionPerformed(ActionEvent e) 
}//fin clase ventana
