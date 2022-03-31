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

botaoCadastra.addEventListener('click', function(event){

    event.preventDefault();
    criaCard();

});

//implementação do REGEX
function validaData(){
    let data = new Date(),
    dia  = data.getDate().toString().padStart(2, '0'),
    mes  = (data.getMonth()+1).toString().padStart(2, '0'),
    ano  = data.getFullYear();


    const dataRegex = `${ano}-${mes}-${dia}`;

    const dataSplit = dataRegex.split(/-/);
    
    const prazoSplit = prazo.value.split(/-/);

    //ano atual < ano do prazo
    if((prazoSplit[0] < dataSplit[0])){
        alert("Data inválida!");
        return false;
    } else 
    //com o ano já validado, se o ano for o mesmo, o mês não pode ser menor que o do prazo
    if (prazoSplit[0] == dataSplit[0] && prazoSplit[1] < dataSplit[1]){
        alert("Data inválida!");
        return false;
    }else 
    //se o ano e mês forem iguais, o dia do prazo terá que ser igual ou maior que a data atual
    if(prazoSplit[0] == dataSplit[0] && prazoSplit[1] == dataSplit[1] && prazoSplit[2] < dataSplit[2]){
        alert("Data inválida!");
        return false;
    }else {
        return true;
    }

}

//Caso mudem o range da prioridade diretamente no html
function validaPrioridade(){

    const regex = /[1-9]{1}/g;
    
    console.log(prioridade.value.match(regex) !== null)
    

    if(prioridade.value.match(regex) !== null){
        if(prioridade.value.match(regex)[0] >= 1 && prioridade.value.match(regex)[0] <= 5 ){
            return true;
        } else {
            alert("Prioridade inválida!");
            return false;
        }
    } else{
        alert("Prioridade inválida!");
    }

    

}


function cadastraCard(){

    if(validaData() && validaPrioridade()){
        //constructor(titulo, categoria, descricao, data, prioridade, status) 
    const card = new Card(titulo.value, categoria.value, descricao.value, data.value, prioridade.value, false);

    lista.adicionaCard(card);
    return(lista.cards.length);
    } 

}

function deletaCard(index, novoCard){
    lista.removeCard(lista.cards[index]);
    cards.removeChild(novoCard);
    console.log("Deletei o card: " + index);

}

//Para editar um card, clique no ícone de edição e depois edite o que quiser. Após, aperte enter para 
//confirmar as edições.
function editaCard(index, novoCard){
    console.log("Editei o card: " + index);
    const children = novoCard.childNodes;
    
    children.forEach(element => {
        element.setAttribute("contenteditable", true);
    
    });

    window.addEventListener("keypress", (e) => {
        if(e.key === "Enter"){
            children.forEach(element => {
                element.setAttribute("contenteditable", false);
            })

        }
    });
    

}


function criaCard(){

    if(validaData() && validaPrioridade()){

        const index = cadastraCard();

        //Não permite mais que 9 cards
        if(index > 9){
            return;
        }

        const novoCard = document.createElement("div");
        novoCard.setAttribute("class", "card_cadastrado");

        const data = document.createElement("div");
        data.setAttribute("id", "data_cadastrada");
        //data.setAttribute("contenteditable", true);
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
        novoStatus.textContent = "Status: ";
        const checkbox = document.createElement("input");
        checkbox.type = "checkbox";
        checkbox.setAttribute("class", "checkbox");
        novoStatus.appendChild(checkbox);
        novoCard.appendChild(novoStatus);
        

        let lixo = document.createElement("img");
        lixo.src = "./imagens/lixo.png";
        lixo.setAttribute("id", "icon_lixo");
        lixo.addEventListener("click", () => deletaCard(index, novoCard))
        novoCard.appendChild(lixo);

        let editor = document.createElement("img");
        editor.src = "./imagens/editar.png";
        editor.setAttribute("id", "icon_editar");
        editor.addEventListener("click", () => editaCard(index, novoCard));
        novoCard.appendChild(editor);


        let alfinete = document.createElement("img");
        alfinete.src = "./imagens/alfinete.png";
        alfinete.setAttribute("id", "icon_alfinete");
        novoCard.appendChild(alfinete);

        cards.appendChild(novoCard);

    } else {
        return;
    }
}
