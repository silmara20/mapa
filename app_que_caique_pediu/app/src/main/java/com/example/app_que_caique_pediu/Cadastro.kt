package com.example.app_que_caique_pediu

import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.util.regex.Pattern

class Cadastro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            // Cor personalizada, você pode mudar o código hexadecimal
            window.statusBarColor = Color.parseColor("#006400")
        }


        //-> Validacao de email e senha <-
        // Referências para os componentes da UI
        val emailEditText = findViewById<EditText>(R.id.editTextTextEmailAddress)
        val nomeEditText = findViewById<EditText>(R.id.editTextText)
        val cepEditText = findViewById<EditText>(R.id.editTextNumber)
        val estadoEditText = findViewById<EditText>(R.id.editTextText2) // Corrigido nome
        val cidadeEditText = findViewById<EditText>(R.id.editTextText3)
        val ruaEditText = findViewById<EditText>(R.id.editTextText4)
        val numeroEditText = findViewById<EditText>(R.id.editTextNumber2)
        val validateButton = findViewById<Button>(R.id.button)

        validateButton.setOnClickListener {
            val email = emailEditText.text.toString().trim()
            val nome = nomeEditText.text.toString().trim()
            val cep = cepEditText.text.toString().trim()
            val estado = estadoEditText.text.toString().trim()
            val cidade = cidadeEditText.text.toString().trim()
            val rua = ruaEditText.text.toString().trim()
            val numero = numeroEditText.text.toString().trim()

            var isValid = true

            if (!isValidEmail(email)) {
                emailEditText.error = "E-mail inválido"
                isValid = false
            }

            if (!isValidNome(nome)) {
                nomeEditText.error = "Nome deve ter pelo menos 3 letras"
                isValid = false
            }

            if (!isValidCep(cep)) {
                cepEditText.error = "CEP inválido (deve ter 8 números)"
                isValid = false
            }

            if (estado.isEmpty()) {
                estadoEditText.error = "Estado obrigatório"
                isValid = false
            }

            if (cidade.isEmpty()) {
                cidadeEditText.error = "Cidade obrigatória"
                isValid = false
            }

            if (rua.isEmpty()) {
                ruaEditText.error = "Rua obrigatória"
                isValid = false
            }

            if (!isValidNumero(numero)) {
                numeroEditText.error = "Número inválido"
                isValid = false
            }

            if (isValid) {
                Toast.makeText(this, "", Toast.LENGTH_SHORT).show()

                //-> chamando para outra tela se os dados estiver certo <-
                val intent = Intent(this, mapa2::class.java)
                startActivity(intent)

            }
        }
    }

    private fun isValidNome(nome: String): Boolean {
        return nome.length >= 3 && nome.all { it.isLetter() || it.isWhitespace() }
    }

    private fun isValidCep(cep: String): Boolean {
        return cep.length == 8 && cep.all { it.isDigit() } // Considerando CEP como 8 dígitos numéricos
    }

    private fun isValidNumero(numero: String): Boolean {
        return numero.all { it.isDigit() } && numero.isNotEmpty()
    }
}

   // Função para validar o formato do e-mail com regex
    private fun isValidEmail(email: String): Boolean {
        val emailPattern = "[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}"
        val pattern = Pattern.compile(emailPattern)
        val matcher = pattern.matcher(email)
        return matcher.matches()

        //this.supportActionBar?.title = "Example 1"

    }
