CREATE TABLE IF NOT EXISTS categorias (
  id SERIAL NOT NULL UNIQUE,
  nome TEXT NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS usuarios (
  cpf VARCHAR(15) NOT NULL UNIQUE,
  nome VARCHAR(255) NOT NULL,
  senha VARCHAR(255) NOT NULL,
  permissao BOOLEAN NOT NULL,
  endereco TEXT NULL,
  cep VARCHAR(9) NULL,
  PRIMARY KEY (cpf)
);
  INSERT INTO usuarios (cpf, nome, senha, permissao, endereco, cep) VALUES ('12345678900', 'admin', 'admin', true, NULL, NULL);

CREATE TABLE IF NOT EXISTS produtos (
  id SERIAL NOT NULL UNIQUE,
  nome TEXT NOT NULL,
  descricao TEXT NOT NULL,
  preco DECIMAL(10,2) NOT NULL,
  categoria_id INTEGER NOT NULL,
  quantidade INTEGER NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (id) REFERENCES categorias(id)
);

CREATE TABLE IF NOT EXISTS pedidos (
  id SERIAL NOT NULL UNIQUE,
  cpf_usuario VARCHAR(15) NULL,
  produtos TEXT NOT NULL,
  entregaId INTEGER NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (cpf_usuario) REFERENCES usuarios(cpf),
  FOREIGN KEY (entregaId) REFERENCES entregas(id)
);

CREATE TABLE IF NOT EXISTS entregas (
  id SERIAL NOT NULL UNIQUE, 
  cliente_cpf VARCHAR(15) NOT NULL, 
  valorFrete DECIMAL(10,2) NOT NULL,
  statusPedido VARCHAR(20) NOT NULL,
  idPedido INTEGER NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (cliente_cpf) REFERENCES usuarios(cpf)
); 


