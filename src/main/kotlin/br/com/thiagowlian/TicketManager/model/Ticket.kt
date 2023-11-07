package br.com.thiagowlian.TicketManager.model

import br.com.thiagowlian.TicketManager.dto.TicketInsertDto
import br.com.thiagowlian.TicketManager.model.validation.ResponsibleValidation
import jakarta.persistence.*

@Entity
@Table(name = "ticket")
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
    @Column
    @OneToOne
    var creator: User,
    @Column
    @OneToOne
    var responsible: User? = null,
    @Column
    @OneToMany(cascade = [CascadeType.ALL], orphanRemoval = true, mappedBy = "ticket")
    var messages: Set<Message>? = null,
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
) {
    constructor(ticketDto: TicketInsertDto, creator: User) : this(
        ticketDto.title,
        ticketDto.descripton,
        StatusTicket.valueOf(ticketDto.status),
        UrgencyTicket.valueOf(ticketDto.urgency),
        creator
    )
}