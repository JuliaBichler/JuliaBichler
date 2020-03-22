DROP DATABASE IF EXISTS infidb;
CREATE DATABASE infidb;
\c infidb;


CREATE TABLE adresse (
adresse_ID SERIAL NOT NULL,
hausnr VARCHAR(50) NOT NULL,
stadt VARCHAR(50) NOT NULL,
plz VARCHAR(50) NOT NULL,
strasse VARCHAR(50) NOT NULL,
PRIMARY KEY(adresse_ID)
);

CREATE TABLE kunde (
kunden_ID SERIAL NOT NULL,
titelV VARCHAR(50) NOT NULL,
vorname VARCHAR(50) NOT NULL,
nachname VARCHAR(50) NOT NULL,
titelN VARCHAR(50) NOT NULL,
PRIMARY KEY(kunden_ID)
);

CREATE TABLE bestellung (
bestell_ID SERIAL NOT NULL,
kunden_ID SERIAL NOT NULL,
adresse_rechnung_ID INT NOT NULL,
adresse_liefer_ID INT NOT NULL,
PRIMARY KEY(bestell_ID),
FOREIGN KEY(kunden_ID) REFERENCES kunde(kunden_ID) ON DELETE CASCADE,
FOREIGN KEY(adresse_rechnung_ID) REFERENCES adresse(adresse_ID) ON DELETE CASCADE,
FOREIGN KEY(adresse_liefer_ID) REFERENCES adresse(adresse_ID) ON DELETE CASCADE
);

CREATE TABLE artikel (
artikel_ID SERIAL NOT NULL,
name VARCHAR(50) NOT NULL,
preis VARCHAR(50) NOT NULL,
PRIMARY KEY(artikel_ID)
);

CREATE TABLE bestellung_artikel (
bestell_ID SERIAL NOT NULL,
artikel_ID SERIAL NOT NULL,
menge INT NOT NULL,
FOREIGN KEY(bestell_ID) REFERENCES bestellung(bestell_ID) ON DELETE CASCADE,
FOREIGN KEY(artikel_ID) REFERENCES artikel(artikel_ID) ON DELETE CASCADE
);
