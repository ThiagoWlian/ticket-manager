package br.com.thiagowlian.TicketManager.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.NOT_FOUND)
class ValueNotFoundException(message: String) : Exception(message) {
}