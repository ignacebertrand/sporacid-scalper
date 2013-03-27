INSERT INTO types_spectacle(
            id, nom, description, is_default)
    VALUES (DEFAULT, 'Humour', 'Spectacle qui fait rire.', false);
INSERT INTO types_spectacle(
            id, nom, description, is_default)
    VALUES (DEFAULT, 'Heavy Metal', 'Spectacle de musique heavy metal.', true);
INSERT INTO types_spectacle(
            id, nom, description, is_default)
    VALUES (DEFAULT, 'Country', 'Spectacle de musique country.', false);
INSERT INTO types_spectacle(
            id, nom, description, is_default)
    VALUES (DEFAULT, 'Classique', 'Spectacle de musique classique.', false);

	
INSERT INTO adresses(
            id, no_civique, no_appartement, nom_rue, code_postal, ville, 
            province)
    VALUES (DEFAULT, 59, null, 'Ste-Catherine Est', 'H2X1K5', 'Montreal', 'Qc');
INSERT INTO salles(
            id, nom, capacite, adresse_id)
    VALUES (DEFAULT, 'Metropolis', 3500, currval('adresse_id_seq'));
INSERT INTO adresses(
            id, no_civique, no_appartement, nom_rue, code_postal, ville, 
            province)
    VALUES (DEFAULT, 1225, null, 'St-Laurent', 'H2X2S6', 'Montreal', 'Qc');
INSERT INTO salles(
            id, nom, capacite, adresse_id)
    VALUES (DEFAULT, 'Club Soda', 1500, currval('adresse_id_seq'));
INSERT INTO salles(
            id, nom, capacite, adresse_id)
    VALUES (DEFAULT, 'Impérail', 2500, currval('adresse_id_seq'));
INSERT INTO adresses(
            id, no_civique, no_appartement, nom_rue, code_postal, ville, 
            province)
    VALUES (DEFAULT, 252, null, 'St-Joseph Est', 'G1K3A9', 'Québec', 'Qc');

	
INSERT INTO types_billet(
            id, nom, description, is_default)
    VALUES (DEFAULT, 'Admission générale', 'Admission générale sur le parterre.', true);
INSERT INTO statut_commandes(
            id, nom, description, is_default)
    VALUES (DEFAULT, 'Reçue', 'La commande a été reçue et est en attente d''être traitée.', true);
INSERT INTO statut_commandes(
            id, nom, description, is_default)
    VALUES (DEFAULT, 'Traitée', 'La commande a été traitée et est en attente d''être envoyée.', false);
INSERT INTO statut_commandes(
            id, nom, description, is_default)
    VALUES (DEFAULT, 'Envoyée', 'La commande a été envoyée.', false);

COMMIT;