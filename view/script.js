document.addEventListener("DOMContentLoaded", function () {
    buscarContatos();
});

function buscarContatos() {
    fetch("http://localhost:8080/contato")
        .then(response => response.json()) 
        .then(contatos => {
            const tabela = document.getElementById("tabela-cliente-contatos");
            tabela.innerHTML = "";

            contatos.forEach(contato => {
                let cliente = contato.cliente ? contato.cliente : {};
                
                let row = `
                    <tr>
                        
                        <td class="linhaListagem">${cliente.nome ? cliente.nome : "Desconhecido"}</td>
                        <td class="linhaListagem">${cliente.cpf ? cliente.cpf : "Não informado"}</td>
                        <td class="linhaListagem">${cliente.dataNascimento ? cliente.dataNascimento : "Não informado"}</td>
                        <td class="linhaListagem">${cliente.endereco ? cliente.endereco : "Não informado"}</td>
                        
                        <td class="linhaListagem">${contato.tipo}</td>
                        <td class="linhaListagem">${contato.valor}</td>
                        <td class="linhaListagem">${contato.observacao ? contato.observacao : "Nenhuma"}</td> 
                    </tr>
                `;
                tabela.innerHTML += row;
            });
        })
        .catch(error => console.error("Erro ao buscar contatos:", error));
}
