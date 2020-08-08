package com.monro.shared.src.domain

import java.util.*
import kotlin.collections.ArrayList

abstract class AggregateRoot {
    @Transient
    private val domainEvents = ArrayList<DomainEvent>()

    fun pullDomainEvents(): Collection<DomainEvent> {
        val currentDomainEvents = Collections.unmodifiableList<DomainEvent>(domainEvents.toList())
        domainEvents.clear()
        return currentDomainEvents
    }

    fun registerEvent(event: DomainEvent): DomainEvent {
        this.domainEvents.add(event)
        return event
    }
}