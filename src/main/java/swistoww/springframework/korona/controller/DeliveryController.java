package swistoww.springframework.korona.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import swistoww.springframework.korona.model.DeliveryDto;
import swistoww.springframework.korona.service.DeliveryService;

import java.util.UUID;

@RestController
@RequestMapping("/korona/v2/delivery")
public class DeliveryController {

    private final DeliveryService deliveryService;

    public DeliveryController(DeliveryService deliveryService){
        this.deliveryService = deliveryService;
    }

    @PostMapping
    public ResponseEntity saveDelivery(@RequestBody DeliveryDto deliveryDto){
        Integer id = deliveryService.saveDelivery(deliveryDto);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/korona/v2/deliveryDto/" +  id.toString());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @GetMapping("/{deliveryId}")
    public ResponseEntity<DeliveryDto> getDelivery(@PathVariable("deliveryId") Integer deliveryId){
        return new ResponseEntity(deliveryService.getDeliveryById(deliveryId), HttpStatus.OK);
    }
}
