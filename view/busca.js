async function buscarCliente() {
    const nome = document.getElementById("nome").value;
    const cpf = document.getElementById("cpf").value;

    try {
        const response = await fetch(`http://localhost:8080/cliente/buscar?nome=${nome}&cpf=${cpf}`);
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
    const tabela = document.querySelector("#resultado tbody"); 
    if (!tabela) {
        console.error("Erro: tabela-clientes não encontrada no HTML.");
        return;
    }

    tabela.innerHTML = ""; 

    if (!cliente.contatos || cliente.contatos.length === 0) {
        console.warn("Cliente encontrado, mas sem contatos cadastrados.", cliente);
    }

    const contatos = cliente.contatos || [];

    const telefones = contatos
        .filter(c => c.tipo && c.tipo.toLowerCase() === "telefone")
        .map(c => c.valor)
        .join(", ") || "-";

    const emails = contatos
        .filter(c => c.tipo && c.tipo.toLowerCase() === "email")
        .map(c => c.valor)
        .join(", ") || "-";

    const observacoes = contatos
        .map(c => c.observacao || "-")
        .join(", ") || "-";

    const row = `
        <tr>
            <td>${cliente.nome}</td>
            <td>${cliente.cpf}</td>
            <td>${cliente.dataNascimento}</td>
            <td>${cliente.endereco}</td>
            <td>${telefones}</td>
            <td>${emails}</td>
            <td>${observacoes}</td>
        </tr>
    `;

    tabela.innerHTML += row;
}