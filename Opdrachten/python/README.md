# MapReduceWorkshop python wordcount

http://www.michael-noll.com/tutorials/writing-an-hadoop-mapreduce-program-in-python/



hadoop jar /usr/hdp/2.6.1.0-129/hadoop-mapreduce/hadoop-streaming.jar -file 
/home/gebruiker1/python/mapper.py -mapper mapper.py -file 
/home/gebruiker1/python/reducer.py -reducer reducer.py -input /user/gebruiker1/input/* -output /user/gebruiker1/pythonoutput22

Open bestand in vi op het cluser en typ ":set ff=unix" en dan ":wq".
