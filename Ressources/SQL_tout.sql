--connection

connect system/bourne;

--creation user
drop user ROBNINA cascade;

create user ROBNINA identified by TOTO;

grant connect, resource to ROBNINA;

--connection

connect ROBNINA/TOTO;

--creation table conseiller

create table conseiller 
(
 idConseiller NUMBER(10)
    CONSTRAINT pk_idcons PRIMARY KEY,
userid varchar(20) unique,
nom varchar(25) not null,
prenom varchar(25)  not null,
password varchar(25)  not null);

-- creation table role
create table role
( idConseiller	NUMBER(10) constraint fk_login references conseiller(idConseiller), 
role_type varchar(20));

--creation table client

create table client 
(idClient number(10) constraint pk_cli primary key ,
nom varchar(25)  not null,
prenom varchar(25)  not null,
 adresse varchar(25) not null,
codepostal varchar(25)  not null,
ville varchar(25)  not null,
telephone varchar(25)  not null,
  idConseiller NUMBER(10)
    CONSTRAINT fk_cli_idcons REFERENCES conseiller( idConseiller )
);

--creation table compte


create table compte 
(idCompte number(10) constraint pk_cpt primary key ,
 solde numeric(10,2) not null,
typeC varchar(25)  not null,
 interet numeric(3,2) not null,
decouvert numeric(6,2)  not null,
idClient NUMBER(10)
    CONSTRAINT fk_cpt_cli REFERENCES Client(idClient )
);

create table virement
(idVirement number(10) constraint pk_vir primary key ,
idComptedebit NUMBER(10)
    CONSTRAINT fk_vir_cptd REFERENCES Compte(idCompte ),
idComptecredit number(10)
    CONSTRAINT fk_vir_cptc REFERENCES Compte(idCompte ),
montant number,
dateV date);





--remplissage de la  table conseiller
insert into conseiller
values (1, 'mbiandou1','mbiandou', 'douglas', 'mdpdouglas');

insert into conseiller 
values (2, 'zam2','zam', 'eddy', 'mdpeddy');

insert into conseiller
values (3,'chabi3','chabi','amelle', 'mdpamelle');

-- remplissage de la table role

insert into role (idConseiller, role_type)
values (1, 'conseiller');
insert into role (idConseiller, role_type)
values (2, 'conseiller');
insert into role (idConseiller, role_type)
values (3, 'conseiller');


--remplissage de la  table client pour le conseiller 1

insert into client (idclient, nom, prenom, adresse, codepostal, ville, telephone, idConseiller)
values (1, 'rodier', 'lise', 'rue de la paix', '91440', 'orsay', '0184596535',1);

insert into client (idclient, nom, prenom, adresse, codepostal, ville, telephone, idConseiller)
values (2, 'petard', 'lise', 'rue de gtm', '93440', 'dugny', '0184595931',1);

insert into client (idclient, nom, prenom, adresse, codepostal, ville, telephone, idConseiller)
values (3, 'de bruyn', 'benjamin', 'rue de toulouse', '75002', 'Toulouse', '0184590574',1);

insert into client (idclient, nom, prenom, adresse, codepostal, ville, telephone, idConseiller)
values (4, 'gondran', 'victor', 'rue de la biologie', '95520', 'garges', '0184595932',1);

insert into client (idclient, nom, prenom, adresse, codepostal, ville, telephone, idConseiller)
values (5, 'cadot', 'solene', 'rue de nice', '01000', 'Nice', '0184596518',1);

insert into client (idclient, nom, prenom, adresse, codepostal, ville, telephone, idConseiller)
values (6, 'belleus', 'hattmann', 'rue de compiegne', '60000', 'compiegne', '0184594892',1);

insert into client (idclient, nom, prenom, adresse, codepostal, ville, telephone, idConseiller)
values (7, 'eymann', 'loriane', 'rue du risque', '92200', 'neuilly', '0184590051',1);

insert into client (idclient, nom, prenom, adresse, codepostal, ville, telephone, idConseiller)
values (8, 'cheleux', 'joinel', 'rue du laser', '93120', 'la courneuve', '0184590782',1);

insert into client (idclient, nom, prenom, adresse, codepostal, ville, telephone, idConseiller)
values (9, 'bordes', 'robinson', 'rue de la tortue', '45000', 'orleans', '0184595901',1);

insert into client (idclient, nom, prenom, adresse, codepostal, ville, telephone, idConseiller)
values (10, 'khalfallah', 'khaled', 'rue du la finance', '93990', 'bagnolet', '0184595445',1);

--remplissage de la  table client pour le conseiller 2

insert into client (idclient, nom, prenom, adresse, codepostal, ville, telephone, idConseiller)
values (11, 'depardieu', 'gerard', 'rue de la paix', '91440', 'orsay', '0184596535',2);

insert into client (idclient, nom, prenom, adresse, codepostal, ville, telephone, idConseiller)
values (12, 'clavier', 'christian', 'rue de gtm', '93440', 'dugny', '0184595931',2);

insert into client (idclient, nom, prenom, adresse, codepostal, ville, telephone, idConseiller)
values (13, 'chabat', 'alain', 'rue de toulouse', '75002', 'Toulouse', '0184590574',2);

insert into client (idclient, nom, prenom, adresse, codepostal, ville, telephone, idConseiller)
values (14, 'baer', 'edouard', 'rue de la biologie', '95520', 'garges', '0184595932',2);


--remplissage de la  table client pour le conseiller 3

insert into client (idclient, nom, prenom, adresse, codepostal, ville, telephone, idConseiller)
values (21, 'blanc','michel', 'rue de la paix', '91440', 'orsay', '0184596535',3);

insert into client (idclient, nom, prenom, adresse, codepostal, ville, telephone, idConseiller)
values (22, 'chazel', 'marianne', 'rue de gtm', '93440', 'dugny', '0184595931',3);

insert into client (idclient, nom, prenom, adresse, codepostal, ville, telephone, idConseiller)
values (23, 'jugnot', 'gerard', 'rue de toulouse', '75002', 'Toulouse', '0184590574',3);

insert into client (idclient, nom, prenom, adresse, codepostal, ville, telephone, idConseiller)
values (24, 'lhermitte', 'thierry', 'rue de la biologie', '95520', 'garges', '0184595932',3);

commit;




--remplissage table compte pour 

insert into compte (idCompte,solde,typeC,interet,decouvert,idClient)
values (11, 10000, 'courant', 0 , 1000, 1);

insert into compte (idCompte,solde,typeC,interet,decouvert,idClient)
values (12, 3000, 'epargne', 3 , 0, 1);

insert into compte (idCompte,solde,typeC,interet,decouvert,idClient)
values (21, 3000, 'courant', 0 , 1000, 2);

insert into compte (idCompte,solde,typeC,interet,decouvert,idClient)
values (22, 500, 'epargne', 3 , 0, 2);

insert into compte (idCompte,solde,typeC,interet,decouvert,idClient)
values (31, 2000, 'courant', 0 , 1000, 3);

insert into compte (idCompte,solde,typeC,interet,decouvert,idClient)
values (32, 300, 'epargne', 3 , 0, 3);

insert into compte (idCompte,solde,typeC,interet,decouvert,idClient)
values (41, 150, 'courant', 0 , 1000, 4);

insert into compte (idCompte,solde,typeC,interet,decouvert,idClient)
values (42, 20, 'epargne', 3 , 0, 4);

insert into compte (idCompte,solde,typeC,interet,decouvert,idClient)
values (51, 60, 'courant', 0 , 1000, 5);

insert into compte (idCompte,solde,typeC,interet,decouvert,idClient)
values (52, 0, 'epargne', 3 , 0, 5);

insert into compte (idCompte,solde,typeC,interet,decouvert,idClient)
values (61, 15000, 'courant', 0 , 1000, 6);

insert into compte (idCompte,solde,typeC,interet,decouvert,idClient)
values (62, 50, 'epargne', 3 , 0, 6);

insert into compte (idCompte,solde,typeC,interet,decouvert,idClient)
values (71, 6000, 'courant', 0 , 1000, 7);

insert into compte (idCompte,solde,typeC,interet,decouvert,idClient)
values (72, 20, 'epargne', 3 , 0, 7);

insert into compte (idCompte,solde,typeC,interet,decouvert,idClient)
values (81, 1000000, 'courant', 0 , 1000, 8);

insert into compte (idCompte,solde,typeC,interet,decouvert,idClient)
values (82, 30000, 'epargne', 3 , 0, 8);

insert into compte (idCompte,solde,typeC,interet,decouvert,idClient)
values (91, 4000, 'courant', 0 , 1000, 9);

insert into compte (idCompte,solde,typeC,interet,decouvert,idClient)
values (92, 320, 'epargne', 3 , 0, 9);

insert into compte (idCompte,solde,typeC,interet,decouvert,idClient)
values (101, 700, 'courant', 0 , 1000, 10);

insert into compte (idCompte,solde,typeC,interet,decouvert,idClient)
values (102, 60, 'epargne', 3 , 0, 10);

insert into compte (idCompte,solde,typeC,interet,decouvert,idClient)
values (111, 7000, 'courant', 0 , 1000, 11);

insert into compte (idCompte,solde,typeC,interet,decouvert,idClient)
values (112, 600, 'epargne', 3 , 0, 11);

insert into compte (idCompte,solde,typeC,interet,decouvert,idClient)
values (121, 50, 'courant', 0 , 1000, 12);

insert into compte (idCompte,solde,typeC,interet,decouvert,idClient)
values (122, 5, 'epargne', 3 , 0, 12);

insert into compte (idCompte,solde,typeC,interet,decouvert,idClient)
values (131, 7005, 'courant', 0 , 1000, 13);

insert into compte (idCompte,solde,typeC,interet,decouvert,idClient)
values (132, 654, 'epargne', 3 , 0, 13);

insert into compte (idCompte,solde,typeC,interet,decouvert,idClient)
values (141, 60000, 'courant', 0 , 1000, 14);

insert into compte (idCompte,solde,typeC,interet,decouvert,idClient)
values (142, 500, 'epargne', 3 , 0, 14);

insert into compte (idCompte,solde,typeC,interet,decouvert,idClient)
values (211, 321, 'courant', 0 , 1000, 21);

insert into compte (idCompte,solde,typeC,interet,decouvert,idClient)
values (212, 560, 'epargne', 3 , 0, 21);

insert into compte (idCompte,solde,typeC,interet,decouvert,idClient)
values (221, 540, 'courant', 0 , 1000, 22);

insert into compte (idCompte,solde,typeC,interet,decouvert,idClient)
values (222, 950, 'epargne', 3 , 0, 22);

insert into compte (idCompte,solde,typeC,interet,decouvert,idClient)
values (231, 2100, 'courant', 0 , 1000, 23);

insert into compte (idCompte,solde,typeC,interet,decouvert,idClient)
values (232, 95, 'epargne', 3 , 0, 23);

insert into compte (idCompte,solde,typeC,interet,decouvert,idClient)
values (241, 321, 'courant', 0 , 1000, 24);

insert into compte (idCompte,solde,typeC,interet,decouvert,idClient)
values (242, 560, 'epargne', 3 , 0, 24);
commit;



commit;