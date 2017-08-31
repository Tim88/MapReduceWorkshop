# MapReduceWorkshop R wordcount

https://coderwall.com/p/imxf6g/running-wordcount-on-hadoop-using-r-script

hadoop jar /usr/hdp/2.6.1.0-129/hadoop-mapreduce/hadoop-streaming.jar -file 
/home/gebruiker1/python/mapper.py -mapper mapper.py -file 
/home/gebruiker1/python/reducer.py -reducer reducer.py -input /user/gebruiker1/input/* -output /user/gebruiker1/pythonoutput22


let op eventuele microsoft line-endings. Om dit ongedaan te maken:

Open bestand in vi op het cluser en typ ":set ff=unix" en dan ":wq".
