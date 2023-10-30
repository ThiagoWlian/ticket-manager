package br.com.thiagowlian.TicketManager.repository

import br.com.thiagowlian.TicketManager.model.Ticket
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TicketRepository : JpaRepository<Ticket, Long>{
}