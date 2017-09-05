package eu.aagsolutions.trip.service.geo.services

import com.google.maps.GeoApiContext
import eu.aagsolutions.trip.service.geo.model.GeoPoint
import com.google.maps.GeocodingApi
import java.math.BigDecimal
import com.google.maps.errors.ApiException
import java.io.IOException
import eu.aagsolutions.trip.service.exceptions.BadGatewayException
import org.springframework.stereotype.Service


/**
 *
 */
@Service
class GeoPointService(val context: GeoApiContext?) {

    fun findGeoPointForAddress(address: String): GeoPoint {
        try {
            val results = GeocodingApi.geocode(context, address).await()
            return GeoPoint(address, BigDecimal.valueOf(results[0].geometry.location.lat)
                    ,BigDecimal.valueOf(results[0].geometry.location.lng))
        } catch (e: ApiException) {
            throw BadGatewayException("Google maps service access error", e)
        } catch (e: InterruptedException) {
            throw BadGatewayException("Google maps service access error", e)
        } catch (e: IOException) {
            throw BadGatewayException("Google maps service access error", e)
        }

    }
}
