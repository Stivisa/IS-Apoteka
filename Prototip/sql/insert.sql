use veleprodaja;

LOAD DATA LOCAL INFILE 'veleprodaja/zaposleni.txt' INTO TABLE Zaposleni
  FIELDS TERMINATED BY ',';
  
LOAD DATA LOCAL INFILE 'veleprodaja/kupci.txt' INTO TABLE KupciDobavljaci
  FIELDS TERMINATED BY ',';
  
LOAD DATA LOCAL INFILE 'veleprodaja/kontakti.txt' INTO TABLE Kontakt_osoba
  FIELDS TERMINATED BY ',';

LOAD DATA LOCAL INFILE 'veleprodaja/porudzbina.txt' INTO TABLE PorudzbinaNarudzbina
  FIELDS TERMINATED BY ',';
  
LOAD DATA LOCAL INFILE 'veleprodaja/ponuda.txt' INTO TABLE Ponuda
  FIELDS TERMINATED BY ',';
  
LOAD DATA LOCAL INFILE 'veleprodaja/otpremnica.txt' INTO TABLE OtpremnicaPrijemnica
  FIELDS TERMINATED BY ','; 
  
LOAD DATA LOCAL INFILE 'veleprodaja/fakturaIzl.txt' INTO TABLE FakturaIzlazna
  FIELDS TERMINATED BY ',';
  
LOAD DATA LOCAL INFILE 'veleprodaja/fakturaUlaz.txt' INTO TABLE FakturaUlazna
  FIELDS TERMINATED BY ',';  
  
LOAD DATA LOCAL INFILE 'veleprodaja/proizvod.txt' INTO TABLE Proizvod
  FIELDS TERMINATED BY ',';
  
LOAD DATA LOCAL INFILE 'veleprodaja/proizvod_has_proizvod.txt' INTO TABLE Proizvod_has_Proizvod
  FIELDS TERMINATED BY ',';
  
LOAD DATA LOCAL INFILE 'veleprodaja/stavka.txt' INTO TABLE Stavka
  FIELDS TERMINATED BY ',';
