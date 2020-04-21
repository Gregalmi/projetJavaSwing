CREATE TABLE Vilains(
   vil_id INT auto_increment,
   vil_nom VARCHAR(50),
   vil_identite VARCHAR(50),
   vil_commentaire VARCHAR(50),
   vil_faiblesse VARCHAR(50),
   vil_malveillance INT,
   PRIMARY KEY(vil_id)
);

CREATE TABLE Groupedecombat(
   cbt_id INT auto_increment,
   cbt_intitule VARCHAR(50),
   PRIMARY KEY(cbt_id)
);

CREATE TABLE Organisation(
   org_id INT auto_increment,
   org_nom VARCHAR(50),
   org_adresse VARCHAR(50),
   org_dirigeant VARCHAR(50),
   org_commentaires VARCHAR(50),
   org_date DATETIME,
   PRIMARY KEY(org_id)
);

CREATE TABLE Heros(
   her_id INT auto_increment,
   her_nom VARCHAR(50),
   her_identite VARCHAR(50) NOT NULL,
   her_commentaire VARCHAR(50),
   her_pouvoir VARCHAR(50),
   org_id INT NOT NULL,
   
   PRIMARY KEY(her_id),
   FOREIGN KEY(org_id) REFERENCES Organisation(org_id)
);

CREATE TABLE Her_participe(
   her_par_id INT,
   cbt_id INT,
   PRIMARY KEY(her_par_id, cbt_id),
   FOREIGN KEY(her_par_id) REFERENCES Heros(her_id),
   FOREIGN KEY(cbt_id) REFERENCES Groupedecombat(cbt_id)
);

CREATE TABLE Vil_participe(
   vil_par_id INT,
   cbt_id INT,
   PRIMARY KEY(vil_par_id, cbt_id),
   FOREIGN KEY(vil_par_id) REFERENCES Vilains(vil_id),
   FOREIGN KEY(cbt_id) REFERENCES Groupedecombat(cbt_id)
);
