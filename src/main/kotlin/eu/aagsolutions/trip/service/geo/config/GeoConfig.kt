package eu.aagsolutions.trip.service.geo.config

import com.google.maps.GeoApiContext
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class GeoConfig {

    @Bean
    fun geoApiContext(@Value("\${google.maps.key}") googleMapsKey: String): GeoApiContext {
        return GeoApiContext.Builder().apiKey(googleMapsKey).build()
    }

}