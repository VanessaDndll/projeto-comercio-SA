const dados = {
    id: null,
    cpf: null,
    nome: null,
    dataNascimento: null,
    endereco: null,
    contatos: null
};

const nome = document.getElementById("nomeResult");
const cpfResult = document.getElementById("cpfResult");
const dataNascimento = document.getElementById("dataNascimento");
const endereco = document.getElementById("enderecoResult");

let editando = false;

// FUNCTION DE BUSCAR CLIENTE
async function buscarCliente() {
    const cpf = document.getElementById("cpf").value

    try {
        const response = await fetch(`http://localhost:8080/cliente/buscar?cpf=${cpf}`);
        const data = await response.json();

        console.log("Resposta da API:", data);

        if (!data) {
            alert("Nenhum cliente encontrado.");
        }

        dados.id = data.id;
        dados.cpf = data.cpf;
        dados.nome = data.nome;
        dados.dataNascimento = data.dataNascimento;
        dados.endereco = data.endereco;
        dados.contatos = data.contatos;

        preencherTabela(data);
    } catch (error) {
        alert("Cliente não encontrado.")
        console.error("Erro ao buscar cliente:", error);
    }
}

// FUNCTION PARA PREENCHER COM OS DADOS
function preencherTabela(cliente) {
    nome.value = cliente.nome;
    cpfResult.value = cliente.cpf;
    dataNascimento.value = cliente.dataNascimento;
    endereco.value = cliente.endereco;

    const contatosTabela = document.getElementById("contatosCliente");
    contatosTabela.innerHTML = "";

    if (cliente.contatos && cliente.contatos.length > 0) {
        contatosTabela.innerHTML += "<h4>Contatos</h4>"
        cliente.contatos.forEach(contato => {
            const row = `
            <div class='contato'>
                <br><hr><br>
                <p>Tipo: <input type='text' name='tipo' value='${contato.tipo}' readonly></p>
                <p>Contato: <input type='text' name='valor' value='${contato.valor}' readonly></input type='text' readonly></p>
                <p>Observação: <input type='text' name='observacao' value='${contato.observacao || 'Sem observação'}' readonly></input type='text' readonly></p>
            </div>
            `;
            contatosTabela.innerHTML += row;
        });
    } else {
        contatosTabela.innerHTML = "<p>Nenhum contato encontrado<p>";
    }
}

// MOSTRAR FORM EDITAR
function editar() {
    const resultadoBusca = document.querySelector('.resultadoBusca');
    const inputsForm = resultadoBusca.querySelectorAll('input');

    if (editando === true) {
        editando = false;
        inputsForm.forEach(input => input.readOnly = true);
    } else {
        editando = true;
        inputsForm.forEach(input => input.readOnly = false);
    }

    trocarBotao()
}

// FUNCTION DO buttonSalvar PARA SALVAR A EDICAO
function salvarEdicao() {

    dados.nome = document.querySelector('#nomeResult').value
    dados.cpf = document.querySelector('#cpfResult').value
    dados.dataNascimento = document.querySelector('#dataNascimento').value
    dados.endereco = document.querySelector('#enderecoResult').value

    console.log('dados: ', dados);

    const arrayDeContatos = [];

    const todosOsContatos = document.querySelectorAll('.contato');


    for (let i = 0; i < todosOsContatos.length; i++) {
        console.log(todosOsContatos[i]);
        const tipoInput = todosOsContatos[i].querySelector("input[name='tipo']");
        const valorInput = todosOsContatos[i].querySelector("input[name='valor']");
        const observacaoInput = todosOsContatos[i].querySelector("input[name='observacao']");

        const contatoASalvar = {};
        contatoASalvar.tipo = tipoInput.value;
        contatoASalvar.valor = valorInput.value;
        contatoASalvar.observacao = observacaoInput.value;
        arrayDeContatos.push(contatoASalvar);
    }

    dados.contatos = arrayDeContatos;

    console.log("Enviando este objeto para salvar: ", dados);
    

    fetch(`http://localhost:8080/cliente/${dados.id}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(dados)
    });
    alert("Dados do cliente atualizado com sucesso.");
}

// FUNCTION DO buttonExcluir PARA EXCLUIR O CLIENTE E SEUS CONTATOS
function excluir() {
    let confirmacao = confirm("Deseja excluir o cliente e todos os seus contatos?");
    if (confirmacao === true) {
        fetch(`http://localhost:8080/cliente/${dados.id}`, {
            method: "DELETE",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({})
        })
        .then(() => alert("Deletado com sucesso"))
        .catch((err) => console.error("Falha ao deletar pessoa: ", err))
    }
}

// FUNCTION PARA TROCAR ENTRE buttonSalvar E buttonExcluir
function trocarBotao() {
    const excluirBtn = document.querySelector('#buttonExcluir');
    const salvarBtn = document.querySelector('#buttonSalvar');
    if (excluirBtn.style.display === 'none') {
        excluirBtn.style.display = 'block';
        salvarBtn.style.display = 'none'
    } else {
        excluirBtn.style.display = 'none'
        salvarBtn.style.display = 'block'
    }
}