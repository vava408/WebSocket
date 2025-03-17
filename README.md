# 🌐 WebSocket

Ce projet implémente un **serveur WebSocket** simple en **Java**, permettant la communication en temps réel entre un serveur et des clients.

---

## 🚀 Fonctionnalités actuelles

✔ **Serveur WebSocket** : Communication en temps réel entre le serveur et les clients.  
✔ **Connexion mono-utilisateur** : Actuellement, un seul utilisateur peut interagir avec le serveur à la fois.  

---

## 🛠️ Fonctionnalités prévues  

❌ **Système de connexion des administrateurs** : Authentification sécurisée pour les administrateurs.  
❌ **Système de déconnexion** : Permet aux utilisateurs de se déconnecter proprement.  
❌ **Facilité de création de serveurs** : Outils ou scripts pour déployer facilement de nouveaux serveurs.  
❌ **Support multi-utilisateur** : Permettre à plusieurs utilisateurs de se connecter et d'interagir avec le serveur simultanément.  

---

## 📁 Structure du projet  

- **`ServeurSimple2.java`** : Implémentation principale du serveur WebSocket.  
- **`ihm/`** : Répertoire destiné à l'interface utilisateur (actuellement en développement).  
- **`websocket/`** : Contient le client permettant de se connecter au serveur.  

---

## 📥 Installation  

1. Clonez le dépôt :

   ```
   git clone https://github.com/vava408/WebSocket.git

    Accédez au répertoire du projet :

   cd WebSocket

Compilez le projet avec:

    javac  @compile.list
    
▶ Utilisation

    Lancez le serveur :

    java websocket.Client

    Connectez un client WebSocket à l'adresse ws://localhost:9000.

🤝 Contributions

Les contributions sont les bienvenues ! Ouvrez une issue pour discuter des améliorations ou soumettez une pull request.

_____________________________________________________________________________________________________________________________________________________________________________________________________________________________________

#🌍 WebSocket (English Version)

This project implements a simple **WebSocket server in Java**, allowing real-time communication between a server and clients.

---

##🚀 Current Features

✔ **WebSocket Server**: Real-time communication between the server and clients.
✔ **Single-user connection**: Currently, only one user can interact with the server at a time.

---

##🛠️ Planned Features

❌ **Admin login system**: Secure authentication for administrators.
❌ **Logout system**: Allow users to properly disconnect.
❌ **Easy server deployment**: Tools or scripts to easily create new servers.
❌ **Multi-user support**: Allow multiple users to connect and interact with the server simultaneously.

---
##📁 Project Structure


  ServeurSimple2.java: Main implementation of the WebSocket server.
  ihm/: Directory for the user interface (currently under development).
  websocket/: Contains the client that connects to the server.


📥 Installation

      git clone https://github.com/vava408/WebSocket.git

      Navigate to the project directory:
  
      cd WebSocket

Build the project:

    javac  @compile.list

▶ Usage

    Start the server:

    java websocket.Client
    
    Connect a WebSocket client to ws://localhost:9000.

🤝 Contributions

Contributions are welcome! Open an issue to discuss improvements or submit a pull request.
