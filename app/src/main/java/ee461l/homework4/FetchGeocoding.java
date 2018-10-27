package ee461l.homework4;

import android.os.AsyncTask;
import static ee461l.homework4.MainActivity.address;

public class FetchGeocoding extends AsyncTask<String,Void,Void> {

    @Override
    protected Void doInBackground(String... url) {

        HttpHandler httpHandler = new HttpHandler();
        String jsonStr = httpHandler.makeServiceCall(url[0]);
        if (jsonStr != null) {
            address.parseResponse(jsonStr);
        }
        return null;
    }

}
