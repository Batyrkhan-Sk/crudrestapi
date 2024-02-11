package com.example.crudrestapi.repositories;

import com.example.crudrestapi.models.Reader;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReaderRepository extends JpaRepository<Reader, Long> {
}
