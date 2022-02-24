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

    @Test
    public void testCadastroDeCard(){
        ListaDeCards lista = new ListaDeCards();
        Card cardNovo = new Card("Cadastro de Card", null, null,
                null, null, null);
        lista.cadastroDeCard(cardNovo);

        Assert.assertEquals(lista.encontraPorTitulo("Cadastro de Card"), cardNovo);

    }

    @Test
    public void testEncontraPorTitulo(){
        ListaDeCards lista = new ListaDeCards();
        Card cardNovo = new Card("Tarefa Encontrada", null, null,
                null, null, null);
        lista.getLista().add(cardNovo);
        Assert.assertEquals(lista.encontraPorTitulo("Tarefa Encontrada"), cardNovo);

    }

    @Test
    public void testDeletaCard(){
        ListaDeCards lista = new ListaDeCards();
        lista.deletaCard("Tarefa 2");

        Assert.assertNull(lista.encontraPorTitulo("Tarefa 2"));
    }

    /*
    Aplicando o TDD nesse método
     */
    @Test
    public void testAtualizaCard(){
        ListaDeCards lista = new ListaDeCards();
        lista.popularCards();

        Card cardAtualizado = new Card("novo titulo", "Categoria nova", "Descrição nova",
                5, false, "02/02/2022");

        lista.atualizaCard("Tarefa 1", cardAtualizado);

        Assert.assertEquals(cardAtualizado.getNome(), lista.encontraPorTitulo("novo titulo").getNome());
    }

}
