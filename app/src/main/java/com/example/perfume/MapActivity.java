package com.example.perfume;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.Vector;

public class MapActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    MarkerOptions marker;
    LatLng centerLocation;

    Vector<MarkerOptions> markerOptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        centerLocation = new LatLng(3.0, 101);

        markerOptions = new Vector<>();

        markerOptions.add(new MarkerOptions().title("Princess Perfume Shah Alam")
                .position(new LatLng(3.0731, 101.4965))
                .snippet("75, Jalan Kristal 7/72 · 016-301 8105")
        );

        markerOptions.add(new MarkerOptions().title("Mr Perfume Shah Alam")
                .position(new LatLng(3.0724, 101.4979))
                .snippet("28, Jalan Zirkon 7f/F · 019-999 5518")
        );

        markerOptions.add(new MarkerOptions().title("SUGARBOMB SHAH ALAM CENTRE")
                .position(new LatLng(3.0736, 101.4979))
                .snippet("AA1-12-A, PUSAT KOMERSIAL, BLOK D, Jalan Plumbum Aa 7/Aa · 017-678 1174")
        );

        markerOptions.add(new MarkerOptions().title("Parfum Bandung Shah Alam HQ")
                .position(new LatLng(3.0739, 101.4984))
                .snippet("10A 1st Floor, Jalan Plumbum N7/N · 011-1198 2746")
        );

        markerOptions.add(new MarkerOptions().title("BungaRRaya HQ")
                .position(new LatLng(3.0741, 101.4987))
                .snippet("36B, Jalan Plumbum N7/N · 013-315 1678")
        );

        markerOptions.add(new MarkerOptions().title("HouseofScents.com.my")
                .position(new LatLng(3.0745, 101.4989))
                .snippet("Pangsapuri Baiduri, Persiaran Tun Arshad Ayub · 017-487 4614")
        );

        markerOptions.add(new MarkerOptions().title("DARMEME HQ")
                .position(new LatLng(3.0737, 101.4981))
                .snippet("no 16, Jalan Kristal 7/61 · 013-357 8745")
        );

        markerOptions.add(new MarkerOptions().title("SHARK FRAGRANCE HQ")
                .position(new LatLng(3.0732, 101.4980))
                .snippet("No70g jalan keluli an7/an, Taman perindustrian bukit raja selatan · 011-6343 9797")
        );

        markerOptions.add(new MarkerOptions().title("De'Xandra Central I-City")
                .position(new LatLng(3.0739, 101.4982))
                .snippet("No 1, Persiaran Multimedia Seksyen 7, Jalan Plumbum 7/102, I-City · 018-204 9778")
        );

        markerOptions.add(new MarkerOptions().title("Leiya Perfume")
                .position(new LatLng(3.0741, 101.4981))
                .snippet("Jalan Plumbum 7/100 · 011-1474 4228")
        );

        markerOptions.add(new MarkerOptions().title("Halal Cosmetics")
                .position(new LatLng(3.0747, 101.4990))
                .snippet("52, Jalan Yakut 7/13, Seksyen 7, 40000 Shah Alam, Selangor, Malaysia · 019-226 9998")
        );

        markerOptions.add(new MarkerOptions().title("The Body Shop Central I-City")
                .position(new LatLng(3.0736, 101.4978))
                .snippet("Lot G-09, Central Plaza I-City, Jalan Multimedia · 019-280 2230")
        );

        markerOptions.add(new MarkerOptions().title("Minyak Wangi Shah Alam")
                .position(new LatLng(3.0733, 101.4977))
                .snippet("26, Jalan Gunung Tahan U11/1a · 019-264 8502")
        );

        markerOptions.add(new MarkerOptions().title("Watsons Seksyen 7")
                .position(new LatLng(3.0731, 101.4977))
                .snippet("No. 11 & 13, Ground Floor, Jalan Plumbum R7/R · 03-5510 0151")
        );

        markerOptions.add(new MarkerOptions().title("Mugis Perfumes")
                .position(new LatLng(3.0739, 101.4978))
                .snippet("Jalan selasie · 011-3632 3729")
        );

        markerOptions.add(new MarkerOptions().title("HQ DeXandra SHAH ALAM")
                .position(new LatLng(3.0727, 101.4995))
                .snippet("L16/L, Jln Serai Wangi G 16/G")
        );

        markerOptions.add(new MarkerOptions().title("Victoria's Secret")
                .position(new LatLng(3.0733, 101.4974))
                .snippet("Selangor · 03-5523 5386")
        );

        markerOptions.add(new MarkerOptions().title("Bath & Body Works")
                .position(new LatLng(3.0733, 101.4981))
                .snippet("CENTRAL I-CITY, Lot G-40 NO.1, PERSIARAN MULTIMEDIA SEKSYEN, 7, Jalan Plumbum 7/102 · 03-5523 8849")
        );
    }


        @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        for (MarkerOptions mark : markerOptions) {
            mMap.addMarker(mark);
        }

        enableMyLocation();

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(centerLocation, 8));
    }

    private void enableMyLocation() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            if (mMap != null) {
                mMap.setMyLocationEnabled(true);
            }
        } else {
            String[] perms = {"android.permission.ACCESS_FINE_LOCATION"};
            ActivityCompat.requestPermissions(this, perms, 200);
        }
    }
}
