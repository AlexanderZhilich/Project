package com.example.bottomnavigation

class QueryBuilder {

    fun toleranceRequest (tolerance: String): String {
        val toleranceRequest = when (tolerance) {
            "a11" -> "AL11"
            "b11" -> "BL11"
            "b12" -> "BL12"
            "c8" -> "CL8"
            "c11" -> "CL11"
            "d8" -> "DL8"
            "d9" -> "DL9"
            "d10" -> "DL10"
            "d11" -> "DL11"
            "e7" -> "EL7"
            "e8" -> "EL8"
            "e9" -> "EL9"
            "f6" -> "FL6"
            "f7" -> "FL7"
            "f8" -> "FL8"
            "f9" -> "FL9"
            "g4" -> "GL4"
            "g5" -> "GL5"
            "g6" -> "GL6"
            "h4" -> "HL4"
            "h5" -> "HL5"
            "h6" -> "HL6"
            "h7" -> "HL7"
            "h8" -> "HL8"
            "h9" -> "HL9"
            "h10" -> "HL10"
            "h11" -> "HL11"
            "h12" -> "HL12"
            "h13" -> "HL13"
            "h14" -> "HL14"
            "j4" -> "JSL4"
            "j5" -> "JSL5"
            "j6" -> "JSL6"
            "j7" -> "JSL7"
            "j8" -> "JSL8"
            "j9" -> "JSL9"
            "j10" -> "JSL10"
            "j11" -> "JSL11"
            "j12" -> "JSL12"
            "j13" -> "JSL13"
            "j14" -> "JSL14"
            "k4" -> "KL4"
            "k5" -> "KL5"
            "k6" -> "KL6"
            "k7" -> "KL7"
            "m4" -> "ML4"
            "m5" -> "ML5"
            "m6" -> "ML6"
            "m7" -> "ML7"
            "n4" -> "NL4"
            "n5" -> "NL5"
            "n6" -> "NL6"
            "n7" -> "NL7"
            "p5" -> "PL5"
            "p6" -> "PL6"
            "r5" -> "RL5"
            "r6" -> "RL6"
            "s5" -> "SL5"
            "s6" -> "SL6"
            "s7" -> "SL7"
            "t6" -> "Tl6"
            "u7" -> "UL7"
            "u8" -> "UL8"
            "x8" -> "XL8"
            "z8" -> "ZL8"
            else -> tolerance
        }
        return toleranceRequest
    }
   fun sizeUpRequest (size: Double): String {
        val sizeUp = when (size) {
            in 0.0..1.0 -> "1 Up"
            in 1.0..3.0 -> "2 Up"
            in 3.0..6.0 -> "3 Up"
            in 6.0..10.0 -> "4 Up"
            in 10.0..14.0 -> "5 Up"
            in 14.0..18.0 -> "6 Up"
            in 18.0..24.0 -> "7 Up"
            in 24.0..30.0 -> "8 Up"
            in 30.0..40.0 -> "9 Up"
            in 40.0..50.0 -> "10 Up"
            in 50.0..65.0 -> "11 Up"
            in 65.0..80.0 -> "12 Up"
            in 80.0..100.0 -> "13 Up"
            in 100.0..120.0 -> "14 Up"
            in 120.0..140.0 -> "15 Up"
            in 140.0..160.0 -> "16 Up"
            in 160.0..180.0 -> "17 Up"
            in 180.0..200.0 -> "18 Up"
            in 200.0..225.0 -> "19 Up"
            in 225.0..250.0 -> "20 Up"
            in 250.0..280.0 -> "21 Up"
            in 280.0..315.0 -> "22 Up"
            in 315.0..355.0 -> "23 Up"
            in 355.0..400.0 -> "24 Up"
            in 400.0..450.0 -> "25 Up"
            in 450.0..1000000.0 -> "26 Up"
            else -> "not rated"
        }
        return sizeUp
    }
    fun sizeDwRequest (size: Double): String {
        val sizeDw = when (size) {
            in 0.0..1.0 -> "1 Dw"
            in 1.0..3.0 -> "2 Dw"
            in 3.0..6.0 -> "3 Dw"
            in 6.0..10.0 -> "4 Dw"
            in 10.0..14.0 -> "5 Dw"
            in 14.0..18.0 -> "6 Dw"
            in 18.0..24.0 -> "7 Dw"
            in 24.0..30.0 -> "8 Dw"
            in 30.0..40.0 -> "9 Dw"
            in 40.0..50.0 -> "10 Dw"
            in 50.0..65.0 -> "11 Dw"
            in 65.0..80.0 -> "12 Dw"
            in 80.0..100.0 -> "13 Dw"
            in 100.0..120.0 -> "14 Dw"
            in 120.0..140.0 -> "15 Dw"
            in 140.0..160.0 -> "16 Dw"
            in 160.0..180.0 -> "17 Dw"
            in 180.0..200.0 -> "18 Dw"
            in 200.0..225.0 -> "19 Dw"
            in 225.0..250.0 -> "20 Dw"
            in 250.0..280.0 -> "21 Dw"
            in 280.0..315.0 -> "22 Dw"
            in 315.0..355.0 -> "23 Dw"
            in 355.0..400.0 -> "24 Dw"
            in 400.0..450.0 -> "25 Dw"
            in 450.0..1000000.0 -> "26 Dw"
            else -> "not rated"
        }
        return sizeDw
    }
    fun getTolerance (allTolerance:String,tolerance: String): String {
        val value1=allTolerance.substringAfter(tolerance)
        val value2=value1.substringAfter('=')
        val value3=value2.substringBefore(',')
       return value3
    }
    }