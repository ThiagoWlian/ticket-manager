package br.com.thiagowlian.TicketManager.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "user")
data class User(
    @Column
    var name: String,
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long)
