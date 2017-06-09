package GUI;

import Data.Archivo;
import Data.ListaCircular;
import Data.MyNodeCountry;
import Domain.Pelicula;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hanse
 */
public class TablaMostrar extends JFrame {

    JTable jtbPrueba;
    DefaultTableModel dtmModeloPrueba;
    Pelicula peli = new Pelicula();
    Archivo ar = new Archivo();
    ListaCircular listaNueva;

    public TablaMostrar(ListaCircular listaImprime) {
        super("Lista de Peliculas");
        listaNueva = listaImprime;
        this.dispose();
        this.setSize(800, 600);
        init();
    }//construtor

    private void init() {
        this.dtmModeloPrueba = new DefaultTableModel();
        this.dtmModeloPrueba.addColumn("Codigo");
        this.dtmModeloPrueba.addColumn("Titulo");
        this.dtmModeloPrueba.addColumn("Genero");
        this.dtmModeloPrueba.addColumn("Total");
        this.dtmModeloPrueba.addColumn("Subtitulo");
        this.dtmModeloPrueba.addColumn("Premier");
        MyNodeCountry head = null;
        MyNodeCountry tail = listaNueva.getTail();
        int size = 0;
        MyNodeCountry temp = listaNueva.getHead();
        if (tail != null) {
            while (temp != tail) {
                this.dtmModeloPrueba.addRow(new Object[]{temp.getPelicula().getCode(), temp.getPelicula().getTitle(),
                    temp.getPelicula().getGendeer(), temp.getPelicula().getTotal(), temp.getPelicula().getSubtitle(),
                    temp.getPelicula().getPremier()});
                temp = temp.getNext();
            }//while
            if (temp == tail) {
                this.dtmModeloPrueba.addRow(new Object[]{temp.getPelicula().getCode(), temp.getPelicula().getTitle(),
                    temp.getPelicula().getGendeer(), temp.getPelicula().getTotal(), temp.getPelicula().getSubtitle(),
                    temp.getPelicula().getPremier()});
            }//if
            this.jtbPrueba = new JTable(this.dtmModeloPrueba);
            JScrollPane scrollPane = new JScrollPane(this.jtbPrueba);
            this.getContentPane().add(scrollPane);
        }//if
    } // init
} // fin clase
