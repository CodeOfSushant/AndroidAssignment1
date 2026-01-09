plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.example.userprofile"
    compileSdk {
        version = release(36)
    }

    defaultConfig {
        applicationId = "com.example.userprofile"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

}

dependencies{
    implementation("com.bluelinelabs:conductor:3.2.0")
    // AndroidX Transition change handlers:
    implementation("com.bluelinelabs:conductor-androidx-transition:3.2.0")
    // ViewPager PagerAdapter:
    implementation("com.bluelinelabs:conductor-viewpager:3.2.0")
    // ViewPager2 Adapter:
    implementation("com.bluelinelabs:conductor-viewpager2:3.2.0")
}

