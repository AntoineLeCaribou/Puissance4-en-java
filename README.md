# Puissance4-en-java

Ce projet est codé en java.
Il comporte un moteur de jeu puissance 4.
Il comporte également des bots.
Il contient d'ailleurs une partie d'intelligence artificielle.

Le moteur du jeu :
Tout le moteur du jeu a été codé par moi même, sans aucune aide extérieur.
Simplement grâce aux cours de M.Dorbec et M.Jeanpierre (professeur à l'iut grand ouest normandie)

Les bots :
- OrdinateurAleatoire joue dans des colonnes aleatoirement (très mauvais)
- OrdinateurAleatoireUnPeuIntelligent peut finir la partie si par hasard il a aligné un quadruplet de 3 jetons, sinon il joue comme le précédent bot (mauvais)
- OrdinateurMinMaxDepth1 utilise l'algo minmax, ainsi il joue naturellement au milieu lorsqu'il commence et il est bien plus fort (il a un niveau amateur)
- OrdinateurMinMaxDepthN utilise aussi minmax mais sur plusieurs profondeurs, c.a.d qu'il va s'enfoncer dans n profondeur et en ressortir le meilleur coup (il a le niveau d'un bon joueur)

Les classes (pous pouvez sinon consulter la javadoc):
- dossier src :
    - package jeton :
        - Couleur -> [enum] représente une couleur, les jetons en possèdent une
        - Jeton -> [abstract] modélise un jeton de puissance 4
        - JetonJaune -> [extends Jeton] modélise un jeton jaune de puissance 4
        - JetonRouge -> [extends Jeton] modélise un jeton rouge de puissance 4
   - package jeu :
        - Partie -> simule une partie de puissance 4, contient un plateau, 2 joueurs et le système de tours
   - package main :
        - Main -> initialise les joueurs et la partie, ensuite il lance la partie
    - package plateau :
        - Plateau -> modélise le plateau (ou la grille) du puissance 4, cette classe sécurise toutes les opérations
    - package joueur :
        - Gagnant -> [enum] représente l'état de la partie
        - Joueur -> [abstract] modélise un joueur, contient un pseudo, un jeton et une méthode pour choisir une colonne
        - Humain -> [extends Joueur] modélise un joueur humain, il peut intéragir avec la console
        - OrdinateurAleatoire -> [extends Joueur] un bot vraiment mauvais
        - OrdinateurAleatoireUnPeuIntelligent -> [extends Joueur] un bot mauvais
        - OrdinateurMinMaxDepth1 -> [extends Joueur] un bot respectable, même s'il est sûrement battable du premier coup
        - OrdinateurMinMaxDepthN -> [extends Joueur] un bot vraiment difficile, je le bats une fois sur deux (avec n = 6) mais il peut monter jusqu'à 8 sans trop trainer
        
Merci aux profs de programmation objet de l'iut grand ouest normandie <3
