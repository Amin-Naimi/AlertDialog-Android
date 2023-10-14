package com.example.emptyproject

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.TextView
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dialogAlert = AlertDialog.Builder(this)// creation de l'alert
        val dialog = dialogAlert.create()// creation de dialog

        val dialogView = layoutInflater.inflate(R.layout.progressdialog, null) //recuperation de lxml
        val textView = dialogView.findViewById<TextView>(R.id.message)
            textView.text = getString(R.string.message_text)

        dialog.setView(dialogView)
        dialog.show()
        Handler(Looper.getMainLooper()).postDelayed({dialog.dismiss()}, 5000)
    }

    override fun onBackPressed() {
        val builder = AlertDialog.Builder(this)
        builder.setMessage("Do you Want to close the application")
        builder.setPositiveButton("No", { dialogInterface: DialogInterface, i: Int -> })
        builder.setNegativeButton("YES", { dialogInterface: DialogInterface, i: Int ->
            super.onBackPressed()
        })
        builder.show()
    }



}