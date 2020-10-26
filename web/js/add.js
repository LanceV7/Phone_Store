$.getJSON("prova", function (json) {

    $.each(json, function() {
        $("#main").append(constractCard(this))

    })
})
function constractCard(obj){
    let card = $('<div class = "card">')
    let cardimg =$('<img class="card-img-top">')
    let cardb=$('<div class="card-body">')
    let cardtit=$('<h5 class="card-title">')
    let cardtxt= $('<p class="card-text">')
    let cardul= $('<ul class="list-group list-group-flush">')
    let carddisp= $('<li class="list-group-item">')
    let cardprice= $('<li class="list-group-item">')
    let cardbody2=$('<div class="card-body">')
    let cardadd=$('<a class="card-link 1" ><i class="fas fa-shopping-cart"></i>AGGIUNGI</a>')
    let cardbuy=$('<a class="card-link 2" >ACQUISTA</a>')

    $(cardimg).attr("src",obj.foto)
    $(cardtit).html(obj.marca)
    $(cardtxt).html(obj.descrizione)
    $(carddisp).html(obj.quantita)
    $(cardprice).html(obj.prezzo)

    $(cardb).append(cardtit)
    $(cardb).append(cardtxt)

    $(cardul).append(carddisp)
    $(cardul).append(cardprice)

    $(cardbody2).append(cardadd)
    $(cardbody2).append(cardbuy)

    $(card).append(cardimg)
    $(card).append(cardb)
    $(card).append(cardul)
    $(card).append(cardbody2)

    return card;
}
