package com.example.appdogcats

import java.util.*

open class Producto {
    var id: Int?
    var brand: String
    var model: String
    var stock: String?
    var type: String?


    constructor(id: Int?, brand: String, model: String, stock: String?, type: String?) {
        this.id = id
        this.brand= brand
        this.model = model
        when(stock){
            null -> this.stock = "NA"
            else -> this.stock = stock
        }

        this.type = type
    }
}