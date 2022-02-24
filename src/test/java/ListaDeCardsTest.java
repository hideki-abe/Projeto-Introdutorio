import cards.Card;
import cards.ListaDeCards;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashSet;

public class ListaDeCardsTest {

    private static final LinkedHashSet<Card> listaTeste = new LinkedHashSet<>();

    public ListaDeCardsTest(){
        ListaDeCards lista = new ListaDeCards();
        lista.popularCards();
        listaTeste.addAll(lista.getLista());
    }



    @Test
    public void testCadastroDeCard(){

    }

    @Ignore
    public void testEncontraPorTitulo(){

    }

    @Ignore
    public void testDeletaCard(){

    }

    /*
    Aplicando o TDD nesse método
     */
    @Test
    public void testAtualizaCard(){
        ListaDeCards lista = new ListaDeCards();

        Card cardAtualizado = new Card("novo titulo", "Categoria nova", "Descrição nova",
                5, false, null);

        Card cardAntigo = lista.encontraPorTitulo("Tarefa 1");
        lista.encontraPorTitulo("Tarefa 1").setNome(cardAtualizado.getNome());


        Assert.assertEquals(cardAtualizado.getNome(), cardAntigo.getNome());
        //lista.listagemDeCards();
    }

}
