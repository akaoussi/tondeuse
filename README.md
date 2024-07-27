# Projet Tondeuse Automatique

## Description du Projet

Ce projet consiste à développer une application pour simuler le déplacement d'une tondeuse sur une pelouse rectangulaire. 
La tondeuse reçoit des instructions pour se déplacer et tourner sur la pelouse tout en respectant les limites définies. 
L'objectif est de fournir une solution robuste et de qualité utilisant les bonnes pratiques de développement logiciel (craftsmanship) avec une couverture de tests élevée.

## Besoin de l'Application

L'application vise à automatiser le déplacement d'une tondeuse sur une pelouse selon des instructions prédéfinies. 
Chaque tondeuse a une position initiale et une orientation, et peut se déplacer selon des instructions de type 'G' (gauche), 'D' (droite) et 'A' (avancer). 
La pelouse est définie par ses dimensions (largeur et hauteur), et la tondeuse ne doit pas sortir des limites de la pelouse.

## Versions Utilisées

- **Java** : 17
- **Spring Boot** : 3.3.2
- **Maven** : 3.8.1
- **Lombok** : 1.18.24
- **Spring Batch** : 5.1.2
- **H2 Database** : 2.1.214

## Qualité du Code

Ce projet est développé en respectant les principes de craftsmanship, en mettant l'accent sur la lisibilité, la maintenabilité et la qualité du code. 
Des pratiques telles que le TDD (Test Driven Development) et le refactoring continu sont appliquées tout au long du développement.

## Couverture de Tests

La couverture des tests unitaires de ce projet est de 97%. Les tests sont écrits pour couvrir les cas d'utilisation principaux ainsi que les cas limites, 
assurant ainsi la fiabilité et la robustesse de l'application.

![image](https://github.com/user-attachments/assets/9cd57467-c144-4fc0-9a6a-018fb7b647bc)


## Solution de Packaging et Déploiement

Pour packager et déployer cette application, suivez les étapes ci-dessous :

1. **Cloner le Répertoire du Projet** :
    ```bash
    git clone <URL-du-depot>
    cd tondeuse
    ```

2. **Construire le Projet avec Maven** :
    ```bash
    mvn clean install
    ```

3. **Exécuter les Tests** :
    ```bash
    mvn test
    ```

4. **Générer le Fichier exécutable JAR** :
    ```bash
    mvn package
    ```

    Le fichier JAR sera généré dans le répertoire `target` du projet.

5. **Déployer le JAR** :
    Pour exécuter l'application, utilisez la commande suivante :
    ```bash
    java -jar target/tondeuse-0.0.1-SNAPSHOT.jar
    ```

## Utilisation de l'Application

### Configuration de l'Entrée

L'entrée pour les instructions de la tondeuse doit être fournie dans un fichier texte nommé `input.txt` placé dans le classpath de l'application. 
Le format du fichier doit être le suivant :

5 5
1 2 N
GAGAGAGAA
3 3 E
AADAADADDA


- `5 5` représente les dimensions de la pelouse (largeur et hauteur).
- `1 2 N` représente la position initiale de la tondeuse (x, y) et son orientation (N, E, W, S).
- `GAGAGAGAA` représente les instructions pour déplacer la tondeuse.

### Sortie de l'Application

L'application générera un fichier `output.txt` avec les positions finales des tondeuses après l'exécution des instructions. 
Le format du fichier de sortie sera similaire à :

1 3 N
5 1 E




## Contributeurs

- Abdelghani KAOUSSI (Auteur principal)


