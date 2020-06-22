package swistoww.springframework.korona;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import swistoww.springframework.korona.controller.DeliveryController;
import swistoww.springframework.korona.domain.Delivery;
import swistoww.springframework.korona.model.DeliveryDto;
import swistoww.springframework.korona.model.OrderItemDto;
import swistoww.springframework.korona.service.DeliveryService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(DeliveryController.class)
@Slf4j
class DeliveryControllerTest {

    @MockBean
    DeliveryService deliveryService;

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void saveDelivery() throws Exception{

        DeliveryDto deliveryDto = DeliveryDto.builder()
                .item(OrderItemDto.builder()
                        .productId("apple")
                        .quantity(10)
                        .warehouseId(String.valueOf(4))
                        .waypointNo(1)
                        .build())
                .item(OrderItemDto.builder()
                        .productId("orange")
                        .quantity(5)
                        .warehouseId(String.valueOf(2))
                        .waypointNo(2)
                        .build())
                .routeLength(10)
                .build();
        String jsonDeliveryDto = objectMapper.writeValueAsString(deliveryDto);
        log.info("Delivery: " + jsonDeliveryDto);
        mockMvc.perform(post("/korona/v2/delivery")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonDeliveryDto))
                .andExpect(status().isCreated());

    }

}
