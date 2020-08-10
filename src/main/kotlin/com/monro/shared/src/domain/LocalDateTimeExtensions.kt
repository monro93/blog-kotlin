package com.monro.shared.src.domain

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun LocalDateTime.format() = format(
    DateTimeFormatter.ISO_LOCAL_DATE
)