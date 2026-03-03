package com.example.userprofile

import android.os.Bundle
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.bluelinelabs.conductor.Conductor
import com.bluelinelabs.conductor.Router
import com.bluelinelabs.conductor.RouterTransaction

class ProfileDisplayActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_profile)
        val container = findViewById<ViewGroup>(R.id.controller_profile_container)
        val bundle = intent.extras
        val router: Router = Conductor.attachRouter(this, container, savedInstanceState)
            .setPopRootControllerMode(Router.PopRootControllerMode.NEVER)
        if (!router.hasRootController()){
            router.setRoot(RouterTransaction.with(ProfileController(bundle)))
        }
    }
}

