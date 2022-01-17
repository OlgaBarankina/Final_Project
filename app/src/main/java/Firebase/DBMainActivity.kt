package Firebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.final_project.MainActivityApplication
import com.example.final_project.R
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_dbmain.*
import kotlinx.android.synthetic.main.activity_dbmain.btStartAllApp
import kotlinx.android.synthetic.main.activity_dbmain.clLogin
import kotlinx.android.synthetic.main.activity_dbmain.edLoginAllApp
import kotlinx.android.synthetic.main.activity_dbmain.edPasswordAllApp

class DBMainActivity : AppCompatActivity() {

    private val database = FirebaseDatabase.getInstance()
    private val reference = database.getReference("db").child("tourapp") // path to my app
    private val applicationId = reference.push().key

    val dbManager = DBFireManager()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dbmain)

        val intent = intent
        val application2 = intent.getStringExtra("Application")


        if (applicationId != null)
            reference.child(applicationId).setValue(application2)



        dbManager.getAllApplications(object : DbCallBack {
            override fun onAllApplications(applications: ArrayList<String>) {

                var formatedMessage = ""

                for(application2 in applications) {
                    formatedMessage += ("\n" + application2)
                }

                tvApp.text = formatedMessage
            }
        })


        goToMainPage()

    }


    fun goToMainPage() {
        clLogin.setVisibility(View.VISIBLE)
        tvApp.setVisibility(View.INVISIBLE)

        val toastError = Toast.makeText(applicationContext, "Wrong Password! Try again", Toast.LENGTH_LONG) as Toast

        btStartAllApp.setOnClickListener {
            if ((edLoginAllApp.getText().toString().equals("olgab")) && (edPasswordAllApp.getText().toString()
                    .toInt().equals(12345))
            ) {
                clLogin.setVisibility(View.INVISIBLE)
                tvApp.setVisibility(View.VISIBLE)
            } else {
                toastError.show()
            }

        }
    }


}