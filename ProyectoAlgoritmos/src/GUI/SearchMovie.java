/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author hansel
 */
public class SearchMovie extends JInternalFrame implements ActionListener{
    private JLabel jlblTitle, jlblGender;
    private JTextField txtTitle;
    private JComboBox jcbGender;
    private JButton btnBuscar;
    private Object desktopPane;
    
    public SearchMovie(){
        super("Buscar Pelicula");
        this.desktopPane=new JDesktopPane();
        this.setClosable(true);
        this.setLayout(null);
        this.setSize(300, 300);
        init();
        this.setVisible(true);
    }//constructor
    
    public void init(){
        this.jlblTitle=new JLabel("Pelicula:");
        this.txtTitle=new JTextField();
        this.jlblGender=new JLabel("Genero:");
        this.jcbGender= new JComboBox();
        this.btnBuscar=new JButton("Buscar");
        this.btnBuscar.addActionListener(this);
        
        this.btnBuscar.setBounds(90, 200, 100, 30);
        
        this.jlblTitle.setBounds(20, 50, 150, 30);
        this.txtTitle.setBounds(140,55,130,20);
        
        this.jlblGender.setBounds(20, 90, 100, 30);
        this.jcbGender.setBounds(140,95,130,20);
        
        this.jcbGender.addItem("Drama");
        this.jcbGender.addItem("Comedy");
        this.jcbGender.addItem("Childish");
        this.jcbGender.addItem("Action");
        this.jcbGender.addItem("Romance");
        this.jcbGender.addItem("Fiction");
        
        this.add(this.btnBuscar);
        this.add(this.jlblGender);
        this.add(this.jcbGender);
        this.add(this.jlblTitle);
        this.add(this.txtTitle);
    }//public void init()
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnBuscar){
            TablaMostrar mostrar=new TablaMostrar();
            mostrar.setFocusable(true);
            mostrar.setVisible(true);
        }
    }
}//fin clase Entrar
