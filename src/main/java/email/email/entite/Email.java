package email.email.entite;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Email {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String recepteur;

    private String expediteur;


    private String sujet;
    private String contenu;


    public Email() {
    }


    public Email(String destinataire, String sujet, String contenu) {
        this.recepteur= destinataire;
        this.sujet = sujet;
        this.contenu = contenu;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDestinataire() {
        return recepteur;
    }

    public void setDestinataire(String destinataire) {
        this.recepteur = destinataire;
    }

    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public String getEnvoi() {
        return expediteur;
    }

    public void setEnvoi(String envoi) {
        this.expediteur = envoi;
    }
}
