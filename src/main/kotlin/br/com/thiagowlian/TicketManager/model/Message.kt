package br.com.thiagowlian.TicketManager.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name = "message")
data class Message(
    @Column
    var message: String,
    @Column
    var creationDate: LocalDateTime,
    @ManyToOne
    @JoinColumn(name = "ticketId")
    var ticket: Ticket,
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?,)
