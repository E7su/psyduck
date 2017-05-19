```
./bin/kafka-console-consumer.sh  --zookeeper localhost:2181 --topic fast-messages 
```

```
cat /tmp/2 | kafkacat -P -b localhost:9092 -t test_test
./bin/kafka-console-consumer.sh  --zookeeper localhost:2181 --topic test_test
```
