package eu.aagsolutions.trip.service.geo.resources

import eu.aagsolutions.trip.service.geo.model.GeoPoint
import eu.aagsolutions.trip.service.geo.services.GeoPointService
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.stream.Collectors


@RestController
@RequestMapping("geo")
class GeoDataResource(val geoPointService: GeoPointService) {

    @GetMapping(value = "/coding", produces = arrayOf(MediaType.APPLICATION_JSON_UTF8_VALUE))
    fun getGeoCodeForAddress(@RequestParam("address") address: String): ResponseEntity<GeoPoint> {
        val geoPoint = geoPointService.findGeoPointForAddress(address)

        return ResponseEntity.ok(geoPoint)
    }


    @PostMapping(value = "/coding", produces = arrayOf(MediaType.APPLICATION_JSON_UTF8_VALUE))
    fun getGeoCodes(@RequestBody addresses: Set<GeoPoint>): ResponseEntity<Set<GeoPoint>> {
        val geoPoints: Set<GeoPoint> = addresses.stream().map { a -> geoPointService.findGeoPointForAddress(a.address) }
                .collect(Collectors.toSet())
        return ResponseEntity.ok(geoPoints)
    }



}