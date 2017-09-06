package eu.aagsolutions.trip.service.telematics.resources

import eu.aagsolutions.trip.service.telematics.model.AccessData
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("telematics")
class AccessDataResource {

    @GetMapping(produces = arrayOf(MediaType.APPLICATION_JSON_UTF8_VALUE))
    fun getGeoCodeForAddress(): ResponseEntity<AccessData> {
        return ResponseEntity.ok(AccessData(
                "dGVzdApE/1TBmAxLG7ndHPe9QkJlws2llGkwdxqczmxWj0ELHHNYwHgaVggoTIF3DqDSOk/mPYa/SE4qNHbBt5vgQZgaat/iG7m9GnPv6PVvUEk/bTOEt1QCBL7QNLg4ao0ilmy3N3QjWD0RU+tIsNAW1aOtXMzWFpfMcTS7iSe/6Pd137AdIQ1MW7OwqLGnw7TmF0ozBmiV",
                "EzYlJoOnpYuBwd7plPNDXU06z04SJ8y7RN/Ceoc6mPY=",
                "7I/W4NGRhh/0crglPVYXuJZgHPFQo7wiAVv/aygWKrIpfMRqxfQHlNLUx4VLapvIlT3Sawy5Ie17vj+KUREkZQ==",
                "1dQWwEnyagGuKZFGWvDf7oTuCaTJT20vZkQcCcqsSHNcoDjtJXBq-0KV46LE1HtExvIYUjh8rqEFdLK41Pu6gxdt4CrG8NmnpHwKQ-Cn6X5Tvxx3mV9mEJXSJYkizq-raQ"))
    }
}