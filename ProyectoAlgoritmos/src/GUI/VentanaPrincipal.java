/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javax.swing.JFrame;
import javax.swing.*;

/**
 *
 * @author Pablo Castillo
 */
public class VentanaPrincipal extends JFrame {
    private JMenu menu;
    private JMenuBar barra;
    private JMenuItem item1;
    public VentanaPrincipal(){
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setVisible(true);
    this.setSize(800,600);
    inict();
    
    }
    
    public void inict(){
        barra=new JMenuBar();
       // this.add(this.barra); 
        this.setJMenuBar(barra);
       this.menu=new JMenu("Menu");
       barra.add(this.menu);
       
       this.item1=new JMenuItem("Insertar Peliculas");
       this.menu.add(item1);
       
    }
    
}
