package ee461l.homework4;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import static ee461l.homework4.MainActivity.address;

public class DisplayMap extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Integer zoom = 15;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_map);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

//  Manipulates the map once available.
//  This callback is triggered when the map is ready to be used.
//  This is where we can add markers or lines, add listeners or move the camera. In this case,
//  we just add a marker near Sydney, Australia.
//  If Google Play services is not installed on the device, the user will be prompted to install
//  it inside the SupportMapFragment. This method will only be triggered once the user has
//  installed Google Play services and returned to the app.

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng enteredLocation = new LatLng(address.getLat(), address.getLng());
        mMap.addMarker(new MarkerOptions().position(enteredLocation).title(address.getFormatted_address()));
        mMap.moveCamera(CameraUpdateFactory.zoomTo(zoom));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(enteredLocation));
    }

    public void zoomIn(View view) {
        if (zoom > 2){
            mMap.moveCamera(CameraUpdateFactory.zoomTo(--zoom));
        }
    }

    public void zoomOut(View view){
        if(zoom < 30) {
            mMap.moveCamera(CameraUpdateFactory.zoomTo(++zoom));
        }
    }
}
