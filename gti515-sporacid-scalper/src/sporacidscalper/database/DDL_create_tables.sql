--
-- Tables with no dependancies
--
CREATE TABLE tags
(id INTEGER PRIMARY KEY NOT NULL DEFAULT NEXTVAL('tag_id_seq'::regclass)
,nom VARCHAR(50) NOT NULL
,url VARCHAR(200) NOT NULL
);

CREATE TABLE adresses
(id INTEGER PRIMARY KEY NOT NULL DEFAULT NEXTVAL('adresse_id_seq'::regclass)
,no_civique INTEGER NOT NULL
,no_appartement INTEGER 
,nom_rue VARCHAR(50) NOT NULL
,code_postal VARCHAR(6) NOT NULL
,ville VARCHAR(255) NOT NULL
,province VARCHAR(2) NOT NULL
);

CREATE TABLE types_spectacle
(id INTEGER PRIMARY KEY NOT NULL DEFAULT NEXTVAL('type_spectacle_id_seq'::regclass)
,nom VARCHAR(50) NOT NULL
,description VARCHAR(300) NOT NULL
);

CREATE TABLE types_billet
(id INTEGER PRIMARY KEY NOT NULL DEFAULT NEXTVAL('type_billet_id_seq'::regclass)
,nom VARCHAR(50) NOT NULL
,description VARCHAR(300) NOT NULL
);

CREATE TABLE commandes
(id INTEGER PRIMARY KEY NOT NULL DEFAULT NEXTVAL('commande_id_seq'::regclass)
,date_creation TIMESTAMP NOT NULL
);

CREATE TABLE nouvelles
(id INTEGER PRIMARY KEY NOT NULL DEFAULT NEXTVAL('nouvelle_id_seq'::regclass)
,titre VARCHAR(50) NOT NULL
,description VARCHAR(300) NOT NULL
,date DATE NOT NULL
,auteur VARCHAR(50) NOT NULL
);


--
-- Tables with 1 dependancies
--
CREATE TABLE transactions
(id INTEGER PRIMARY KEY NOT NULL DEFAULT NEXTVAL('transaction_id_seq'::regclass)
,commande_id INTEGER NOT NULL REFERENCES commandes(id)
,nom VARCHAR(50) NOT NULL
,numero_confirmation_paiement INTEGER NOT NULL
,total_transaction NUMERIC NOT NULL
);

CREATE TABLE item_commandes
(id INTEGER PRIMARY KEY NOT NULL DEFAULT NEXTVAL('item_commande_id_seq'::regclass)
,commande_id INTEGER NOT NULL REFERENCES commandes(id)
,quantite INTEGER CHECK(quantite > 0)
);

CREATE TABLE artistes
(id INTEGER PRIMARY KEY NOT NULL DEFAULT NEXTVAL('artiste_id_seq'::regclass)
,spectacle_id INTEGER NOT NULL REFERENCES spectacles(id)
,nom VARCHAR(50) NOT NULL
,description VARCHAR(300) NOT NULL
);

CREATE TABLE types_billet_representation
(id INTEGER PRIMARY KEY NOT NULL DEFAULT NEXTVAL('type_billet_representation_id_seq'::regclass)
,type_billet_id INTEGER NOT NULL REFERENCES types_billet(id)
,prix NUMERIC NOT NULL
,nb_billet_emis INTEGER NOT NULL
);

CREATE TABLE representations
(id INTEGER PRIMARY KEY NOT NULL DEFAULT NEXTVAL('representation_id_seq'::regclass)
,salle INTEGER NOT NULL REFERENCES salles(id) 
,statut VARCHAR(50) NOT NULL
,date_debut DATE NOT NULL
,date_fin DATE NOT NULL
);

CREATE TABLE salles
(id INTEGER PRIMARY KEY NOT NULL DEFAULT NEXTVAL('salle_id_seq'::regclass)
,adresse_id INTEGER NOT NULL REFERENCES adresses(id)
,nom VARCHAR(50)NOT NULL
,capacite INTEGER NOT NULL CHECK(capacite > 0) 
);

--
-- Tables with 2 dependancies
--
CREATE TABLE clients
(id INTEGER PRIMARY KEY NOT NULL DEFAULT NEXTVAL('client_id_seq'::regclass)
,adresse_id VARCHAR(100) NOT NULL REFERENCES adresses(id)
,commande_id INTEGER NOT NULL REFERENCES commandes(id)
,identifiant VARCHAR(50) NOT NULL
,mot_de_passe VARCHAR(50) NOT NULL
,nom VARCHAR(50) NOT NULL
,email VARCHAR(100) NOT NULL
);

CREATE TABLE spectacles
(id INTEGER PRIMARY KEY NOT NULL DEFAULT NEXTVAL('spectacle_id_seq'::regclass)
,adresse_id INTEGER NOT NULL REFERENCES adresse(id)
,type_spectacle INTEGER NOT NULL REFERENCES types_spectacle(id)
,nom VARCHAR(50)NOT NULL
,capacite INTEGER CHECK(capacite > 0) 
);


