package main.resources.s3;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.AmazonS3Exception;

public class CreateBucket {

  public static void main(String[] args) {
    final AmazonS3 s3 = AmazonS3ClientBuilder.defaultClient();
    String bucketName = "try-s3-jdk";

    try {
      s3.createBucket(bucketName);
    } catch (AmazonS3Exception e) {
      System.err.println(e.getErrorMessage());
    }
  }
}
