package com.monro.shared.src.domain

import java.util.*

fun generateAggregateRootId(): String {
    return  UUID.randomUUID().toString();
}