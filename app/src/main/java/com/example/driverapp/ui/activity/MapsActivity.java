package com.example.driverapp.ui.activity;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.res.Resources;
import android.location.Location;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.driverapp.R;
import com.example.driverapp.model.Commen;
import com.firebase.geofire.GeoFire;
import com.firebase.geofire.GeoLocation;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.driverapp.databinding.ActivityMapsBinding;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;


public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;
    private FusedLocationProviderClient fusedLocationProviderClient; //Location
    private LocationRequest locationRequest;
    private LocationCallback locationCallback;
    SupportMapFragment mapFragment;
    DatabaseReference onlineRef,currentUserRef,driversLocationRef;
    GeoFire geoFire;
    ValueEventListener onlineValueEventListener = new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot snapshot) {
            if(snapshot.exists())
                currentUserRef.onDisconnect().removeValue();
        }

        @Override
        public void onCancelled(@NonNull DatabaseError error) {
            Snackbar.make(mapFragment.getView(),error.getMessage(),Snackbar.LENGTH_LONG).show();
        }
    };


    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        init();
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    // default settings while opening the map.
    private void init(){
        locationRequest = new LocationRequest();
        locationRequest.setSmallestDisplacement(10f);
        locationRequest.setInterval(5000);
        locationRequest.setFastestInterval(3000);
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);

        locationCallback = new LocationCallback() {
            @Override
            public void onLocationResult(@NonNull LocationResult locationResult) {
                super.onLocationResult(locationResult);

                LatLng newPosition = new LatLng(locationResult.getLastLocation().getLatitude(),
                        locationResult.getLastLocation().getLongitude());
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(newPosition,18f));

            }
        };
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(getApplicationContext());
        fusedLocationProviderClient.requestLocationUpdates(locationRequest,locationCallback, Looper.myLooper());
    }

    // the locator button is at the (bottom left) of the map screen.
    private void locatorButton(){
        mMap.setMyLocationEnabled(true);
        mMap.getUiSettings().setMyLocationButtonEnabled(true);
        mMap.setOnMyLocationButtonClickListener(() -> {
            fusedLocationProviderClient.getLastLocation()
                    .addOnFailureListener(e -> Toast.makeText(getApplicationContext(), ""+e.getMessage(), Toast.LENGTH_SHORT).show())
                    .addOnSuccessListener(location -> {
                        LatLng userLatLng = new LatLng(location.getLatitude(),location.getLongitude());
                        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(userLatLng,18f));
                    });
            return true;
        });
        //Set Layout button
        View locationButton = ((View)mapFragment.getView().findViewById(Integer.parseInt("1"))
                .getParent())
                .findViewById(Integer.parseInt("2"));
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) locationButton.getLayoutParams();
        //Right bottom
        params.addRule(RelativeLayout.ALIGN_PARENT_TOP,0);
        params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM,RelativeLayout.TRUE);
        params.setMargins(0,0,0,50);
    }

    // organized layout of the map.
    private void styleMap(GoogleMap googleMap){
        try{
            boolean success = googleMap.setMapStyle(MapStyleOptions.loadRawResourceStyle(getApplicationContext(),R.raw.maps_style));
            if(!success)
                Log.e("EDMT_ERROR","Style parsing error");
        }catch (Resources.NotFoundException e){
            Log.e("EDMT_ERROR",e.getMessage());
        }
    }

    // check permission.
    private void checkPermission(){
        Dexter.withContext(getApplicationContext())
                .withPermission(Manifest.permission.ACCESS_FINE_LOCATION)
                .withListener(new PermissionListener() {
                    @Override
                    public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                        locatorButton();
                    }

                    @Override
                    public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {
                        Toast.makeText(getApplicationContext(), "Permission" + permissionDeniedResponse.getPermissionName() + ""+
                                " was denied!", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {

                    }
                }).check();
    }

    // remove location updates.
    @Override
    protected void onDestroy() {
        fusedLocationProviderClient.removeLocationUpdates(locationCallback);
        geoFire.removeLocation(FirebaseAuth.getInstance().getCurrentUser().getUid());
        onlineRef.removeEventListener(onlineValueEventListener);
        super.onDestroy();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        styleMap(googleMap);
        checkPermission();
    }

}

