Um projeto simples de CRUD em java 21 para apenas colocar em pratica o conceito de SOLID e Design pattern

Destaques de SOLID e Design Patterns

SRP → cada classe tem uma única responsabilidade
DIP → Controller e Service dependem de interfaces, não de classes concretas
Repository Pattern → abstrai o acesso ao banco
DTO + Mapper → isola a Entity da API
Injeção por construtor → melhor prática de DI

Arquitetura em Camadas:

1. Domain (Entity)           ← o que é salvo no banco
2. Repository                ← como acessamos o banco
3. DTO                       ← o que entra e sai da API
4. Mapper                    ← converte Entity ↔ DTO
5. Service (interface + impl)← regras de negócio
6. Controller                ← recebe HTTP
7. Exception Handler         ← tratamento de erros


A camada de serviço não precisa saber como o banco funciona
Você depende de uma abstração (a interface), não de uma implementação concreta
Isso aplica o princípio DIP (Dependency Inversion) do SOLID

Por que usamos DTOs e não a Entity diretamente?

Por que record?

Disponível desde o Java 16 (estamos no 21)
Imutável por padrão
Já gera automaticamente: construtor, getters, equals, hashCode e toString
Muito menos código

O que o Mapper faz?

toEntity()No CREATE → transforma o que o cliente enviou em Entity
toResponseDTO() Em todas as respostas → transforma Entity no que devolvemos
updateEntityFromDTO() - o UPDATE → atualiza os campos da Entity existente

Service
Aqui aplicamos fortemente o SOLID.
Vamos criar dois arquivos:

A interface → contrato (abstração)
A implementação → lógica de negócio

Design Patterns

Dependency Injection (via construtor)
Repository Pattern (usa o repository)
Mapper Pattern (usa o mapper)
Centralized Exception Handling — os Controllers ficam limpos, sem try/catch.

Como SOLID foi aplicado

S - Single ResponsibilityTodas as classesCada uma tem uma responsabilidade: Controller só HTTP, Service só negócio, Mapper só conversão, Repository só acesso a dados
O - Open/ClosedProductService (interface)Podemos criar outra implementação sem alterar o Controller
L - Liskov SubstitutionProductServiceImplQualquer classe que implemente ProductService pode substituir a atual sem quebrar o sistema
I - Interface SegregationProductServiceInterface pequena e coesa (só métodos de produto)
D - Dependency InversionController e ServiceDependem de abstrações (ProductService, ProductRepository), não de classes concretas

Design Patterns aplicados

Repository PatternProductRepository Abstrai o acesso ao banco
DTO PatternProductRequestDTO / ProductResponseDTOIsola a API da Entity
Mapper / AssemblerProductMapperConverte Entity ↔ DTO
Dependency InjectionService e ControllerInjeção via construtor
Centralized Exception HandlingGlobalExceptionHandlerTrata erros em um só lugar




















MotivoExplicaçãoSegurançaNão expõe a estrutura interna do bancoValidaçãoValida só o que entra na APIFlexibilidadePode mudar a Entity sem quebrar a APIControleVocê decide exatamente o que devolve pro cliente

