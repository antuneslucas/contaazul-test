Contaazul Java Developer Test (Solution)
=======================================
Test for [Contaazul](https://contaazul.com/)


This solution uses Java 8, Junit 4, Mockito 2 and Logback.

**Challenge**:

A team of robots must be placed by NASA to explore a terrain on Mars.
This terrain, which is rectangular, needs to be navigated by the robots in such a way that their coupled cameras can get a complete view of the region, sending those images back to Earth.

The position of each robot is represented by the combination of Cartesian coordinates (x, y) and a letter, which can represent one of four orientations: NORTH, SOUTH, EAST and WEST. To simplify navigation, the "Martian" region to be explored was subdivided into rectangular subregions.
A valid position of a robot would be (0, 0, N), which means that the robot is positioned in the lower left corner of the terrain, facing north.
To control each robot, NASA sends a simple string, which can contain the letters 'L', 'R' and 'M'. The letters 'L' and 'R' cause the robot to rotate on its own axis 90 degrees to the left or right, respectively, without moving from its current position. The letter 'M' causes the robot to move forward.
Assume that a robot moves to NORTH with respect to the y-axis. That is, a step for the NORTH of the position (x, y), is the position (x, y + 1)
Example: If the robot is in position (0, 0, N), the command "MML" will get it to the position (0, 2, W).

Write a program that allows NASA engineers to send commands to the Robot and know where it is. Engineers will run tests on your software to make sure it behaves as expected before sending the Robot to Mars.


**Challenge Requirements**:
- The terrain should be started with 5x5 positions;
- The robot starts at the coordinate (0, 0, N);
- It should be possible to send a command to the Robot that returns his final position;
- The Robot can not move outside the specified area;
- You should not save robot status for later reference;


**Some test scenarios**:
- Movement with right turns:
  - `curl -s --request POST http://localhost:8080/rest/mars/MMRMMRMM`
  - Expected output: (2, 0, S)
- Movement with left turn:
  - `curl -s --request POST http://localhost:8080/rest/mars/MML`
  - Expected output: (0, 2, W)
- Request with left movement sent again:
  - `curl -s --request POST http://localhost:8080/rest/mars/MML`
  - Expected output: (0, 2, W)
- Invalid command:
  - `curl -s --request POST http://localhost:8080/rest/mars/AAA`
  - Expected output: 400 Bad Request
- Invalid position:
  - `curl -s --request POST http://localhost:8080/rest/mars/MMMMMMMMMMMMMMMMMMMMMMMM`
  - Expected output: 400 Bad Request


**Technical requirements**:
- The challenge must be delivered written in Java;
- The project should be compiled using only Maven;
- Only the JEE and JUnit libraries should be used;
- The challenge will run on the latest version of Wildfly;
- The communication interface with the robot is REST;

=======================================

## Original version:

**O Problema**:

Um time de robôs devem ser colocados pela NASA para explorar um terreno em Marte.
Esse terreno, que é retangular, precisa ser navegado pelos robôs de tal forma que suas câmeras acopladas possam obter uma visão completa da região, enviando essas imagens novamente para a Terra.

A posição de cada robô é representada pela combinação de coordenadas cartesianas (x, y) e por uma letra, que pode representar uma das quatro orientações: NORTH, SOUTH, EAST e WEST. Para simplificar a navegação, a região “marciana” a ser explorada foi subdividia em sub-regiões retangulares.
Uma posição válida de um robô, seria (0, 0, N), que significa que o robô está posicionado no canto esquerdo inferior do terreno, voltado para o Norte.
Para controlar cada robô, a NASA envia uma string simples, que pode conter as letras ‘L’, ‘R’ e ‘M’. As letras ‘L’ e ‘R’ fazem o robô rotacionar em seu próprio eixo 90 graus para esquerda ou para direita, respectivamente, sem se mover da sua posição atual. A letra ‘M’ faz o robô deslocar-se uma posição para frente.
Assuma que um robô se movimenta para o NORTE em relação ao eixo y. Ou seja, um passo para o NORTE da posição (x,y), é a posição (x, y+1)
Exemplo: Se o robô está na posição (0,0,N), o comando "MML" fará ele chegar na posição (0,2,W)

Escreva um programa que permita aos engenheiros da NASA enviar comandos para o Robô e saber onde ele se encontra. Os engenheiros irão rodar testes no seu software para garantir que ele se comporta da forma esperada, antes de enviar o Robô para marte.

**Requisitos do desafio**:

- O terreno deverá ser iniciado com 5x5 posições;
- O robô inicia na coordenada (0,0,N);
- Deverá ser possível enviar um comando para o Robô que me retorne a posição final dele;
- O Robô não pode se movimentar para fora da área especificada;
- Não deve guardar estado do robô para consulta posterior;

**Alguns cenários de teste**:
- Movimento com rotações para direita:
  - `curl -s --request POST http://localhost:8080/rest/mars/MMRMMRMM`
  - Saída esperada: (2, 0, S)
- Movimento para esquerda:
  - `curl -s --request POST http://localhost:8080/rest/mars/MML`
  - Saída esperada: (0, 2, W)
- Repetição da requisição com movimento para esquerda:
  - `curl -s --request POST http://localhost:8080/rest/mars/MML`
  - Saída esperada: (0, 2, W)
- Comando inválido:
  - `curl -s --request POST http://localhost:8080/rest/mars/AAA`
  - Saída esperada: 400 Bad Request
- Posição inválida:
  - `curl -s --request POST http://localhost:8080/rest/mars/MMMMMMMMMMMMMMMMMMMMMMMM`
  - Saída esperada: 400 Bad Request

**Requisitos técnicos**:
- O desafio deve ser entregue escrito em Java;
- O projeto deverá ser compilado utilizando somente o Maven;
- Deverão ser utilizadas apenas as biblioteca do JEE e JUnit;
- O desafio será executado na última versão do Wildfly;
- A interface de comunicação com o robô é REST;
