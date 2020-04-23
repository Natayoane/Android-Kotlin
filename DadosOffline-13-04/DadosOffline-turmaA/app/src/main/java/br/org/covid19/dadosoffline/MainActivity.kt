package br.org.covid19.dadosoffline

import android.content.Context
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    // a classe que manipula os dados offline é a SharedPreferences
    var preferencias:SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // getPreferences() recupera as "preferências" do app
        // Dados offline do app
        // Context.MODE_PRIVATE indica que esses dado serão privados deste app
        preferencias = getPreferences(Context.MODE_PRIVATE)

        // os método getX() das preferências recuperam um dado a partir de seu NOME
        // o primeiro argumento é o NOME do dado
        // o segundo argumento é o valor padrão, caso não encontre o dado
        etNome.setText(preferencias?.getString("nomeUsuario", ""))
    }

    fun salvarDados(v:View) { // associar on onclick do botão

        // edit() retorna o "editor" das preferências
        // com ele podemos criar ou alterar dados offline
        val editor = preferencias?.edit()

        // o método putX() criam ou alteram dados offline
        // o primeiro argumento é o NOME do dado
        // o segundo argumento é o VALOR do dado
        editor?.putString("nomeUsuario", etNome.text.toString())

        // Aqui salvamos os dados na memória interna no aparelho
        editor?.commit()

        // editor.apply()
        // este faz o mesmo que o commit(), a diferença é que ele é assincrono
    }

    fun limparDados(v:View) {
        val editor = preferencias?.edit()
        editor?.clear()
        editor?.commit()
    }
}
