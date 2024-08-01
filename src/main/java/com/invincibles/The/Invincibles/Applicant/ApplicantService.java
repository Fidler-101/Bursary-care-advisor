package com.invincibles.The.Invincibles.Applicant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplicantService {
    @Autowired private ApplicantRepository applicantRepository;



    public Applicant getByUsernameAndPassword(String username, String password) {

        return applicantRepository.findByUsernameAndPassword(username,password);
    }

    public void save(Applicant app) {
        applicantRepository.save(app);
    }
    public Applicant findApplicantByUsername(String username) {
        return applicantRepository.findByUsername(username);
    }


}
