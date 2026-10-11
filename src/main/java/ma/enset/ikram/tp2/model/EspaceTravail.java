package ma.enset.ikram.tp2.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "espaces_travail")
public class EspaceTravail implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code_espace", nullable = false, unique = true, length = 30)
    private String codeEspace;

    @Column(name = "designation", nullable = false)
    private String designation;

    @Column(name = "capacite_personnes", nullable = false)
    private int capacitePersonnes;

    @Column(name = "est_disponible")
    private Boolean estDisponible = true;

    @Column(name = "etage_batiment")
    private Integer etage;

    @Column(name = "superficie_m2")
    private Double superficieM2;

    @Column(name = "equipements_inclus")
    private String equipementsInclus;

    public EspaceTravail() {
    }

    public EspaceTravail(String codeEspace, String designation, int capacitePersonnes, Integer etage, Double superficieM2, String equipementsInclus) {
        this.codeEspace = codeEspace;
        this.designation = designation;
        this.capacitePersonnes = capacitePersonnes;
        this.etage = etage;
        this.superficieM2 = superficieM2;
        this.equipementsInclus = equipementsInclus;
        this.estDisponible = true;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCodeEspace() { return codeEspace; }
    public void setCodeEspace(String codeEspace) { this.codeEspace = codeEspace; }

    public String getDesignation() { return designation; }
    public void setDesignation(String designation) { this.designation = designation; }

    public int getCapacitePersonnes() { return capacitePersonnes; }
    public void setCapacitePersonnes(int capacitePersonnes) { this.capacitePersonnes = capacitePersonnes; }

    public Boolean getEstDisponible() { return estDisponible; }
    public void setEstDisponible(Boolean estDisponible) { this.estDisponible = estDisponible; }

    public Integer getEtage() { return etage; }
    public void setEtage(Integer etage) { this.etage = etage; }

    public Double getSuperficieM2() { return superficieM2; }
    public void setSuperficieM2(Double superficieM2) { this.superficieM2 = superficieM2; }

    public String getEquipementsInclus() { return equipementsInclus; }
    public void setEquipementsInclus(String equipementsInclus) { this.equipementsInclus = equipementsInclus; }

    @Override
    public String toString() {
        return "EspaceTravail{" +
                "id=" + id +
                ", codeEspace='" + codeEspace + '\'' +
                ", designation='" + designation + '\'' +
                ", capacite=" + capacitePersonnes +
                ", etage=" + etage +
                ", dispo=" + estDisponible +
                '}';
    }
}
