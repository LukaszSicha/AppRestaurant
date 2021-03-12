package ie.wit.apprestaurant.order

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.DocumentReference
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


        val deleteButton : Button = view.findViewById(R.id.deleteButton)

        // Whenever user press delete button, it brings him to OrderFragment
        // And then deletes all reservations
        deleteButton.setOnClickListener {
            deleteFireBaseData()
            fragmentManager?.beginTransaction()?.replace(R.id.restaurantView, OrderFragment())?.addToBackStack(null)?.commit()
            deleteButton.setVisibility(View.GONE)
        }


        return view
    }

// https://www.youtube.com/watch?v=5UEdyUFi_uQ

    /**
     * Allows user to read all documents from clod firestore
     * This function dosen't have any buttons because its loaded straight the way when
     * users starts the application.
     */
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


// https://firebase.google.com/docs/firestore/manage-data/delete-data
// https://www.youtube.com/watch?v=24NE6Vloi9I
// https://github.com/mitchtabian/FirestoreGettingStarted/tree/Deleting_Data_Start

    /**
     * Allows user to delete every document from the firebase cloud
     */
    fun deleteFireBaseData(){
        val db = FirebaseFirestore.getInstance()
        db.collection("users").get().addOnCompleteListener {

            if(it.isSuccessful) {
                for(document in it.result!!){
                    val id : String = document.id
                    val deleteRes : DocumentReference = db.collection("users").document(id)
                    deleteRes.delete()

                }
            }
        }


    }

}
