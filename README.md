# Stationery System
Caso queira contribuir com novas funcionalidades, melhorias e/ou correções no projeto, siga os passos do arquivo [CONTRIBUTING.md](./.github/doc/CONTRIBUTING.md).

## :wrench: Ambiente de Desenvolvimento
Para que todos tenham o ambiente de desenvolvimento o mais parecido possível e evitar problemas, certifique-se de ter as ferramentas acima com as seguintes versões:

| Ferramenta | Versão |
| --- | --- |
| Git | A mais recente |
| IntelliJ IDEA | 2022.3.1 |
| OpenJDK | 11.0.17 |
| MYSQL | 8.0.31 |

## :compass: Guia de Instalação
> Com as ferramentas devidamente instaladas, execute os comandos abaixo

### **1. Clonar repositório**
```bash
git clone https://github.com/dhianapereira/stationery-system.git
```

### **2. Entrar na pasta do projeto**
```bash
cd stationery-system
```

### **3. Criar arquivo de variáveis de ambiente**
Crie uma cópia do arquivo [`.env.example`](./.env.example) na raiz do projeto com o nome `.env` e preencha com os devidos valores.

### **4. Criar banco de dados**
Crie o banco de dados a partir do script [`database.sql`](./database.sql).

E pronto! Você já pode rodar o projeto clicando em F5 ou no botão `run` da sua IDE. 

---
## Licença
stationery-system está sobre a licença [MIT](LICENSE)