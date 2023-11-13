package br.com.thiagowlian.TicketManager.model.validation

import br.com.thiagowlian.TicketManager.exception.ResponsibleNotFoundException
import br.com.thiagowlian.TicketManager.model.Ticket

class CreatorValidation(var ticket: Ticket) : BaseValidation<Ticket>(ticket) {
    override fun isValid(): Boolean {
        if (ticket.creator == null) {
            throw ResponsibleNotFoundException("Nenhum responsável foi atribuído ao ticket!")
        }
        return startNextValidation()
    }
}