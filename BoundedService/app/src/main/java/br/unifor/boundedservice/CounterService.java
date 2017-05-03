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
    private CounterServiceListener listener;

    public CounterService() {
        this.binder = new CounterBinder();
        this.stop = false;
        this.count = 0;
    }

    public void setListener(CounterServiceListener listener) {
        this.listener = listener;
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
                        listener.onCounterUpdate(count);
                        Log.i("App", String.valueOf(count));
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        counterWorker.start();

    }

    public void stopCounter(){
        try {
            this.stop = true;
            this.counterWorker.join();
            this.count = 0;
            this.stop = false;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
