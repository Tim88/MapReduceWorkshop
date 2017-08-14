/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordcountapplication;

import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class WordCountMapper extends Mapper<LongWritable, Text, Text, IntWritable> {	
	@Override

	public void map(LongWritable key, Text value, Context con) throws IOException, InterruptedException
	{
	String line = value.toString();
	String[] words=line.split(",");
		for(String word: words )
		{
			Text outputKey = new Text(word.toUpperCase().trim());
			IntWritable outputValue = new IntWritable(1);
			con.write(outputKey, outputValue);
		}
	}
}
