package maxtemperature;
import java.io.IOException;
import java.util.Iterator;
 
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.IntWritable;

import org.apache.hadoop.io.Text;
 
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.conf.Configuration;
 
public class MaxTemperature{
 
    
    //Mapper
    
    
    public static class MaxTemperatureMapper extends
            Mapper<LongWritable, Text, Text, IntWritable> {
        
                private static final int MISSING = 9999;
        @Override
        public void map(LongWritable key, Text value, Context context)
                throws IOException, InterruptedException {
             
            String line = value.toString();

            String year = line.substring(15, 19);
            int temp;
            //maximum temperature
            if(line.charAt(87) == '+'){
                temp = Integer
                            .parseInt(line.substring(88, 92));
            }else{
                temp = Integer.parseInt(line.substring(87, 92));
            }
            String quality = line.substring(92,93);
            if (temp != MISSING && quality.matches("[01459]")){
                context.write(new Text(year), new IntWritable(temp));
            }
        }
 
    }
 
//Reducer

    
    public static class MaxTemperatureReducer extends
            Reducer<Text, IntWritable, Text, IntWritable> {
 
        
        public void reduce(Text key, Iterable<IntWritable> values, Context context)
                throws IOException, InterruptedException {
 
            
            int maxValue = Integer.MIN_VALUE;
                        for (IntWritable value : values){
                            maxValue = Math.max(maxValue, value.get());
                        }
                        context.write(key, new IntWritable(maxValue));
        }
 
    }
 
 
 
    /**
    * @method main
    * This method is used for setting all the configuration properties.
    * It acts as a driver for map reduce code.
    */
    
    public static void main(String[] args) throws Exception {
 
                          //reads the default configuration of cluster from the configuration xml files
        Configuration conf = new Configuration();
        
        //Initializing the job with the default configuration of the cluster        
                Job job = new Job();
        
        //Assigning the driver class name
        job.setJarByClass(MaxTemperature.class);
                
                job.setJobName("Max temperature");
 
        //Defining the mapper class name
        job.setMapperClass(MaxTemperatureMapper.class);
        
        //Defining the reducer class name
        job.setReducerClass(MaxTemperatureReducer.class);
 
        //Defining input Format class which is responsible to parse the dataset into a key value pair
        job.setOutputValueClass(IntWritable.class);
        
        //Defining output Format class which is responsible to parse the dataset into a key value pair
        job.setOutputKeyClass(Text.class);
 
        //Configuring the input path from the filesystem into the job
        FileInputFormat.addInputPath(job, new Path(args[0]));
 
        //Configuring the output path from the filesystem into the job
        FileOutputFormat.setOutputPath(job, new Path(args[1]));

 
        //exiting the job only if the flag value becomes false
        System.exit(job.waitForCompletion(true) ? 0 : 1);
 
    }
}