package com.monro.shared.src.domain

import java.io.Serializable
import java.time.LocalDateTime
import java.util.*
import kotlin.collections.HashMap

abstract class DomainEvent(
        var aggregateId: String,
        var body: HashMap<String, Serializable>,
        var eventId: String = UUID.randomUUID().toString(),
        var ocurredOn: String = LocalDateTime.now().toString()
)