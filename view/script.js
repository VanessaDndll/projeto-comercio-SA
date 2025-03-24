document.addEventListener("DOMContentLoaded", function () {
    buscarClienteContato();
});

function buscarClienteContato() {
    fetch("http://localhost:8080/cliente")
        .then(response => response.json())

        .then(clientes => {
            console.log(clientes);

            const tabela = document.getElementById("tabela-cliente-contatos");
            tabela.innerHTML = "";

            clientes.forEach(cliente => {
                console.log("cliente: ", cliente);

                if (cliente.contatos.length > 0) {
                    cliente.contatos.forEach(contato => {
                        tabela.innerHTML += `
                            <td class="linhaListagem">${cliente.nome}</td>
                            <td class="linhaListagem">${cliente.cpf}</td>
                            <td class="linhaListagem">${cliente.dataNascimento}</td>
                            <td class="linhaListagem">${cliente.endereco}</td>
                        
                            <td class="linhaListagem">${contato.tipo}</td>
                            <td class="linhaListagem">${contato.valor}</td>
                            <td class="linhaListagem">${contato.observacao}</td>
                        `;
                    });

                } else {
                    tabela.innerHTML += `
                        <td class="linhaListagem">${cliente.nome}</td>
                        <td class="linhaListagem">${cliente.cpf}</td>
                        <td class="linhaListagem">${cliente.dataNascimento}</td>
                        <td class="linhaListagem">${cliente.endereco}</td>

                        <td class="linhaListagem">-</td>
                        <td class="linhaListagem">-</td>
                        <td class="linhaListagem">-</td>
                    `
                }

            });
        })
        .catch(error => console.error("Erro ao buscar clientes:", error));
}
