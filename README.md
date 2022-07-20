# Banco_Digital
PROJETO EM SPRINGBOOT, API  SEGUINDO O DESAFIO PROPOSTO PELA DIGITAL INNOVATION ONE DE ORIENTAÇÃO A OBJETOS.
-------------------------------------------------------------------------------------------------------------------------------------------------------
POSSUI DUAS ENTIDADES COM ALGUMAS ROTAS HTTP.

METODOS HTTP BANCO

GET(RETORNA UMA LISTA DOS BANCOS CADASTRADOS JUNTO COM OS SEUS CONTAS CADASTRADAS)
http://localhost:8080/banco/

POST(ADICIONA UM BANCO NO BANCO DE DADOS)
http://localhost:8080/banco/

METODOS HTTP CONTA

GET(RETORNA TODAS AS CONTAS CADASTRADAS)
http://localhost:8080/conta/

GET(BUSCA POR UMA CONTA ESPECÍFICA)
http://localhost:8080/conta/{id}

POST(CRIA UMA CONTA EM UM BANCO EXISTENTE)
http://localhost:8080/conta/{idBanco}

PUT(DEPOSITA UM VALOR NA CONTA)
http://localhost:8080/conta/{id}

PUT(SACA UM VALOR DA CONTA)
http://localhost:8080/conta/sacar/{id}
