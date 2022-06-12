package org.revature.revbook.aws;

public enum BucketName {
    SITE_IMAGE("revbook123");

    private final String bucketName;

    BucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public String getBucketName() {
        return bucketName;
    }
}
