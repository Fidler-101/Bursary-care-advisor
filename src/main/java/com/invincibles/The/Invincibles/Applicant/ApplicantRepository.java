package com.invincibles.The.Invincibles.Applicant;


import org.springframework.data.repository.CrudRepository;

public interface ApplicantRepository extends CrudRepository<Applicant, Long> {

    Applicant findByUsernameAndPassword(String username, String password);
    Applicant findByUsername(String username);
}
