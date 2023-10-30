package br.com.thiagowlian.TicketManager.model

import br.com.thiagowlian.TicketManager.dto.TicketInsertDto
import jakarta.persistence.*

@Entity
@Table(name = "Ticket")
data class Ticket(
        @Column(name = "title")
        var title: String,
        @Column(name = "description")
        var description: String?,
        @Column(name = "status")
        @Enumerated(EnumType.STRING)
        var status: StatusTicket,
        @Column(name = "urgency")
        @Enumerated(EnumType.STRING)
        var urgency: UrgencyTicket,
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long?,
) {

    constructor(ticketDto: TicketInsertDto) : this(ticketDto.title, ticketDto.descripton, StatusTicket.valueOf(ticketDto.status), UrgencyTicket.valueOf(ticketDto.urgency), null)
}