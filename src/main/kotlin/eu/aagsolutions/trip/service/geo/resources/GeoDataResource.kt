package eu.aagsolutions.trip.service.geo.resources

import eu.aagsolutions.trip.service.geo.model.Event
import eu.aagsolutions.trip.service.geo.model.GeoPoint
import eu.aagsolutions.trip.service.geo.model.Trip
import eu.aagsolutions.trip.service.geo.services.GeoPointService
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.stream.Collectors


@RestController
@RequestMapping("geo")
class GeoDataResource(val geoPointService: GeoPointService) {

    @GetMapping(value = "coding", produces = arrayOf(MediaType.APPLICATION_JSON_UTF8_VALUE))
    fun getGeoCodeForAddress(@RequestParam("address") address: String): ResponseEntity<GeoPoint> {
        val geoPoint = geoPointService.findGeoPointForAddress(address)

        return ResponseEntity.ok(geoPoint)
    }


    @PostMapping(value = "coding", consumes = arrayOf(MediaType.APPLICATION_JSON_UTF8_VALUE),
            produces = arrayOf(MediaType.APPLICATION_JSON_UTF8_VALUE))
    fun getGeoCodes(@RequestBody addresses: Set<GeoPoint>): ResponseEntity<Set<GeoPoint>> {
        val geoPoints: Set<GeoPoint> = addresses.stream()
                .map { a -> geoPointService.findGeoPointForAddress(a.address) }
                .collect(Collectors.toSet())
        return ResponseEntity.ok(geoPoints)
    }

    @PostMapping(value = "coding/trip", consumes = arrayOf(MediaType.APPLICATION_JSON_UTF8_VALUE),
            produces = arrayOf(MediaType.APPLICATION_JSON_UTF8_VALUE))
    fun getGeoCodesForTrip(@RequestBody trip: Trip): ResponseEntity<Trip> {
        val stopPoints: Set<Event> = trip.events.stream()
                .map { e -> Event(e.id, geoPointService.findGeoPointForAddress(e.point.address),
                        e.startDateTime, e.duration, e.tripId) }
                .collect(Collectors.toSet())
        val startPoint = geoPointService.findGeoPointForAddress(trip.startPoint.address)
        val endPoint = geoPointService.findGeoPointForAddress(trip.endPoint.address)
        return ResponseEntity.ok(Trip(trip.id, startPoint, endPoint, trip.startDate, stopPoints))
    }


}