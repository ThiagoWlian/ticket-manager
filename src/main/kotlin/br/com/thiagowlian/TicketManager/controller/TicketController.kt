package br.com.thiagowlian.TicketManager.controller

import br.com.thiagowlian.TicketManager.dto.TicketDto
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import br.com.thiagowlian.TicketManager.dto.TicketInsertDto
import br.com.thiagowlian.TicketManager.model.Ticket
import br.com.thiagowlian.TicketManager.service.TicketService
import br.com.thiagowlian.TicketManager.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PutMapping
import java.net.URI

@RestController
@RequestMapping("/ticket")
class TicketController(private var ticketService: TicketService, private var userService: UserService) {

    @PostMapping
    fun createTicket(@RequestBody ticketInsertDto: TicketInsertDto): ResponseEntity<TicketDto> {
        var creator = userService.findById(ticketInsertDto.creatorId)
        var ticket = ticketInsertDto.toEntity(creator)
        ticketService.saveTicket(ticket)
        var ticketDto = TicketDto(ticket)
        return ResponseEntity.created(URI.create("/ticket/${ticket.id}")).body(ticketDto)
    }

    @PutMapping("/{id}")
    fun updateStatusTicket(@PathVariable id: Long, @RequestBody status: String): ResponseEntity<TicketDto> {
        var ticket = userService.findById(id)
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}")
    fun getTicketById(@PathVariable id: Long) : ResponseEntity<TicketDto> {
        var ticket: Ticket = ticketService.findById(id);
        var ticketDto = TicketDto(ticket)
        return ResponseEntity.ok().body(ticketDto)
    }

    @GetMapping
    fun getAllTicket() : ResponseEntity<List<TicketDto>> {
        var tickets: List<Ticket> = ticketService.findAll();
        var ticketsDto = tickets.map { e -> TicketDto(e) }
        return ResponseEntity.ok().body(ticketsDto)
    }
}