package lk.ijse.edu.inventoryservice.controller;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("/api/v1/inventory")
public class InventoryController {

    @GetMapping("/health")
    public ResponseEntity<String> checkHelth(){
        return new ResponseEntity<>("Inventory Good", HttpStatusCode.valueOf(200));
    }
}
