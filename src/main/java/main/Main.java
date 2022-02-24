package main;

import cards.Card;
import cards.ListaDeCards;
import java.util.Scanner;

/*
@Author Lucas Hideki Abe
 */

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListaDeCards lista = new ListaDeCards();

        /*
        //loop de cadastro
        int x = 1;
        while(x != 0){
            cadastro(lista, sc);
            System.out.println("Para encerrar o cadastro, digite 0! Para continuar, digite qualquer outro numero!");
            x = sc.nextInt();
            sc.nextLine();
        }

         */

        lista.popularCards();
        lista.listagemDeCards();

        System.out.println("Digite o titulo de um card para ser apagado: ");
        String cardASerApagado = sc.nextLine();
        Card encontrado = lista.encontraPorTitulo(cardASerApagado);
        lista.deletaCard("Tarefa 1");

        lista.listagemDeCards();

        sc.close();
    }

    public static void cadastro(ListaDeCards lista, Scanner sc){

            System.out.println("Criando nova tarefa");
            System.out.print("Título da tarefa: ");
            String titulo = sc.nextLine();
            System.out.print("Categoria: ");
            String categoria = sc.nextLine();
            System.out.print("Descrição: ");
            String descricao = sc.nextLine();
            System.out.print("Prioridade(de 1 a 5): ");
            int prioridade = sc.nextInt();
            sc.nextLine();

            Card card = new Card(titulo, categoria, descricao, prioridade, false, null);
            lista.cadastroDeCard(card);

        }
    }


