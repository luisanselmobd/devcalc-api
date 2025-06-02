# devcalc-api

## Objetivo do Projeto

Este projeto tem como objetivo colocar em prática os conhecimentos adquiridos ao longo do curso Pipelines de CI/CD e DevOps. Para isso, foi desenvolvido uma API REST em Java que será utilizada como meio de validação do funcionamento de pipelines automatizados com GitHub Actions. O pipeline inclui etapas de verificação de código, execução de testes automatizados, build, empacotamento e simulação de deploy.

## Ferramentas Utilizadas

- Java 21  
- Maven  
- Javalin (framework para construção da API REST)  
- GitHub Actions (para automação de pipelines CI/CD)

## Como Executar a API Localmente

Abra seu terminal ou prompt de comando e execute:

```bash
git clone https://github.com/luisanselmobd/devcalc-api.git
```

Com o repositório clonado, basta executar a partir de uma IDE ou com os seguintes comandos:

```bash
mvn clean compile
mvn exec:java -Dexec.mainClass="com.devcalc.Main"
```

## Correção de erro

No console foi impressa a seguinte mensagem: 

Run eko "Pipeline iniciado com sucesso"
/home/runner/work/_temp/ef380f97-ff15-406c-ab0f-3ee87c1869f5.sh: line 1: eko: command not found
Error: Process completed with exit code 127.

Então foi possível identificar que havia um erro no comando, possibilitando a correção.