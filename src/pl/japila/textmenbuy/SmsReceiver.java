package pl.japila.textmenbuy;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class SmsReceiver extends BroadcastReceiver {
    public static final String SMS_EXTRA_NAME = "pdus";

    public void onReceive(Context context, Intent intent) {
        Bundle extras = intent.getExtras();
        String messages = "";
        if (extras != null) {
            Object[] smsExtra = (Object[]) extras.get(SMS_EXTRA_NAME);
        }
        Toast.makeText(context, "onReceive", Toast.LENGTH_SHORT).show();
    }
}
