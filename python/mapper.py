#!/usr/bin/evn python

#dit moet in /home/<gebruiker>/<ditbestand>
#voeg executie rechten toe
import sys

#input comes from STDIN (standard input)
for line in sys.stdin:
    #remove leading and trailing whitespace
    line = line.strip()
    #split line into word
    words = line.split()
    #increase counters
    for word in words:
        #write the results to STDOUT
        print '%s\t%s' % (word,1)
