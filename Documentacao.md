# Decisões arquiteturais e a estrutura do projeto

## Requisitos para rodar o projeto

  ### Setup de ambiente:
- [Docker](https://www.docker.com)
- [Eclipse IDE](https://spring.io/tools)
- [Intellij IDE](https://www.jetbrains.com/pt-br/idea/)

  ### Como rodar na minha máquina?
- inicie no terminal do git `git init`
- Clone o projeto `https://github.com/LucasTavara/Ecoplus.git`
- Visualize a branch que você está `main\develop`
- Atualize o local utilizando `git pull origin <nome da branch>`
- Pronto 🎉


  ## Estrutura do projeto

  ### Foi Desenvolvido o projeto no padrão MVC, explicação de cada pasta criada no back-end.
- `/com.app`: É onde está localizado o código fonte da nossa aplicação.
  
  - `/config`: Onde as configurações da  aplicação se encontra  
    - `ThymeleafConfig.java`: Configura o Thymeleaf como o motor de templates para a aplicação Spring.
    - `WebConfig.java`: Implementa a interface WebMvcConfigurer para configurar o comportamento do Spring MVC.
     
  - `/Controller`: Contem todas as classes controladoras da aplicação.
    - `/user`: Está localizado os controladores do usuário na aplicação.
      - `UserAuthController.java` : Este controller lida com a lógica de autenticação e registro, fornecendo uma interface REST para usuários interagirem com o sistema de autenticação da aplicação.
      - `UserController.java` : Este controller fornece uma interface completa para gerenciar usuários, permitindo a criação, leitura, atualização e exclusão de registros de usuários na aplicação.
         Ele segue as práticas comuns de APIs RESTful, com respostas apropriadas para cada ação executada.
    - `FormController.java` : Esse controlador fornece uma interface completa para gerenciar os formulários da aplicação, com respostas apropriadas para cada ação executada.
    - `GlobalExceptionHandler.java` : O objetivo principal dessa classe é capturar e manipular exceções específicas que ocorrem em qualquer lugar da aplicação, fornecendo respostas personalizadas e apropriadas para essas exceções.
    - `PageController.java` : Esse controlador ajuda a estruturar a lógica de apresentação da aplicação, separando a lógica de processamento de dados da lógica de apresentação e navegação.
  - `/dto` : É usado para transferir dados entre diferentes camadas de uma aplicação.
    - `/user` :  Pasta user tem relação com a user controller, está localizado dtos da entidade de usuario.
      - `UseAuthDto.java` : oferece uma forma "limpa" e eficiente de representar e ransferir dados relacionados à autenticação de usuários.
      - `UserDto.java` : Localizado os dados de transferencia de um usuario recebendo um construtor padrão do UserDto
    - `FormDto.java` : Localizado os dados de transferencia de um formulario recebendo um construtor padrão e convertendo entidade para objeto.
    -  `ResponseDto.java` : Localizado os dados de transferencia para autenticação do token.
  - `/entity`:  armazenado as entidades da API
    - `/user`: pasta da entidade e enumeração usuário da API
        - `User.java`: entidade de usuário, com getter e setter, construtores e relacionamento com banco de dados.
        - `UserRole.java`:  classe de Enumeração recebendo 'ADMIN' e 'USER' como parametros.
    - `Form.java`: Entidade do Formulário, recebendo getter e setter, construtores e relacionamento com banco de dados.
  - `/mapper`: Usado para transformar dados em diferentes representações.
     - `Usermapper.java`: realizar a conversão bidirecional entre duas representações de dados: a entidade User e o DTO UserDto.
  - `/repository` : abstrai os detalhes de como os dados são obtidos e manipulados.
      - `FormRepository.java`: é uma parte da camada de persistência da aplicação e é responsável por realizar operações de acesso a dados para a entidade Form.
      - `UserRepository.java`: é uma parte da camada de persistência da aplicação e é responsável por realizar operações de acesso a dados para a entidade User.
  - `/security`: Contém pasta de segurança do  projeto.
    - `SecurityConfiguration.java`: Contém a configuração de segurança da aplicação, aqui é onde são permitodos o acesso a determinados métodos e classes da  API.
    - `SecurityFilter.java`: Filtra as Funcionalidades da API
    -  `TokenService.java`: Contém os serviços para validar uma autenticação via token.
      
  - `/service`: Contém as camadas de serviço da aplicação.
      - `/exception`: Contém algumas exceções personalizadas.
          - `ObjectNotFoundException.java`: retorna um método padrão para exceção dos objetos.
          - `UserNotFoundException.java`: retorna um método padrão para exceção dos Usuarios.
      - `FormService.java`: Contém os serviços para os métodos de atualização, criação e listagem de um formulário.
      -  `ImageService.java`: Contém todos os serviços para os métodos de informação e atualização da imagem.
      -  `UserService.java`: Contém os serviços para os métodos de atualização, criação e listagem de um Usuário.
     
- `resources` Contém as informações sobre o Front End do projeto
  
