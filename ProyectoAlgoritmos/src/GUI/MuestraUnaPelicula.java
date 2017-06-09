package GUI;

import Bussines.ArchivoBussines;
import Data.ListaCircular;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Phanse
 */
public class MuestraUnaPelicula extends JInternalFrame implements ActionListener {

    private JLabel jlblTitle;
    private JTextField txtTitle;
    private JButton btnBuscar;
    ListaCircular listaGeneral;
    String ruta;

    public MuestraUnaPelicula(String ruta) {

        super("Buscar Pelicula");
        this.listaGeneral = new ListaCircular();
        this.ruta = ruta;
        this.setClosable(true);
        this.setLayout(null);
        this.setSize(300, 300);
        init();
        this.setVisible(true);
    }//constructor

    public void init() {
        this.jlblTitle = new JLabel("Pelicula:");
        this.txtTitle = new JTextField();

        this.btnBuscar = new JButton("Buscar");
        this.btnBuscar.addActionListener(this);

        this.btnBuscar.setBounds(90, 200, 100, 30);

        this.jlblTitle.setBounds(20, 50, 150, 30);
        this.txtTitle.setBounds(140, 55, 130, 20);

        this.add(this.btnBuscar);
        this.add(this.jlblTitle);
        this.add(this.txtTitle);
    }//public void init()

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btnBuscar) {
            ArchivoBussines archivo = new ArchivoBussines();
            InternaTablaSola interna = new InternaTablaSola(ruta, txtTitle.getText());
            interna.setVisible(true);
        }//if
    }//actionPerformed(ActionEvent ae)
}//fin clase
