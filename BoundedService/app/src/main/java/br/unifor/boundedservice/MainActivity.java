package br.unifor.boundedservice;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mMainNumber;
    private Button mMainStart;
    private Button mMainStop;

    private boolean mServiceConnected;
    private Intent mServiceIntent;
    private CounterService mService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMainNumber = (TextView) findViewById(R.id.main_number);
        mMainStart = (Button) findViewById(R.id.main_start);
        mMainStop = (Button) findViewById(R.id.main_stop);

        mMainStart.setOnClickListener(this);
        mMainStop.setOnClickListener(this);

        mServiceIntent = new Intent(this, CounterService.class);
        startService(mServiceIntent);
        this.mServiceConnected = false;

    }

    @Override
    protected void onStart() {
        super.onStart();
        bindService(mServiceIntent, mConnection, BIND_AUTO_CREATE);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unbindService(mConnection);
    }

    private ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            CounterService.CounterBinder counterBinder = (CounterService.CounterBinder) service;
            mService = counterBinder.getInstance();
            mServiceConnected = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            mServiceConnected = false;
        }
    };


    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.main_start:
                if (mServiceConnected) {
                    mService.startCounter();
                } else {
                    Toast.makeText(this,
                            "O aplicativo não está conectado ao serviço.",
                            Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.main_stop:
                if (mServiceConnected) {
                    mService.stopCounter();
                } else {
                    Toast.makeText(this,
                            "O aplicativo não está conectado ao serviço.",
                            Toast.LENGTH_SHORT).show();
                }
                break;

        }

    }
}
