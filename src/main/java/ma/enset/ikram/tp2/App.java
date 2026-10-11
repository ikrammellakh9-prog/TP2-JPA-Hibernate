package ma.enset.ikram.tp2;

import ma.enset.ikram.tp2.model.EspaceTravail;
import ma.enset.ikram.tp2.model.UtilisateurCompte;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class App {
    public static void main(String[] args) {
        System.out.println("==========================================================");
        System.out.println("  TP2 JPA - MAPPING OBJET-RELATIONNEL & CYCLE DE VIE (IKRAM) ");
        System.out.println("==========================================================");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ikramTP2_PU");
        EntityManager em = emf.createEntityManager();

        try {
            System.out.println("\n[1] ETAT PERSIST : Creation et persistance des entites");
            em.getTransaction().begin();

            UtilisateurCompte u1 = new UtilisateurCompte("ikram_m", "ikram.mellakh@enset-media.ac.ma", "Ikram Mellakh", "ADMINISTRATRICE");
            UtilisateurCompte u2 = new UtilisateurCompte("mehdi_b", "mehdi.benali@tech-corp.com", "Mehdi Benali", "DEVELOPPEUR");

            EspaceTravail e1 = new EspaceTravail("ESP-LAB-01", "Laboratoire IA & Big Data", 35, 2, 85.5, "Projecteur 4K, Serveurs GPU");
            EspaceTravail e2 = new EspaceTravail("ESP-CONF-02", "Salle de Conference Ibn Batouta", 60, 1, 140.0, "Visioconference Cisco, Micros sans fil");
            EspaceTravail e3 = new EspaceTravail("ESP-BOX-03", "Box de Brainstorming Agile", 8, 3, 22.0, "Ecran tactile interactif");

            em.persist(u1);
            em.persist(u2);
            em.persist(e1);
            em.persist(e2);
            em.persist(e3);

            em.getTransaction().commit();
            System.out.println("-> Utilisateurs et Espaces de travail inseres avec succes.");

            System.out.println("\n[2] ETAT MANAGED & UPDATE : Modification de capacite");
            em.getTransaction().begin();
            EspaceTravail espaceModif = em.find(EspaceTravail.class, e1.getId());
            espaceModif.setCapacitePersonnes(40);
            espaceModif.setSuperficieM2(92.0);
            em.getTransaction().commit();
            System.out.println("-> Espace modifie : " + espaceModif);

            System.out.println("\n[3] REQUETES JPQL : Filtrage dynamique des espaces disponibles");
            List<EspaceTravail> espacesDispos = em.createQuery(
                    "SELECT e FROM EspaceTravail e WHERE e.estDisponible = true AND e.capacitePersonnes >= :capMin ORDER BY e.capacitePersonnes DESC",
                    EspaceTravail.class
            ).setParameter("capMin", 10).getResultList();

            System.out.println("-> Espaces trouves (>= 10 personnes) : " + espacesDispos.size());
            for (EspaceTravail esp : espacesDispos) {
                System.out.println("   * " + esp.getCodeEspace() + " | " + esp.getDesignation() + " (Capacite: " + esp.getCapacitePersonnes() + ")");
            }

            System.out.println("\n[4] SUPPRESSION D'UNE ENTITE TEMPORAIRE (REMOVE)");
            em.getTransaction().begin();
            EspaceTravail temp = new EspaceTravail("ESP-TEMP", "Espace Temporaire Maintenance", 5, 0, 15.0, "Aucun");
            em.persist(temp);
            em.flush();
            System.out.println("-> Entite temporaire creee avec ID : " + temp.getId());
            em.remove(temp);
            em.getTransaction().commit();
            System.out.println("-> Entite temporaire supprimee via em.remove().");

        } catch (Exception ex) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            ex.printStackTrace();
        } finally {
            em.close();
            emf.close();
            System.out.println("\n==========================================================");
            System.out.println("  EXECUTION DU TP2 TERMINEE AVEC SUCCES (BUILD SUCCESS)");
            System.out.println("==========================================================");
        }
    }
}
