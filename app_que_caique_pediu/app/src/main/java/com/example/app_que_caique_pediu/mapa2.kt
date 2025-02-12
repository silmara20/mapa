package com.example.app_que_caique_pediu

import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.example.app_que_caique_pediu.databinding.ActivityMapa2Binding

class mapa2 : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapa2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            // Obtém o SupportMapFragment e notifica quando o mapa estiver pronto para uso
            val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
            mapFragment.getMapAsync(this)
        }

        fun onMapReady(googleMap: GoogleMap) {
            mMap = googleMap

            // Define a posição do marcador (Latitude e Longitude)
            val localizacao = LatLng(-23.530627, -46.418724) // Exemplo: São Paulo
            mMap.addMarker(MarkerOptions().position(localizacao).title("Marcador em São Paulo"))

            // Move a câmera para o local com zoom
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(localizacao, 15f))
        }

        binding = ActivityMapa2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)


        //-> muda acor da barra de cima <-
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            // Cor personalizada, você pode mudar o código hexadecimal
            window.statusBarColor = Color.parseColor("#006400")
        }

    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val sydney = LatLng(-34.0, 151.0)
        mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
    }
}