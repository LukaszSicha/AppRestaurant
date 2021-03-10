package ie.wit.apprestaurant.maps

import androidx.fragment.app.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import ie.wit.apprestaurant.R

class MapsFragment : Fragment() {

    private val callback = OnMapReadyCallback { googleMap ->

        val ireland = LatLng(52.16, -7.15)
        googleMap.addMarker(MarkerOptions().position(ireland).title("Our location!"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(ireland))
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_maps, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            MapsFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}