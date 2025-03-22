async function buscarCliente() {
    const cpf = document.getElementById("cpf").value;

    try {
        const response = await fetch(`http://localhost:8080/cliente/buscar?cpf=${cpf}`);
        const data = await response.json();

        console.log("Resposta da API:", data);

        if (!data) {
            throw new Error("Nenhum cliente encontrado.");
        }

        preencherTabela(data);
    } catch (error) {
        console.error("Erro ao buscar cliente:", error);
    }
}

function preencherTabela(cliente) {
    document.getElementById("nome").innerHTML = cliente.nome;
    document.getElementById("cpf").innerHTML = cliente.cpf;
    document.getElementById("dataNascimento").innerHTML = cliente.dataNascimento;
    document.getElementById("endereco").innerHTML = cliente.endereco;

    const contatosTabela = document.getElementById("contatosCliente");
    contatosTabela.innerHTML = ""; 

    if (cliente.contatos && cliente.contatos.length > 0) {
        cliente.contatos.forEach(contato => {
            const row = `<tr>
                <td>${contato.tipo}</td>
                <td>${contato.valor}</td>
                <td>${contato.observacao || "Sem observação"}</td>
            </tr>`;
            contatosTabela.innerHTML += row;
        });
    } else {
        contatosTabela.innerHTML = "<tr><td colspan='3'>Nenhum contato encontrado</td></tr>";
    }
}