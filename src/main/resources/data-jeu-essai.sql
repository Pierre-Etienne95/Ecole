-- data-jeu-essai.sql

INSERT INTO Etudiant (nom, email, cursus, annee) VALUES
('Alice Dupont', 'alice.dupont@example.com', 'Informatique', 2),
('Bob Martin', 'bob.martin@example.com', 'Réseaux', 3),
('Charlie Dumas', 'charlie.dumas@example.com', 'Sécurité', 1);

INSERT INTO Materiel (nom, description, categorie) VALUES
('Ordinateur Portable', 'Ordinateur portable 15 pouces', 'Informatique'),
('Routeur WiFi', 'Routeur WiFi 5Ghz', 'Réseaux'),
('Disque Dur Externe', 'Disque dur externe 1To', 'Stockage');

INSERT INTO Pret (etudiant_id, materiel_id, debut, fin) VALUES
(1, 1, '2024-03-01', '2024-03-15'),
(2, 2, '2024-03-05', NULL),
(3, 3, '2024-03-10', '2024-04-10');

INSERT INTO Probleme (etudiant_id, materiel_id, titre, description) VALUES
(1, 1, 'Clavier', 'Le clavier ne fonctionne pas correctement.'),
(2, 2, 'Demarage', 'Le routeur redémarre de manière inattendue.'),
(3, 3, 'Bug','Le disque dur n est pas reconnu par les systèmes d exploitation.');
