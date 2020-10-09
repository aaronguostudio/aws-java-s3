package main.resources.s3;

import com.amazonaws.HttpMethod;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.AmazonS3Exception;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;

import java.net.URL;
import java.util.Date;

public class GetPreSignedUrl {
  public static void main (String[] args) {
    final AmazonS3 s3 = AmazonS3ClientBuilder.defaultClient();

    String bucketName = "try-s3-jdk";
    String keyName = "a.txt";

    try {
      java.util.Date expiration = new java.util.Date();
      long expTimeMillis = expiration.getTime();
      expTimeMillis += 1000 * 60 * 60;
      expiration.setTime(expTimeMillis);

      GeneratePresignedUrlRequest generatePresignedUrlRequest =
              new GeneratePresignedUrlRequest(bucketName, keyName)
                      .withMethod(HttpMethod.PUT)
                      .withExpiration(expiration);

      URL url = s3.generatePresignedUrl(generatePresignedUrlRequest);
      System.out.println(url.toString());
    } catch (AmazonS3Exception e) {
      System.out.println(e.getErrorMessage());
    }
  }
}
