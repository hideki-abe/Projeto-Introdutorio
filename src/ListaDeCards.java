import java.util.HashSet;

public class ListaDeCards {

    private HashSet<Card> lista = new HashSet<>();


    public ListaDeCards(){}
    public ListaDeCards(HashSet<Card> lista) {
        this.lista = lista;
    }

    public HashSet<Card> getLista() {
        return lista;
    }

    public void setLista(HashSet<Card> lista) {
        this.lista = lista;
    }


}
