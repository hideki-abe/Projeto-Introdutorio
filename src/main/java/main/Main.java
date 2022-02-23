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

        lista.cadastroDeCard();
        lista.popularCards(lista);
        lista.listagemDeCards(lista);

        System.out.println("Digite o titulo de um card para ser apagado: ");
        String titulo = sc.nextLine();
        Card encontrado = lista.encontraPorTitulo(titulo, lista);
        lista.deletarCard(encontrado, lista);

        lista.listagemDeCards(lista);

        sc.close();
    }
}
