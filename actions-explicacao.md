# Workflow vs Actions
Um workflow é um conjunto de configurações e ações organizadas de modo a permitir uma ou mais automações. Assim, a partir de gatilhos configurados pelo usuário, é possível disparar uma série de ações correlacionadas afim de automatizar processos e tarefas.

Uma action é uma parte desse conjunto de automações, geralmente responsável por uma única tarefa. É organizada em arquivos de tipo .yml e tem como característica ser reutilizada diversas vezes em um workflow. 

Portanto, podemos dizer que um workflow é todo um processo de automatização de um projeto, enquanto actions são partes desse todo que podem ser reutilizadas diversas vezes dentro do mesmo workflow.

# action.yml
Toda action possui sua configuração estabelecida em um arquivo .yml. Nele, são definidas as características da action referida, como nome, descrição, inputs que recebe e outputs que produz, além de detalhes relacionados à apresentação no GithubMarket e seu modo de funcionamento.

# Exemplo de action no arquivo ci.yml
Como exemplo de action utilizada no ci.yml, trago a actions/setup-java@v3. Ela é a responsável por fazer a preparação do ambiente para que seja possível executar o projeto em Java. Através do @, passo o parâmetro da versão que pretendo utilizar. No caso, @v3 significa: traga a action setup-java, na versão 3 com o patch mais atualizado possível.
Além disso, posso passar parâmetros através do uso da palavra with.
```
with:
    java-version: '21'
```
No exemplo acima, estou passando o parâmetro da versão do Java que será executado: 21.

