package pl.japila.textmenbuy;

import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    private static final String TAG = "MainActivity";
    List<String> smsList = new ArrayList<String>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    // http://stackoverflow.com/questions/2223296/select-first-sms-on-android-database-inbox
    // http://www.apriorit.com/our-company/dev-blog/227-handle-sms-on-android
    public void onClick(View v) {
        ContentResolver contentResolver = getContentResolver();
        Cursor cursor = contentResolver.query(Uri.parse("content://sms/inbox"), null, null, null, null);
        int indexBody = cursor.getColumnIndexOrThrow("body");
        int indexAddr = cursor.getColumnIndexOrThrow("address");

        if (indexBody < 0 || !cursor.moveToFirst()) return;

        smsList.clear();

        // Get the first SMS only
        // do {
        String str = "Sender: " + cursor.getString(indexAddr) + "\n" + cursor.getString(indexBody);
        smsList.add(str);
//        }
//        while (cursor.moveToNext());

        ListView smsListView = (ListView) findViewById(R.id.SMSList);
        smsListView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, smsList));
    }
}
