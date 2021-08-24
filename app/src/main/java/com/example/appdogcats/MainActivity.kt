package com.example.appdogcats

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import java.time.LocalDateTime
import kotlin.random.Random
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    //CONTADORES PARA LOS INDEX DE LOS LIST Y ARRAYS
    private var contCel = 0; private var contCar = 0; private var contador = 0; private var contadorID = 0
    private var bandera = ""

    private val listProd = mutableListOf<Producto>()
    private val listCel = listOf(
        Celular("Motorola", "G9 Plus", "11"),
        Celular("Samsung", "Edge", "15"),
        Celular("Huawei", "G8 Plus", null)
    )
    private val listCar = listOf(
        Auto("Chevrolet", "Spark", "150"),
        Auto("BMW", "Z4", null),
        Auto("Audi", "R8", "15")
    )

    fun makeSound(view: View) {
        when(bandera){
            "Cellphone" -> Toast.makeText(this, "Ring Ring!", Toast.LENGTH_SHORT).show()
            "Car" -> Toast.makeText(this, "Run Run!", Toast.LENGTH_SHORT).show()
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun hour(view: View) {
        val currentDateTime = LocalDateTime.now()
        Toast.makeText(this, "" + currentDateTime.hour + ":" + currentDateTime.minute, Toast.LENGTH_SHORT).show()
    }
    fun charge(view: View) {
        when(bandera){
            "Cellphone" -> Toast.makeText(this, "Charging battery!", Toast.LENGTH_SHORT).show()
            "Car" -> Toast.makeText(this, "Charging fuel!", Toast.LENGTH_SHORT).show()
        }
    }
    fun getPreviousPet(view: View) {
        contadorID -= 1
        txtInfo.text.isEmpty()
        if(contadorID >= 0){
            bandera = listProd[contadorID].type.toString()
            txtInfo.text = ("Your product is a: " + listProd[contadorID].type + " its brand is: " + listProd[contadorID].brand
                    + " its model is: " + listProd[contadorID].model
                    + " and its stock is " + listProd[contadorID].stock)
        }else{
            contadorID += 1
            Toast.makeText(this, "No Info", Toast.LENGTH_SHORT).show()
        }
    }
    fun createNewPet(view: View) {
        var random = Random.nextInt(1,10)
        bandera = ""
        if(random % 2 == 0 ){
            if((contCel < listCel.size) && (contador < 6)){
                bandera = "Cellphone"
                listCel[contCel].id = contador
                listCel[contCel].type = bandera
                txtInfo.text = ("Your product is a: " + listCel[contCel].type + " its brand is: " + listCel[contCel].brand
                        + " its model is: " + listCel[contCel].model
                        + " and its stock is " + listCel[contCel].stock)
                listProd.add(listCel[contCel])
                contadorID = listCel[contCel].id!!
                contCel += 1
                contador += 1
            }else{
                Toast.makeText(this, "No Info", Toast.LENGTH_SHORT).show()
            }
        }else{
            if(contCar < listCar.size && contador < 6){
                bandera = "Car"
                listCar[contCar].id = contador
                listCar[contCar].type = bandera
                txtInfo.text = ("Your product is a: " + listCar[contCar].type + " its brand is: " + listCar[contCar].brand
                        + " its model is: " + listCel[contCar].model
                        + " and its stock is " + listCar[contCar].stock)
                listProd.add(listCar[contCar])
                contadorID = listCel[contCar].id!!
                contCar += 1
                contador += 1
            }else{
                Toast.makeText(this, "No Info", Toast.LENGTH_SHORT).show()
            }
        }
    }
    fun getNextPet(view: View) {
        contadorID += 1
        txtInfo.text.isEmpty()
        if(contadorID < contador){
            bandera = listProd[contadorID].type.toString()
            txtInfo.text = ("Your product is a: " + listProd[contadorID].type + " its brand is: " + listProd[contadorID].brand
                    + " its model is: " + listProd[contadorID].model
                    + " and its stock is " + listProd[contadorID].stock)
        }else{
            contadorID -= 1
            Toast.makeText(this, "No Info", Toast.LENGTH_SHORT).show()
        }
    }
}
