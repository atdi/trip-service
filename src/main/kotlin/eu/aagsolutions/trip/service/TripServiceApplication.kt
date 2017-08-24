package eu.aagsolutions.trip.service

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class TripServiceApplication

fun main(args: Array<String>) {
    SpringApplication.run(TripServiceApplication::class.java, *args)
}
