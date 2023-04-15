package com.github.cesar1287.jogodavelha.model

data class Cell(
    var player: Player?
) {

    val isEmpty: Boolean
        get() = player?.value?.isEmpty() == true
}

