# TP2 - Calculatrice Moderne pour Android

Ce projet est une application de calculatrice simple pour Android, développée en Kotlin. L'objectif était de créer une calculatrice fonctionnelle avec une interface utilisateur moderne inspirée du design d'Apple.

## ✨ Fonctionnalités

- **Opérations de base :** Addition, soustraction, multiplication et division.
- **Interface Moderne :** Un design sombre avec des boutons ronds, inspiré de la calculatrice iOS.
- **Logique Améliorée :** L'opérande actuel reste visible après avoir sélectionné une opération.
- **Compteur de Visites :** L'application utilise `SharedPreferences` pour compter et afficher le nombre de fois où elle a été ouverte.
- **Gestion des Erreurs :** Prise en charge de la division par zéro.

## 🛠️ Technologies Utilisées

- **Langage :** Kotlin
- **Architecture :** Single Activity
- **UI :**
    - `ConstraintLayout` pour un positionnement flexible.
    - `com.google.android.material.button.MaterialButton` pour les boutons stylisés.
- **Persistance des données :** `SharedPreferences` pour le stockage simple clé-valeur.

## 🚀 Comment l'exécuter

1.  Clonez ce dépôt.
2.  Ouvrez le projet avec Android Studio.
3.  Lancez la synchronisation Gradle.
4.  Exécutez l'application sur un émulateur ou un appareil Android.
