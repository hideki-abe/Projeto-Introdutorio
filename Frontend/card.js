export default class Card{

    #titulo;
    #categoria;
    #descricao;
    #data;
    #prioridade;
    #status;

    constructor(titulo, categoria, descricao, data, prioridade, status) {
        this.#titulo = titulo;
        this.#categoria = categoria;
        this.#descricao = descricao;
        this.#data = data;
        this.#prioridade = prioridade;
        this.#status = status;
    }

    set setTitulo(titulo){
        this.#titulo = titulo;
    }

    set setCategoria(categoria){
        this.#categoria = categoria;
    }

    set setDescricao(descricao){
        this.#descricao = descricao;
    }

    set setData(data){
        this.#data = data;
    }

    set setPrioridade(prioridade){
        this.#prioridade = prioridade;
    }

    set setStatus(status){
        this.#status = status;
    }


}