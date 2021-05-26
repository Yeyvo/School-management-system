CREATE DATABASE IF NOT EXISTS SchoolManagementSystem DEFAULT CHARACTER SET UTF8 DEFAULT COLLATE UTF8_GENERAL_CI;

USE SchoolManagementSystem;


DROP TABLE IF EXISTS ServicesEtud;
DROP TABLE IF EXISTS Inscription;
DROP TABLE IF EXISTS Filière;

DROP TABLE IF EXISTS Etablissement;
DROP TABLE IF EXISTS Etudiant;

CREATE TABLE Etudiant(
	EtudId INT NOT NULL PRIMARY KEY,
	EtudCNE varchar(255),
	EtudNom varchar(255),
	EtudPrenom varchar(255),
	EtudSfam varchar(255),
	EtudNat varchar(255),
	EtudNai varchar(255),
	EtudSexe varchar(255),
	EtudAd1 varchar(255),
	EtudCPS varchar(255),
	EtudVil varchar(255),
	EtudDpt varchar(255),
	EtudTel varchar(255),
	EtudMail varchar(255),
	EtudRib varchar(255),
	CniePere varchar(255),
	EtudNomp varchar(255),
	EtudPrep varchar(255),
	EtudDNP DATE,
	EtudDDP DATE,
	CnieMere varchar(255),
	EtudNomm varchar(255),
	Etudprem varchar(255),
	EtudDNM DATE,
	EtudDDM DATE
	);


CREATE TABLE Etablissement(
	CodeEtab INT NOT NULL PRIMARY KEY,
	DesEtab varchar(255),
	EtudDPM varchar(255)
	);



CREATE TABLE Filière(
	CodeEtab INT NOT NULL,
	CodeFil INT NOT NULL,
	DesFil varchar(255),
	PRIMARY KEY (CodeEtab, CodeFil),
	FOREIGN KEY (CodeEtab) REFERENCES Etablissement(CodeEtab)
	);



CREATE TABLE Inscription(
	EtudId INT NOT NULL,
	EtudEtab INT NOT NULL,
	EtudFil INT,
	EtudInsc varchar(255) NOT NULL,
	PRIMARY KEY (EtudId, EtudEtab, EtudInsc),
	FOREIGN KEY (EtudId) REFERENCES Etudiant(EtudId),
	FOREIGN KEY (EtudEtab) REFERENCES Etablissement(CodeEtab),
	FOREIGN KEY (EtudEtab,EtudFil) REFERENCES Filière(CodeEtab,CodeFil)
	);



CREATE TABLE ServicesEtud(
	EtudId INT NOT NULL,
	EtudANS varchar(255) NOT NULL,
	EtudBO BOOLEAN,
	EtudCU BOOLEAN,
	EtudCMB varchar(255),
	EtudCMBO varchar(255),
	PRIMARY KEY (EtudId, EtudANS),
	FOREIGN KEY (EtudId) REFERENCES Etudiant(EtudId)
	);