function constractCard(obj){

    let tr = $('<tr id="2">')

    let codice = $('<th scope="row">')
    let marca = $('<td id="marca">')
    let nome = $('<td id="nome">')
    let descrizione = $('<td id="descrizione">')
    let prezzo = $('<td id="prezzo">')
    let qt = $('<td id="qt">')
    let btn = $('<td><button type="submit">Elimina</button></td>')


    $(codice).html(obj.codiceTel)
    $(marca).html(obj.marca)
    $(nome).html(obj.nome)
    $(descrizione).html(obj.descrizione)
    $(prezzo).html(obj.prezzo)
    $(qt).html(obj.quantita)


    $(tr).append(codice)
    $(tr).append(marca)
    $(tr).append(nome)
    $(tr).append(descrizione)
    $(tr).append(prezzo)
    $(tr).append(qt)
    $(tr).append(btn)





    return tr;

}