package br.com.akoniglobal.utilipet.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.akoniglobal.utilipet.model.Tutor;
import br.com.akoniglobal.utilipet.repository.TutorRepository;
import br.com.akoniglobal.utilipet.shared.TutorDTO;

@Service
public class TutorServiceImpl implements TutorService {

    @Autowired
    private TutorRepository repository;

    @Override
    public TutorDTO cadastrarTutor(TutorDTO tutorDto) {  
        ModelMapper mapper = new ModelMapper();      
        Tutor tutor = mapper.map(tutorDto, Tutor.class);
        tutor = repository.save(tutor);
        return mapper.map(tutor, TutorDTO.class);
    }

    @Override
    public List<TutorDTO> obterTutores() {        
        List<Tutor> tutores = repository.findAll();
        
        return tutores.stream()
        .map( tutor -> new ModelMapper().map(tutor, TutorDTO.class))
        .collect(Collectors.toList());        
    }

    @Override
    public Optional<TutorDTO> obterTutorPorID(String id) {        
        Optional<Tutor> tutor = repository.findById(id);
        if (tutor.isPresent()) {
            return Optional.of( new ModelMapper().map(tutor.get(), TutorDTO.class));
        }
        return Optional.empty();
    }

    @Override
    public void removerTutor(String id) {
        repository.deleteById(id);        
    }

    @Override
    public TutorDTO atualizarTutorPorID(String id, TutorDTO novoTutorDto) {       
        Tutor tutor = new ModelMapper().map(novoTutorDto, Tutor.class);
        tutor.setId(id);
        tutor = repository.save(tutor);
        return new ModelMapper().map(tutor, TutorDTO.class);
    }
    
}
