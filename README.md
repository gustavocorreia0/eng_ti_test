# Transação Financeira

Projeto desenvolvido como solução para um desafio de refatoração e correção de código legado de transações financeiras.

A proposta original continha uma implementação em C# com problemas de tipagem, organização, concorrência, atualização de saldo e formatação de saída. A solução foi reestruturada em Java, utilizando orientação a objetos, separação de responsabilidades e armazenamento de dados em memória.

---

## Objetivo

Refatorar o código original mantendo as funcionalidades e saídas esperadas, corrigindo os erros existentes e aplicando boas práticas de desenvolvimento.

O sistema processa uma lista de transações financeiras entre contas, validando saldo disponível e atualizando os saldos das contas envolvidas.

---

## Tecnologias utilizadas

- Java 21
- Orientação a Objetos
- Armazenamento em memória
- Streams
- Testes unitários
- `String` para colunas primárias
- `BigDecimal` para valores monetários
- `LocalDateTime` para datas e horários

---

## Principais melhorias aplicadas

- Separação de responsabilidades entre domínio, serviço e repositório.
- Processamento das transações em ordem cronológica.
- Validação de saldo antes da transferência.
- Atualização dos saldos em memória.
- Correção da lógica de impressão dos resultados.
- Remoção de herança desnecessária entre serviço e acesso a dados.
- Código mais legível, testável e de fácil manutenção.

---