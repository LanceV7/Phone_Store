
let carts = document.querySelectorAll('.card-link');


for( let i=0; i< carts.length; i++){
    carts[i].addEventListener('click', () =>{
        carNumb();
    })
}

function onLoadcartN(){
    let productNum= localStorage.getItem('carNumb');
    if(productNum){
        document.querySelector('#cart').textContent = productNum;
    }
}

function carNumb(){
    let productNum= localStorage.getItem('carNumb');
    productNum= parseInt(productNum);
    if(productNum){
        localStorage.setItem('carNumb', productNum + 1);
        document.querySelector('#cart').textContent =productNum + 1;
    }else {
        localStorage.setItem('carNumb', 1);
        document.querySelector('#cart').textContent = 1;
    }
}
onLoadcartN();