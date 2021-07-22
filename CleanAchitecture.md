## 01. Arquitetura de Software

*Arquitetura:* 
- Componentes do software e suas relações
- Infraestrutura do software
- Estrutura e design do código
- Suporte ao requisitos de negocio
- Simplificar evolução no software
- Performance
- Escalabilidade
- Disponibilidade
- Confiabilidade
- Segurança
- Manutenibilidade
- Extensibilidade
- Outros requisitos não funcionais

O conceito de arquitetura de software é bastante subjetivo e existem inúmeras definições distintas sobre o tema na literatura.
Neste link você pode encontrar um compilado das principais definições sobre arquitetura de software: https://resources.sei.cmu.edu/library/asset-view.cfm?assetid=513807

Quais são as principais vantagens de utilizar o Clean Architecture como modelo de arquitetura em um projeto de software?
- Código mais fácil de manter.
  O Clean Architecture favorece a utilização de boas praticas de programação e de orientação a objetos, o que torna mais fácil a manutenção e evolução do software.

- Código mais fácil de testar.
  O Clean Architecture torna muito mais simples a escrita de testes automatizados.
  
Resumo:
- O que é arquitetura de software.
- Os principais modelos de arquitetura de software.
- O que é o Clean Architecture e quais são as suas vantagens.


## 02. Domain Model

Qual a diferença entre uma Entidade e um VO (Value Object)?
- Entidades possuem uma identidade única, enquanto VOs são considerados iguais, se todos os seus atributos tiverem valores iguais.
  Se dois e-mails possuem o mesmo endereço, podemos considerá-los como o mesmo e-mail. 
  Já duas pessoas com o nome, altura e idade não necessariamente são a mesma pessoa.

Value Objects:
Às vezes o conceito do que pode ser um Value Object acaba ficando meio nublado em nossos pensamentos e isso é perfeitamente normal.
O artigo a seguir deixa uma descrição interessante sobre o que é um Value Object e pode ser usado como referência sempre que você quiser rever esse assunto: https://martinfowler.com/bliki/ValueObject.html


A classe Telefone é um Value Object ou uma Entidade?
- Value Object, já que dois telefones com DDD e número iguais são considerados o mesmo telefone.
  Se a igualdade entre dois objetos de uma classe é verificada através da comparação de todos os seus valores, se trata de um Value Object.

*Fábricas*
É importante frisar que o que aqui é chamado de fábrica não é uma aplicação do Factory Method.
O que implementamos neste caso é semelhante ao padrão Builder.
Você pode aprender mais sobre design patterns neste outro curso aqui na Alura: https://cursos.alura.com.br/course/design-patterns

Resumo:
- O que são Entidades e Value Objects, no contexto do Clean Architecture.
- As diferenças entre Entidades e Value Objects.
- O conceito de fábrica, no contexto do Clean Architecture.


## 03. Camadas

Desde os cursos de orientação a objetos, nós já vimos como utilizar pacotes, mas agora eles estão sendo ainda mais úteis.  
Que vantagem ganhamos ao organizar nossa aplicação em pacotes?  
- Nossa arquitetura fica mais clara e, em um projeto grande, encontramos as classes mais facilmente.  
  Pacotes são uma ferramenta essencial para toda arquitetura.   
  No final do treinamento, teremos uma estrutura mais robusta de módulos, com a utilização dos pacotes.  

*Screaming Arch*  
Existe um conceito chamado Screaming Architecture.   
Em uma tradução livre, Arquitetura Gritante.  
Seguindo este princípio, fica fácil bater o olho na arquitetura de um projeto e saber do que se trata, facilitando até a entrada de novas pessoas no projeto: https://blog.cleancoder.com/uncle-bob/2011/09/30/Screaming-Architecture.html  

*Regra de dependência*  
Vimos que em vários padrões arquiteturais existem divisões em camadas.   
Esses modelos foram evoluindo, até que essas camadas foram divididas em mais interiores e mais exteriores.  
Qual a ordem em que as dependências deveriam acontecer nas camadas de um projeto?  
- Sempre para dentro (camadas de fora podem depender das de dentro)
  Assim, o nosso domínio (camada mais interna) é independente de qualquer detalhe exterior. 
  Nossa aplicação depende apenas do nosso domínio, e não conhece detalhes de infraestrutura. 
  A camada de infraestrutura apoia as camadas mais interiores.

*Domain Driven Design*
Ao desenvolver um sistema complexo, o domínio deve ser o foco. Por isso, ele é a camada central dos padrões de arquitetura.  
Web, frameworks e mecanismos de persistência (como bancos de dados) são meros detalhes. São ferramentas para executar suas regras de negócio.  
Executar a sua aplicação pela CLI deve ser tão fácil quanto através de uma API. O mesmo vale para uma interface Web.  
O conceito de modelarmos a nossa aplicação pensando primeiramente no domínio é chamado de Domain Driven Design, ou design orientado a domínio.   
Munidos desta mentalidade, podemos garantir uma melhor manutenibilidade e extensibilidade de nosso projeto.

Resumo:
- Que podemos utilizar pacotes do Java para separar a nossa aplicação em módulos que façam sentido.
- A aplicar conceitos de padrões arquiteturais ao separar nossa aplicação em camadas.
  Começamos pelo domínio.
  

## 04. Repositórios

*Repositórios em duas camadas*
Separamos o nosso repositório em duas camadas: interface no domínio e implementação na infraestrutura.
Que vantagem temos ao separar os repositórios nessas duas camadas?
- Isolamos o nosso domínio de detalhes de persistência.
  Ao deixarmos apenas a interface na camada de domínio, a camada de aplicação poderá depender dos nossos repositórios, mas deixando a implementação na camada de infraestrutura, o nosso domínio não precisa conhecer detalhes de infraestrutura.
  
Resumo:
- O conceito de repositórios.
- A motivação para separar os repositórios em mais de uma camada.
- Que é possível criar implementações que sejam mais fáceis de utilizar em nossos testes.


## 05. Services

Qual o objetivo da utilização de classes service?  
- Representar uma classe que executa alguma ação que não pertence a nenhuma entidade ou VO.   
  As nossas regras de negócio devem ficar nas entidades e VOs, mas nem sempre isso faz sentido.   
  Quando precisamos executar alguma ação que não faça parte de nenhuma entidade nem de um VO, podemos utilizar uma classe Service.  
  

*Aplicação*
O que entra na camada de aplicação pode ser um assunto polêmico.   
A interface de envio de e-mail que acabamos de criar poderia muito bem estar em nosso domínio, sem ferir nenhuma regra.

Resumo:
- O conceito de classes Services e mais especifico Domain, Application e Infrastructure Services
- Domain Services são classes que representam uma ação entre mais de uma entidade.
- Application Services controlam o fluxo de alguma regra em nossa aplicação.
- Infrastructure Services são implementações de interfaces presentes nas camadas de domínio ou de aplicação.





