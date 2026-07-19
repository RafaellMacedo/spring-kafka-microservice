<div align="center">

# 🛒 Spring Kafka Microservices

Arquitetura de microserviços desenvolvida com **Spring Boot**, utilizando **Apache Kafka**, **OpenFeign**, **PostgreSQL**, **MinIO** e **JasperReports** para demonstrar comunicação síncrona e assíncrona entre serviços.

![Java](https://img.shields.io/badge/Java-21-orange)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-4.x-brightgreen)
![Kafka](https://img.shields.io/badge/Apache-Kafka-black)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-blue)
![Docker](https://img.shields.io/badge/Docker-blue)
![MinIO](https://img.shields.io/badge/MinIO-red)
![Maven](https://img.shields.io/badge/Maven-C71A36)
![License](https://img.shields.io/badge/license-MIT-green)

</div>

---

# 📖 Sobre o Projeto

Este projeto foi desenvolvido com o objetivo de demonstrar uma arquitetura moderna baseada em **Microserviços**, utilizando o ecossistema Spring.

A aplicação simula um fluxo de compras, onde diferentes serviços trabalham de forma independente, comunicando-se através de **REST** e **Apache Kafka**, permitindo baixo acoplamento e maior escalabilidade.

Além disso, o projeto demonstra:

- Comunicação síncrona utilizando OpenFeign;
- Comunicação assíncrona com Apache Kafka;
- Geração de documentos PDF utilizando JasperReports;
- Armazenamento de arquivos em buckets utilizando MinIO;
- Persistência em PostgreSQL;
- Containerização com Docker Compose.

---

# 🏗 Arquitetura

```text
                         Cliente

                            │
                            ▼

                   APIs REST (HTTP)

                            │

        ┌───────────────────┴────────────────────┐
        │                                        │

        ▼                                        ▼

+---------------------+                +----------------------+
| Pedido Service      |                | Cliente Service      |
+---------------------+                +----------------------+
        │
        │ OpenFeign
        ▼

+----------------------+
| Produto Service      |
+----------------------+

        │
        │ Publica Evento
        ▼

================= Apache Kafka =================

        │

        ▼

+----------------------+
| Faturamento Service  |
+----------------------+
        │
        │ JasperReports
        ▼

      Geração do PDF

        │

        ▼

     Bucket MinIO
```

---

# 🚀 Tecnologias Utilizadas

- Java 21
- Spring Boot
- Spring Data JPA
- Spring Kafka
- Spring Cloud OpenFeign
- PostgreSQL
- Apache Kafka
- Docker
- Docker Compose
- MinIO
- JasperReports
- Maven
- Lombok

---

# 📦 Microserviços

## 📋 Pedido

Responsável por:

- Cadastro de pedidos
- Processamento de pagamentos
- Publicação de eventos no Kafka
- Consulta de pedidos
- Comunicação com os serviços de Cliente e Produto

---

## 👤 Cliente

Responsável por:

- Cadastro de clientes
- Consulta de clientes

---

## 📦 Produto

Responsável por:

- Cadastro de produtos
- Consulta de produtos

---

## 🧾 Faturamento

Responsável por:

- Consumir eventos do Kafka
- Gerar documentos PDF
- Enviar arquivos para o MinIO
- Gerar URL pública dos arquivos

---

# 🔄 Fluxo da Aplicação

```text
Cliente cria um pedido

        │

        ▼

Pedido Service

        │

        ▼

Apache Kafka

        │

        ▼

Faturamento

        │

        ▼

Geração do PDF

        │

        ▼

Upload para o MinIO

        │

        ▼

URL pública do documento
```

---

# 📁 Estrutura do Projeto

```text
cliente/

produto/

pedido/

faturamento/

docker/

docs/

postman/
```

---

# ☁️ MinIO

O MinIO é utilizado como serviço de armazenamento de objetos (Object Storage).

Arquivos armazenados:

- Notas fiscais
- Faturas
- Relatórios
- Uploads realizados pelos usuários

---

# 📄 JasperReports

Responsável pela geração dinâmica dos documentos PDF.

Exemplos:

- Nota Fiscal
- Comprovante
- Relatórios

---

# 🐳 Executando o Projeto

## Clonar o repositório

```bash
git clone https://github.com/RafaellMacedo/spring-kafka-microservice.git
```

---

## Subir a infraestrutura

```bash
docker compose up -d
```

Serão iniciados:

- PostgreSQL
- Apache Kafka
- Zookeeper
- MinIO
- Kafka UI

---

## Executar os microserviços

```bash
mvn spring-boot:run
```

ou

```bash
./mvnw spring-boot:run
```

---

# 📬 Endpoints da API

## Pedido

| Método | Endpoint |
|---------|----------|
| POST | `/pedidos` |
| POST | `/pedidos/pagamentos` |
| POST | `/pedidos/callback-pagamentos` |
| GET | `/pedidos/{id}` |

---

## Cliente

| Método | Endpoint |
|---------|----------|
| POST | `/clientes` |
| GET | `/clientes/{id}` |

---

## Produto

| Método | Endpoint |
|---------|----------|
| GET | `/produtos/{id}` |

---

## Bucket (MinIO)

| Método | Endpoint |
|---------|----------|
| POST | `/bucket` |
| GET | `/bucket?fileName=arquivo.pdf` |

---

# 📮 Collection do Postman

O projeto possui uma collection do Postman com todos os endpoints necessários para testar os microserviços.

```
postman/
└── Springboot Microserviços.postman_collection.json
```

Ela contém exemplos de:

- Cadastro de Clientes
- Consulta de Clientes
- Consulta de Produtos
- Criação de Pedidos
- Processamento de Pagamentos
- Callback de Pagamento
- Upload de Arquivos
- Geração de URL dos arquivos

---

# 📬 Tópicos Kafka

Eventos publicados:

```
icompras.pedidos-pagos

icompras.pedidos-faturados

icompras.pedidos-enviados
```

---

# ✅ Funcionalidades

- Arquitetura baseada em Microserviços
- Comunicação REST
- Comunicação assíncrona com Kafka
- OpenFeign
- PostgreSQL
- Docker Compose
- Upload de Arquivos
- Armazenamento em Bucket (MinIO)
- Geração de PDFs com JasperReports
- Integração entre serviços
- APIs REST

---

# 🚀 Próximas Melhorias

- API Gateway
- Service Discovery (Eureka)
- Spring Cloud Config
- Resilience4J
- Spring Security + JWT
- Testcontainers
- Observabilidade com Prometheus e Grafana
- Logs centralizados (ELK)
- Kubernetes
- Pipeline CI/CD (GitHub Actions)

---

# 👨‍💻 Autor

**Rafael Macedo**

🔗 GitHub  
https://github.com/RafaellMacedo

🔗 LinkedIn  
https://linkedin.com/in/rafaelmacedo
