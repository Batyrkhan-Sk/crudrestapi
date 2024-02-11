package com.example.crudrestapi.services;

import com.example.crudrestapi.repositories.LoanRepository;
import com.example.crudrestapi.models.Reader;
import com.example.crudrestapi.models.Book;
import com.example.crudrestapi.models.Loan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LoanService {
    @Autowired
    private LoanRepository loanRepository;

    public List<Loan> getAllLoans() {
        return loanRepository.findAll();
    }

    public Loan createLoan(Loan loan) {
        return loanRepository.save(loan);
    }

    public Loan updateLoan(Long id, Loan updatedLoan) {
        Loan existingLoan = loanRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Loan not found with id: " + id));
        existingLoan.setBook(updatedLoan.getBook());
        existingLoan.setReader(updatedLoan.getReader());
        existingLoan.setLoanDate(updatedLoan.getLoanDate());
        existingLoan.setReturnDate(updatedLoan.getReturnDate());
        return loanRepository.save(existingLoan);
    }

    public void deleteLoan(Long id) {
        loanRepository.deleteById(id);
    }

    public List<Loan> findLoansByReader(Reader reader) {
        return loanRepository.findByReader(reader);
    }

    public List<Loan> findLoansByBook(Book book) {
        return loanRepository.findByBook(book);
    }

}

