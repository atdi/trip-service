package eu.aagsolutions.trip.service.geo.model

import java.util.Date

class Event(
        val id: Long?,
        val point: GeoPoint,
        val startDateTime: Date,
        val duration: Int,
        val tripId: Long)