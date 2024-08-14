
/* Efeito de Rolagem da barra de navegação */
let navBar = document.querySelector('#header')

document.addEventListener('scroll', ()=>{
    let = scrollTop = window.scrollY

    if(scrollTop > 0){
        navBar.classList.add('rolar')
    } else{
        navBar.classList.remove('rolar')
    }


})