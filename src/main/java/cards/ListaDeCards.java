package cards;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class ListaDeCards {

    private static final LinkedHashSet<Card> lista = new LinkedHashSet<>();

    public ListaDeCards(){}

    public HashSet<Card> getLista() {
        return lista;
    }

    //função para cadastrar novas tarefas(cards)
    public void cadastroDeCard(Card card){
        lista.add(card);
    }

    //função de auxílio para deletarCard que encontra um card pelo título
    public Card encontraPorTitulo(String titulo){
        for (Card card: lista) {
            if(card.getNome().equals(titulo)){
                return card;
            }
        }
        System.out.println("Card não encontrado!");
        return null;
    }

    //função para deletar um card já conhecido pelo nome
    public void deletaCard(Card encontrado){
        lista.remove(encontrado);
    }

    //função que lista todos os cards seguindo o método de ordenação do LinkedList
    public void listagemDeCards(){
        for (Card card: lista) {
            System.out.println(card.toString());
        }
    }

    //função que atualiza o card encontrado por um titulo
    public void atualizaCard(String titulo, Card cardAtualizado){
        this.encontraPorTitulo(titulo).setNome(cardAtualizado.getNome());
        this.encontraPorTitulo(titulo).setDescricao(cardAtualizado.getDescricao());
        this.encontraPorTitulo(titulo).setPrazo(cardAtualizado.getPrazo());
        this.encontraPorTitulo(titulo).setPrioridade(cardAtualizado.getPrioridade());
        this.encontraPorTitulo(titulo).setStatus(cardAtualizado.getStatus());

    }

    //função que popula cards, simulando um banco de dados
    public void popularCards(){
        LocalDate data = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");


        Card card1 = new Card("Tarefa 1","categoria", "descricao", 1, false, data.format(formatter));
        Card card2 = new Card("Tarefa 2","categoria", "descricao", 1, false, data.format(formatter));
        Card card3 = new Card("Tarefa 3", "categoria","descricao", 1, false, data.format(formatter));
        Card card4 = new Card("Tarefa 4", "categoria","descricao", 1, false, data.format(formatter));
        Card card5 = new Card("Tarefa 5", "categoria","descricao", 1, false, data.format(formatter));
        Card card6 = new Card("Tarefa 6","categoria","descricao", 1, false, data.format(formatter));

        lista.add(card1);
        lista.add(card2);
        lista.add(card3);
        lista.add(card4);
        lista.add(card5);
        lista.add(card6);

    }

}
