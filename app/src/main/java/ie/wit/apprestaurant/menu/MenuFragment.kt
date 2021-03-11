package ie.wit.apprestaurant.menu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ie.wit.apprestaurant.R
import ie.wit.apprestaurant.adapters.MenuAdapter


/**
 * MenuFragment that uses MenuAdapter and allows to look through menu
 */

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


        recycler_view.adapter = MenuAdapter(menuList)
        recycler_view.layoutManager = LinearLayoutManager(activity)
        recycler_view.setHasFixedSize(true)
        return view
    }

    /**
     * DummyList of the menu, allows us to change how many items are displayed and what pictures
     * we want to use for it.
     */
    private fun generateDummyList(size: Int): List<MenuItem> {

        val list = ArrayList<MenuItem>()

        for (i in 0 until size) {
            val drawable = when (i % 3) {
                0 -> R.drawable.hamburger
                1 -> R.drawable.hotdog
                else -> R.drawable.pizza
            }

            val item = MenuItem(
                drawable,
                "Order $i",
                "Click on me to order!"
            )
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