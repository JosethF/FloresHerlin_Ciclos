package com.example.loginclear

class Ciclo(var title:String, var fullName:String) {

    @JvmName("getTitle1")
    fun getTitle():String{ return this.title }

    @JvmName("getFullName1")
    fun getFullName():String{ return  this.fullName }

    @JvmName("setTitle1")
    fun setTitle(title:String){ this.title=title}

    @JvmName("setFullName1")
    fun setFullName(fullName:String){ this.fullName=fullName}
}