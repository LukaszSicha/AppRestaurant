package ie.wit.apprestaurant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import ie.wit.apprestaurant.home.HomeFragment
import ie.wit.apprestaurant.maps.MapsFragment
import ie.wit.apprestaurant.menu.MenuFragment
import ie.wit.apprestaurant.order.OrderFragment



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // https://www.youtube.com/watch?v=rIHArmoq9f8
        setTheme(R.style.splashScreenTheme)
        setContentView(R.layout.activity_main)

        val navView: BottomNavigationView = findViewById(R.id.bottomNav)
        navigateTo(HomeFragment.newInstance()) //set main fragment to view after splashscreen

        //Navigation menu that allows user to navigate bottom menu
        navView.setOnNavigationItemReselectedListener {item ->
            when (item.itemId) {
                R.id.home -> navigateTo(HomeFragment.newInstance())
                R.id.trend -> navigateTo(MenuFragment.newInstance())
                R.id.account -> navigateTo(MapsFragment.newInstance())
                R.id.setting -> navigateTo(OrderFragment.newInstance())
            }
        }

    }

    private fun navigateTo(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.frameLayout, fragment)
            .addToBackStack(null)
            .commit()
    }
}