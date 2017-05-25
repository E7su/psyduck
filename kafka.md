

``` 
                          88                        ad88  88                     
                          88                       d8"    88                     
                          88                       88     88                     
                          88   ,d8   ,adPPYYba,  MM88MMM  88   ,d8   ,adPPYYba,  
                          88 ,a8"    ""     `Y8    88     88 ,a8"    ""     `Y8  
                          8888[      ,adPPPPP88    88     8888[      ,adPPPPP88  
                          88`"Yba,   88,    ,88    88     88`"Yba,   88,    ,88  
                          88   `Y8a  `"8bbdP"Y8    88     88   `Y8a  `"8bbdP"Y8  
```

## Install kafka
```
tar -xzf kafka_2.11-0.9.0.0.tgz
cd kafka_2.11-0.9.0.0
```

## Start a ZooKeeper server 
// Kafka has a single node Zookeeper configuration built-in

// To stop Zookeeper, you will need to bring it back to the foreground and use control-C or you will need to find the process and kill it
```
bin/zookeeper-server-start.sh config/zookeeper.properties &
```

## Run kafka
```
bin/kafka-server-start.sh config/server.properties
```

## Create the topics for the example programs
```
bin/kafka-topics.sh --create --zookeeper localhost:2181 \
       --replication-factor 1 --partitions 1 --topic fast-messages
       
bin/kafka-topics.sh --create --zookeeper localhost:2181 \ 
       --replication-factor 1 --partitions 1 --topic summary-markers
```

## These can be listed:
```
bin/kafka-topics.sh --list --zookeeper localhost:2181
```

## Compile and package up the example programs
```
git clone https://github.com/mapr-demos/kafka-sample-programs.git 
cd kafka-sample-programs/
mvn clean package
```

## Run the example producer
```
kafka-sample-programs/target/kafka-example producer
```

## Start the example consumer
```
kafka-sample-programs/target/kafka-example consumer
```

## Read consumer's messages
```
./bin/kafka-console-consumer.sh  --zookeeper localhost:2181 --topic fast-messages 
```

## Create producer from file and test it in consumer
```
cat /tmp/2 | kafkacat -P -b localhost:9092 -t test_test

./bin/kafka-console-consumer.sh  --zookeeper localhost:2181 --topic test_test
```

## Test
```
./bin/kafka-console-producer.sh  --broker-list 127.0.0.1:9092 --topic fast-messages
```
