package br.com.thiagowlian.TicketManager.controller

import br.com.thiagowlian.TicketManager.dto.TicketDto
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import br.com.thiagowlian.TicketManager.dto.TicketInsertDto
import br.com.thiagowlian.TicketManager.model.Ticket
import br.com.thiagowlian.TicketManager.service.TicketService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import java.net.URI

@RestController
@RequestMapping("/ticket")
class TicketController(private var ticketService: TicketService) {

    @PostMapping
    fun createTicket(@RequestBody ticketInsertDto: TicketInsertDto): ResponseEntity<TicketDto> {
        var ticket = ticketInsertDto.toEntity()
        var ticketDto = ticket.let {
            ticketService.saveTicket(it)
            TicketDto(it)
        }
        return ResponseEntity.created(URI.create("/ticket/${ticket.id}")).body(ticketDto)
    }

    @GetMapping("/{id}")
    fun getTicketById(@PathVariable id: Long) : ResponseEntity<TicketDto> {
        var ticket: Ticket = ticketService.findById(id);
        var ticketDto = TicketDto(ticket)
        return ResponseEntity.ok().body(ticketDto)
    }
}