Select * from clube

CREATE TABLE IF NOT EXISTS Jogador (
    ID_Jogador SERIAL,
    Nome Varchar(40) NOT NULL,
    Posicao Varchar(4) NOT NULL,
    Idade integer NOT NULL,
    Pe_Dominante Char NOT NULL,
    
    --Chave Primaria
    CONSTRAINT jogador_pkey PRIMARY KEY(ID_Jogador)
);

CREATE TABLE IF NOT EXISTS Clube (
    ID_Clube SERIAL,
    Nome Varchar(40) NOT NULL,
    Localizacao Varchar(40) NOT NULL,
    
    --Chave Primaria
    CONSTRAINT clube_pkey PRIMARY KEY(ID_Clube)
);

CREATE TABLE IF NOT EXISTS Tecnico (
    ID_Tecnico SERIAL,
    Nome Varchar(40),
    Idade integer,
    Licenca Char,
    
    --Chave Primaria
    CONSTRAINT tecnico_pkey PRIMARY KEY(ID_Tecnico)
);

CREATE TABLE IF NOT EXISTS Competicao (
    ID_Competicao SERIAL,
    Nome Varchar(40) NOT NULL,
    Localizacao Varchar(40) NOT NULL,
    
    --Chave Primaria
    CONSTRAINT competicao_pkey PRIMARY KEY(ID_Competicao)
);


CREATE TABLE Clube_Jogador (
    id_clube SERIAL,
    id_jogador SERIAL,
    Salario numeric NOT NULL,
    
    CONSTRAINT clube_jogador_fkey FOREIGN KEY (id_clube)
    REFERENCES Clube(id_clube),
    
    CONSTRAINT clube2_jogador_fkey FOREIGN KEY (id_jogador)
    REFERENCES Jogador(id_jogador)
);

CREATE TABLE Clube_Tecnico (
    id_clube SERIAL,
    id_tecnico SERIAL,
    Salario numeric NOT NULL,
    
    CONSTRAINT clube_tecnico_fkey FOREIGN KEY (id_clube)
    REFERENCES Clube(id_clube),
    
    CONSTRAINT clube2_tecnico_fkey FOREIGN KEY (id_tecnico)
    REFERENCES Tecnico(id_tecnico)
);

CREATE TABLE Clube_Competicao (
    id_clube SERIAL,
    id_competicao SERIAL,
    
    CONSTRAINT clube_competicao_fkey FOREIGN KEY (id_clube)
    REFERENCES Clube(id_clube),
    
    CONSTRAINT clube2_competicao_fkey FOREIGN KEY (id_competicao)
    REFERENCES Competicao(id_Competicao)
    
);