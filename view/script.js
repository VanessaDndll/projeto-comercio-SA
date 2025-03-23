document.addEventListener("DOMContentLoaded", function () {
    buscarContatos();
});

function buscarContatos() {
    fetch("http://localhost:8080/contato")
        .then(response => response.json()) 

        /**
         * Tarefa de casa:
         * - Fazer com que a tabela mostre sempre todos os clientes.
         * - Caso o cliente tenha mais de um contato, adicionar fileiras extras.
         * Dica: pensar no comprimento do array contato e criar novas fileiras baseado nele
         * [contato1, contato2, contato3...]
         */

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
                        
                        <td class="linhaListagem">${contato && contato.tipo ? contato.tipo : "-"}</td>
                        <td class="linhaListagem">${contato && contato.valor ? contato.valor : "-"}</td>
                        <td class="linhaListagem">${contato && contato.observacao ? contato.observacao : "-"}</td> 
                    </tr>
                `;
                tabela.innerHTML += row;
            });
        })
        .catch(error => console.error("Erro ao buscar contatos:", error));
}
