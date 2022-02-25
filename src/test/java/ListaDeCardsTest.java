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
        System.out.println("Criando ");
        ListaDeCards lista = new ListaDeCards();
        Card cardNovo = new Card("Cadastro de Card", null, null,
                null, null, null);
        System.out.println("Tarefa: \n" + cardNovo);

        lista.cadastroDeCard(cardNovo);

        Assert.assertEquals(lista.encontraPorTitulo("Cadastro de Card"), cardNovo);

        System.out.println("Criada com sucesso!");
    }

    @Test
    public void testEncontraPorTitulo(){
        System.out.println("Encontrando ");
        ListaDeCards lista = new ListaDeCards();
        Card cardNovo = new Card("Tarefa Encontrada", null, null,
                null, null, null);
        lista.getLista().add(cardNovo);
        System.out.println("Tarefa: " + lista.encontraPorTitulo("Tarefa Encontrada"));
        Assert.assertEquals(lista.encontraPorTitulo("Tarefa Encontrada"), cardNovo);

        System.out.println("Encontrada com sucesso!");
    }

    @Test
    public void testDeletaCard(){
        System.out.println("Deletando");
        ListaDeCards lista = new ListaDeCards();
        lista.cadastroDeCard(new Card("Tarefa a ser deletada", null,
                null, null, null, null));
        Card cardASerDeletado = lista.encontraPorTitulo("Tarefa a ser deletada");
        System.out.println("Tarefa: " + cardASerDeletado);

        lista.deletaCard("Tarefa a ser deletada");

        Assert.assertNull(lista.encontraPorTitulo("Tarefa 2"));
        System.out.println("Deletada com sucesso!");

    }

    /*
    Aplicando o TDD nesse método
     */
    @Test
    public void testAtualizaCard() throws Exception {
        System.out.println("Atualizando ");
        ListaDeCards lista = new ListaDeCards();
        lista.popularCards();

        Card cardAtualizado = new Card("novo titulo", "Categoria nova", "Descrição nova",
                5, false, "02/02/2022");
        System.out.println("Tarefa: " + lista.encontraPorTitulo("Tarefa 1"));
        lista.atualizaCard("Tarefa 1", cardAtualizado);

        Assert.assertEquals(cardAtualizado.getNome(), lista.encontraPorTitulo("novo titulo").getNome());
        System.out.println("Atualizada com sucesso!");
    }

}
