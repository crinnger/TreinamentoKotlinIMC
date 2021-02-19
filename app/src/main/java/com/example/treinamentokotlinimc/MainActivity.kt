package com.example.treinamentokotlinimc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.w("lifecicle","CREATE - Iniciou o aplicativo")
        setListener()
    }

    override fun onStart() {
        super.onStart()
        Log.w("lifecicle","START - tela visivel")
    }

    override fun onResume() {
        super.onResume()
        Log.w("lifecicle","RESUME - tela pode interagir")
    }

    override fun onPause() {
        super.onPause()
        Log.w("lifecicle","PAUSE - tela perdeu foco nao pode interagir")
    }

    override fun onStop() {
        super.onStop()
        Log.w("lifecicle","STOP - tela nao visivel mas existe")
    }

    override fun onRestart() {
        super.onRestart()
        Log.w("lifecicle","RESTART - tela retornando foco")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.w("lifecicle","DESTROY - Aplicacao fechada")
    }

    private fun setListener(){
/**       altura.doAfterTextChanged {text ->
            Toast.makeText(this,text.toString(),Toast.LENGTH_SHORT).show()
        }

        peso.doOnTextChanged { text, start, before, count ->
            titulo.setText(text)
        } **/
        Log.w("Validacao","no Set listener")
        buttonCalcular.setOnClickListener {
            val pesoC = peso.getText().toString().toFloatOrNull()
            val alturaC = altura.getText().toString().toFloatOrNull()
            Log.w("Validacao","Peso:$pesoC altura:$alturaC")
            if(pesoC !=null && alturaC !=null){
                val imc = pesoC/(alturaC * alturaC)
                titulo.setText("Seu IMC é ${imc.toString()}")
            }
        }
    }
}