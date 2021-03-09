package ie.wit.apprestaurant.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ie.wit.apprestaurant.R
import ie.wit.apprestaurant.adapters.ExampleAdapter
import ie.wit.apprestaurant.adapters.ExampleItem


class MenuFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val menuList = generateDummyList(30)

        val view = inflater.inflate(R.layout.fragment_menu, container, false)
        val recycler_view : RecyclerView = view.findViewById(R.id.menu_recycler)


        recycler_view.adapter = ExampleAdapter(menuList)
        recycler_view.layoutManager = LinearLayoutManager(activity)
        recycler_view.setHasFixedSize(true)
        return view
    }


    private fun generateDummyList(size: Int): List<ExampleItem> {

        val list = ArrayList<ExampleItem>()

        for (i in 0 until size) {
            val drawable = when (i % 3) {
                0 -> R.drawable.hamburger
                1 -> R.drawable.hotdog
                else -> R.drawable.pizza
            }

            val item = ExampleItem(drawable, "Order $i", "Click on me to order!")
            list += item
        }

        return list
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            MenuFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}