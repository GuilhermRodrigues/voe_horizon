package br.com.voehorizon.repository.cidade;

import br.com.voehorizon.dto.DataContent;
import br.com.voehorizon.repository.cidade.response.CidadesIBGEResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Service
public class CidadeApiRepository {

    private RestTemplate restTemplate;

    @Value("${ibge.url}")
    private String url;

    public List<CidadesIBGEResponse> obterCidades() {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<?> request = new HttpEntity<>(headers);
        restTemplate = new RestTemplate();

        URI uri = UriComponentsBuilder.fromUriString(url + "/municipios")
                .build()
                .toUri();

        ParameterizedTypeReference<DataContent<List<CidadesIBGEResponse>>> responseType =
                new ParameterizedTypeReference<>() {};

        ResponseEntity<DataContent<List<CidadesIBGEResponse>>> response =
                restTemplate.exchange(uri, HttpMethod.GET, request, responseType);

        return response.getBody().getContent();

    }

}
