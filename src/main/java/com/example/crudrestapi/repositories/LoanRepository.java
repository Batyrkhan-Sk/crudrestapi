package com.example.crudrestapi.repositories;

import com.example.crudrestapi.models.Book;
import com.example.crudrestapi.models.Loan;
import com.example.crudrestapi.models.Reader;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LoanRepository extends JpaRepository<Loan, Long> {
    Loan save(Loan loan);

    List<Loan> findAll();

    List<Loan> findByReader(Reader reader);

    List<Loan> findByBook(Book book);

    void deleteById(Long id);
}
