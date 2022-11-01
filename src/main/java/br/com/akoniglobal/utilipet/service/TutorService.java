package br.com.akoniglobal.utilipet.service;

import java.util.List;
import java.util.Optional;
import br.com.akoniglobal.utilipet.shared.TutorDTO;

public interface TutorService {
    
    TutorDTO cadastrarTutor(TutorDTO tutor);
    List<TutorDTO> obterTutores();
    Optional<TutorDTO> obterTutorPorID(String id);
    void removerTutor(String id);
    TutorDTO atualizarTutorPorID(String id, TutorDTO tutor);

}
