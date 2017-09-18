package eu.aagsolutions.trip.service.geo.model

import java.util.UUID

class Trip(val id: UUID, val startPoint: GeoPoint, val endPoint: GeoPoint, val stopPoints: Set<Event>)
