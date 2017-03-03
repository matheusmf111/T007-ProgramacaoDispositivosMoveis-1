package br.unifor.welcome;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button clickMe;
    private EditText text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Recupera a referencia do botão declarado no layout da MainActivity
        clickMe = (Button) findViewById(R.id.main_button);

        // Recupera a referencia do campo de texto declarado no layout da MainActivity
        text = (EditText) findViewById(R.id.main_text);

        // Associa o listener de click (neste caso a MainActivity) ao botão
        clickMe.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.main_button:

                // Cria a Intent explícita que iniciará a NewActivity
                Intent it = new Intent(this, NewActivity.class);

                String textString = text.getText().toString();

                if(!textString.isEmpty()){

                    it.putExtra("text", textString);


                    // Cria o bundle de passagem de parâmetros
//                Bundle bundle = new Bundle();
//                bundle.putString("nome", "Bruno Lopes");
//                bundle.putInt("idade", 32);

                    // Anexa o bundle a Intent
                    //it.putExtras(bundle);

                    // Inicia a Activity
                    startActivity(it);

                } else {
                    text.setError("Campo não pode ser vazio");
                }




                break;

        }

    }

}
