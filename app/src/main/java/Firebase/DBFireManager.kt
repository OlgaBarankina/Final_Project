package Firebase

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_main_application.*
import android.content.Intent
import androidx.core.content.ContextCompat.startActivity
import com.example.final_project.MainActivityApplication
import android.content.Intent.getIntent

import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_dbmain.*


class DBFireManager: DBInterface {
    val database = FirebaseDatabase.getInstance()


    override fun getAllApplications(callback: DbCallBack) {
        val applications = ArrayList<String>()
        val reference = database.getReference("db").child("tourapp")

        reference.addValueEventListener(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                applications.clear()

                for (item in snapshot.children) {

                    val value: String? =
                        item.getValue(String::class.java)
                    if (value != null) applications.add(value)
                }
                callback.onAllApplications(applications)
            }

            override fun onCancelled(error: DatabaseError) {}

        })


    }
}

interface DbCallBack {
    fun onAllApplications(applications: ArrayList<String>)
}