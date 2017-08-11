/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package votecountapplication;

import org.apache.hadoop.io.IntWritable;

/**
 *
 * @author barent
 */
public class VoteCountReducer extends Reducer<Text, IntWritable, Text, IntWritable> {
    
    public void reduce(Text key, Iterable<IntWritable> values, Context output)
               throws IOException, InterruptedException {
        int voteCount = 0;
        for(IntWritable value : values){
            voteCount += value.get();
        }
        output.write(key, new IntWritable(voteCount));
    }
}
