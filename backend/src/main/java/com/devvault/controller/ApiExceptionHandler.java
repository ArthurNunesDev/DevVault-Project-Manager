package com.devvault.controller;
import org.springframework.http.*; import org.springframework.web.bind.annotation.*; import java.util.*;
@RestControllerAdvice public class ApiExceptionHandler {
 @ExceptionHandler(NoSuchElementException.class) ResponseEntity<Map<String,String>> notFound(NoSuchElementException e){return ResponseEntity.status(404).body(Map.of("message",e.getMessage()));}
 @ExceptionHandler(Exception.class) ResponseEntity<Map<String,String>> generic(Exception e){return ResponseEntity.status(500).body(Map.of("message","Erro interno do servidor."));}
}