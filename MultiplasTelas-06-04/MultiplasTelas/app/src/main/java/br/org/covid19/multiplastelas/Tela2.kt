package br.org.covid19.multiplastelas

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_tela2.*

class Tela2 : AppCompatActivity() {

    // atributo de instância
    var contadorTela2 = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela2)

        // os "intent.extras" são os dados que recebemos da tela anterior
        // o argumento do getX() é o NOME do dado
        val usuario = intent.extras?.getString("usuario")
        val idade = intent.extras?.getInt("idade")
        val isAdmin = intent.extras?.getBoolean("isAdmin")

        val mensagem = "O usuário ${usuario} tem ${idade} anos. Administrador? ${isAdmin}"
        Toast.makeText(this, mensagem, Toast.LENGTH_LONG).show()

    }

    fun contar(v:View) { // colocar no onclick da própria TextView
        contadorTela2++
        tvTopoTela2.text = "Você já clicou ${contadorTela2} vezes!"
    }

    // alterando o comportamento do botão "voltar" do Android
    override fun onBackPressed() {
        // só volta depois que clicou 5 vezes ou mais

        if (contadorTela2 >= 5) {
            super.onBackPressed() // invocanco o funcionamento padrão do botão "voltar"
        } else {
            tvTopoTela2.text = "Preciso de 5 toques, please!"
        }
    }

    fun sair(v:View) { // indicar no onclick do botão "Voltar p/ o inicio"
        finish()
    }
}
