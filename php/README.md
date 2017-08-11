# MapReduceWorkshop php wordcount

http://www.evanconkle.com/2012/02/writing-hadoop-mapreduce-program-php/

Zorg voor input-bestanden en kopieer ze naar hdfs
zorg dat de mapper en reducer executie-rechten hebben
bin/hadoop dfs -copyFromLocal <input-bestandendir> /user/<gebruiker>/<input-bestandendir>

check met 

bin/hadoop dfs -ls

run de job


bin/<a href="http://www.evanconkle.com/2011/12/installing-ganglia-centos/">hadoop</a> jar contrib/<a href="http://www.evanconkle.com/2011/12/installing-ganglia-centos/">hadoop</a>-streaming.jar -mapper /home/<gebruiker>/mapper.php -reducer /home/<gebruiker>/reducer.php -input <input-dir>/* -output <output-dir>




sudo -u hdfs <a href="http://www.evanconkle.com/2011/12/installing-ganglia-centos/">hadoop</a> jar <a href="http://www.evanconkle.com/2011/12/installing-ganglia-centos/">hadoop</a>-streaming-0.20.2-cdh3u3.jar -mapper /mapreduce/mapper.php -reducer /mapreduce//reducer.php -input <input-dir>/* -output <output-dir>
