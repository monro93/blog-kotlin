package com.monro.shared.src.domain

import java.util.*

abstract class Id internal constructor(
        uuid: String?
) {
    protected val uuid = if (uuid !== null) UUID.fromString(uuid).toString() else UUID.randomUUID().toString()

    override fun equals(other: Any?): Boolean {
        if(this === other) {
            return true
        }
        if (other == null || javaClass != other.javaClass) {
            return false
        }
        val that: Id = other as Id
        return uuid == that.uuid
    }

    override fun hashCode(): Int {
        return uuid.hashCode() ?: 0
    }
}