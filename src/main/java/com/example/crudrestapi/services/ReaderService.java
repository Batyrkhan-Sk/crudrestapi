package com.example.crudrestapi.services;

import com.example.crudrestapi.models.Reader;
import com.example.crudrestapi.repositories.ReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ReaderService {
    @Autowired
    private ReaderRepository readerRepository;

    public List<Reader> getAllReaders() {
        return readerRepository.findAll();
    }

    public Reader createReader(Reader reader) {
        return readerRepository.save(reader);
    }

    public Reader updateReader(Long id, Reader updatedReader) {
        Reader existingReader = readerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reader not found with id: " + id));
        existingReader.setName(updatedReader.getName());
        existingReader.setEmail(updatedReader.getEmail());
        return readerRepository.save(existingReader);
    }

    public void deleteReader(Long id) {
        readerRepository.deleteById(id);
    }

    public Reader getReaderById(Long id){
        return readerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reader not found with id: " + id));
    }

}
