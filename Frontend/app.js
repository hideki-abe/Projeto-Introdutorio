import Card from "./card.js";
import ListaDeCards from "./listaDeCards.js";

const titulo = document.querySelector("#titulo");
const categoria = document.querySelector("#categoria");
const descricao = document.querySelector("#descricao");
const prazo = document.querySelector("#data");
const prioridade = document.querySelector("#prioridade");
const botaoCadastra = document.querySelector("#submit");
const cards = document.getElementById("cards");


const lista = new ListaDeCards();

console.log(lista.cards);

botaoCadastra.addEventListener('click', function(){

    criaCard()
    
});

function cadastraCard(){
    //constructor(titulo, categoria, descricao, data, prioridade, status) 
    const card = new Card(titulo.value, categoria.value, descricao.value, data.value, prioridade.value, false);

    lista.adicionaCard(card);

}

function deletaCard(){
    console.log("Deletei o card");

}


function criaCard(){

    const novoCard = document.createElement("div");
    novoCard.setAttribute("class", "card_cadastrado");

    const data = document.createElement("div");
    data.setAttribute("id", "data_cadastrada");
    data.textContent = prazo.value;
    novoCard.appendChild(data);

    const novoTitulo = document.createElement("div");
    novoTitulo.setAttribute("id", "titulo_cadastrado");
    novoTitulo.textContent = titulo.value;
    novoCard.appendChild(novoTitulo);

    
    const novaCategoria = document.createElement("div");
    novaCategoria.setAttribute("id", "categoria_cadastrada");
    novaCategoria.textContent = categoria.value;
    novoCard.appendChild(novaCategoria);

    const novaDescricao = document.createElement("div");
    novaDescricao.setAttribute("id", "descricao_cadastrada");
    novaDescricao.textContent = descricao.value;
    novoCard.appendChild(novaDescricao);
    
    const novaPrioridade = document.createElement("div");
    novaPrioridade.setAttribute("id", "prioridade_cadastrada");
    novaPrioridade.textContent = "Prioridade: " + prioridade.value;
    novoCard.appendChild(novaPrioridade);


    const novoStatus = document.createElement("div");
    novoStatus.setAttribute("id", "status_cadastrado");
    novoStatus.textContent = "Status: A fazer";
    novoCard.appendChild(novoStatus);
    

    let lixo = document.createElement("img");
    lixo.src = "./imagens/lixo.png";
    lixo.setAttribute("id", "icon_lixo");
    lixo.addEventListener("click", () => deletaCard())
    novoCard.appendChild(lixo);

    let editor = document.createElement("img");
    editor.src = "./imagens/editar.png";
    editor.setAttribute("id", "icon_editar");
    novoCard.appendChild(editor);


    let alfinete = document.createElement("img");
    alfinete.src = "./imagens/alfinete.png";
    alfinete.setAttribute("id", "icon_alfinete");
    novoCard.appendChild(alfinete);

    cards.appendChild(novoCard);

    cadastraCard();

}



window.addEventListener("keypress", (e) => {
    if(e.key === "Enter"){
        criaCard();
        console.log("Cadastro de card realizado com sucesso!")
    }
});