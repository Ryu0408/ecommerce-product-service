package com.ryu.ecommerce.product.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class ProductController {

    @GetMapping("/api/products")
    public List<Map<String, Object>> list() {
        return List.of(
                Map.of("id", "p1", "name", "루이스폴센 PH5", "price", 980000),
                Map.of("id", "p2", "name", "베르판 펜던트", "price", 1250000),
                Map.of("id", "p3", "name", "비비아 조명", "price", 890000)
        );
    }

    @GetMapping("/actuator/healthz")
    public Map<String, Object> healthz() {
        return Map.of("ok", true);
    }
}
