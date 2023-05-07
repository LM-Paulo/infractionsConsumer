package br.com.centra.infractions.infractionsconsumer.feign;


import br.com.centra.infractions.infractionsconsumer.dto.RecordsDto;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(url= "localhost:8080/api/records" , name = "infractions")
public interface InfractionsFeignConsumer {

    @PostMapping("/create")
    void create(RecordsDto recordsDto);

}