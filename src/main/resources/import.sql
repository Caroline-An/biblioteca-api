-- EDITORAS
INSERT INTO tbl_editoras (id, nome, cnpj, endereco, telefone, email) VALUES
(1, 'Editora Alfa', '12.345.678/0001-90', 'Rua das Letras, 123 - São Paulo/SP', '(11) 98765-4321', 'contato@editoralfa.com'),
(2, 'Editora Beta', '98.765.432/0001-12', 'Av. Cultura, 456 - Rio de Janeiro/RJ', '(21) 91234-5678', 'suporte@editorabeta.com'),
(3, 'Editora Gama', '11.222.333/0001-44', 'Praça do Saber, 789 - Belo Horizonte/MG', '(31) 99876-5432', 'info@editoragama.com'),
(4, 'Editora Delta', '55.666.777/0001-88', 'Rua do Conhecimento, 321 - Curitiba/PR', '(41) 98765-1234', 'contato@editoradelta.com'),
(5, 'Editora Épsilon', '22.333.444/0001-55', 'Av. Livros, 654 - Porto Alegre/RS', '(51) 91234-8765', 'atendimento@editoraepsilon.com');

-- CLIENTES
INSERT INTO tbl_clientes (id, nome, email, telefone, cpf) VALUES
(1, 'João Silva', 'joao.silva@email.com', '(11) 98765-4321', '123.456.789-00'),
(2, 'Maria Oliveira', 'maria.oliveira@email.com', '(21) 98765-4321', '987.654.321-00'),
(3, 'Pedro Santos', 'pedro.santos@email.com', '(31) 98765-4321', '456.789.123-00'),
(4, 'Ana Costa', 'ana.costa@email.com', '(41) 98765-4321', '789.123.456-00'),
(5, 'Carlos Pereira', 'carlos.pereira@email.com', '(51) 98765-4321', '321.654.987-00');

-- LIVROS
INSERT INTO tbl_livros
(id, ISBN, TITULO, NUMERO_DE_PAGINAS, ANO_DE_PUBLICACAO, CATEGORIA, EDITORA_ID)
VALUES
(1, '978-85-801-0001-1', 'Memórias Póstumas de Brás Cubas', 200, 1881, 'ROMANCE', 1),
(2, '978-85-801-0001-2', 'Dom Casmurro', 464, 1899, 'ROMANCE', 1),
(3, '978-85-801-0001-3', 'Memórias Póstumas de Brás Cubas', 304, 1881, 'ROMANCE', 2),
(4, '978-85-801-0001-4', 'O Guarani', 560, 1857, 'AVENTURA', 2),
(5, '978-85-801-0001-5', 'A Hora da Estrela', 88, 1977, 'ROMANCE', 3),
(6, '978-85-801-0001-6', 'Vidas Secas', 128, 1938, 'ROMANCE', 4),
(7, '978-85-801-0001-7', 'Gabriela, Cravo e Canela', 424, 1958, 'ROMANCE', 5),
(8, '978-85-801-0001-8', 'Sítio do Picapau Amarelo', 360, 1920, 'INFANTO_JUVENIL', 1),
(9, '978-85-801-0001-9', 'Alguma Poesia', 120, 1930, 'ARTE', 2),
(10, '978-85-801-0010-0', 'O Alquimista', 176, 1988, 'FICCAO', 3),
(11, '978-85-801-0011-1', 'Os Maias', 720, 1878, 'ROMANCE', 4),
(12, '978-85-801-0012-2', 'Mensagem', 104, 1934, 'ARTE', 5);

-- EMPRÉSTIMOS
INSERT INTO tbl_emprestimos
(id, livro_id, data_emprestimo, data_prevista_devolucao, devolvido)
VALUES
(1, 1, CURRENT_DATE - 10, CURRENT_DATE + 5, FALSE),
(2, 2, CURRENT_DATE - 5, CURRENT_DATE + 10, FALSE),
(3, 3, CURRENT_DATE - 20, CURRENT_DATE - 5, FALSE),
(4, 4, CURRENT_DATE - 2, CURRENT_DATE + 12, FALSE),
(5, 5, CURRENT_DATE - 15, CURRENT_DATE, FALSE),
(6, 6, CURRENT_DATE - 30, CURRENT_DATE - 15, TRUE),
(7, 7, CURRENT_DATE - 3, CURRENT_DATE + 11, FALSE),
(8, 8, CURRENT_DATE - 8, CURRENT_DATE + 7, FALSE),
(9, 9, CURRENT_DATE - 1, CURRENT_DATE + 14, FALSE),
(10, 10, CURRENT_DATE - 12, CURRENT_DATE + 2, TRUE);
