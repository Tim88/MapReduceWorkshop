# MapReduceWorkshop R wordcount

https://coderwall.com/p/imxf6g/running-wordcount-on-hadoop-using-r-script

/usr/bin/hadoop jar /usr/hdp/2.6.0.3-8/hadoop-mapreduce/hadoop-streaming.jar -mapper /gebruikermap/mapper.R -reducer /gebruikermap/reducer.R -input /user/hue/Word_Count/input/* -output /user/hue/Word_Count/python_output3

let op eventuele microsoft line-endings. Om dit ongedaan te maken:

Open bestand in vi op het cluser en type ":set ff=unix" en dan ":wq".
