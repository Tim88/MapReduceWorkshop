# MapReduceWorkshop R wordcount

https://coderwall.com/p/imxf6g/running-wordcount-on-hadoop-using-r-script

Zorg voor input-bestanden en kopieer ze naar hdfs
zorg dat de mapper en reducer executie-rechten hebben
bin/hadoop dfs -copyFromLocal <input-bestandendir> /user/<gebruiker>/<input-bestandendir>

check met 



bin/hadoop dfs -ls


make sure Hadoop is running, type jps on terminal
should give running processes as --> DataNode, NameNode, JobTracker, TaskTracker,SecondaryNameNode
R must be in path ,run


echo "foo foo quux labs foo bar quux" | Rscript mapper.R 


bin/hadoop dfs -copyFromLocal '/home/trendwise/apache/hadoop-1.0.4/README.txt'  /readme
bin/hadoop dfs -ls /

run job

bin/hadoop jar /home/trendwise/apache/hadoop-1.0.4/contrib/streaming/hadoop-streaming-1.0.4.jar \
-file  /home/trendwise/Desktop/Learn/RHadoop/mapper.R  -mapper /home/trendwise/Desktop/Learn/RHadoop/mapper.R \
-file /home/trendwise/Desktop/Learn/RHadoop/reducer.R  -reducer /home/trendwise/Desktop/Learn/RHadoop/reducer.R \
-input /readme -output /RCount
