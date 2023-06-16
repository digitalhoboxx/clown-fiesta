package dev.dhb.clownfiesta.worldtime;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Service
public class WorldTimeService {

    private final WorldTimeRepository worldTimeRepository;

    @Autowired
    public WorldTimeService(WorldTimeRepository worldTimeRepository) {
        this.worldTimeRepository = worldTimeRepository;
    }

//makes the api call to WorldTime and passes it for processing
    public static String getWorldTime(String zone, String city) throws JsonProcessingException {
        String uri = "http://worldtimeapi.org/api/timezone/" + zone + "/" + city;

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        httpHeaders.set(zone, city);

        HttpEntity request = new HttpEntity(httpHeaders);

        ResponseEntity<String> response = restTemplate.exchange(
                uri,
                HttpMethod.GET,
                request,
                String.class,
                0
        );

        if (response.getStatusCode() == HttpStatus.OK) {
            System.out.println("Request Successful.");
            return processWorldTime(response.getBody());
        } else {
            System.out.println("Request Failed");
            return response.getStatusCode().toString();
        }
    }
//makes use of WorldTime.toString() to only pass along the selected parameters
    public static String processWorldTime(String input) throws JsonProcessingException {
        WorldTime worldTime = new ObjectMapper().readValue(input, WorldTime.class);
        return worldTime.toString();
    }

}
