package com.example.lok

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import de.deanomus.restapi.RestAPIData
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.net.HttpURLConnection
import java.net.URL
import java.net.URLEncoder

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_layout)
        val username = findViewById<EditText>(R.id.username)
        val password = findViewById<EditText>(R.id.passsword)
        val button = findViewById<Button>(R.id.loginBtn)

        button.setOnClickListener {
            // LoginFunktion


            var reqParam = URLEncoder.encode("name", "UTF-8") + "=" + URLEncoder.encode(username.toString(), "UTF-8")
            reqParam += "&" + URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(password.toString(), "UTF-8")
            val mURL = URL(RestAPIData.url + "api/v1_0/login")

            with(mURL.openConnection() as HttpURLConnection) {
                // optional default is GET
                requestMethod = "POST"

                val wr = OutputStreamWriter(getOutputStream());
                wr.write(reqParam);
                wr.flush();

                println("URL : $url")
                println("Response Code : $responseCode")

                BufferedReader(InputStreamReader(inputStream)).use {
                    val response = StringBuffer()

                    var inputLine = it.readLine()
                    while (inputLine != null) {
                        response.append(inputLine)
                        inputLine = it.readLine()
                    }
                    println("Response : $response")
                }
            }


            Intent(this, MainActivity::class.java).also {
                startActivity(it, null)
            }
        }
    }
}