async function buscarCliente() {
    const nome = document.getElementById("nome").value.trim();
    const cpf = document.getElementById("cpf").value.trim();

    if (!nome || !cpf) {
        alert("Por favor, preencha o nome e o CPF.");
        return;
    }

    try {
        const response = await fetch(`http://localhost:8080/cliente/buscar?nome=${nome}&cpf=${cpf}`);
        if (!response.ok) {
            throw new Error("Erro ao buscar cliente");
        }
        const cliente = await response.json();
        preencherTabela(cliente);
    } catch (error) {
        console.error("Erro ao buscar cliente:", error);
        alert("Cliente não encontrado.");
    }
}

function preencherTabela(cliente) {
    const tbody = document.querySelector("#resultado tbody");
    tbody.innerHTML = "";

    if (!cliente) {
        tbody.innerHTML = "<tr><td colspan='7'>Nenhum cliente encontrado.</td></tr>";
        return;
    }

    const telefones = cliente.contatos
        .filter(contato => contato.tipo === "telefone")
        .map(contato => contato.valor)
        .join(", ") || "Não informado";

    const emails = cliente.contatos
        .filter(contato => contato.tipo === "email")
        .map(contato => contato.valor)
        .join(", ") || "Não informado";

    const observacoes = cliente.contatos
        .map(contato => contato.observacao)
        .filter(obs => obs)
        .join(", ") || "Não informado";

    const tr = document.createElement("tr");
    tr.innerHTML = `
        <td>${cliente.nome}</td>
        <td>${cliente.cpf}</td>
        <td>${cliente.data_nascimento}</td>
        <td>${cliente.endereco}</td>
        <td>${telefones}</td>
        <td>${emails}</td>
        <td>${observacoes}</td>
    `;
    tbody.appendChild(tr);
}
