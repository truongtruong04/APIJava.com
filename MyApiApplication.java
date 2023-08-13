package com.example.demo;

import jakarta.annotation.Resource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class MyApiApplication{
    public static void main(String args[]) {
        SpringApplication.run(MyApiApplication.class, args);
    }

    @GetMapping("/api/{id}")
    public ResponseEntity<String> getResource(@PathVariable("id") int id) {

        if (resourceNotFound(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Không tìm thấy resource với id  " + id);
        }
        String resourceData = getResourceData(id);
        return ResponseEntity.ok().body("Dữ liệu của resource có id  " + id + ": " + resourceData);
    }


    @PostMapping("/api")
    public ResponseEntity<String> createResource(@Validated @RequestBody Resource resource) {

        return ResponseEntity.status(HttpStatus.CREATED).body("Đã tạo mới resource thành công");
    }


    @PutMapping("/api/{id}")
    public ResponseEntity<String> updateResource(@PathVariable("id") int id, @Validated @RequestBody Resource resource) {

        if (resourceNotFound(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Không tìm thấy resource với id " + id);
        }
        return ResponseEntity.ok().body("Đã cập nhật resource có id " + id + " thành công");
    }

    @DeleteMapping("/api/{id}")
    public ResponseEntity<String> deleteResource(@PathVariable("id") int id) {
        if (resourceNotFound(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Không tìm thấy resource với id " + id);
        }
        return ResponseEntity.ok().body("Đã xóa resource có id " + id + " thành công");
    }


    private boolean resourceNotFound(int id) {

        return true;
    }

    private String getResourceData(int id) {


        return "Dữ liệu của resource";
    }



}