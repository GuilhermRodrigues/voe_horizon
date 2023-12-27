# Documentação das Escolhas do Projeto

## Introdução
Para atender aos requisitos do projeto, foi necessário adotar algumas soluções tanto para a modelagem dos dados quanto para popular as bases. Neste arquivo, explico um pouco sobre essas escolhas.

## Modelagem de Dados
Inicialmente, criei um arquivo .drawio para modelar o banco e ganhar tempo no desenvolvimento. No entanto, devido ao curto período disponível, não foi possível utilizá-lo. Mesmo assim, gerei um PNG e um arquivo .erd com a modelagem extraída da ferramenta DBeaver.

## Popular a Base

- **Estados**
    - Para popular os estados, utilizei a API do IBGE, que disponibiliza essas informações. Para entender melhor como funciona, acesse: [Documentação da API de Estados do IBGE](https://servicodados.ibge.gov.br/api/docs/localidades#api-UFs-estadosGet).

- **Aeroportos**
    - Para persistir os aeroportos do Brasil, utilizei o serviço chamado API-Redemet, oferecido pelo Departamento de Controle do Espaço Aéreo. Esse serviço permite coletar dados de aeroportos por país. Disponível em: [API-Redemet para Aeródromos](https://ajuda.decea.mil.br/base-de-conhecimento/api-redemet-aerodromos/).
    - A partir desse serviço, comecei a popular os aeroportos do Brasil e também as cidades, pois precisava encontrar uma forma de relacionar os aeroportos com as cidades e as cidades com os estados. Seguindo a estrutura do JSON que eles retornam, desenvolvi uma solução que atendesse às necessidades do momento.

  ```json
  {
    "status": true,
    "message": "",
    "data": [
        {
            "id": 3226,
            "cod": "SBAA",
            "nome": "Aeroporto de Conceição do Araguaia",
            "cidade": "Conceição do Araguaia/PA",
            "pais": "BRASIL",
            ...
        }
    ]
  }
  
## Fluxo da API
Ao final do campo cidade, é possível observar que ele retorna a UF. Para fazer uma relação com os estados já armazenados no banco, busquei pela UF e, caso encontrasse, fazia uma associação da cidade com o estado. Embora acredite que existam soluções melhores, fiquei limitado às APIs públicas, o que dificultou um pouco o trabalho.