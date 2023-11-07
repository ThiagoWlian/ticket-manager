package br.com.thiagowlian.TicketManager.model

import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

abstract class EntityBase(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?
) {
}