package br.unifor.colorpicker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

public class ColorChangeActivity extends AppCompatActivity {

    private SeekBar mCorVermelha;
    private SeekBar mCorVerde;
    private SeekBar mCorAzul;

    private Button mVoltar;

    private int mVermelho;
    private int mVerde;
    private int mAzul;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_change);

        Intent it = getIntent();
        if(it != null){

            mVermelho = it.getIntExtra("vermelho", 0);
            mVerde = it.getIntExtra("verde", 0);
            mAzul = it.getIntExtra("azul", 0);

        }

        mCorVermelha = (SeekBar) findViewById(R.id.color_change_red);
        mCorVermelha.setMax(255);
        mCorVermelha.setProgress(mVermelho);

        mCorVerde = (SeekBar) findViewById(R.id.color_change_green);
        mCorVerde.setMax(255);
        mCorVerde.setProgress(mVerde);

        mCorAzul = (SeekBar) findViewById(R.id.color_change_blue);
        mCorAzul.setMax(255);
        mCorAzul.setProgress(mAzul);


        mVoltar = (Button) findViewById(R.id.color_change_back);
        mVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent back = new Intent();

                back.putExtra("vermelho", mCorVermelha.getProgress());
                back.putExtra("verde", mCorVerde.getProgress());
                back.putExtra("azul", mCorAzul.getProgress());

                setResult(RESULT_OK, back);
                finish();

            }
        });

    }
}
