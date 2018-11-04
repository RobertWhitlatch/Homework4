package ee461l.homework4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import static ee461l.homework4.MainActivity.address;

public class EnterAddress extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_address);
    }

    public void gotoDisplayMap(View view) {

        EditText streetAddressIn = findViewById(R.id.streetAddressIn);
        String streetAddress = streetAddressIn.getText().toString();
        address.setStreetAddress(streetAddress);

        EditText streetNameIn = findViewById(R.id.streetNameIn);
        String streetName = streetNameIn.getText().toString();
        address.setStreetName(streetName);

        EditText cityIn = findViewById(R.id.cityIn);
        String city = cityIn.getText().toString();
        address.setCity(city);

        EditText stateIn = findViewById(R.id.stateIn);
        String state = stateIn.getText().toString();
        address.setState(state);

        EditText zipCodeIn = findViewById(R.id.zipCodeIn);
        String zipCode = zipCodeIn.getText().toString();
        address.setZipCode(zipCode);

        EditText countryIn = findViewById(R.id.countryIn);
        String country = countryIn.getText().toString();
        address.setCountry(country);

        address.buildURL();

        FetchGeocoding geocode = new FetchGeocoding();
        geocode.execute(address.getURL());

        Intent intent = new Intent(this, DisplayMap.class);
        startActivity(intent);
    }
}
