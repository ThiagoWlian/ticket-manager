package br.com.thiagowlian.TicketManager

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TicketManagerApplication

fun main(args: Array<String>) {
	runApplication<TicketManagerApplication>(*args)
}
