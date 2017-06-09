package Data;

import Domain.Pelicula;

/**
 *
 * @author Pablo Castillo
 */
public class ListaCircular {

    private MyNodeCountry head;
    private MyNodeCountry tail;
    private MyNodeCountry node;
    private int size;

    public ListaCircular() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }//constructor

    public void insertInOrder(Pelicula pelicula) {
        MyNodeCountry newNodeCountry = new MyNodeCountry(pelicula);
        MyNodeCountry node = this.getHead();
        while (node != null && node.getPelicula().getTitle().compareTo(newNodeCountry.getPelicula().getTitle()) < 0) {
            if (node == this.getTail()) {
                break;
            }//if
            node = node.getNext();
        }//while
        if (getSize() == 0) {
            this.setHead(newNodeCountry);
            this.setTail(newNodeCountry);
            this.getTail().setNext(this.getHead());
            this.getHead().setPrev(this.getTail());
        } else {
            if (node == this.getHead()) {
                if (node.getPelicula().getTitle().compareTo(newNodeCountry.getPelicula().getTitle()) > 0) {
                    newNodeCountry.setNext(this.getHead());
                    newNodeCountry.setPrev(this.getTail());
                    this.getHead().setPrev(newNodeCountry);
                    this.setHead(newNodeCountry);
                    this.getTail().setNext(this.getHead());
                    this.getHead().setPrev(this.getTail());
                } else {
                    newNodeCountry.setPrev(this.getHead());
                    newNodeCountry.setNext(this.getTail());
                    this.getHead().setNext(newNodeCountry);
                    this.setTail(newNodeCountry);
                    this.getTail().setNext(this.getHead());
                    this.getHead().setPrev(this.getTail());
                }//if-else
            } else {
                if (node == this.getTail() && node.getPelicula().getTitle().compareTo(newNodeCountry.getPelicula().getTitle()) < 0) {
                    newNodeCountry.setPrev(this.getTail());
                    newNodeCountry.setNext(this.getHead());
                    this.getTail().setNext(newNodeCountry);
                    this.setTail(newNodeCountry);
                    this.getHead().setPrev(this.getTail());
                    this.getTail().setNext(this.getHead());
                } else {
                    node.getPrev().setNext(newNodeCountry);
                    newNodeCountry.setPrev(node.getPrev());
                    newNodeCountry.setNext(node);
                    node.setPrev(newNodeCountry);
                }//if-else
            }//if-else
        }//if-else
        this.setSize(this.getSize() + 1);
    }//insertInOrder

    public void printList() {
        MyNodeCountry temp = this.getHead();
        System.err.print(this.getTail().getPelicula().getTitle() + "<-->"+"\n");
        if (this.getSize() > 0) {
            while (temp != this.getTail()) {
                System.err.print(temp.getPelicula().getTitle() + "<-->"+"\n");
                temp = temp.getNext();
                if (temp == this.getTail()) {
                    System.err.print(temp.getPelicula().getTitle() + "<-->"+"\n");
                }//if
            }//while
        }//if
    }// printList para pruebas

    public MyNodeCountry getHead() {
        return head;
    }

    public void setHead(MyNodeCountry head) {
        this.head = head;
    }

    public MyNodeCountry getTail() {
        return tail;
    }

    public void setTail(MyNodeCountry tail) {
        this.tail = tail;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public MyNodeCountry getNode() {
        return node;
    }

    public void setNode(MyNodeCountry node) {
        this.node = node;
    }
}
