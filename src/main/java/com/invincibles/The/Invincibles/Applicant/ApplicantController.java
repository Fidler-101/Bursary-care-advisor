package com.invincibles.The.Invincibles.Applicant;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ApplicantController {

    @Autowired private ApplicantRepository applicantRepository;
    @Autowired private ApplicantService applicantService;




    @GetMapping("/add/user")
    public String goToAddUser() {
        return "SignUp";
    }



    @GetMapping("/login/user")
    public String goToLogin() {
        return "login";
    }


    @PostMapping("/register/user")
    public String saveUser(@RequestParam("username") String username,
                           @RequestParam("firstname") String firstname,
                           @RequestParam("lastname") String lastname,
                           @RequestParam("idNumber") Long idNumber,
                           @RequestParam("gender") String gender,
                           @RequestParam("birthday") String birthday,
                           @RequestParam("phoneNumber") String phone,
                           @RequestParam("email") String email,
                           @RequestParam("password") String password) {

        Applicant app = new Applicant();
        app.setBirthday(birthday);
        app.setFirstname(firstname);
        app.setPassword(password);
        app.setEmail(email);
        app.setUsername(username);
        app.setLastname(lastname);
        app.setId(idNumber);
        app.setPhoneNumber(phone);
        app.setGender(gender);
applicantService.save(app);


        return "registered";
    }
    @PostMapping("/validate/user/login")
    public String goToDashboard(@RequestParam("username") String username,
                                @RequestParam("password") String password,
                                Model model, HttpServletRequest request) {

        HttpSession session = request.getSession(true);
      Applicant user = applicantService.getByUsernameAndPassword(username,password);

        if (user == null) {
            model.addAttribute("message", "Invalid username or password");

            return "login";
        }

        model.addAttribute("user", user);
      session.setAttribute("username",username);
        session.setAttribute("user", user);

        return "ApplicantDashboard";
    }


    @GetMapping("/view/Applicant")
    public String goToWithdraw(HttpServletRequest request, Model model) {

        HttpSession session = request.getSession();

      String username=(String)  session.getAttribute("username");
      Applicant applicant= applicantRepository.findByUsername(username);

model.addAttribute("applicant",applicant);
        session.setAttribute("applicant",applicant);



        return "viewApplicant";
    }
}
