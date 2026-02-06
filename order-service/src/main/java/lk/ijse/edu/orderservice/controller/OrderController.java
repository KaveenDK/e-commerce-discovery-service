package lk.ijse.edu.orderservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * --------------------------------------------
 * @Author Dimantha Kaveen
 * @GitHub: https://github.com/KaveenDK
 * @Website: https://dimantha-kaveen-portfolio.web.app/
 * @Linkdin: https://www.linkedin.com/in/KaveeNDK/
 * --------------------------------------------
 * @Created 2/6/2026
 * @Project e-commerce
 * --------------------------------------------
 **/

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/health")
    public ResponseEntity<String> checkHelth(){
        return new ResponseEntity<>("Order Good", HttpStatusCode.valueOf(200));
    }

    @GetMapping("/inventory")
    public ResponseEntity<String> callToInventoryService() {
        String url = "http://inventory-service/api/v1/inventory/health";
        String response = restTemplate.getForObject(url, String.class);

        return new ResponseEntity<>(
                response == null ? "Fail" : "Success",
                HttpStatus.OK
        );
    }
}
