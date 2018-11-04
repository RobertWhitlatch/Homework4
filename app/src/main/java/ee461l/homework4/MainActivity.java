package ee461l.homework4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public static String API_Key = "AIzaSyCb3RKIFfRkmKrzazQOcFgzcnvKsX9Qc44";
    public static AddressEntry address = new AddressEntry(API_Key);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void gotoEnterAddress(View view) {
        address = new AddressEntry(API_Key);
        Intent intent = new Intent(this, EnterAddress.class);
        startActivity(intent);
    }

}
