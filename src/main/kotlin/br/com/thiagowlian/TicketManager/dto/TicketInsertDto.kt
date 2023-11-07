package br.com.thiagowlian.TicketManager.dto

import br.com.thiagowlian.TicketManager.model.Ticket
import br.com.thiagowlian.TicketManager.model.User

data class TicketInsertDto(val title: String, val descripton: String, val status: String, val urgency: String, val creatorId: Long) {

    fun toEntity(creator: User): Ticket {
        return Ticket(this, creator)
    }
}