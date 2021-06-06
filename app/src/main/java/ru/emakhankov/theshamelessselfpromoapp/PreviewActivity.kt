package ru.emakhankov.theshamelessselfpromoapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_preview.*

class PreviewActivity : AppCompatActivity() {

    private lateinit var message: Message
    private lateinit var messagePreviewText: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preview)

        displayMessage()
        setupButton()

        /* val contactName = intent.getStringExtra("Contact Name")
         val contactNumber = intent.getStringExtra("Contact Number")
         val myDisplayName = intent.getStringExtra("My Display")
         val includeJunior = intent.getBooleanExtra("Include Junior", false)
         val jobTitle = intent.getStringExtra("Job Title")
         val immediateStart = intent.getBooleanExtra("Immediate Start", false)
         val startDate = intent.getStringExtra("Start Date")

         val textString = "Contact Name: $contactName, Contact Number: $contactNumber, My Display Name: $myDisplayName, Include Junior: $includeJunior, Job Title: $jobTitle, Immediate Start: $immediateStart, Start Date: $startDate"
         text_view_message.text = textString*/


    }

    private fun setupButton() {
        button_send_message.setOnClickListener {
            // send message intent

            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("smsto: ${message.contactNumber}")
                putExtra("sms_body", messagePreviewText)

            }

            startActivity(intent)

        }
    }

    private fun displayMessage() {

        message = intent.getSerializableExtra("Message") as Message

        messagePreviewText = """
                Hi ${message.contactName},
                
                My name is ${message.myDisplayName} and I am ${message.getFullJobDescription()}.
                
                I have a portfolio of apps to demonstrate my technical skills that i can show on request
                
                
                I am able to staet a new position ${message.getAvailability()}.
                
                Please get in touch if you have any suitabble roles for me.
                
                Thanks and best regards
                
            """.trimIndent()

        text_view_message.text = messagePreviewText
    }
}