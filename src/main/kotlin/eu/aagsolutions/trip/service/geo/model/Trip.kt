package eu.aagsolutions.trip.service.geo.model

class Trip(val id: Long?, val startPoint: GeoPoint, val endPoint: GeoPoint, val stopPoints: Set<Event>)
