package org.revature.revbook.aws;

public enum BucketName {
    // This is the name of the S3 Bucket on AWS. You will want to change this
    //  to your own S3 bucket:
    SITE_IMAGE("revbook123");

    private final String bucketName;

    BucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public String getBucketName() {
        return bucketName;
    }
}
