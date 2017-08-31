package pairs;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;
import org.apache.hadoop.io.WritableUtils;


/**
 * TextPair is a Pair of Text that is Writable (Hadoop serialization API)
 * and Comparable to itself.
 *
 */
public class TextPair implements WritableComparable<TextPair> {

private Text first;
private Text second;


public void set(Text first, Text second) {
  this.first = first;
  this.second = second;
}

public Text getFirst() {
  return this.first;
}

public Text getSecond() {
  return this.second;
}
  
public TextPair() {
  set(new Text(), new Text());
}

public TextPair(String first, String second) {
  this.set(new Text(first), new Text(second));
}

public TextPair(Text first, Text second) {
  this.set(first, second);
}

@Override
public void write(DataOutput out) throws IOException {
  first.write(out);
  second.write(out);
}

@Override
public void readFields(DataInput in) throws IOException {
  first.readFields(in);
  second.readFields(in);
}

@Override
public int hashCode() {
  return first.hashCode() * 163 + second.hashCode();
}

@Override
public boolean equals(Object o) {
  if (o instanceof TextPair) {
    TextPair tp = (TextPair) o;
    return first.equals(tp.first) && second.equals(tp.second);
  }
  return false;
}

@Override
public int compareTo(TextPair tp) {
  int cmp = first.compareTo(tp.first);
  if (cmp != 0) {
    return cmp;
  }
  return second.compareTo(tp.second);
}

@Override
  public String toString() {
    return first + "\t" + second;
  }





// DO NOT TOUCH THE CODE BELOW

public static class Comparator extends WritableComparator {
 
  private static final Text.Comparator TEXT_COMPARATOR = new Text.Comparator();
 
  public Comparator() {
    super(TextPair.class);
  }

  @Override
  public int compare(byte[] b1, int s1, int l1,
                     byte[] b2, int s2, int l2) {
   
    try {
      int firstL1 = WritableUtils.decodeVIntSize(b1[s1]) + readVInt(b1, s1);
      int firstL2 = WritableUtils.decodeVIntSize(b2[s2]) + readVInt(b2, s2);
      int cmp = TEXT_COMPARATOR.compare(b1, s1, firstL1, b2, s2, firstL2);
      if (cmp != 0) {
        return cmp;
      }
      return TEXT_COMPARATOR.compare(b1, s1 + firstL1, l1 - firstL1,
                                     b2, s2 + firstL2, l2 - firstL2);
    } catch (IOException e) {
      throw new IllegalArgumentException(e);
    }
  }
}

static {
 WritableComparator.define(TextPair.class, new Comparator());
}

public static class FirstComparator extends WritableComparator {
 
 private static final Text.Comparator TEXT_COMPARATOR = new Text.Comparator();
 
 public FirstComparator() 
{   super(TextPair.class);
 }

 @Override
 public int compare(byte[] b1, int s1, int l1,
                    byte[] b2, int s2, int l2) {
   
   try {
     int firstL1 = WritableUtils.decodeVIntSize(b1[s1]) + readVInt(b1, s1);
     int firstL2 = WritableUtils.decodeVIntSize(b2[s2]) + readVInt(b2, s2);
     return TEXT_COMPARATOR.compare(b1, s1, firstL1, b2, s2, firstL2);
   } catch (IOException e) {
     throw new IllegalArgumentException(e);
   }
 }
 
@SuppressWarnings("unchecked")
@Override
 public int compare(WritableComparable a, WritableComparable b) {
   if (a instanceof TextPair && b instanceof TextPair) {
     return ((TextPair) a).getFirst().compareTo(((TextPair) b).getFirst());
   }
   return super.compare(a, b);
 }

}
}

