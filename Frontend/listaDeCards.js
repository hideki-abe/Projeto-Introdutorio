export default class ListaDeCards{
    
    #cards;


    constructor(){
        this.#cards = [];
    }

    adicionaCard(card){
        this.#cards.push(card);
    }

    removeCard(card){
        var index = this.#cards.indexOf(card);
        this.#cards.splice(index);
    }

    get cards(){
        return this.#cards;
    }

    set cards(cards){
        this.#cards = cards;
    }


}