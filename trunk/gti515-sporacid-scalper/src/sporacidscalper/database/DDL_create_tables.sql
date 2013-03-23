--
-- Tables with no dependancies
--
CREATE TABLE tags
(id SERIAL PRIMARY KEY
,nom VARCHAR(50) NOT NULL
,url VARCHAR(200) NOT NULL
);

CREATE TABLE adresses
(id SERIAL PRIMARY KEY
,no_civique INTEGER NOT NULL
,no_appartement INTEGER 
,nom_rue VARCHAR(50) NOT NULL
,code_postal VARCHAR(6) NOT NULL
,ville VARCHAR(255) NOT NULL
,province VARCHAR(2) NOT NULL
);

CREATE TABLE types_spectacle
(id SERIAL PRIMARY KEY
,nom VARCHAR(50) NOT NULL
,description VARCHAR(300) NOT NULL
);

CREATE TABLE types_billet
(id SERIAL PRIMARY KEY
,nom VARCHAR(50) NOT NULL
,description VARCHAR(300) NOT NULL
);

CREATE TABLE commandes
(id SERIAL PRIMARY KEY
,date_creation TIMESTAMP NOT NULL
);

CREATE TABLE nouvelles
(id SERIAL PRIMARY KEY
,titre VARCHAR(50) NOT NULL
,description VARCHAR(300) NOT NULL
,date DATE NOT NULL
,auteur VARCHAR(50) NOT NULL
);




--
-- Tables with dependancies
--




CREATE TABLE item_commandes
(id SERIAL PRIMARY KEY
,commande_id INTEGER NOT NULL REFERENCES commandes(id)
,quantite INTEGER CHECK(quantite > 0)
);

CREATE TABLE clients
(id SERIAL PRIMARY KEY
,commande_id INTEGER NOT NULL REFERENCES commandes(id)
,identifiant VARCHAR(50) NOT NULL
,mot_de_passe VARCHAR(50) NOT NULL
,nom VARCHAR(50) NOT NULL
,email VARCHAR(100) NOT NULL
,adresse_id VARCHAR(100) NOT NULL REFERENCES adresses(id)
);

CREATE TABLE spectacles
(id SERIAL PRIMARY KEY
,nom VARCHAR(50)NOT NULL
,capacite INTEGER CHECK(quantite > 0) 
,adresse_id INTEGER NOT NULL REFERENCES adresse_(id)
,type_spectacle INTEGER NOT NULL REFERENCES types_spectacle(id)
);

CREATE TABLE artistes
(id SERIAL PRIMARY KEY
,nom VARCHAR(50) NOT NULL
,description VARCHAR(300) NOT NULL
,spectacle_id INTEGER NOT NULL REFERENCES spectacles(id)
);

CREATE TABLE types_billet_representation
(id SERIAL PRIMARY KEY
,prix NUMERIC NOT NULL
,nb_billet_emis INTEGER NOT NULL
,type_billet_id INTEGER NOT NULL REFERENCES types_billet(id)
);

CREATE TABLE salles
(id SERIAL PRIMARY KEY
,nom VARCHAR(50)NOT NULL
,capacite INTEGER NOT NULL CHECK(capacite > 0) 
,adresse_id INTEGER NOT NULL REFERENCES adresses(id)
);

CREATE TABLE representations
(id SERIAL PRIMARY KEY
,statut VARCHAR(50) NOT NULL
,salle INTEGER NOT NULL REFERENCES salles(id) 
,date_debut DATE NOT NULL
,date_fin DATE NOT NULL
);

CREATE TABLE transactions
(id serial PRIMARY KEY
,nom VARCHAR(50) NOT NULL
,numero_confirmation_paiement INTEGER NOT NULL
,total_transaction NUMERIC NOT NULL,
);
