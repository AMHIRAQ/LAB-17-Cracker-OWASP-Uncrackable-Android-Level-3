# LAB 17 – Analyse et Compréhension d’OWASP UnCrackable Android Level 3

## 📖 Description

Ce laboratoire explore les techniques de rétro-ingénierie appliquées à l'application de démonstration **OWASP UnCrackable Level 3**. L'objectif est d'étudier les mécanismes de protection d'une application Android, notamment les vérifications d'intégrité, les protections anti-debug et l'obfuscation du code natif.

Le laboratoire combine l'analyse Java, l'analyse native et l'observation du comportement de l'application afin de comprendre comment la vérification du secret est implémentée.

> ⚠️ **Avertissement**
>
> Ce laboratoire est destiné à la formation et à l'apprentissage de la sécurité des applications Android dans un environnement contrôlé. Les techniques étudiées doivent être utilisées uniquement sur des applications de test ou dans le cadre d'un audit autorisé.

---

## 🎯 Objectifs pédagogiques

À la fin de ce laboratoire, vous serez capable de :

* Décompiler une application Android.
* Explorer le code Java et Smali.
* Analyser une bibliothèque native Android.
* Comprendre les mécanismes d'obfuscation.
* Étudier les protections d'intégrité et d'anti-analyse.
* Suivre le flux de données entre Java et code natif.
* Comprendre l'utilisation d'opérations XOR pour masquer une information.

---

## 🛠️ Prérequis

### Logiciels

* Android Studio
* Émulateur Android ARM64 (API 30+)
* Ghidra
* Jadx-GUI
* Apktool
* Python 3
* ADB

### Ressources

* APK OWASP UnCrackable Level 3

---

## 📚 Outils utilisés

| Outil          | Utilisation                             |
| -------------- | --------------------------------------- |
| Android Studio | Exécution et débogage Android           |
| Jadx           | Décompilation Java                      |
| Apktool        | Analyse des ressources et du code Smali |
| Ghidra         | Analyse du code natif                   |
| Python         | Analyse et traitement des données       |
| ADB            | Communication avec l'émulateur          |

---

## 📂 Déroulement du laboratoire

### 1. Analyse Java avec Jadx

Objectifs :

* Identifier le point d'entrée de l'application.
* Comprendre les contrôles d'intégrité.
* Localiser les appels vers les bibliothèques natives.

Éléments observés :

* Chargement des bibliothèques natives.
* Vérification de l'intégrité des composants.
* Détection de modifications de l'application.
* Détection d'environnements considérés comme suspects.

---

### 2. Analyse Smali avec Apktool

Objectifs :

* Explorer la structure interne de l'APK.
* Comprendre le code Smali généré.
* Identifier les mécanismes de contrôle exécutés au démarrage.

Éléments étudiés :

* Activité principale.
* Vérifications d'intégrité.
* Contrôle du flux d'exécution.

---

### 3. Étude des protections de l'application

Analyse des mécanismes présents :

* Vérification d'intégrité de l'application.
* Détection de modifications.
* Contrôles anti-analyse.
* Vérifications exécutées au lancement.

Objectif :

Comprendre comment l'application décide d'autoriser ou de bloquer son exécution.

---

### 4. Analyse de la bibliothèque native

Bibliothèque étudiée :

* `libfoo.so`

Objectifs :

* Identifier les fonctions exécutées au chargement.
* Étudier les mécanismes de protection intégrés.
* Comprendre le rôle du code natif dans la validation du secret.

Points observés :

* Contrôles d'environnement.
* Vérifications d'intégrité.
* Logique de validation déplacée hors du code Java.

---

### 5. Analyse de la fonction de validation

Objectifs :

* Retrouver la fonction native appelée depuis Java.
* Comprendre le mécanisme de vérification de la saisie utilisateur.
* Identifier les données utilisées pour la comparaison.

Analyse réalisée :

* Étude de la fonction JNI.
* Suivi des buffers manipulés.
* Observation des comparaisons effectuées.

---

### 6. Étude de l'obfuscation

Signes d'obfuscation rencontrés :

* Multiplication d'opérations répétitives.
* Allocations mémoire nombreuses.
* Structures de données artificielles.
* Calculs sans impact direct sur la vérification finale.

Objectif :

Distinguer la logique utile du bruit ajouté pour compliquer l'analyse.

---

### 7. Analyse du flux de données

Méthodologie :

* Suivre les références mémoire.
* Identifier les données réellement utilisées.
* Reconstituer la transformation appliquée à la chaîne secrète.

Compétence développée :

Ne pas se concentrer uniquement sur la taille du code mais sur le cheminement des données.

---

## 🔍 Concepts de sécurité étudiés

### Vérification d'intégrité

L'application contrôle l'intégrité de certains composants afin de détecter des modifications.

### Déplacement de la logique en natif

Une partie critique du traitement est réalisée dans une bibliothèque native plutôt qu'en Java.

### Obfuscation

Le code contient des éléments destinés à ralentir l'analyse :

* Calculs inutiles
* Structures complexes
* Flux d'exécution difficiles à suivre

### Encodage de données

Les informations importantes ne sont pas stockées directement sous forme lisible.

---

## 📋 Checklist de validation

* [ ] APK analysée avec Jadx
* [ ] APK décompilée avec Apktool
* [ ] Bibliothèque native importée dans Ghidra
* [ ] Fonction JNI identifiée
* [ ] Flux de données étudié
* [ ] Mécanismes d'obfuscation identifiés
* [ ] Transformation des données comprise
* [ ] Validation du fonctionnement de l'application réalisée

---

## 🎓 Compétences acquises

* Reverse Engineering Android
* Analyse Smali
* Analyse JNI
* Analyse de bibliothèques natives
* Identification d'obfuscation
* Compréhension des protections Android
* Analyse de flux de données
* Étude des mécanismes de validation

---

## 📝 Questions de réflexion

1. Pourquoi déplacer une vérification critique vers du code natif ?
2. Quels sont les avantages et les limites de l'obfuscation ?
3. Pourquoi suivre les données est-il souvent plus efficace que lire le code séquentiellement ?
4. Comment renforcer davantage la protection d'un secret dans une application Android ?

---

## ⚖️ Cadre d'utilisation

Ce laboratoire est destiné à :

* L'enseignement de la sécurité mobile.
* Les formations en rétro-ingénierie.
* Les environnements de test OWASP.
* Les audits autorisés.

---

## 👨‍💻 Auteur

Laboratoire de sécurité Android – Analyse d'OWASP UnCrackable Level 3 et étude des mécanismes de protection applicative.
