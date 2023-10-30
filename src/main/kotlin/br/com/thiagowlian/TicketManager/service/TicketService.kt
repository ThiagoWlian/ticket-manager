package br.com.thiagowlian.TicketManager.service

import br.com.thiagowlian.TicketManager.model.Ticket
import br.com.thiagowlian.TicketManager.repository.TicketRepository
import org.springframework.stereotype.Service
import java.util.Optional

@Service
class TicketService(private var ticketRepository: TicketRepository) {

    fun saveTicket(ticket: Ticket) {
        ticketRepository.save(ticket)
    }

    fun findAll(ticket: Ticket) {
        ticketRepository.findAll()
    }

    fun findById(id: Long) : Ticket {
        var ticke: Optional<Ticket> = ticketRepository.findById(id)
        if (ticke.isPresent)
            return ticketRepository.findById(id).get();
        else
            throw ValueNotFoundException("Não existe ticket com o ID informado!")
    }
}