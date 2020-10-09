package main.resources.s3;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.AmazonS3Exception;

import java.io.File;

public class UploadFile {
  public static void main (String[] args) {
    final AmazonS3 s3 = AmazonS3ClientBuilder.defaultClient();

    String bucketName = "try-s3-jdk";
    String keyName = "a.txt";
    String filePath = "/Users/xianghuiguo/Desktop/a.txt";

    try {
      s3.putObject(bucketName, keyName, new File(filePath));
    } catch (AmazonS3Exception e) {
      System.out.println(e.getErrorMessage());
    }
  }
}
