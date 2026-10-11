package ma.enset.ikram.tp2.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "utilisateurs_comptes")
public class UtilisateurCompte implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 60)
    private String identifiant;

    @Column(nullable = false, unique = true, length = 120)
    private String emailPro;

    @Column(name = "nom_complet", nullable = false)
    private String nomComplet;

    @Column(name = "role_acces")
    private String roleAcces;

    @Column(name = "compte_actif")
    private Boolean actif = true;

    @Column(name = "date_inscription")
    private LocalDate dateInscription;

    public UtilisateurCompte() {
        this.dateInscription = LocalDate.now();
    }

    public UtilisateurCompte(String identifiant, String emailPro, String nomComplet, String roleAcces) {
        this();
        this.identifiant = identifiant;
        this.emailPro = emailPro;
        this.nomComplet = nomComplet;
        this.roleAcces = roleAcces;
        this.actif = true;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getIdentifiant() { return identifiant; }
    public void setIdentifiant(String identifiant) { this.identifiant = identifiant; }

    public String getEmailPro() { return emailPro; }
    public void setEmailPro(String emailPro) { this.emailPro = emailPro; }

    public String getNomComplet() { return nomComplet; }
    public void setNomComplet(String nomComplet) { this.nomComplet = nomComplet; }

    public String getRoleAcces() { return roleAcces; }
    public void setRoleAcces(String roleAcces) { this.roleAcces = roleAcces; }

    public Boolean getActif() { return actif; }
    public void setActif(Boolean actif) { this.actif = actif; }

    public LocalDate getDateInscription() { return dateInscription; }
    public void setDateInscription(LocalDate dateInscription) { this.dateInscription = dateInscription; }

    @Override
    public String toString() {
        return "UtilisateurCompte{" +
                "id=" + id +
                ", identifiant='" + identifiant + '\'' +
                ", emailPro='" + emailPro + '\'' +
                ", nomComplet='" + nomComplet + '\'' +
                ", roleAcces='" + roleAcces + '\'' +
                ", actif=" + actif +
                '}';
    }
}
