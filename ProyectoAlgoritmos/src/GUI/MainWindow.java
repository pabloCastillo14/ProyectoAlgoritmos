package GUI;

import Data.Archivo;
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
 * @author hanse
 */
public class MainWindow extends JFrame implements ActionListener {

    private JDesktopPane desktopPane;
    private JMenuBar jmbMenu;
    private JMenu jmOpciones;
    private JMenuItem jmiInsertarPelicula, jmiBuscarPelicula, jmiBuscar, jmiListaGeneral;
    String ruta;

    public MainWindow() {
        super("Renta de Peliculas");

        Archivo archivo = new Archivo();

        String path = archivo.fileChoooserData();
        this.ruta = path;
        this.setSize(800, 600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.desktopPane = new JDesktopPane();
        this.desktopPane.setLayout(null);
        this.init();
        this.add(this.desktopPane);
        this.setVisible(true);
    } //constructor

    public void init() {
        this.jmbMenu = new JMenuBar();
        this.setJMenuBar(this.jmbMenu);

        this.jmOpciones = new JMenu("Menu");
        this.jmbMenu.add(this.jmOpciones);

        this.jmiInsertarPelicula = new JMenuItem("Insetar Pelicula");
        this.jmiInsertarPelicula.addActionListener(this);
        this.jmOpciones.add(this.jmiInsertarPelicula);

        this.jmiBuscarPelicula = new JMenuItem("Buscar Pelicula");
        this.jmiBuscarPelicula.addActionListener(this);
        this.jmOpciones.add(this.jmiBuscarPelicula);

        this.jmiBuscar = new JMenuItem("Buscar Pelicula por nombre");
        this.jmiBuscar.addActionListener(this);
        this.jmOpciones.add(this.jmiBuscar);

        this.jmiListaGeneral = new JMenuItem("listado General");
        this.jmiListaGeneral.addActionListener(this);
        this.jmOpciones.add(this.jmiListaGeneral);

    }//init

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.jmiInsertarPelicula) {
            InsertMovie insert = new InsertMovie(ruta);
            insert.setFocusable(true);
            insert.setVisible(true);
            this.desktopPane.add(insert);
        } else if (e.getSource() == this.jmiBuscarPelicula) {
            SearchMovie search = new SearchMovie(ruta);
            search.setFocusable(true);
            search.setVisible(true);
            this.desktopPane.add(search);
        } else if (e.getSource() == this.jmiBuscar) {
            MuestraUnaPelicula muestra = new MuestraUnaPelicula(ruta);
            muestra.setFocusable(true);
            muestra.setVisible(true);
            this.desktopPane.add(muestra);
        } else if (e.getSource() == this.jmiListaGeneral) {
            ListadoGeneral general = new ListadoGeneral(ruta);
            general.setFocusable(true);
            general.setVisible(true);
        }//if-else
    }//actionPerformed(ActionEvent e) 
}//fin clase
