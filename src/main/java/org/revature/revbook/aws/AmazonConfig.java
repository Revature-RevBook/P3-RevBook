package org.revature.revbook.aws;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.amazonaws.services.s3.AmazonS3;

@Configuration
public class AmazonConfig {

    // Amazon S3 Bucket Access Variables:
    @Value("${s3_accessKey}")
    private String accessKey;
    @Value("${s3_secretKey}")
    private String secretKey;
    @Value("${s3_region}")
    private String s3Region;

    // AmazonS3 Object:
    // Creates a connection using the credentials to access the Amazon S3 Bucket so that a user can
    //  add/remove objects from the bucket.
    @Bean //spring instantiates this at runtime.
    public AmazonS3 s3() {
        AWSCredentials awsCredentials = new BasicAWSCredentials(accessKey, secretKey);
        return AmazonS3ClientBuilder.standard().withRegion(s3Region)
                .withCredentials(new AWSStaticCredentialsProvider(awsCredentials)).build();
    }
}

