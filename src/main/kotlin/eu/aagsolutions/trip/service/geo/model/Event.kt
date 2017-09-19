package eu.aagsolutions.trip.service.geo.model

import java.util.Date
import java.util.UUID

class Event(
        val id: UUID,
        val point: GeoPoint,
        val startDateTime: Date,
        val duration: Int,
        val tripId: UUID)