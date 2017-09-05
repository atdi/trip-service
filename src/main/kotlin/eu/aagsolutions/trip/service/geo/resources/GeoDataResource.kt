package eu.aagsolutions.trip.service.geo.resources

import eu.aagsolutions.trip.service.geo.model.GeoPoint
import eu.aagsolutions.trip.service.geo.services.GeoPointService
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("geo")
class GeoDataResource(val geoPointService: GeoPointService) {

    @GetMapping(value = "/coding", produces = arrayOf(MediaType.APPLICATION_JSON_UTF8_VALUE))
    fun getPatient(@RequestParam("address") address: String): ResponseEntity<GeoPoint> {
        val geoPoint = geoPointService.findGeoPointForAddress(address)

        return ResponseEntity.ok(geoPoint)
    }

}