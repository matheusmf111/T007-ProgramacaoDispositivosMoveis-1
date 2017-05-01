package br.unifor.boundedservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class CounterService extends Service {

    private IBinder binder;
    private boolean stop;
    private long count;
    private Thread counterWorker;

    public CounterService() {
        this.binder = new CounterBinder();
        this.stop = false;
        this.count = 0;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    public class CounterBinder extends Binder{
        public CounterService getInstance(){
            return CounterService.this;
        }
    }

    public void startCounter(){

        counterWorker = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!stop){
                    try {
                        count++;
                        Log.i("App", String.valueOf(count));
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

    }

    public void stopCounter(){
        try {
            this.stop = true;
            this.counterWorker.join();
            this.stop = false;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
