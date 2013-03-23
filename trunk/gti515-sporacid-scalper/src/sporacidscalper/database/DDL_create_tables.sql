CREATE TABLE adresses
(id SERIAL PRIMARY KEY
,no_civique INTEGER NOT NULL
,no_appartement INTEGER 
,nom_rue VARCHAR(50) NOT NULL
,code_postal VARCHAR(6) NOT NULL
,ville VARCHAR(255) NOT NULL
,province VARCHAR(2) NOT NULL
);

CREATE TABLE commandes
(id SERIAL PRIMARY KEY
,date_creation TIMESTAMP NOT NULL
);

CREATE TABLE item_commandes
(id SERIAL PRIMARY KEY
,commande_id INTEGER NOT NULL REFERENCES commandes(id)
,quantite INTEGER CHECK(quantite > 0)
);

CREATE TABLE transactions
(id SERIAL PRIMARY KEY
,commande_id INTEGER NOT NULL REFERENCES commandes(id)
,nom VARCHAR(255)
,no_confirmation_paiement INTEGER
,total_transaction NUMERIC
);
