package com.example.crudrestapi.controllers;


import com.example.crudrestapi.services.ReaderService;
import com.example.crudrestapi.models.Reader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/readers")
public class ReaderController {
    @Autowired
    private ReaderService readerService;

    @GetMapping()
    public List<Reader> getAllReaders() {
        return readerService.getAllReaders();
    }

    @PostMapping
    public Reader addReader(@RequestBody Reader reader){
        return readerService.createReader(reader);
    }
}

