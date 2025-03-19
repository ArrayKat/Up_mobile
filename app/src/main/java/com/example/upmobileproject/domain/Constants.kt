package com.example.upmobileproject.domain

import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.gotrue.Auth
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.storage.Storage

object Constants {
    val Supabase = createSupabaseClient(
        supabaseUrl = "https://jvzvjcruiufhuptnlsly.supabase.co",
        supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6Imp2enZqY3J1aXVmaHVwdG5sc2x5Iiwicm9sZSI6ImFub24iLCJpYXQiOjE3NDIzMTUyMjksImV4cCI6MjA1Nzg5MTIyOX0.zAiikpKPThIzCdvak0hdon2MmakkVkjQMFAk9RGRT28"
    ){
        install(Auth)
        install(Postgrest)
        install(Storage)
    }
}