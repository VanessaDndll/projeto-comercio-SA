let contName = 1;

// FUNCTION PARA O BOTAO btn-adicionar-contato PARA CRIAR UMA CAIXA NOVA DE CONTATO
function adicionarContato() {
    let div = document.createElement("div");
    div.classList.add("contato-group");

    div.innerHTML = `
            <select name="tipo${contName}">
                <option value="telefone">Telefone</option>
                <option value="email">E-mail</option>
            </select>
            <input type="text" name="valor${contName}" required>
            <textarea name="observacao${contName}" ></textarea>
            <button class="btn-remover-contato" type="button" onclick="removerContato(this)">Remover</button><br><br>
        `;
    contName++;
    document.getElementById("contato").appendChild(div);
}

// FUNCTION PARA REMOVER A CAIXA DE CONTATO
function removerContato(botao) {
    botao.parentNode.remove();
}

document.getElementById("form_cadastro").addEventListener("submit", async function (event) {
    event.preventDefault();

    console.log("Enviando form");

    const cliente = {
        nome: document.getElementById("nome").value,
        cpf: document.getElementById("cpf").value,
        dataNascimento: document.getElementById("data_nascimento").value,
        endereco: document.getElementById("endereco").value,
        contato: []
    };

    let contNamePush = 1;

    document.querySelectorAll(".contato-group").forEach(group => {
        const tipo = group.querySelector(`select[name="tipo${contNamePush}"]`).value;
        const valor = group.querySelector(`input[name="valor${contNamePush}"]`).value;
        const observacao = group.querySelector(`textarea[name="observacao${contNamePush}"]`).value;
        contNamePush++;
        cliente.contato.push({
            tipo,
            valor,
            observacao
        });
    });

    try {
        const response = await fetch("http://localhost:8080/cliente/cadastrar", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(cliente)
        });
        console.log(`Conteudo sendo enviado: `, cliente);

        if (response.ok) {
            alert("Cliente cadastrado com sucesso!");
            document.getElementById("form_cadastro").reset();
            document.getElementById("contato").innerHTML = "";
        } else {
            alert("Erro ao cadastrar o cliente.");
        }
    } catch (error) {
        console.error("Erro:", error);
    }
});