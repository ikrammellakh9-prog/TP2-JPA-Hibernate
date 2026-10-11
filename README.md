# TP 2 : Premiers pas avec JPA & Hibernate (Ikram Mellakh)

Projet de manipulation fondamentale de l'ORM JPA 2.2 et Hibernate 5.6 sur base de donnÃ©es mÃ©moire H2.

## EntitÃ©s MÃ©tier et Mappings
- **UtilisateurCompte** : gestion d'accÃ¨s, dates temporelles `@Temporal` et contraintes d'unicitÃ©.
- **EspaceTravail** : gestion des espaces de travail et disponibilitÃ©s.

---

## Captures d'Ã‰cran IntelliJ IDEA & Terminal CMD

### 1. EntitÃ© UtilisateurCompte (IntelliJ IDEA)
![EntitÃ© Utilisateur](docs/images/01-intellij-entity-utilisateur.png)

### 2. EntitÃ© EspaceTravail (IntelliJ IDEA)
![EntitÃ© Espace](docs/images/02-intellij-entity-espace.png)

### 3. RÃ©sultat des Tests et ExÃ©cution (CMD / PowerShell)
![RÃ©sultat ExÃ©cution CMD](docs/images/03-cmd-test-result.png)

---

## Lancement
```bash
mvn clean compile exec:java -Dexec.mainClass=ma.enset.ikram.tp2.App
```