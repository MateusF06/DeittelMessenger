# ATIVIDADE – DEITELMESSENGER E BUFFER SEGURO

## Produtor-consumidor:
  cd ProdutorConsumidor/ch05
  javac *.java
  java SharedBufferTest
  java SynchronizedBufferTest

## DeitelMessenger:
  cd DeitelMessenger_original/DeitelMessager/src
  javac -d ../bin $(find . -name '*.java')
  java -cp ../bin com.deitel.messenger.sockets.server.DeitelMessengerServerTest
  Em outro terminal, com ambiente gráfico:
  java -cp ../bin com.deitel.messenger.sockets.client.DeitelMessenger

### O servidor usa TCP na porta 12345 e multicast UDP 239.0.0.1:5555 (envio 5554).
