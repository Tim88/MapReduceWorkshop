/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package votecountapplication;

import org.apache.hadoop.conf.Configuration;

/**
 *
 * @author barent
 */
public class VoteCountApplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        int res = ToolRunner.run(new Configuration(), new VoteCountApplication(), args);
        System.exit(res);
    }
    
    public int run(String[] args) throws Exception {
        if (args.length != 2){
            System.out.println("usage: [input] [output]");
            System.exit(-1);
        }
        
        Job job = Job.getInstance(new Configuration());
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);
        
        job.setMapperClass(VoteCountMapper.class);
        job.setReducerClass(VoteCountReducer.class);
        
        job.setInputFormatClass(TextInputFormat.class);
        job.setOutputFormatClass(TextOutputFormat.class);

        FileInputFormat.setInputPaths(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));

        job.setJarByClass(VoteCountApplication.class);

        job.submit();
        return 0;
    }
}
