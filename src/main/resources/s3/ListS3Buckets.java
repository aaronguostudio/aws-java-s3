package main.resources.s3;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.Bucket;

import java.util.List;

public class ListS3Buckets {

  public static void main (String[] args) {
    final AmazonS3 s3 = AmazonS3ClientBuilder.defaultClient();
    List<Bucket> buckets = s3.listBuckets();
    System.out.println("Buckets:");
    for (Bucket b : buckets) {
      System.out.println(b.getName());
    }
  }
}
