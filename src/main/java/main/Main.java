package main.java.main;

import main.java.cards.Card;
import main.java.cards.ListaDeCards;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

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
