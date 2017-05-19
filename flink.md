```
wget http://apache-mirror.rbc.ru/pub/apache/flink/flink-1.2.0/flink-1.2.0-bin-hadoop26-scala_2.11.tgz
```

```
mvn package
/home/temp/flink-1.2.0/bin/flink run --class Test2 --jobmanager yarn-cluster -yn 2 ./target/test-1.0-SNAPSHOT-jar-with-dependencies.jar
```
