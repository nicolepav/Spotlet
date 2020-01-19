package com.example.spotlet

import android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class AltMap : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private lateinit var lm: LocationManager

    override fun onCreate(savedInstanceState: Bundle?) {

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)

        // Obtain the SupportMapFragment
        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        val lastArea = fusedLocationClient.getLastLocation()
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // zoom buttons
        mMap.getUiSettings().setZoomControlsEnabled(true)
        mMap.getUiSettings().setCompassEnabled(true)

        // Add a marker in Sydney and move the camera
        val sydney = LatLng(-34.0, 151.0)
        mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
        mMap = googleMap
        // Add a marker in ucr and move the camera
        val ucr = LatLng(34.0, -117.0)
        mMap.addMarker(MarkerOptions().position(ucr).title("Marker in UCR"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(ucr))
        // Add sample parking spots
        val ucrSpot = LatLng(34.001, -117.0001)
        mMap.addMarker(MarkerOptions().position(ucrSpot).title("Available Spot"))
        val ucrSpot1 = LatLng(34.005, -117.01)
        mMap.addMarker(MarkerOptions().position(ucrSpot1).title("Available Spot"))
        val ucrSpot2 = LatLng(34.002, -117.001)
        mMap.addMarker(MarkerOptions().position(ucrSpot2).title("Available Spot"))
        val ucrSpot3 = LatLng(34.011, -117.11)
        mMap.addMarker(MarkerOptions().position(ucrSpot3).title("Available Spot"))
        val ucrSpot4 = LatLng(34.021, -117.0201)
        mMap.addMarker(MarkerOptions().position(ucrSpot4).title("Available Spot"))
    }

    //wtf


}


