import java.time.LocalDate;

public class Card {

    private String nome;
    private String descricao;
    private Integer prioridade;
    //O status false significa que a atividade não foi concluída
    private Boolean status;
    private String prazo;
    private String categoria;


    public Card(String nome, String categoria, String descricao, Integer prioridade, Boolean status, String prazo) {
        this.nome = nome;
        this.categoria = categoria;
        this.descricao = descricao;
        this.prioridade = prioridade;
        this.status = status;
        this.prazo = prazo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    /*
    Listagem de Cards
     */

    @Override
    public String toString() {
        return "Card{" +
                "nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", categoria='" + categoria +
                ", prioridade=" + prioridade +
                ", status=" + status +
                ", prazo='" + prazo + '\'' +
                '}';
    }
}
