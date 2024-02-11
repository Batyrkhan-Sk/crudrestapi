package com.example.crudrestapi.controllers;


import com.example.crudrestapi.services.LoanService;
import com.example.crudrestapi.models.Loan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/loans")
public class LoanController {
    @Autowired
    private LoanService loanService;

    @GetMapping()
    public List<Loan> getAllLoans() {
        return loanService.getAllLoans();
    }

    @PostMapping
    public Loan addLoan(@RequestBody Loan loan){
        return loanService.createLoan(loan);
    }

}

