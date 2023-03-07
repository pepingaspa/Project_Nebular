# NEBULAR


Nebular is a project led by a group of students in cybersecurity in CYTech Cergy Paris.

## AUTHORS

Alan DABROWSKI - Téo MARTIN - Gaspard PEPIN

---

## TOOLS

Netbeans IDE for linux 

SQL DBeaver

---

## PROTOCOL 0 TRUST:

This protocol is the process to authentify the server and the client. 

The ARP protocol is done and the client try to connect using a socket to the server socket.
Once the socket connection is done, server and client need to authenticate to each other.

1st step: The client pings the server to announce it wishes to establish a connection with it.
On its side, the server gets the MAC address of the said client using the socket. From this and the universal time it generates a one-time key that will be used for the first communication.
Then the server generates a random number that will be used to generate a key for the upcoming communications with the client.
2nd step: The server sends to the client the number generated encrypted with the temporary key it generated.
The client decrypts the message, and generates on its side a random number, named r, between 1 and n-1 (commonly known value written in the code).
3rd step: The client sends the value x calculated with the formula x = r² mod n, along with a table of a hundred values calculated using the Fiat-Shamir method. From now on, every communication is encrypted with the randomly generated key that it just received.
4th step: The server sends a value between 0 and 2100-1.
5th step: The client applies the Fiat-Shamir formula to his table then sends it back to the server.
6th step: The server verifies that all the values are good in the table.
7th step: Once the table is verified to be well filled, both the client and server are authentified, it is time for the user to log in and the communication can continue.
 
This process is thought to double authenticate the client and authenticate once the server.
To this extent, we use a nonce challenge once, as a two-way authentication with 3 messages. Then we use the zero-knowledge authentication to authenticate the client.
We chose to only authenticate the server once, because it is the one initiating everything during the first interaction. Since the client was only just answering this whole time (even though it could obviously not answer the good things if it didn’t know the shared secret), we chose to authenticate it a second time through a zero-knowledge challenge, with a hundred attempts. That way it has ½100 chances to be right without knowing the secret. That makes about 1 over 1030 time right when it shouldn’t be. This lets us be pretty sure about the fact that both the server and client are the good ones.
We thought about preventing brute-force intrusions by putting a limit to the number of attempts of connection before black-listing an IP or a MAC for about 10-15 minutes, but it hasn’t been implemented yet.
