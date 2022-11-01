package br.com.akoniglobal.utilipet.view.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.akoniglobal.utilipet.model.Tutor;
import br.com.akoniglobal.utilipet.service.TutorService;
import br.com.akoniglobal.utilipet.shared.TutorDTO;
import br.com.akoniglobal.utilipet.view.model.TutorResponse;

@RestController
@RequestMapping("/tutores")
// @CrossOrigin(origins = "http://localhost:8080")
public class TutorController {
    
    @Autowired
    private TutorService service;    

    ModelMapper mapper = new ModelMapper();

    @GetMapping
    public ResponseEntity<List<TutorResponse>> obterTutores(){  
        List<TutorDTO> tutoresDto = service.obterTutores();
        
        List<TutorResponse> tutoresResponse = tutoresDto.stream()
        .map(t -> new ModelMapper().map(t, TutorResponse.class))
        .collect(Collectors.toList());
        
        return new ResponseEntity<>(tutoresResponse, HttpStatus.FOUND);           
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<TutorDTO> obterTutorPorId(@PathVariable String id){
        Optional<TutorDTO> tutor = service.obterTutorPorID(id);
        if (tutor.isPresent()) {
            return new ResponseEntity<>(tutor.get(), HttpStatus.FOUND);    
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<TutorDTO> cadastrarTutor(@RequestBody TutorDTO tutor){
        return new ResponseEntity<>(service.cadastrarTutor(tutor), HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<TutorDTO> atualizarTutor(@PathVariable String id, @RequestBody TutorDTO novoTutorDto){
        Optional<TutorDTO> tutor = service.obterTutorPorID(id);
        if (tutor.isPresent()) {
            return new ResponseEntity<>(service.atualizarTutorPorID(id, novoTutorDto), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> removerTutor(@PathVariable String id){
        service.removerTutor(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
