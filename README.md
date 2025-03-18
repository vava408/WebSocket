# 🌐 WebSocket

Ce projet implémente un **serveur WebSocket** simple en **Java**, permettant la communication en temps réel entre un serveur et des clients.

---

## 🚀 Fonctionnalités actuelles

✔ **Serveur WebSocket** : Communication en temps réel entre le serveur et les clients.  
✔ **Connexion mono-utilisateur** : Actuellement, un seul utilisateur peut interagir avec le serveur à la fois.  

---

## 🛠️ Fonctionnalités prévues  

❌ **Système de connexion des administrateurs** : Authentification sécurisée pour les administrateurs.  
⌛ **Système de déconnexion** : Permet aux utilisateurs de se déconnecter proprement.  
❌ **Facilité de création de serveurs** : Outils ou scripts pour déployer facilement de nouveaux serveurs.  
❌ **Support multi-utilisateur** : Permettre à plusieurs utilisateurs de se connecter et d'interagir avec le serveur simultanément.  

legende :
⌛ - **En cours de développement**
❌ - **Non développé**
✔️ - **Validé**

---

## 📁 Structure du projet  

- **`ServeurSimple2.java`** : Implémentation principale du serveur WebSocket.  
- **`ihm/`** : Répertoire destiné à l'interface utilisateur (actuellement en développement).  
- **`websocket/`** : Contient le client permettant de se connecter au serveur.  

---

## 📥 Installation  

1. Clonez le dépôt :

  
       git clone https://github.com/vava408/WebSocket.git

   Accédez au répertoire du projet :

       cd WebSocket

Compilez le projet avec:

    javac  @compile.list
    
▶ Utilisation

    Lancez le serveur :

    java ServeurSimple2
    
    Lancez le Client :

    java websocket.Client

    

## 🤝 Contributions

Les contributions sont les bienvenues ! Ouvrez une issue pour discuter des améliorations ou soumettez une pull request.
