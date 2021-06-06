CREATE DATABASE IF NOT EXISTS SchoolManagementSystem DEFAULT CHARACTER SET UTF8 DEFAULT COLLATE UTF8_GENERAL_CI;

USE SchoolManagementSystem;


DROP TABLE IF EXISTS ServicesEtud;
DROP TABLE IF EXISTS Inscription;
DROP TABLE IF EXISTS Filière;

DROP TABLE IF EXISTS Etablissement;
DROP TABLE IF EXISTS Etudiant;

CREATE TABLE Etudiant(
	EtudId INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	EtudCNE varchar(15),
	EtudNom varchar(50),
	EtudPrenom varchar(70),
	EtudSfam varchar(15),
	EtudNat varchar(255),
	EtudNai DATE,
	EtudSexe varchar(20),
	EtudAd1 varchar(255),
	EtudCPS INT,
	EtudVil varchar(70),
	EtudDpt varchar(255),
	EtudTel varchar(20),
	EtudMail varchar(100),
	EtudRib varchar(255),
	CniePere varchar(20),
	EtudNomp varchar(255),
	EtudPrep varchar(255),
	EtudDNP DATE,
	EtudDDP DATE,
	CnieMere varchar(20),
	EtudNomm varchar(255),
	Etudprem varchar(255),
	EtudDNM DATE,
	EtudDDM DATE
	)ENGINE=INNODB;


CREATE TABLE Etablissement(
	CodeEtab INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	DesEtab varchar(255),
	EtudDPM varchar(255)
	)ENGINE=INNODB;



CREATE TABLE Filiere(
	CodeEtab INT NOT NULL,
	CodeFil INT NOT NULL,
	DesFil varchar(255),
	PRIMARY KEY (CodeEtab, CodeFil),
	FOREIGN KEY (CodeEtab) REFERENCES Etablissement(CodeEtab)
	)ENGINE=INNODB;



CREATE TABLE Inscription(
	EtudId INT NOT NULL,
	EtudEtab INT NOT NULL,
	EtudFil INT NOT NULL,
	EtudInsc varchar(11) NOT NULL,
	PRIMARY KEY (EtudId, EtudEtab, EtudInsc),
	FOREIGN KEY (EtudId) REFERENCES Etudiant(EtudId),
	FOREIGN KEY (EtudEtab) REFERENCES Etablissement(CodeEtab),
	FOREIGN KEY (EtudEtab,EtudFil) REFERENCES Filiere(CodeEtab,CodeFil)
	)ENGINE=INNODB;



CREATE TABLE ServicesEtud(
	EtudId INT NOT NULL,
	EtudANS varchar(11) NOT NULL,
	EtudBO BOOLEAN,
	EtudCU BOOLEAN,
	EtudCMB BOOLEAN,
	EtudCMBO varchar(255),
	PRIMARY KEY (EtudId, EtudANS),
	FOREIGN KEY (EtudId) REFERENCES Etudiant(EtudId)
	)ENGINE=INNODB;
