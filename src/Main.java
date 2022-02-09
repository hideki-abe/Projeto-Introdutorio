import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ListaDeCards lista = new ListaDeCards();


        int caso = 1;
        while(caso!=0){

            System.out.println("Criando Card");
            System.out.print("Título da tarefa: ");
            String titulo = sc.nextLine();
            System.out.print("Descrição: ");
            String descricao = sc.nextLine();
            System.out.print("Prioridade(de 1 a 5): ");
            int prioridade = sc.nextInt();

            Card card = new Card(titulo, descricao, prioridade, false, null);
            lista.getLista().add(card);

            System.out.println("Deseja criar outra tarefa? Para cancelar digite 0");
            caso = sc.nextInt();
            sc.nextLine();
        }

        listagemDeCards(lista);


        sc.close();
    }

    public static void listagemDeCards(ListaDeCards lista){
        for (Card card: lista.getLista()) {
            System.out.println(card.toString());
        }
    }


}
