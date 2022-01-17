package Location

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.location.*
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.final_project.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main_discounts.*
import kotlinx.android.synthetic.main.activity_main_location.*



class MainActivityLocation: AppCompatActivity() {

    private var locationManager: LocationManager? = null


    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_location)


        var myloclong = tvgetlongitude.setText("")
        var myloclat = tvgetlatitude.setText("")
        tvBranch.visibility = View.GONE



        //define the listener
        val locationListener: LocationListener = object : LocationListener {
            override fun onLocationChanged(location: Location) {

                tvgetlongitude.text = String.format("%.5f", location.longitude)
                tvgetlatitude.text = String.format("%.5f", location.longitude)


            }


            override fun onStatusChanged(provider: String, status: Int, extras: Bundle) {}
            override fun onProviderEnabled(provider: String) {}
            override fun onProviderDisabled(provider: String) {}
        }


        val locationListenerGPS: LocationListener = object : LocationListener {
            override fun onLocationChanged(locationGPS: Location) {


                tvgetlongitude.text = String.format("%.5f", locationGPS.longitude)
                tvgetlatitude.text = String.format("%.5f", locationGPS.latitude)

            }

            override fun onStatusChanged(s: String, i: Int, bundle: Bundle) {}
            override fun onProviderEnabled(s: String) {}
            override fun onProviderDisabled(s: String) {}
        }


        locationManager = getSystemService(LOCATION_SERVICE) as LocationManager?

        if (Build.VERSION.SDK_INT < 23) {

            btlocation.setOnClickListener { view ->
                try {
                    // Request location updates
                    locationManager?.requestLocationUpdates(
                        LocationManager.NETWORK_PROVIDER,
                        1000L,
                        10f,
                        locationListener

                    )
                } catch (ex: SecurityException) {
                    Log.d("MyLogFinalProject", "Security Exception, no location available")
                }
            }
        } else {
            if (ContextCompat.checkSelfPermission(
                    this,
                    Manifest.permission.ACCESS_FINE_LOCATION
                ) != PackageManager.PERMISSION_GRANTED
            ) {

                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                    0
                )
            } else {


                btlocation.setOnClickListener { view ->
                    try {
                            locationManager?.requestLocationUpdates(
                            LocationManager.GPS_PROVIDER,
                            0L,
                            0f,
                            locationListenerGPS
                        )
                    } catch (ex: SecurityException) {
                        Log.d("MyLogFinalProject", "Security Exception, no location available")
                    }
                }
            }
        }


        val startPoint = Location("LocationA") // my location
        startPoint.latitude = 50.4583
        startPoint.longitude = 30.6137

        val endPoint = Location("LocationB")
        endPoint.latitude = 50.4459
        endPoint.longitude = 30.5150

        val distance = startPoint.distanceTo(endPoint).toDouble()

        val endPoint2 = Location("LocationC")
        endPoint2.latitude = 50.4588
        endPoint2.longitude = 30.5234

        val distance2 = startPoint.distanceTo(endPoint2).toDouble()

        val endPoint3 = Location("LocationD")
        endPoint3.latitude = 50.4522
        endPoint3.longitude = 30.5971

        val distance3 = startPoint.distanceTo(endPoint3).toDouble()

        val endPoint4 = Location("LocationE")
        endPoint4.latitude = 50.4549
        endPoint4.longitude = 30.6119

        val distance4 = startPoint.distanceTo(endPoint4).toDouble()


        val endPoint5 = Location("LocationF")
        endPoint5.latitude = 50.4378
        endPoint5.longitude = 30.5157

        val distance5 = startPoint.distanceTo(endPoint5).toDouble()

        var finalDistance = listOf(distance, distance2, distance3, distance4, distance5)

        var finalDistanceMin = String.format("%.5f",finalDistance.minOrNull())


        btbranch.setOnClickListener {
            tvBranch.visibility = View.VISIBLE
            if (swLangLocation.isChecked) {

                if (finalDistanceMin == "7144.21094") {
                    tvBranch.setText(
                        "вул. Богдана Хмельницького, 24, Київ, Україна, 02000\n" +
                                "50.4459, 30.5150\n" +
                                "метро: Золоті Ворота"
                    )
                } else if (finalDistanceMin == "6412.5810546875") {
                    tvBranch.setText(
                        "Боричів Спуск, 8, Київ, Україна, 02000\n" +
                                "50.4588, 30.5234\n" +
                                "метро: Поштова Площа"
                    )
                } else if (finalDistanceMin == "1360.21069") {
                    tvBranch.setText(
                        "Броварський просп., 17, Київ, Україна, 02000\n" +
                                "50.4522, 30.5971\n" +
                                "метро: Лівобережна"
                    )
                } else if (finalDistanceMin == "399.22589") {
                    tvBranch.setText(
                        "вул. Попудренко, 9А, Київ, Україна, 02000\n" +
                                "50.4549, 30.6119\n" +
                                "метро: Дарниця"
                    )
                } else if (finalDistanceMin == "7324.68506") {
                    tvBranch.setText(
                        "вул. Велика Васильківська, 36, Київ, Україна, 02000\n" +
                                "50.4378, 30.5157\n" +
                                "метро: Площа Льва Толстого"
                    )
                } else {
                    tvBranch.setText(
                        "Вибачте, наші відділення відсутні\n" +
                                "поруч із Вами"
                    )
                }

            } else {
                if (finalDistanceMin == "7144.21094") {
                    tvBranch.setText(
                        "Bohdana Khmel'nyts'koho St, 24, Kyiv, Ukraine, 02000\n" +
                                "50.4459, 30.5150\n" +
                                "metro: Zoloti Vorota"
                    )
                } else if (finalDistanceMin == "6412.5810546875") {
                    tvBranch.setText(
                        "Borychiv descent, 8, Kyiv, Ukraine, 02000\n" +
                                "50.4588, 30.5234\n" +
                                "metro: Poshtova Ploshcha"
                    )
                } else if (finalDistanceMin == "1360.21069") {
                    tvBranch.setText(
                        "Brovarskyi Ave, 17, Kyiv, Ukraine, 02000\n" +
                                "50.4522, 30.5971\n" +
                                "metro: Livoberezhna"
                    )
                } else if (finalDistanceMin == "399.22589") {
                    tvBranch.setText(
                        "Popudrenka St, 9А, Kyiv, Ukraine, 02000\n" +
                                "50.4549, 30.6119\n" +
                                "metro: Darnytsia"
                    )
                } else if (finalDistanceMin == "7324.68506") {
                    tvBranch.setText(
                        "Velyka Vasylkivska St, 36, Kyiv, Ukraine, 02000\n" +
                                "50.4378, 30.5157\n" +
                                "metro: Ploshcha Lva Tolstog"
                    )
                } else {
                    tvBranch.setText(
                        "Sorry, we do not have branches\n" +
                                "next to your location"
                    )
                }
            }
        }




        changeLangLocation()

    }



    fun changeLangLocation() {
        swLangLocation.setOnClickListener {
            if (swLangLocation.isChecked) {

                tvlatitude.setText("Широта :")
                tvlongitude.setText("Довгота :")
                tvCheckLoginAllApp.setText("Поточна локація")
                tvGetBranch.setText("Найближче відділення")
                swLangLocation.setText("АНГЛ")
                tvLangLocation.setText("УКР")

            } else {

                tvlatitude.setText("Latitude :")
                tvlongitude.setText("Longitude :")
                tvCheckLoginAllApp.setText("Set Your Location")
                tvGetBranch.setText("Get Nearest Branch")
                swLangLocation.setText("ENG")
                tvLangLocation.setText("UKR")

            }
        }
    }


}
