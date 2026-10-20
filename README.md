
# Desafio Reservas de Hotel - EBAC

Sistema de controle de reservas de hotel desenvolvido
em Java como atividade do curso Back-end Java da EBAC.

## Objetivo

Aplicar conceitos de Programação Orientada a Objetos,
vetores, estruturas condicionais, repetição e validação
de dados em um sistema de reservas via console.

## Funcionalidades

- Cadastrar novas reservas
- Listar reservas cadastradas
- Buscar reservas por parte do nome do hóspede
- Ordenar reservas por dias de estadia (decrescente)
- Encerrar o sistema

## Regras de Negócio

- Capacidade máxima de 10 reservas
- Número mínimo de dias: 1
- Valor da diária maior que zero
- Busca sem diferenciar letras maiúsculas e minúsculas
- Cálculo automático do valor total da reserva

## Estrutura

- `src/Reserva.java`: classe de domínio
- `src/SistemaReservas.java`: menu e operações

## Conceitos Utilizados

- Classes e objetos
- Encapsulamento
- Getters e setters
- Construtor
- Palavra-chave this
- Sobrescrita de toString()
- Vetores de objetos
- Switch-case
- Laços for e do-while
- Bubble Sort
- Scanner
- Métodos auxiliares

## Tecnologias

- Java 17+
- IntelliJ IDEA
- Git e GitHub

## Como Executar

1. Abra o projeto no IntelliJ IDEA.
2. Execute `SistemaReservas.java`.
3. Utilize as opções do menu.
4. Cadastre, consulte e ordene reservas.
5. Selecione a opção 5 para encerrar.

Os dados são armazenados apenas em memória
e são perdidos quando o programa é encerrado.
