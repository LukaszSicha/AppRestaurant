package ie.wit.apprestaurant.order

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore

import ie.wit.apprestaurant.R
import ie.wit.apprestaurant.adapters.ViewReservationAdapter


class ViewReservationFragment : Fragment() {

    private lateinit var res_recycler: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_view_reservation, container, false)
        res_recycler = view.findViewById(R.id.res_recycler)
        res_recycler.layoutManager = LinearLayoutManager(activity)
        readFireStoreData()

        return view
    }


    fun readFireStoreData() {
        val listRes = ArrayList<ReservationItem>()
        val db = FirebaseFirestore.getInstance()
        db.collection("users")
            .get()
            .addOnCompleteListener {

                if(it.isSuccessful) {
                    for(document in it.result!!) {
                        val reservationVal = ReservationItem(document.data.getValue("inputFirstName").toString(), document.data.getValue("inputLastName").toString(), document.data.getValue("date").toString(), document.data.getValue("amountofpoeple").toString())
                        listRes.add(reservationVal)
                    }
                    res_recycler.adapter = ViewReservationAdapter(listRes)
                }
            }
    }

    /*fun deleteFireBaseData(){
        val db = FirebaseFirestore.getInstance()

        db.collection("users").document("DC")
            .delete()
            .addOnSuccessListener { Log.d(TAG, "DocumentSnapshot successfully deleted!") }
            .addOnFailureListener { e -> Log.w(TAG, "Error deleting document", e) }


    }*/

}
