```
wget www.us.apache.org/dist/hadoop/common/hadoop-1.0.3/hadoop-1.0.3-bin.tar.gz
sudo aptitude update
/etc/init.d/hadoop-hdfs-namenode start
/etc/init.d/hadoop-hdfs-datanode status
less /var/log/hadoop-hdfs/hadoop-hdfs-namenode-skylake.log
mkdir -p $HADOOP_HOME/dfs/name
mkdir -p $HADOOP_HOME/dfs/name/data
vim /etc/hadoop/conf/hdfs-site.xml

/etc/init.d/hadoop-yarn-resourcemanager start
less /var/log/hadoop-yarn/yarn-yarn-resourcemanager-skylake.log 
vim /etc/hadoop/conf/yarn-site.xml 
```
