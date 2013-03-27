--
-- Tables with no dependancies
--
CREATE TABLE tags
(id INTEGER PRIMARY KEY NOT NULL DEFAULT NEXTVAL('tag_id_seq'::regclass)
,nom VARCHAR(50) NOT NULL
,url VARCHAR(512) NOT NULL
);

CREATE TABLE adresses
(id INTEGER PRIMARY KEY NOT NULL DEFAULT NEXTVAL('adresse_id_seq'::regclass)
,no_civique INTEGER NOT NULL
,no_appartement INTEGER 
,nom_rue VARCHAR(50) NOT NULL
,code_postal VARCHAR(6) NOT NULL
,ville VARCHAR(256) NOT NULL
,province VARCHAR(42) NOT NULL
);

CREATE TABLE types_spectacle
(id INTEGER PRIMARY KEY NOT NULL DEFAULT NEXTVAL('type_spectacle_id_seq'::regclass)
,nom VARCHAR(50) NOT NULL
,description VARCHAR(256) NOT NULL
);

CREATE TABLE types_billet
(id INTEGER PRIMARY KEY NOT NULL DEFAULT NEXTVAL('type_billet_id_seq'::regclass)
,nom VARCHAR(50) NOT NULL
,description VARCHAR(256) NOT NULL
,is_default BOOLEAN NOT NULL
);

CREATE TABLE nouvelles
(id INTEGER PRIMARY KEY NOT NULL DEFAULT NEXTVAL('nouvelle_id_seq'::regclass)
,titre VARCHAR(50) NOT NULL
,description VARCHAR(256) NOT NULL
,date_parution TIMESTAMP NOT NULL
,auteur VARCHAR(50) NOT NULL
);

CREATE TABLE artistes
(id INTEGER PRIMARY KEY NOT NULL DEFAULT NEXTVAL('artiste_id_seq'::regclass)
,nom VARCHAR(50) NOT NULL
,description VARCHAR(256) NOT NULL
);

CREATE TABLE statut_commandes
(id INTEGER PRIMARY KEY NOT NULL DEFAULT NEXTVAL('statut_commande_id_seq'::regclass)
,nom VARCHAR(256)
,description VARCHAR(256)
,is_default BOOLEAN NOT NULL
);

--
-- Tables with 1 dependancies
--
CREATE TABLE commandes
(id INTEGER PRIMARY KEY NOT NULL DEFAULT NEXTVAL('commande_id_seq'::regclass)
,statut_commande_id INTEGER NOT NULL REFERENCES statut_commandes(id)
,date_modification TIMESTAMP NOT NULL
);

CREATE TABLE item_commandes
(id INTEGER PRIMARY KEY NOT NULL DEFAULT NEXTVAL('item_commande_id_seq'::regclass)
,commande_id INTEGER NOT NULL REFERENCES commandes(id)
,quantite INTEGER CHECK(quantite > 0)
);

CREATE TABLE salles
(id INTEGER PRIMARY KEY NOT NULL DEFAULT NEXTVAL('salle_id_seq'::regclass)
,adresse_id INTEGER NOT NULL REFERENCES adresses(id)
,nom VARCHAR(50)NOT NULL
,capacite INTEGER NOT NULL CHECK(capacite > 0) 
);

CREATE TABLE representations
(id INTEGER PRIMARY KEY NOT NULL DEFAULT NEXTVAL('representation_id_seq'::regclass)
,salle_id INTEGER NOT NULL REFERENCES salles(id) 
,statut VARCHAR(50) NOT NULL
,date_debut TIMESTAMP NOT NULL
,date_fin TIMESTAMP NOT NULL
);

--
-- Tables with 2 dependancies
--
CREATE TABLE clients
(id INTEGER PRIMARY KEY NOT NULL DEFAULT NEXTVAL('client_id_seq'::regclass)
,adresse_id INTEGER NOT NULL REFERENCES adresses(id)
,commande_id INTEGER NOT NULL REFERENCES commandes(id)
,identifiant VARCHAR(50) NOT NULL
,mot_de_passe VARCHAR(50) NOT NULL
,nom VARCHAR(50) NOT NULL
,email VARCHAR(100) NOT NULL
);

CREATE TABLE spectacles
(id INTEGER PRIMARY KEY NOT NULL DEFAULT NEXTVAL('spectacle_id_seq'::regclass)
,adresse_id INTEGER NOT NULL REFERENCES adresses(id)
,type_spectacle_id INTEGER NOT NULL REFERENCES types_spectacle(id)
,nom VARCHAR(50) NOT NULL
,capacite INTEGER CHECK(capacite > 0) 
);

--
-- Tables with WTF dependancies
--
CREATE TABLE transactions
(id INTEGER PRIMARY KEY NOT NULL DEFAULT NEXTVAL('transaction_id_seq'::regclass)
,commande_id INTEGER NOT NULL REFERENCES commandes(id)
,client_id INTEGER NOT NULL REFERENCES clients(id)
,adresse_livraison_id INTEGER NOT NULL REFERENCES adresses(id)
,date_creation TIMESTAMP NOT NULL
,nom VARCHAR(50) NOT NULL
,numero_confirmation_paiement INTEGER NOT NULL
,total_transaction NUMERIC NOT NULL
);

--
-- Relationship tables 
--
CREATE TABLE artistes_tags
(artiste_id INTEGER NOT NULL REFERENCES artistes(id)
,tag_id INTEGER NOT NULL REFERENCES tags(id)
);
ALTER TABLE artistes_tags ADD CONSTRAINT artistes_tags_pkey PRIMARY KEY(artiste_id, tag_id);

CREATE TABLE artistes_spectacles
(artiste_id INTEGER NOT NULL REFERENCES artistes(id)
,spectacle_id INTEGER NOT NULL REFERENCES spectacles(id)
);
ALTER TABLE artistes_spectacles ADD CONSTRAINT artistes_spectacles_pkey PRIMARY KEY(artiste_id, spectacle_id);

CREATE TABLE types_billet_representations
(type_billet_id INTEGER NOT NULL REFERENCES types_billet(id)
,representation_id INTEGER NOT NULL REFERENCES representations(id)
,prix NUMERIC NOT NULL
,nb_billet_emis INTEGER NOT NULL
);
ALTER TABLE types_billet_representations ADD CONSTRAINT types_billet_representation_pkey PRIMARY KEY(type_billet_id, representation_id);

