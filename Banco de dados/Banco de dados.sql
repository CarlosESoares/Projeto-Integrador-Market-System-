CREATE DATABASE `mercado` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE mercado;

-- 1. Criação da tabela `clientes`
CREATE TABLE `clientes` (
  `id_cliente` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `sobrenome` varchar(45) NOT NULL,
  `cpf_cliente` varchar(45) NOT NULL,
  `credito` double DEFAULT NULL,
  PRIMARY KEY (`id_cliente`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 2. Criação da tabela `funcionarios`
CREATE TABLE `funcionarios` (
  `id_funcionario` int NOT NULL AUTO_INCREMENT,
  `tipo_funcionario` varchar(45) NOT NULL,
  `login` varchar(45) NOT NULL,
  `senha` varchar(45) NOT NULL,
  `NomeFuncionario` varchar(45) NOT NULL,
  `SobreNome` varchar(45) NOT NULL,
  `Telefone` varchar(45) NOT NULL,
  `Salario` varchar(45) NOT NULL,
  `Endereco` varchar(45) NOT NULL,
  PRIMARY KEY (`id_funcionario`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 3. Criação da tabela `produtos`
CREATE TABLE `produtos` (
  `id_produto` int NOT NULL AUTO_INCREMENT,
  `produto` varchar(45) NOT NULL,
  `tipo_produto` varchar(45) NOT NULL,
  `data_chegada` varchar(45) NOT NULL,
  `validade_produto` varchar(45) DEFAULT NULL,
  `preco` double NOT NULL,
  `qntd` int NOT NULL,
  PRIMARY KEY (`id_produto`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 4. Criação da tabela `vendas` (depende de `funcionarios` e `clientes`)
CREATE TABLE `vendas` (
  `id_venda` int NOT NULL AUTO_INCREMENT,
  `funcionario_id_funcionario` int NOT NULL,
  `cliente_id_cliente` int NOT NULL,
  `total_compra` decimal(10,2) DEFAULT NULL,
  `metodo_pagamento` char(45) DEFAULT NULL,
  PRIMARY KEY (`id_venda`),
  KEY `funcionario_id_funcionario` (`funcionario_id_funcionario`),
  KEY `cliente_id_cliente` (`cliente_id_cliente`),
  CONSTRAINT `vendas_ibfk_1` FOREIGN KEY (`funcionario_id_funcionario`) REFERENCES `funcionarios` (`id_funcionario`),
  CONSTRAINT `vendas_ibfk_2` FOREIGN KEY (`cliente_id_cliente`) REFERENCES `clientes` (`id_cliente`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 5. Criação da tabela `carrinho` (depende de `vendas` e `produtos`)
CREATE TABLE `carrinho` (
  `id_venda` int DEFAULT NULL,
  `produtos_Id_produto` int NOT NULL,
  `quantidade` int DEFAULT NULL,
  `preco` double DEFAULT NULL,
  `carrinhocol` varchar(45) DEFAULT NULL,
  `tipo` varchar(45) DEFAULT NULL,
  `validade` varchar(45) DEFAULT NULL,
  `data_chegada` varchar(45) DEFAULT NULL,
  KEY `id_venda` (`id_venda`),
  KEY `produtos_Id_produto` (`produtos_Id_produto`),
  CONSTRAINT `carrinho_ibfk_1` FOREIGN KEY (`id_venda`) REFERENCES `vendas` (`id_venda`),
  CONSTRAINT `carrinho_ibfk_2` FOREIGN KEY (`produtos_Id_produto`) REFERENCES `produtos` (`id_produto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
