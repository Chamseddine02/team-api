📘 Documentation – Projet Team API : Team API est une application Java développée avec Spring Boot permettant de gérer des équipes de sport et leurs joueurs. L’architecture suit une séparation en couches bien définies pour assurer maintenabilité, évolutivité et testabilité.


Architecture du projet:

L’application est organisée selon une architecture classique à plusieurs couches :

Entities : représentations des données stockées en base.

DTOs : objets utilisés pour l’échange de données entre les couches ou avec l’extérieur.

Repositories : interfaces pour interagir avec la base de données.

Services : logique métier.

Controllers : endpoints REST ou vues HTML pour l’interaction utilisateur.

Organisation des packages :

controller/	Reçoit les requêtes HTTP
→ EquipeController.java	Expose des endpoints REST pour la gestion des équipes
→ EquipeVueController.java	Gère l’affichage via des vues HTML (Thymeleaf)
dto/	Objets de transfert de données
→ EquipeDto.java	Représentation API d’une équipe
→ JoueurDto.java	Représentation API d’un joueur
model/	Entités métier 
→ Equipe.java	Entité représentant une équipe
→ Joueur.java	Entité représentant un joueur
repository/	Accès aux données 
→ EquipeRepository.java	
→ JoueurRepository.java	
service/	Logique métier
→ EquipeService.java	
resources/templates/	Templates HTML pour affichage 
→ index.html, equipes.html	

Configuration : 
Fichier application.properties - Configure la connexion à la base MySQL :
spring.datasource.url=jdbc:mysql://localhost:3306/teamdb
spring.datasource.username=user
spring.datasource.password=password
spring.jpa.hibernate.ddl-auto=update


 Lancement du projet : 
 
💡 Prérequis
Java 17+
Maven
Docker & Docker Compose

Étapes de démarrage
Démarrer MySQL :

docker-compose up -d
Lancer l’application :

./mvnw spring-boot:run

Accéder à l’API :

Interface REST : http://localhost:8080/api/equipes

Interface HTML : http://localhost:8080/equipes
