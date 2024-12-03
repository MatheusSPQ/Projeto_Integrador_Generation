# 📂 Sistema de Gestão de Recursos Humanos (SGRH)

O *Sistema de Gestão de Recursos Humanos (SGRH)* é uma solução projetada para otimizar o gerenciamento de dados de funcionários, permitindo operações de **CRUD** e consultas específicas por CPF. 🚀

---

## 📝 **Descrição Geral**

O SGRH automatiza e controla as informações dos colaboradores, facilitando tarefas comuns do setor de RH.  
Desenvolvido em **Java**, com **Spring Boot** e banco de dados **MySQL**, o sistema oferece uma API eficiente para integrações futuras.  

---

## 🛠️ **Funcionalidades Principais**

1. **Cadastro de Funcionários (Create)** ✍️  
   - Insira novos registros, validando o CPF único.  

2. **Leitura de Dados (Read)** 📄  
   - Exiba dados gerais ou específicos de funcionários.  

3. **Atualização de Dados (Update)** 🔄  
   - Atualize informações como cargo, telefone e e-mail.  

4. **Exclusão de Funcionários (Delete)** ❌  
   - Remova registros utilizando o ID.  

5. **Pesquisa por CPF** 🔍  
   - Consulte informações detalhadas de um funcionário com base no CPF.  

---

## 🗂️ **Modelo de Dados**

### **Entidade: `Funcionario`**
| **Atributo**         | **Tipo**    | **Descrição**                       |
|-----------------------|-------------|-------------------------------------|
| `id`                 | `int`       | Identificador único do funcionário. |
| `nome`               | `String`    | Nome completo.                      |
| `cpf`                | `String`    | CPF único.                          |
| `dataNascimento`     | `Date`      | Data de nascimento.                 |
| `telefone`           | `String`    | Número de telefone.                 |
| `email`              | `String`    | Endereço de e-mail.                 |
| `cargo`              | `String`    | Cargo na empresa.                   |
| `dataAdmissao`       | `Date`      | Data de admissão.                   |

---

## 🔧 **Tecnologias Utilizadas**

- **Java** ☕: Backend robusto e confiável.  
- **Spring Boot** ⚙️: Framework para rápida criação de aplicações web.  
- **Spring Data JPA** 🛢️: Interação com MySQL através de ORM.  
- **MySQL** 🗄️: Banco de dados relacional para armazenamento seguro.  
- **Insomnia** 🧪: Testes e validações das APIs RESTful.  

---

## 📊 **Diagrama de Entidade-Relacionamento (ER)**

```plaintext
Funcionario
|-- id (PK)
|-- nome
|-- cpf (unique)
|-- dataNascimento
|-- telefone
|-- email
|-- cargo
|-- dataAdmissao
```
## 📷 ** Imagens

- ![image](https://github.com/user-attachments/assets/e175b8b9-9250-468b-86ce-3457379b2935)
- ![image](https://github.com/user-attachments/assets/4ccaac45-ead7-4a92-a6ee-aa202f2a6cf1)
- ![image](https://github.com/user-attachments/assets/6542f460-ded0-47cd-aeb1-8b945fe2812c)
- ![image](https://github.com/user-attachments/assets/4df906f4-16a2-4098-9272-433a506a8ec1)
- ![image](https://github.com/user-attachments/assets/78713571-b2d0-43a4-8582-59c32a0cef0e)
- ![image](https://github.com/user-attachments/assets/58503916-f225-4e68-9717-dba1ebb9555c)
- ![image](https://github.com/user-attachments/assets/00befffb-9310-4619-876e-c99f08f477b1)








