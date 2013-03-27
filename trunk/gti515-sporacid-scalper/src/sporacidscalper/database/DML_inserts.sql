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

	
INSERT INTO spectacles(
            id, type_spectacle_id, nom, poster_url)
    VALUES (DEFAULT, 2, 'Lancement d''album Decrepit Birth', 'styles/images/decrepit-birth-event.jpg');

INSERT INTO artistes(
            id, nom, description)
    VALUES (DEFAULT, 'Decrepit Birth', 'Decrepit Birth is a death metal band from Santa Cruz, California, USA. They have released two studio albums through Unique Leader Records and one through Nuclear Blast, and a demo independently. [Wkipedia]');

INSERT INTO tags(
            id, nom, url)
    VALUES (DEFAULT, 'Technical Death Metal', 'http://en.wikipedia.org/wiki/Technical_death_metal');

INSERT INTO artistes_tags(
            artiste_id, tag_id)
    VALUES (currval('artiste_id_seq'), currval('tag_id_seq'));

INSERT INTO tags(
            id, nom, url)
    VALUES (DEFAULT, 'Heavy Metal', 'http://en.wikipedia.org/wiki/Heavy_metal_music');

INSERT INTO artistes_tags(
            artiste_id, tag_id)
    VALUES (currval('artiste_id_seq'), currval('tag_id_seq'));
	
INSERT INTO artistes_spectacles(
            artiste_id, spectacle_id)
    VALUES (currval('artiste_id_seq'), currval('spectacle_id_seq'));

COMMIT;