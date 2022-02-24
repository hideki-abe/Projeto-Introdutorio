package cards;

import java.time.LocalDate;

public class Card {

    private String titulo;
    private String descricao;
    private Integer prioridade;
    //O status false significa que a atividade não foi concluída
    private Boolean status;
    private String prazo;
    private String categoria;

    public Card(){

    }

    public Card(String titulo, String categoria, String descricao, Integer prioridade, Boolean status, String prazo) {
        this.titulo = titulo;
        this.categoria = categoria;
        this.descricao = descricao;
        this.prioridade = prioridade;
        this.status = status;
        this.prazo = prazo;
    }

    public String getNome() {
        return titulo;
    }

    public void setNome(String nome) {
        this.titulo = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public Integer getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Integer prioridade) {
        this.prioridade = prioridade;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public void setPrazo(String prazo) {
        this.prazo = prazo;
    }

    public String getPrazo() {
        return prazo;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getCategoria() {
        return categoria;
    }

    /*
              Listagem de Cards
            */
    @Override
    public String toString() {
        return "main.java.cards.Card{" +
                "nome='" + titulo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", categoria='" + categoria +
                ", prioridade=" + prioridade +
                ", status=" + status +
                ", prazo='" + prazo + '\'' +
                '}';
    }
}
