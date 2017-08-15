# MapReduceWorkshop python wordcount

http://www.michael-noll.com/tutorials/writing-an-hadoop-mapreduce-program-in-python/

!!!!!!!!!!!!!!!!!
/usr/bin/hadoop jar /usr/hdp/2.6.0.3-8/hadoop-mapreduce/hadoop-streaming.jar -mapper /usr/lib/hue/mapper.py -reducer /usr/lib/hue/reducer.py -input /user/hue/Word_Count/input/* -output /user/hue/Word_Count/python_output3
!!!!!!!!!!!!!!!!!

!!!!!!!!!!!!!
let op line-endings waar je piemel microsoft van wordt
!!!!!!!!!!!!!

Zorg voor input-bestanden en kopieer ze naar hdfs
bin/hadoop dfs -copyFromLocal <input-bestandendir> /user/<gebruiker>/<input-bestandendir>

check met 

bin/hadoop dfs -ls

run de job
jar contrib/streaming/hadoop-*streaming*.jar \
-file /home/<gebruiker>/mapper.py    -mapper /home/<gebruiker>/mapper.py \
-file /home/<gebruiker>/reducer.py   -reducer /home/<gebruiker>/reducer.py \
-input /user/<gebruiker>/<input-bestandendir>/* -output /user/<gebruiker>/<output-dir>
