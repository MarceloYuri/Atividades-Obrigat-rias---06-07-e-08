-- Criação das tabelas no PostgreSQL
CREATE TABLE usuario (
    id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    tipo VARCHAR(20) NOT NULL CHECK (tipo IN ('aluno', 'professor')),
    limite_itens INT NOT NULL
);

CREATE TABLE item (
    id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    codigo VARCHAR(50) NOT NULL UNIQUE,
    titulo VARCHAR(150) NOT NULL,
    tipo VARCHAR(20) NOT NULL CHECK (tipo IN ('livro', 'revista')),
    autor VARCHAR(100),
    edicao INT,
    disponivel BOOLEAN NOT NULL DEFAULT TRUE
);

CREATE TABLE emprestimo (
    id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    item_id INT NOT NULL REFERENCES item(id),
    usuario_id INT NOT NULL REFERENCES usuario(id),
    data_retirada DATE NOT NULL,
    data_devolucao_prevista DATE NOT NULL,
    data_devolucao DATE,
    valor_multa NUMERIC(10,2) DEFAULT 0.00
);

-- Inserção de dados de teste (pelo menos 4 itens, 2 utilizadores e 2 empréstimos)
INSERT INTO usuario (nome, tipo, limite_itens) VALUES 
('Mariana Costa', 'aluno', 3),
('Roberto Dias', 'professor', 5);

INSERT INTO item (codigo, titulo, tipo, autor, edicao, disponivel) VALUES 
('L-100', 'Java: Como Programar', 'livro', 'Deitel', 10, FALSE),
('L-101', 'Banco de Dados', 'livro', 'Elmasri', 6, TRUE),
('R-200', 'Superinteressante', 'revista', 'Editora Abril', 450, FALSE),
('R-201', 'Galileu', 'revista', 'Editora Globo', 320, TRUE);

INSERT INTO emprestimo (item_id, usuario_id, data_retirada, data_devolucao_prevista, data_devolucao, valor_multa) 
VALUES (1, 1, '2026-11-01', '2026-11-15', NULL, 0.00);

INSERT INTO emprestimo (item_id, usuario_id, data_retirada, data_devolucao_prevista, data_devolucao, valor_multa) 
VALUES (3, 2, '2026-10-01', '2026-10-08', '2026-10-07', 1.50);