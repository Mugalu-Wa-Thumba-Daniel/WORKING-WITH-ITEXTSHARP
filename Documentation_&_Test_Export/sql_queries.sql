-- Créer la base de données
CREATE DATABASE university;

-- Utiliser la base de données
USE university;

-- Créer la table 'students'
CREATE TABLE students (
    id INT AUTO_INCREMENT PRIMARY KEY, -- Identifiant unique pour chaque étudiant
    name VARCHAR(100) NOT NULL,        -- Nom de l'étudiant
    age INT NOT NULL,                  -- Âge de l'étudiant
    program VARCHAR(100) NOT NULL,     -- Programme suivi par l'étudiant
    email VARCHAR(150) NOT NULL UNIQUE -- Adresse e-mail unique de l'étudiant
);

-- Insérer des données de test
INSERT INTO students (name, age, program, email) VALUES
('Alice Dupont', 22, 'Informatique', 'alice.dupont@example.com'),
('Jean Martin', 24, 'Mathématiques', 'jean.martin@example.com'),
('Marie Curie', 23, 'Physique', 'marie.curie@example.com'),
('Paul Dubois', 21, 'Chimie', 'paul.dubois@example.com'),
('Élodie Rousseau', 20, 'Biologie', 'elodie.rousseau@example.com');

		