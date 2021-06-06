package ru.emakhankov.theshamelessselfpromoapp

import java.io.Serializable

data class Message(val contactName: String, val contactNumber: String, val myDisplayName: String,
                   val includeJunior: Boolean, val jobTitle: String?, val immediateStart: Boolean,
                   val startDate: String?): Serializable {

                       fun getFullJobDescription() = if (!includeJunior) "a $jobTitle" else "a Junior $jobTitle"

                        fun getAvailability() = if (immediateStart) "immediately" else "from $startDate"
                   }