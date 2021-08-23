CREATE TABLE IF NOT EXISTS logs (
	codlog serial NOT NULL,
	descricao text NOT NULL,
	dataAcao text NOT NULL
	
);
--Funcoes

CREATE OR REPLACE FUNCTION fc_inserir_jogador()
    RETURNS TRIGGER AS $$
        BEGIN
            INSERT INTO logs
            (codlog,descricao,dataAcao) VALUES ( default, 'Jogador inserido:' || new.nome, CURRENT_TIMESTAMP);
            RETURN NEW;
        END;
    $$
    LANGUAGE 'plpgsql';
    
CREATE OR REPLACE FUNCTION fc_transfereJogador()
	RETURNS TRIGGER AS $$
	BEGIN
		INSERT INTO logs
		(codlog, descricao, dataAcao) VALUES (default, 'Jogador: ' || new.id_jogador || ' Tranferido para Clube: '|| new.id_clube, CURRENT_TIMESTAMP);
		RETURN NEW;
	END;
	$$
	LANGUAGE 'plpgsql';

CREATE OR REPLACE FUNCTION fc_atualizaJogador()
	RETURNS TRIGGER AS $$
	BEGIN
		INSERT INTO logs
		(codlog, descricao, dataAcao) VALUES (default, 'Jogador: ' || new.id_jogador || 'Atualizado' , CURRENT_TIMESTAMP);
		RETURN NEW;
	END;
	$$
	LANGUAGE 'plpgsql';


CREATE OR REPLACE FUNCTION fc_deletaJogador()
	RETURNS TRIGGER AS $$
	BEGIN
		INSERT INTO logs
		(codlog, descricao, dataAcao) VALUES (default, 'Jogador Deletado' , CURRENT_TIMESTAMP);
		RETURN NEW;
	END;
	$$
	LANGUAGE 'plpgsql';


--Triggers
    CREATE TRIGGER log_trigger AFTER INSERT ON jogador
    FOR EACH ROW
    EXECUTE PROCEDURE fc_inserir_jogador();

	CREATE TRIGGER log_transferencia_trigger AFTER INSERT ON Clube_Jogador
	FOR EACH ROW
	EXECUTE PROCEDURE fc_transfereJogador();
	
	CREATE TRIGGER log_alterarAtributos AFTER UPDATE ON Jogador
	FOR EACH ROW
	EXECUTE PROCEDURE fc_atualizajogador();
	
	CREATE TRIGGER log_deletaJogador AFTER DELETE ON Jogador
	FOR EACH ROW
	EXECUTE PROCEDURE fc_deletaJogador();
	