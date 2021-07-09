package com.example.mobile.javamodulo2.util

import java.util.regex.Matcher
import java.util.regex.Pattern


fun String.validateFormaterEmail(): Boolean{
    // Patrón para validar el email
    val pattern: Pattern = Pattern
            .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")
    val mather: Matcher = pattern.matcher(this)
    return mather.find()
}