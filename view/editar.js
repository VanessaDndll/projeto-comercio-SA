function preencherEdicao() {
    const dadosGuardados = JSON.parse(localStorage.getItem('dadosCliente'));
    console.log(dadosGuardados);
}

preencherEdicao()