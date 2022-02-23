package main.java.cards;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class ListaDeCards {

    private static final LinkedHashSet<Card> lista = new LinkedHashSet<>();

    public ListaDeCards(){}

    public HashSet<Card> getLista() {
        return lista;
    }

    //função para cadastrar novas tarefas(cards) pelo System.in
    public void cadastroDeCard(){
        Scanner sc = new Scanner(System.in);
        int caso = 1;
        while(caso!=0){

            System.out.println("Criando nova tarefa");
            System.out.print("Título da tarefa: ");
            String titulo = sc.nextLine();
            System.out.print("Categoria: ");
            String categoria = sc.nextLine();
            System.out.print("Descrição: ");
            String descricao = sc.nextLine();
            System.out.print("Prioridade(de 1 a 5): ");
            int prioridade = sc.nextInt();

            Card card = new Card(titulo, categoria, descricao, prioridade, false, null);
            lista.add(card);

            System.out.println("Deseja criar outra tarefa? Para cancelar digite 0");
            caso = sc.nextInt();
            sc.nextLine();
        }
    }

    //função de auxílio para deletarCard que encontra um card pelo título
    public Card encontraPorTitulo(String titulo, ListaDeCards lista){
        for (Card card: lista.getLista()) {
            if(card.getNome().equals(titulo)){
                return card;
            }
        }
        return null;
    }

    //função para deletar um card já conhecido pelo nome
    public void deletarCard(Card encontrado, ListaDeCards lista){
        lista.getLista().remove(encontrado);
    }

    //função que lista todos os cards seguindo o método de ordenação do LinkedList
    public void listagemDeCards(ListaDeCards lista){
        for (Card card: lista.getLista()) {
            System.out.println(card.toString());
        }
    }

    //função que popula cards, simulando um banco de dados
    public void popularCards(ListaDeCards lista){
        LocalDate data = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");


        Card card1 = new Card("Tarefa 1","categoria", "descricao", 1, false, data.format(formatter));
        Card card2 = new Card("Tarefa 2","categoria", "descricao", 1, false, data.format(formatter));
        Card card3 = new Card("Tarefa 3", "categoria","descricao", 1, false, data.format(formatter));
        Card card4 = new Card("Tarefa 4", "categoria","descricao", 1, false, data.format(formatter));
        Card card5 = new Card("Tarefa 5", "categoria","descricao", 1, false, data.format(formatter));
        Card card6 = new Card("Tarefa 6","categoria","descricao", 1, false, data.format(formatter));

        lista.getLista().add(card1);
        lista.getLista().add(card2);
        lista.getLista().add(card3);
        lista.getLista().add(card4);
        lista.getLista().add(card5);
        lista.getLista().add(card6);

    }

}
