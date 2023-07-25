package com.example.zapatsrpint

 class Presenter(private val view: IviewPresenter) {
    private  var modelo:Model = Model()

    fun guardarData(
        nombre:String,
        img:String,
        precio:Double
    ) {
        val zapato = Zapatio(nombre, img, precio)
        val zapatos = modelo.guardarData(zapato)
        view.guardarData(zapatos)
    }}