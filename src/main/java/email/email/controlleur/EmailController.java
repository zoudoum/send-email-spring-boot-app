package email.email.controlleur;

import email.email.entite.Email;
import email.email.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class EmailController {

    private final EmailService emailService;

    @Autowired
    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }
    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping("/envoyer-email")
    public ResponseEntity<String>  envoyerEmail(@RequestBody Email email) {
        try {

            email.setDestinataire("doumzoro@gmail.com");
            emailService.sendEmail(email.getDestinataire(), email.getSujet(), "Message de :" + email.getEnvoi() +" " +email.getContenu());

            return ResponseEntity.status(HttpStatus.CREATED).body("L'e-mail a été envoyé avec succès");
        } catch (Exception e) {

            e.printStackTrace();

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Une erreur s'est produite lors de l'envoi de l'e-mail");
        }
    }
    }
