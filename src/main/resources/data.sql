INSERT INTO roles VALUES('1','USER')
INSERT INTO roles VALUES('2','ADIM')

INSERT INTO public.messages(
	conteudo, data_envio, matricula_destino, motivo)
	VALUES ( 'Mensagem de teste', current_date, '121750', 'Ganho');