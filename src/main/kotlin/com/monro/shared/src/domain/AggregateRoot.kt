package com.monro.shared.src.domain

class AggregateRoot(
        var domainEvents: MutableCollection<DomainEvent>
) {
    fun pullDomainEvents(): Collection<DomainEvent> {
        val currentDomainEvents = domainEvents.toList();
        domainEvents.clear();
        return currentDomainEvents;
    }
}