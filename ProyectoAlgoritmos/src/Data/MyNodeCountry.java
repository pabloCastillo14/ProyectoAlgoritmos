package Data;

import Domain.Pelicula;

/**
 *
 * @author hanse
 */
public class MyNodeCountry {

    Pelicula pelicula;
    MyNodeCountry next;
    MyNodeCountry prev;

    public MyNodeCountry(Pelicula dato) {
        this.pelicula = dato;
        this.next = null;
        this.prev = null;
    }//constructor

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public MyNodeCountry getNext() {
        return next;
    }

    public void setNext(MyNodeCountry next) {
        this.next = next;
    }

    public MyNodeCountry getPrev() {
        return prev;
    }

    public void setPrev(MyNodeCountry prev) {
        this.prev = prev;
    }

}
