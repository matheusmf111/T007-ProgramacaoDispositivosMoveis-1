package br.unifor.fragmentexample;

import android.content.res.Configuration;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fManager = getSupportFragmentManager();
        FragmentTransaction fTransaction = fManager.beginTransaction();

        int orientation = getWindowManager().getDefaultDisplay().getRotation();
        if(orientation == Configuration.ORIENTATION_PORTRAIT){

            Fragment1 f1 = new Fragment1();
            fTransaction.replace(android.R.id.content, f1);

        } else {

            Fragment2 f2 = new Fragment2();
            fTransaction.replace(android.R.id.content, f2);

        }

        fTransaction.commit();


    }

}
