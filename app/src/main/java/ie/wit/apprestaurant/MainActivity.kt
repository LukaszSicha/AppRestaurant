package ie.wit.apprestaurant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import ie.wit.apprestaurant.fragments.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navView: BottomNavigationView = findViewById(R.id.bottomNav)

        navView.setOnNavigationItemReselectedListener {item ->
            when (item.itemId) {
                R.id.home -> navigateTo(HomeFragment.newInstance())
                R.id.trend -> navigateTo(MenuFragment.newInstance())
                R.id.account -> navigateTo(MapsFragment.newInstance())
                R.id.setting -> navigateTo(ReservationFragment.newInstance())

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