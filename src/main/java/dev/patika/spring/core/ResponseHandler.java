package dev.patika.spring.core;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {
    public static ResponseEntity<Object> responseBuilder(String message, HttpStatus status,Object data){
        Map<String,Object> response = new HashMap<>();
        response.put("status",status);
        response.put("message",message);
        response.put("data",data);

        return new ResponseEntity<>(response,status);
    }
    public static ResponseEntity<Object> responseBuilder(String message, HttpStatus status){
        Map<String,Object> response = new HashMap<>();
        response.put("status",status);
        response.put("message",message);

        return new ResponseEntity<>(response,status);
    }
}
