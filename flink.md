## Install Flink
```
wget http://apache-mirror.rbc.ru/pub/apache/flink/flink-1.2.0/flink-1.2.0-bin-hadoop26-scala_2.11.tgz
```

## Maven Dependencies
```
<dependency>
  <groupId>org.apache.flink</groupId>
  <artifactId>flink-java</artifactId>
  <version>1.2.1</version>
</dependency>
<dependency>
  <groupId>org.apache.flink</groupId>
  <artifactId>flink-streaming-java_2.10</artifactId>
  <version>1.2.1</version>
</dependency>
<dependency>
  <groupId>org.apache.flink</groupId>
  <artifactId>flink-clients_2.10</artifactId>
  <version>1.2.1</version>
</dependency>
```

## Create and start my package on Yarn cluster
```
mvn package

/home/temp/flink-1.2.0/bin/flink run --class Test2 --jobmanager yarn-cluster -yn 2 ./target/test-1.0-SNAPSHOT-jar-with-dependencies.jar
```
