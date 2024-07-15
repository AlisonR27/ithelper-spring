-- -- Inserção de dados nas tabelas
-- INSERT INTO departamento (nomedepartamento) VALUES
--                                                 ('Recursos Humanos'),
--                                                 ('Tecnologia da Informação'),
--                                                 ('Financeiro'),
--                                                 ('Marketing');
--
-- INSERT INTO usuario (datanascimento, email, nomecompleto, nomeusuario, senhausuario, tipousuario) VALUES
--                                                                                                       ('1985-05-15', 'ana.silva@example.com', 'Ana Silva', 'asilva', '$2a$10$9j0pRHT8I2/UbxxzSp8uKOIEMv0XVi1ipew29G5vb5A8lZHRKlakG', 'A'),
--                                                                                                       ('1990-08-22', 'bruno.souza@example.com', 'Bruno Souza', 'bsouza', '$2a$10$9j0pRHT8I2/UbxxzSp8uKOIEMv0XVi1ipew29G5vb5A8lZHRKlakG', 'U'),
--                                                                                                       ('1988-11-03', 'carla.moraes@example.com', 'Carla Moraes', 'cmoraes', '$2a$10$9j0pRHT8I2/UbxxzSp8uKOIEMv0XVi1ipew29G5vb5A8lZHRKlakG', 'U');
--
-- INSERT INTO endereco (bairro, logradouro, municipio, uf, idusuario) VALUES
--                                                                         ('Centro', 'Rua A', 'Cidade A', 'SP', 1),
--                                                                         ('Jardim', 'Rua B', 'Cidade B', 'RJ', 2),
--                                                                         ('Alto', 'Rua C', 'Cidade C', 'MG', 3);
--
-- INSERT INTO funcionario (cargofuncionario, iddepartamento, idusuario) VALUES
--                                                                           ('Gerente de RH', 1, 1),
--                                                                           ('Analista de TI', 2, 2),
--                                                                           ('Contador', 3, 3);
--
-- INSERT INTO chamado (datahoraabertura, datahorafechamento, descricaochamado, prioridade, statuschamado, titulochamado, idfuncionario) VALUES
--                                                                                                                                           ('2024-06-01 10:00:00', '2024-06-01 12:00:00', 'Problema no sistema', 'A', 'F', 'Erro no sistema', 2),
--                                                                                                                                           ('2024-06-02 09:30:00', '2024-06-02 11:45:00', 'Impressora não funciona', 'B', 'F', 'Problema na impressora', 3);
--
-- INSERT INTO telefone (numerotelefone, tipotelefone, idusuario) VALUES
--                                                                    ('111111111', 'Celular', 1),
--                                                                    ('222222222', 'Residencial', 2),
--                                                                    ('333333333', 'Comercial', 3);
--
-- INSERT INTO equipamento (localequipamento, modeloequipamento, patrimonio, tipoequipamento, idchamado) VALUES
--                                                                                                           ('Sala 1', 'Dell XPS', '12345', 'Computador', 1),
--                                                                                                           ('Sala 2', 'HP LaserJet', '67890', 'Impressora', 2);
--
-- INSERT INTO tecnico (idfuncionario) VALUES
--                                         (2),
--                                         (3);
--
-- INSERT INTO atribuicao_chamado (datahoraatribuicao, idchamado, idtecnico) VALUES
--                                                                               ('2024-06-01 10:30:00', 1, 1),
--                                                                               ('2024-06-02 10:00:00', 2, 2);
--
-- INSERT INTO acao (datahoraacao, descricaoacao, idatribuicao_chamado) VALUES
--                                                                          ('2024-06-01 10:45:00', 'Verificação inicial', 1),
--                                                                          ('2024-06-01 11:15:00', 'Correção do erro', 1),
--                                                                          ('2024-06-02 10:15:00', 'Verificação da impressora', 2),
--                                                                          ('2024-06-02 11:00:00', 'Substituição de peça', 2);