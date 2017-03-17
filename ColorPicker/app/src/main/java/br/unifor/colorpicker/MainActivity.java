package br.unifor.colorpicker;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final int COLOR_BACK = 1;

    private View mColor;
    private Button mChangeColor;
    private int mVermelho;
    private int mVerde;
    private int mAzul;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mVermelho = 0;
        mVerde = 0;
        mAzul = 0;

        mColor = findViewById(R.id.main_color);
        mColor.setBackgroundColor(Color.argb(255, mVermelho, mVerde, mAzul));

        mChangeColor = (Button) findViewById(R.id.main_change_color);
        mChangeColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent it = new Intent("RAPADURA");

                it.putExtra("vermelho", mVermelho);
                it.putExtra("verde", mVerde);
                it.putExtra("azul", mAzul);

                startActivityForResult(it, COLOR_BACK);

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        switch (requestCode) {

            case COLOR_BACK:

                if(resultCode == RESULT_OK){

                    if (data != null) {
                        mVermelho = data.getIntExtra("vermelho", 0);
                        mVerde = data.getIntExtra("verde", 0);
                        mAzul = data.getIntExtra("azul", 0);
                    }

                    mColor.setBackgroundColor(Color.argb(255, mVermelho, mVerde, mAzul));

                }

                break;

        }

    }
}
