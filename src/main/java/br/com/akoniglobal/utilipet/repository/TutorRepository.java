package br.com.akoniglobal.utilipet.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.akoniglobal.utilipet.model.Tutor;

public interface TutorRepository extends MongoRepository<Tutor, String>{
    
}
