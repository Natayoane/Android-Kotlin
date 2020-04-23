package br.org.covid19.multiplastelas

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun irTela2(v:View) { // colocar esta função no onclick do botão no XML de layout
        // Apenas criamos uma Intent, mas não vamos para a outra tela, ainda
        val tela2 = Intent(this, Tela2::class.java)

        // os "extras" são os dados que enviamos de uma tela para outra
        // o primeiro argumento é o NOME do dado
        // o segundo argumento é o VALOR do dado
        tela2.putExtra("usuario","zeruela")
        tela2.putExtra("idade", 30)
        tela2.putExtra("isAdmin", true)

        // aqui solicitamos a exibição da Intent (no caso, da Activity Tela2)
        startActivity(tela2)

        // ao fazermos isso, é CRIADA UMA NOVA intância de Tela2
    }

    fun sairApp(v:View) { // por no onclick do botão de sair do app
        // para finalizar o app, esta é a função
        // Ela finaliza, "desliga", os recursos que estiverem sendo usados (cartão sd, rede etc)
        finishAffinity()
    }
}
