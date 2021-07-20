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

