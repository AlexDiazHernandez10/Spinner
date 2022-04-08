package mx.edu.tecmm.moviles.spinner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener{
    lateinit var txtTitulo: TextView
    lateinit var  txtDescripcion: TextView
    lateinit var  spLenguajes: Spinner
    val lenguajes = arrayListOf("JAVA", "PHP","C#", "RUBY", "SWIFT")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtTitulo = findViewById(R.id.txtTitulo)
        txtDescripcion = findViewById(R.id.txtDescripcion)
        spLenguajes = findViewById(R.id.spLenguajes)
        txtDescripcion.text=""
        //Agregando datos al spinner
        val adaptador = ArrayAdapter( this,android.R.layout.simple_spinner_item,lenguajes)
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spLenguajes.adapter= adaptador
        spLenguajes.onItemSelectedListener = this
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
        Log.e("SPINNER","Se selecciono: $position")
        val lenguaje: String =lenguajes[position]
        txtTitulo.text=lenguaje
        txtDescripcion.text = when(position){
            0 ->{"Java es un lenguaje de programación interpretado, dialecto del estándar ECMAScript."}
            1 ->{"PHP es un lenguaje de programación de uso general que se adapta especialmente al desarrollo web."}
            2 ->{"C# es un lenguaje de programación multiparadigma desarrollado y estandarizado por la empresa Microsoft como parte de su plataforma .NET"}
            3 ->{"Ruby es un lenguaje de programación interpretado, reflexivo y orientado a objetos, "}
            4 ->{"Swift es un lenguaje de programación multiparadigma creado por Apple enfocado en el desarrollo de aplicaciones para iOS y macOS."}
            else -> {"Descricion"}
            }
        txtTitulo.text = lenguaje
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("Not yet implemented")
    }
}