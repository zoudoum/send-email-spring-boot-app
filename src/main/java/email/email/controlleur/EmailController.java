package email.email.controlleur;

import email.email.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmailController {

    private final EmailService emailService;

    @Autowired
    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @GetMapping("/envoyer-email")
    public String envoyerEmail() {
        String destinataire = "destinataire@example.com";
        String sujet = "Sujet de l'e-mail";
        String contenu = "Contenu de l'e-mail";

        // Appeler le service pour envoyer l'e-mail
        emailService.sendEmail(destinataire, sujet, contenu);

        // Rediriger ou retourner une vue en fonction de vos besoins
        return "redirect:/accueil";
    }
}