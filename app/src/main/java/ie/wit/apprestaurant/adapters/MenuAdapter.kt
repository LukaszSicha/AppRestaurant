package ie.wit.apprestaurant.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ie.wit.apprestaurant.R
import ie.wit.apprestaurant.menu.MenuItem


/**
 * MenuAdapter which allows to display simple recycler view and all options
 * that it is containing.
 */

class MenuAdapter(private val menuList: List<MenuItem>) : RecyclerView.Adapter<MenuAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.example_item,
            parent, false)

        return ViewHolder(itemView)
    }

    /**
     * Displays all the items
     */

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = menuList[position]

        holder.imageView.setImageResource(currentItem.imageResource)
        holder.textView1.text = currentItem.text1
        holder.textView2.text = currentItem.text2
    }

    override fun getItemCount() = menuList.size

    /**
     * Options in the adapter that are displayed to the user
     */

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.image_view)
        val textView1: TextView = itemView.findViewById(R.id.text_view_1)
        val textView2: TextView = itemView.findViewById(R.id.text_view_2)

    }
}