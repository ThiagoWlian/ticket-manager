package br.com.thiagowlian.TicketManager.dto

import br.com.thiagowlian.TicketManager.model.Ticket

data class TicketInsertDto(val title: String, val descripton: String, val status: String, val urgency: String) {

    fun toEntity(): Ticket {
        return Ticket(this)
    }
}