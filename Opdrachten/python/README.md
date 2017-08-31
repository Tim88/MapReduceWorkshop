# MapReduceWorkshop python wordcount

commando voor hadoop streaming (script talen)

!!!!!!!!!!!!!!!!!
/usr/bin/hadoop jar /usr/hdp/2.6.0.3-8/hadoop-mapreduce/hadoop-streaming.jar -mapper /usr/lib/hue/mapper.py -reducer /usr/lib/hue/reducer.py -input /user/hue/Word_Count/input/* -output /user/hue/Word_Count/python_output3
!!!!!!!!!!!!!!!!!

let op eventuele microsoft line-endings. Om dit ongedaan te maken:

Open bestand in vi op het cluser en type ":set ff=unix" en dan ":wq".

