package br.unifor.welcome;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class NewActivity extends AppCompatActivity {

    private Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);


        // Recupera a Intent utilizada para iniciar a Activity
        Intent it = getIntent();

        // Verifica se a Intent é diferente de null (por razões de segurança)
        if(it != null){

            // Recupera o bundle anexado a Intent
            bundle = it.getExtras();

            // Verifica se o Bundle é nulo, caso positivo encerra a janela
            if(bundle == null){

                // Exibe os valores passados no bundle
                Toast.makeText(this, "Nome: " + bundle.getString("nome") + ", Idade: " + bundle.getInt("idade"), Toast.LENGTH_SHORT).show();

            }

        }



    }
}
