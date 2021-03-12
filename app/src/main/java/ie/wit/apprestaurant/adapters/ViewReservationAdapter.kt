package ie.wit.apprestaurant.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ie.wit.apprestaurant.R
import ie.wit.apprestaurant.order.ReservationItem


/**
 * Same adapter as MenuFragment, the only one difference its used for the
 * ViewReservationFragment
 */

class ViewReservationAdapter (private val reservationList: ArrayList<ReservationItem>) : RecyclerView.Adapter<ViewReservationAdapter.ReservationViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReservationViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.reservation_item,
            parent, false)

        return ReservationViewHolder(itemView)
    }


    override fun onBindViewHolder(holder: ReservationViewHolder, position: Int) {
        val currentItem = reservationList[position]


        holder.textView1.text = currentItem.firstname
        holder.textView2.text = currentItem.lastname
        holder.textView1.text = currentItem.date
        holder.textView2.text = currentItem.numberpeople
    }

    override fun getItemCount() = reservationList.size

    class ReservationViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView1: TextView = itemView.findViewById(R.id.res_text1)
        val textView2: TextView = itemView.findViewById(R.id.res_text2)

    }
}