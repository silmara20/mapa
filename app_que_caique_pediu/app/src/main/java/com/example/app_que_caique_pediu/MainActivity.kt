package com.example.app_que_caique_pediu

import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Mudando a cor da Status Bar e Navigation Bar com opacidade reduzida
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            // Cor para a Status Bar com 50% de opacidade (exemplo: #80FF5733)
            window.statusBarColor = Color.parseColor("#11006400")  // Cor semitransparente (80 = 50% de opacidade)

            // Cor para a Navigation Bar com 50% de opacidade
            window.navigationBarColor = Color.parseColor("#80363636")  // Cor preta com 50% de opacidade

            // Permite que o conteúdo da Activity ocupe toda a tela (inclusive a Status Bar e Navigation Bar)
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or
                    View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION or
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
        }

        // Inicializando o botão
        val btSegunda = findViewById<Button>(R.id.bt_segunda)

        // Usando o OnClickListener para navegar para a SegundaTela
        btSegunda.setOnClickListener {
            val segundatela = Intent(applicationContext, Cadastro::class.java)
            startActivity(segundatela)  // Corrigido: passamos o Intent para startActivity()

        }
        //-> Validacao de email e senha <-
        // Referências para os componentes da UI
        val emailEditText = findViewById<EditText>(R.id.editTextTextEmailAddress2)
        val passwordEditText = findViewById<EditText>(R.id.editText)
        val validateButton = findViewById<Button>(R.id.button2)

        // Configuração do listener para o botão de validação
        validateButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()

            if (isValidEmail(email) && isValidPassword(password)) {
                Toast.makeText(this, "E-mail e senha válidos!", Toast.LENGTH_SHORT).show()

                //-> chamando para outra tela se os dados estiver certo <-
                val intent = Intent(this, mapa2::class.java)
                startActivity(intent)

            } else {
                if (!isValidEmail(email)) {
                    Toast.makeText(this, "E-mail inválido!", Toast.LENGTH_SHORT).show()
                }
                if (!isValidPassword(password)) {
                    Toast.makeText(this, "Senha inválida!", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun isValidPassword(password: String): Boolean {
        val passwordPattern = "^(?=.*[A-Za-z])(?=.*\\d).{4}"
        val pattern = Pattern.compile(passwordPattern)
        val matcher = pattern.matcher(password)
        return matcher.matches()
    }

    // Função para validar o formato do e-mail com regex
    private fun isValidEmail(email: String): Boolean {
        val emailPattern = "[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}"
        val pattern = Pattern.compile(emailPattern)
        val matcher = pattern.matcher(email)
        return matcher.matches()


    }
}