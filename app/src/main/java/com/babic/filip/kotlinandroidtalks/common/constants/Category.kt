package com.babic.filip.kotlinandroidtalks.common.constants

import java.io.Serializable

/**
 * Created by Filip Babic @cobe
 */
sealed class Category : Serializable {

    class None : Category()

    data class Work(val colleagueName: String = "") : Category()

    data class Shopping(val items: List<String> = listOf()) : Category()

    data class Bills(val amount: Float = 0f, val deadline: String = "") : Category()
}