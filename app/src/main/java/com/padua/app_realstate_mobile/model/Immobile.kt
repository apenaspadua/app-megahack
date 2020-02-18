package com.padua.app_realstate_mobile.model

class Immobile(
    var tamanho: Int?,
    var quarto: Int?,
    var banheiro: Int?,
    var suite: String?,
    var piso: String?,
    var varanda: String?,
    var garagem: String?,
    var piscina: String?,
    var moveisImbutidos: String?,
    var bairro: String?,
    var cidade: String?,
    var estado: String?,
    var preco: Int?,
    var proprietario: String?
) {
    constructor() : this(tamanho = null, quarto = null, banheiro = null, suite = null, piso = null,
        varanda = null, garagem = null, piscina = null, moveisImbutidos = null, bairro = null,
        cidade = null, estado = null, preco = null, proprietario = null)
}