# Tennis Score Computer

## Description
Ce projet est une implémentation d'un système de scoring pour un jeu de tennis entre deux joueurs A et B. Il prend en entrée une chaine de caractères qui représente les points gagnés par les joueurs et affiche le score après chaque point, et affiche enfin le gagnant.

## Pourquoi cette structure ?
Nous avons opté pour une architecture modulaire afin de séparer les responsabilités et faciliter la maintenance du code :

- `TennisGame` : Responsable de la logique métier (règles du tennis, calcul des scores, détection du gagnant). Cela permet d'assurer une séparation claire entre la logique du jeu et l'affichage.
- `TennisScoreProcessor` : Joue le rôle d'adaptateur entre l'entrée utilisateur et la logique métier. Il gère les entrées et affiche le score.
- `Main` : Point d'entrée du programme, permettant l'interaction avec l'utilisateur.

L’implémentation a été volontairement simple afin d'éviter le "over-engineering", en effet le problème ne nécessite pas l'utilisation de patterns complexes comme une architecture hexagonale avancée ou une injection de dépendances.
L’objectif principal était de simplifier le traitement, sans introduire d’abstractions inutiles.
## Fonctionnalités
- Gestion du score selon les règles classiques du tennis (0, 15, 30, 40, avantage, deuce).
- Détection du gagnant lorsque l'écart de deux points est atteint après 40.
- Validation des entrées pour s'assurer qu'elles contiennent uniquement 'A' ou 'B'.

## Structure du projet
Le projet est organisé en trois classes principales :

### 1. `Main.java`
Point d'entrée de l'application, permettant à l'utilisateur de saisir une séquence de points gagnés par les joueurs sous forme d'une chaine de caractères.

### 2. `TennisGame.java`
- Gère la logique de jeu et le suivi du score.
- Vérifie les conditions de victoire.

### 3. `TennisScoreProcessor.java`
- Vérifie la validité de l'entrée.
- Affiche le score après chaque point.

## Prérequis
- Java 17
- Maven 

## Installation et Exécution
1. Cloner le projet :
   ```sh
   git clone https://github.com/abdelaziz-sys/tennis-score-computer.git
   cd tennis-score-computer
2. Compiler le projet :
   `mvn clean install`
3. Exécuter le programme :
   `java -jar target/tennis-score-computer-1.0.jar`
