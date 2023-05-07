package br.com.centra.infractions.infractionsconsumer.service;

import br.com.centra.infractions.infractionsconsumer.dto.RecordsDto;
import br.com.centra.infractions.infractionsconsumer.feign.InfractionsFeignConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.Random;

@Component
@EnableScheduling
public class RadarSimulator {

    @Autowired
    private InfractionsFeignConsumer infractionsFeignConsumer;
    private final Random random;

    public RadarSimulator() {
        this.random = new Random();
    }


    @PostConstruct
    @Scheduled(fixedRate = 3000)
    public void initialMethod() {
        while (true) {
            LocalDateTime dateTime = LocalDateTime.now();
            Integer speed = random.nextInt(21) + 80;
            String plate = generatePlate();
            String vehicleClass = generateVehicleClass();

            RecordsDto recordsDto = new RecordsDto(dateTime, speed, plate, vehicleClass);
            infractionsFeignConsumer.create(recordsDto);


        }
    }

    private String generatePlate() {
        StringBuilder plate = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            plate.append((char) (random.nextInt(26) + 'A'));
        }
        plate.append(random.nextInt(10000));
        return plate.toString();
    }

    private String generateVehicleClass() {
        String[] vehicleClasses = { "Carro", "Moto", "Caminhão", "Ônibus", "Van" };
        return vehicleClasses[random.nextInt(vehicleClasses.length)];
    }

}
