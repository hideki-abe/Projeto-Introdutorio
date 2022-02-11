import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ListaDeCards lista = new ListaDeCards();

        cadastroDeCard(lista, sc);
        popularCards(lista);
        listagemDeCards(lista);

        System.out.println("Digite o titulo de um card para ser apagado: ");
        String titulo = sc.nextLine();
        Card encontrado = encontraPorTitulo(titulo, lista);
        deletarCard(encontrado, lista);

        listagemDeCards(lista);

        sc.close();
    }

    public static Card encontraPorTitulo(String titulo, ListaDeCards lista){
        for (Card card: lista.getLista()) {
            if(card.getNome().equals(titulo)){
                return card;
            }
        }
        return null;
    }

    public static void deletarCard(Card encontrado, ListaDeCards lista){
        lista.getLista().remove(encontrado);
    }

    public static void cadastroDeCard(ListaDeCards lista, Scanner sc){
        int caso = 1;
        while(caso!=0){

            System.out.println("Criando Card");
            System.out.print("Título da tarefa: ");
            String titulo = sc.nextLine();
            System.out.print("Categoria: ");
            String categoria = sc.nextLine();
            System.out.print("Descrição: ");
            String descricao = sc.nextLine();
            System.out.print("Prioridade(de 1 a 5): ");
            int prioridade = sc.nextInt();

            Card card = new Card(titulo, categoria, descricao, prioridade, false, null);
            lista.getLista().add(card);

            System.out.println("Deseja criar outra tarefa? Para cancelar digite 0");
            caso = sc.nextInt();
            sc.nextLine();
        }
    }

    public static void listagemDeCards(ListaDeCards lista){
        for (Card card: lista.getLista()) {
            System.out.println(card.toString());
        }
    }

    public static void popularCards(ListaDeCards lista){
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
