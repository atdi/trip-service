package eu.aagsolutions.trip.service.geo.services

import com.google.maps.GeoApiContext
import com.google.maps.GeocodingApi
import com.google.maps.errors.ApiException
import eu.aagsolutions.trip.service.exceptions.BadGatewayException
import eu.aagsolutions.trip.service.geo.model.GeoPoint
import org.springframework.stereotype.Service
import java.io.IOException


/**
 *
 */
@Service
class GeoPointService(val context: GeoApiContext?) {

    fun findGeoPointForAddress(address: String): GeoPoint {
        try {
            val results = GeocodingApi.geocode(context, address).await()
            return GeoPoint(address, results[0].geometry.location.lat,
                    results[0].geometry.location.lng)
        } catch (e: ApiException) {
            throw BadGatewayException("Google maps service access error", e)
        } catch (e: InterruptedException) {
            throw BadGatewayException("Google maps service access error", e)
        } catch (e: IOException) {
            throw BadGatewayException("Google maps service access error", e)
        }

    }
}
