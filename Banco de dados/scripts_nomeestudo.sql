-- MySQL Script generated by MySQL Workbench
-- Tue May  7 07:46:03 2024
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering
-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
DROP DATABASE IF EXISTS mercado;

CREATE DATABASE IF NOT EXISTS mercado;

USE mercado;

-- -----------------------------------------------------
-- Table funcionarios
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS funcionarios (
  id_funcionario INT  primary key auto_increment,
  tipo_funcionario VARCHAR(45) NOT NULL,
  login VARCHAR(45) NOT NULL,
  senha VARCHAR(45) NOT NULL,
  NomeFuncionario Varchar(45) not null,
  SobreNome Varchar(45) not null,
  Telefone Varchar(45) not null,
  Salario Varchar(45) not null,
  Endereco Varchar(45) not null
);

-- -----------------------------------------------------
-- Table clientes
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS clientes (
  id_cliente INT  primary key auto_increment,
  nome VARCHAR(45) NOT NULL,
  sobrenome VARCHAR(45) NOT NULL,
  cpf_cliente VARCHAR(45) NOT NULL
);

-- -----------------------------------------------------
-- Table vendas
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS vendas (
  id_venda INT  primary key auto_increment,
  funcionario_id_funcionario INT NOT NULL,
  cliente_id_cliente INT NOT NULL,
  FOREIGN KEY (funcionario_id_funcionario) REFERENCES funcionarios (id_funcionario),
  FOREIGN KEY (cliente_id_cliente) REFERENCES clientes (id_cliente)
);

-- -----------------------------------------------------
-- Table creditos
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS creditos (
  id_credito INT primary key auto_increment,
  num_total_parcelas INT NOT NULL,
  preco_parcela INT NOT NULL,
  vendas_Id_venda INT NOT NULL,
  limite_divida DOUBLE NOT NULL,
  qtd_parcelas_pagas INT NULL,
  FOREIGN KEY (vendas_Id_venda) REFERENCES vendas (id_venda)
);

-- -----------------------------------------------------
-- Table produtos
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS produtos (
  id_produto INT  primary key auto_increment,
  produto VARCHAR(45) NOT NULL,
  tipo_produto VARCHAR(45) NOT NULL,
  data_chegada VARCHAR(45) NOT NULL,
  validade_produto VARCHAR(45) NULL,
  preco DOUBLE NOT NULL,
  qntd INT NOT NULL
);

-- -----------------------------------------------------
-- Table carrinho
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS carrinho (
  id_venda INT NULL,
  produtos_Id_produto INT NOT NULL,
  quantidade VARCHAR(45) NULL,
  FOREIGN KEY (id_venda) REFERENCES vendas (id_venda),
  FOREIGN KEY (produtos_Id_produto) REFERENCES produtos (id_produto)
);
