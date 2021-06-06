package ru.emakhankov.theshamelessselfpromoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

/*    private var contactNameEditText: TextInputEditText? = null
    private var contactNumberEditText: TextInputEditText? = null
    private var myDisplayNameEditText: TextInputEditText? = null
    private var startDateEditText: TextInputEditText? = null
    private var juniorCheckBox: CheckBox? = null
    private var immediateStartCheckBox: CheckBox? = null
    private var jobTitleSpinner: Spinner? = null*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val spinnerValues: Array<String> = arrayOf("Android Developer", "Android Enginner")
        val spinnerAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, spinnerValues)

        spinner_job_title.adapter = spinnerAdapter



/*        contactNameEditText = findViewById(R.id.edit_text_contact_name)
        contactNumberEditText = findViewById(R.id.edit_text_contact_number)
        myDisplayNameEditText = findViewById(R.id.edit_text_my_display_name)
        startDateEditText = findViewById(R.id.edit_text_start_date)
        juniorCheckBox = findViewById(R.id.check_box_junior)
        immediateStartCheckBox = findViewById(R.id.check_box_immediate_start)
        jobTitleSpinner = findViewById(R.id.spinner_job_title)*/


/*

        val previewButton: Button = findViewById(R.id.button_preview)

        previewButton.setOnClickListener {
            //Toast.makeText(this, "My button click works in Kotlin", Toast.LENGTH_LONG).show()
            onPreviewClicked()
        }*/

        button_preview.setOnClickListener {
            onPreviewClicked()
        }
    }

    private fun onPreviewClicked() {

     /*   val textString = contactNameEditText?.text.toString() + ", " + contactNumberEditText?.text.toString()
        Toast.makeText(this, textString, Toast.LENGTH_LONG).show()*/
/*
        val textString = edit_text_contact_name?.text.toString() + ", " + edit_text_contact_number?.text.toString()
        Toast.makeText(this, textString, Toast.LENGTH_LONG).show()
        */

/*        val contactName = edit_text_contact_name.text.toString()
        val contactNumber = edit_text_contact_number.text.toString()
        val myDisplayName = edit_text_my_display_name.text.toString()
        val includeJunior = check_box_junior.isChecked
        val jobTitle = spinner_job_title.selectedItem?.toString()
        val immediateStart = check_box_immediate_start.isChecked
        val startDate = edit_text_start_date.toString()*/

        val message = Message(edit_text_contact_name.text.toString(),
            edit_text_contact_number.text.toString(),
            edit_text_my_display_name.text.toString(),
            check_box_junior.isChecked,
            spinner_job_title.selectedItem?.toString(),
            check_box_immediate_start.isChecked,
            edit_text_start_date.toString())

        val previewActivityIntent = Intent(this, PreviewActivity::class.java)
        previewActivityIntent.putExtra("Message", message)

/*        previewActivityIntent.putExtra("Contact Name", contactName)
        previewActivityIntent.putExtra("Contact Number", contactNumber)
        previewActivityIntent.putExtra("My Display", myDisplayName)
        previewActivityIntent.putExtra("Include Junior", includeJunior)
        previewActivityIntent.putExtra("Job Title", jobTitle)
        previewActivityIntent.putExtra("Immediate Start", immediateStart)
        previewActivityIntent.putExtra("Start Date", startDate)*/

        startActivity(previewActivityIntent)

        //val testString = "Harcoded values here $contactName some more values $contactNumber, My Display name: $myDisplayName, Include Junior: $includeJunior, Job Title: $jobTitle, Immediate Start: $immediateStart, Start Date: $startDate "

        //Toast.makeText(this, testString, Toast.LENGTH_LONG).show()
    }
}