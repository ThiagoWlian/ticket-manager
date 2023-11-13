package br.com.thiagowlian.TicketManager.dto

import br.com.thiagowlian.TicketManager.model.Ticket

data class TicketDto(val id: Long?, val title: String, val descripton: String?, val status: String, val urgency: String) {

    constructor(ticket: Ticket) : this(id=ticket.id, title=ticket.title, descripton=ticket.description, status=ticket.status.name, urgency = ticket.urgency!!.name)
}
