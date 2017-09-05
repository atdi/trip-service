package eu.aagsolutions.trip.service.exceptions

/**
 *
 */
class BadGatewayException(message: String, e: Throwable) : RuntimeException(message, e)
