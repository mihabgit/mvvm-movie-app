package com.mihab.cmedmvvm.service.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Character(
    val image: String?,
    val name: String?,
    val actor: String?,
    val house: String?,
    val species: String?,
    val gender: String?,
    val dateOfBirth: String?,
): Parcelable
