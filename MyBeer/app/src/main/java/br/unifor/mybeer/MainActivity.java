package br.unifor.mybeer;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import br.unifor.mybeer.fragments.FragmentBeerList;

public class MainActivity extends AppCompatActivity {

    private Toolbar mAppToolbar;
    private FragmentBeerList mFragmentBeerList;
    private FragmentManager mFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAppToolbar = (Toolbar) findViewById(R.id.app_toolbar);
        mAppToolbar.setTitle("My Beer");

        setSupportActionBar(mAppToolbar);

        mFragmentBeerList = new FragmentBeerList();
        mFragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        transaction.replace(R.id.main_body, mFragmentBeerList);
        transaction.commit();

    }

}
