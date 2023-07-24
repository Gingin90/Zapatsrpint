package com.example.zapatsrpint

import android.content.ClipData.Item

 class Zapatilla {
    companion object {
        fun ListZapatilla(): List<Zapatilla> {
            val zapatilla = mutableListOf<Item>()

            val zapatillaItem1 = Item("Zapato 1","https://example.com/zapato1.jpg",99.99)
            zapatilla.add(zapatillaItem1)
            val zapatillaItem2 = Item("Zapato 2", "https://example.com/zapato2.jpg",79.99)
            zapatilla.add(zapatillaItem2)
            val zapatillaItem3 = Item("Zapato 3", "https://example.com/zapato3.jpg",149.99)
            zapatilla.add(zapatillaItem3)
            val zapatillaItem4 = Item("Zapato 4", "https://example.com/zapato4.jpg",129.99)
            zapatilla.add(zapatillaItem4)
            val zapatillaItem5 = Item("Zapato 5", "https://example.com/zapato5.jpg", 109.99)
            zapatilla.add(zapatillaItem5)
            val zapatillaItem6 = Item("Zapato 6", "https://example.com/zapato6.jpg", 89.99)
            zapatilla.add(zapatillaItem6)
            val zapatillaItem7 = Item("Zapato 7", "https://example.com/zapato7.jpg", 199.99)
            zapatilla.add(zapatillaItem7)
            val zapatillaItem8 = Item("Zapato 8", "https://example.com/zapato8.jpg", 169.99)
            zapatilla.add(zapatillaItem8)
            val zapatillaItem9= Item("Zapato 9", "https://example.com/zapato9.jpg",119.99)
            zapatilla.add(zapatillaItem9)
            val zapatillaItem10 = Item("Zapato 10", "https://example.com/zapato10.jpg", 149.99)
            zapatilla.add(zapatillaItem10)
            return ListZapatilla()
        }
    }
