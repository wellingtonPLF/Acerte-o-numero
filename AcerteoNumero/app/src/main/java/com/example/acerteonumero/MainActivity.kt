package com.example.acerteonumero

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    private lateinit var btStart: Button
    private lateinit var tvTitle: TextView
    private lateinit var tvDivisores: TextView
    private lateinit var tvImparOuPar: TextView
    private lateinit var tvQtdDivisores: TextView

    private lateinit var etResposta : EditText
    private lateinit var btResponder: Button

    private lateinit var numeroAleatorio: numeroAleatorio

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.btStart = findViewById(R.id.btStart)
        this.tvTitle = findViewById(R.id.tvTitle)
        this.tvDivisores = findViewById(R.id.tvDivisores)
        this.tvImparOuPar = findViewById(R.id.tvImparOuPar)
        this.tvQtdDivisores = findViewById(R.id.tvQtdDivisores)
        this.etResposta = findViewById(R.id.etResposta)
        this.btResponder = findViewById(R.id.btResponder)

        this.btStart.setOnClickListener({
            this.btStart.setVisibility(View.INVISIBLE)
            this.tvTitle.setVisibility(View.VISIBLE)
            this.numeroAleatorio = numeroAleatorio(1,100)
            Log.i("APP_ACERTE", this.numeroAleatorio.getnumber().toString())
            this.tvDivisores.text = this.tvDivisores.text.toString()+this.numeroAleatorio.divisores()
            this.tvImparOuPar.text = this.tvImparOuPar.text.toString()+this.numeroAleatorio.imparOrpar()
            this.tvQtdDivisores.text = this.tvQtdDivisores.text.toString()+this.numeroAleatorio.contador()
        })

        this.btResponder.setOnClickListener{
            try{
                if(this.etResposta.text.toString().toInt() == this.numeroAleatorio.getnumber()){
                    chuteCerto()
                }
                else{
                    chuteErrado()
                }
            }
            catch(e: Exception){
                Log.i("APP_ACERTE", "Error")
            }
        }
    }

    fun chuteCerto(){
        val janela = AlertDialog.Builder(this)

        janela.setTitle("Parabéns!")
        janela.setIcon(R.mipmap.ic_launcher)
        janela.setMessage("Você acertou!")

        janela.setPositiveButton("Jogar Novamente"){ dialog, which ->
            resetando()
        }
        janela.create().show()
    }

    fun chuteErrado(){
        val janela = AlertDialog.Builder(this)

        janela.setTitle("Vish!")
        janela.setIcon(R.mipmap.ic_launcher)
        janela.setMessage("Vc chutou errado é uma pena, o resultado era "+numeroAleatorio.getnumber())

        janela.setPositiveButton("Jogar Novamente"){ dialog, which ->
            resetando()
        }

        janela.create().show()
    }

    fun resetando(){
        this.etResposta.getText().clear()
        this.numeroAleatorio = numeroAleatorio(1,100)
        Log.i("APP_ACERTE", this.numeroAleatorio.getnumber().toString())
        this.tvDivisores.text = "Seus Divisores: "+this.numeroAleatorio.divisores()
        this.tvImparOuPar.text = "O numero é "+this.numeroAleatorio.imparOrpar()
        this.tvQtdDivisores.text = "Quantidade de divisores desse número: "+this.numeroAleatorio.contador()
    }
}