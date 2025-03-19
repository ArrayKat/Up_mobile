package com.example.upmobileproject.data.models

import android.icu.util.Calendar
import kotlinx.serialization.Serializable
import java.sql.Time
import java.time.LocalDateTime
import java.time.OffsetDateTime
import java.time.ZoneOffset

@Serializable
data class profiles (
    val id:String ="",
    val created_at:String = "",
    val user_id:String="",
    val photo:String="",
    val firstname:String="",
    val lastname:String="",
    val address:String="",
    val phone:String =""
)

