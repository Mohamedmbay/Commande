# Application de gestion de commandes – Spring Boot + JWT

## Description

Ce projet est une **application backend développée avec Spring Boot** permettant de gérer des commandes.
L'application expose une **API REST** permettant de manipuler différentes entités liées à un système de commandes.

Les principales entités sont :

* Client
* Produit
* Commande
* LigneCommande

Dans cette version du projet, un **système d'authentification basé sur JWT (JSON Web Token)** a été ajouté afin de sécuriser l'accès aux endpoints de l'application.

---

## Technologies utilisées

* Java 21
* Spring Boot
* Spring Web
* Spring Data JPA
* Spring Security
* JWT (jjwt)
* Base de données H2
* Maven

---

## Architecture du projet

Le projet suit une architecture classique en couches :

```
controller → service → repository → entity
```

* **Entity** : représente les tables de la base de données
* **Repository** : permet l'accès aux données avec Spring Data JPA
* **Service** : contient la logique métier
* **Controller** : expose les endpoints REST

---

## Authentification JWT

Un système d'authentification basé sur **JWT (JSON Web Token)** a été implémenté.

### Endpoint de connexion

```
POST /api/auth/login
```

Exemple de requête :

```json
{
  "username": "mohamed",
  "password": "1234"
}
```

Si l'authentification est réussie, l'application renvoie un **token JWT**.

Exemple de réponse :

```
eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJtb2hhbWVkIiwiaWF0IjoxNzEwMDAwMDAwLCJleHAiOjE3MTA4NjQwMDB9...
```

---

## Utilisation du token

Pour accéder aux endpoints protégés, il faut envoyer le token dans le header de la requête :

```
Authorization: Bearer TOKEN
```

Exemple :

```
GET /api/produits
```

Header :

```
Authorization: Bearer eyJhbGciOiJIUzI1NiJ9...
```

---

## Lancer le projet

Cloner le dépôt :

```
git clone https://github.com/Mohamedmbay/Commande.git
```

Entrer dans le dossier du projet :

```
cd commandes
```

Lancer l'application :

```
mvn spring-boot:run
```

L'application démarre sur :

```
http://localhost:8080
```

---

## Base de données

Le projet utilise **H2 Database**, une base de données en mémoire utilisée pour le développement et les tests.

---

## Auteur

Modou Mbaye
Projet réalisé dans le cadre d'un TP Spring Boot.
