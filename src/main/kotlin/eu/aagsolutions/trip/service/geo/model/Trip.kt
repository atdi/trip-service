package eu.aagsolutions.trip.service.geo.model

class Trip(val startPoint: GeoPoint, val endPoint: GeoPoint, val stopPoints: Set<GeoPoint>)
