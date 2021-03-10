package ie.wit.apprestaurant.order

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore
import ie.wit.apprestaurant.R

/**
 * Code learned from https://www.youtube.com/watch?v=5UEdyUFi_uQ
 * There is a bit of my implementation from the last year, and
 * code is used different for fragments
 */

class OrderFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_order, container, false)

        val saveRes : Button = view.findViewById(R.id.saveButton)

        saveRes.setOnClickListener {
            val inputFirstName : EditText = view.findViewById(R.id.inputFirstName)
            val inputLastName : EditText = view.findViewById(R.id.inputLastName)
            val date : EditText = view.findViewById(R.id.date)
            val amountofpoeple : EditText = view.findViewById(R.id.amountofpeople)

            saveFireStore(inputFirstName.text.toString(),inputLastName.text.toString(), date.text.toString(), amountofpoeple.text.toString())
        }
        return view
    }

    fun saveFireStore(inputFirstName: String, inputLastName: String, date: String, amountofpoeple: String) {
        val db = FirebaseFirestore.getInstance()
        val user: MutableMap<String, Any> = HashMap()
        user["inputFirstName"] = inputFirstName
        user["inputLastName"] = inputLastName
        user["date"] = date
        user["amountofpoeple"] = amountofpoeple

        db.collection("users").add(user)
            .addOnSuccessListener {
                println("Record ADDED")
            }
            .addOnFailureListener {
                println("Record Wrong")
            }
    }

    companion object {
        fun newInstance() =
            OrderFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}