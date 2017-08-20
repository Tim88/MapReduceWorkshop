/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordcountapplication;

import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

/**
 *
 * @author barent
 */
public class WordCountReducer extends Reducer<Text, IntWritable, Text, IntWritable> 
{
    
    private IntWritable writableSum = new IntWritable();
    
    public void reduce(Text word, Iterable<IntWritable> values, Context context) 
            throws IOException, InterruptedException
    {
        int sum = 0;
        for(IntWritable value : values)
        {
            sum += value.get();
        }
        writableSum.set(sum);
        context.write(word, writableSum);
    }
}
