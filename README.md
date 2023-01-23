# NEBULAR


Nebular is a project lead by a group of students in cybersecurity in CYTech Cergy Paris.

## AUTHORS

Alan DABRWOSKI - Téo MARTIN - Gaspard PEPIN

---

## TOOLS

Netbeans IDE for linux 

SQL DBeaver

---

## PROTOCOL 0 TRUST:

This protocol is the process to authentify the server and the client. 

The ARP protocol is done and the client try to connect using a socket to the server socket.
Once the socket connection is done, server and client needs to authenticate to each other.

* Step 1 :

    Server and client generate seperatly a key using the MAC address of the client. The key is temporary and should be the same for both of them.

* Step 2 :

    Server generates a strong symetric key and encrypt it with the temporary key. It sends the final key to the client which decodes it with the temporary key.

    All communications are now crypted using the symetric definitive key.

* Step 3 :

    Server sends its certificate to the client to authenticate and client checks it.

* Step 4 :

    Client sends IP and server verifies it.

* Step 5 :

    Server and client are now authentified. The user can log in.
