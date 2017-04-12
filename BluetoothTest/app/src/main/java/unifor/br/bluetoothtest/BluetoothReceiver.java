package unifor.br.bluetoothtest;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class BluetoothReceiver extends BroadcastReceiver {

    private List<BluetoothDevice> mDevices;

    @Override
    public void onReceive(Context context, Intent intent) {

        if (BluetoothAdapter.ACTION_DISCOVERY_STARTED.equals(intent.getAction())) {

            // TODO: Iniciou o processo de discovery
            mDevices = new ArrayList<>();
            Log.i("APP", "Processo de discovery inicado!");

        } else if (BluetoothDevice.ACTION_FOUND.equals(intent.getAction())) {

            // TODO: Um dispositovo foi encontrado
            BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
            mDevices.add(device);
            Log.i("APP", "Dispositivo encontrado!");

        } else if (BluetoothAdapter.ACTION_DISCOVERY_FINISHED.equals(intent.getAction())) {

            // TODO: O processo de discovery encerrou
            Log.i("APP", "Processo de discovery terminado!");
            for (BluetoothDevice device: mDevices) {
                Log.i("APP", "Name: " + device.getName() + ", Address:" + device.getAddress());
            }

        }

    }
}
