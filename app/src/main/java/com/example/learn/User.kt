package com.example.learn

class User {
    var name_ : String? = null
    var email : String? = null
    var uid : String? = null

    constructor(){}

    constructor(name: String? , email: String? , uid: String?){

        this.name_ = name
        this.email= email
        this.uid = uid

    }
}