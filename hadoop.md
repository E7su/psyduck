```  
            __     __ 
           /  \~~~/  \
     ,----(     ..    )         
    /      \__     __/___  /_______ ______  /___________________ 
   /|         (\  |(  __  __ \  __ `/  __  /_  __ \  __ \__  __ \
  ^ \   /___\  /\ |   _  / / / /_/ // /_/ / / /_/ / /_/ /_  /_/ /
     |__|   |__|-"    /_/ /_/\__,_/ \__,_/  \____/\____/_  .___/ 
                                                        /_/                             
    

                                                      __     __ 
                                                     /  \~~~/  \
                                               ,----(     ..    ) __              __                
                                              /      \__     __/ / /_  ____ _____/ /___  ____  ____ 
                                             /|         (\  |(  / __ \/ __ `/ __  / __ \/ __ \/ __ \
                                            ^ \   /___\  /\ |  / / / / /_/ / /_/ / /_/ / /_/ / /_/ /
                                               |__|   |__|-"  /_/ /_/\__,_/\__,_/\____/\____/ .___/ 
                                                                                           /_/      

```

## Install Hadoop Pseudo
```
sudo apt-get update
sudo apt-get install lxc lxc-templates systemd-services cgroup-bin   bridge-utils debootstrap
vim /etc/apt/sources.list.d/cloudera.list 
sudo apt-get update
aptitude search pseudo
apt-cache policy hadoop-conf-pseudo
aptitude purge hadoop-conf-pseudo
aptitude install hadoop-conf-pseudo
```

## Start all
```
/etc/init.d/hadoop-hdfs-namenode start
/etc/init.d/hadoop-hdfs-secondarynamenode start
/etc/init.d/hadoop-hdfs-datanode start
/etc/init.d/hadoop-yarn-resourcemanager start
less /var/log/hadoop-yarn/yarn-yarn-resourcemanager-skylake.log 
```

## Install Java
```
aptitude search java | grep 7
sudo add-apt-repository ppa:webupd8team/java
aptitude update
aptitude search oracle
aptitude install oracle-java8-installer oracle-java7-installer

ls -la /usr/bin/java
ls -la /etc/alternatives/java
ls -la /usr/lib/jvm/
java -version
```

## Start namenode
```
wget www.us.apache.org/dist/hadoop/common/hadoop-1.0.3/hadoop-1.0.3-bin.tar.gz
sudo aptitude update
/etc/init.d/hadoop-hdfs-namenode start
/etc/init.d/hadoop-hdfs-datanode status
less /var/log/hadoop-hdfs/hadoop-hdfs-namenode-skylake.log
mkdir -p $HADOOP_HOME/dfs/name/data
vim /etc/hadoop/conf/hdfs-site.xml
```

## Start Yarn's resourcemanager
```
/etc/init.d/hadoop-yarn-resourcemanager start
/etc/init.d/hadoop-yarn-resourcemanager status
less /var/log/hadoop-yarn/yarn-yarn-resourcemanager-skylake.log 
vim /etc/hadoop/conf/yarn-site.xml 
```

## Start Flink's application on Yarn
```
export HADOOP_CONF_DIR=/etc/hadoop/conf

mvn package && /home/temp/flink-1.2.0/bin/flink run --class TestRecordsCounter --classpath file:///home/temp/flink-1.2.0/lib/ --jobmanager yarn-cluster -yn 2 ./target/test-1.0-SNAPSHOT-jar-with-dependencies.jar
```

## Tmp
```
ip a
ls -la /var/lib/hadoop-hdfs/cache/hdfs/dfs/name/in_use.lock
netstat -tlnp | grep 80
echo $?
ps fax | grep 24659
telnet localhost 9092

cd /etc/hadoop/conf
grep -r yarn.nodemanager.local-dir ./
vim ./yarn-site.xml 
ls -la /var/lib/hadoop-yarn/cache/yarn/nm-local-dir/

sudo -u hdfs hadoop fs -mkdir -p /var/log/hadoop-yarn
sudo -u hdfs hadoop fs -chown yarn:mapred /var/log/hadoop-yarn
hostname -f
export YARN_RESOURCEMANAGER_OPTS="-Xmx64m"

vim /etc/hadoop/conf/hadoop-env.sh 
vim ./yarn-env.sh
vim ./log4j.properties 
vim /usr/lib/hadoop-yarn/sbin/yarn-daemon.sh
vim /etc/init.d/

java -version
dpkg -l
```

## Kill Yarn application
```
yarn application --kill application_1495181670677_0002
```

## Java update alternatives
```
ps fax | grep java
/usr/lib/jvm/default-java/bin/java
/usr/lib/jvm/default-java/bin/java -version
update-alternatives 
update-alternatives --list lava
update-alternatives --set java /usr/lib/jvm/java-8-oracle/jre/bin/java
```
