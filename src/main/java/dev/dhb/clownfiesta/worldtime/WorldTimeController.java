package dev.dhb.clownfiesta.worldtime;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("api/v1/worldtime")
public class WorldTimeController {
    public WorldTimeController(RestTemplateBuilder restTemplateBuilder) {
        RestTemplate restTemplate = restTemplateBuilder.build();
    }

//takes parameters from request url and passed them to service layer
    @GetMapping("{zone}/{city}")
    public String getWorldTime(@PathVariable("zone") String zone, @PathVariable("city") String city) throws JsonProcessingException {
        return WorldTimeService.getWorldTime(zone, city);
    }

}
