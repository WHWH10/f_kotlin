package com.example.myapplication.안드로이드_Essential

import io.realm.RealmObject

open class School : RealmObject() {
    var name: String? = null
    var location: String? = null
}