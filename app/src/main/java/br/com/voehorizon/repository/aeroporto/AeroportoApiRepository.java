package br.com.voehorizon.repository.aeroporto;

import br.com.voehorizon.dto.DataContent;
import br.com.voehorizon.repository.aeroporto.response.AeroportoApiResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class AeroportoApiRepository{

     private RestTemplate restTemplate;

     @Value("${api-redemet.url}")
     private String url;

     @Value("${api-redemet.api-key}")
     private String apiKey;


     public List<AeroportoApiResponse> obterAeroportos(){
          HttpHeaders headers = new HttpHeaders();
          headers.setContentType(MediaType.APPLICATION_JSON);
          headers.add("X-Api-Key", apiKey);

          HttpEntity<?> request = new HttpEntity<>(headers);
          restTemplate = new RestTemplate();

          URI uri = UriComponentsBuilder.fromUriString(url)
                  .queryParam("api_key", apiKey)
                  .queryParam("pais", "Brasil")
                  .build()
                  .toUri();

          ParameterizedTypeReference<DataContent<List<AeroportoApiResponse>>> responseType =
                  new ParameterizedTypeReference<>() {};

          ResponseEntity<DataContent<List<AeroportoApiResponse>>> response =
                  restTemplate.exchange(uri, HttpMethod.GET, request, responseType);

          return response.getBody().getContent();

     }
}
