package org.revature.revbook.aws;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.util.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Optional;

@Service
public class FileStore {

    @Autowired
    private AmazonS3 s3;

    // Upload method
    // Send object to S3 Bucket:
    public void upload(String path, String fileName, Optional<Map<String, String>> optionalMetaData, InputStream inputStream)
    {
        // Create new ObjectMetadata and add metadata if exists:
        ObjectMetadata metadata = new ObjectMetadata();
        optionalMetaData.ifPresent(map -> {
            if (!map.isEmpty()) {
                map.forEach(metadata::addUserMetadata);
            }
        });

        // Add file to the destination path (send/upload):
        try {
            s3.putObject(path, fileName, inputStream, metadata);
        } catch (Exception ex) {
            throw new IllegalStateException("Failed to store file to s3", ex);
        }
    }

    // Download method
    // Retrieve object from S3 Bucket:
    public byte[] download(String path, String key) {
        // Try to retrieve the object from the S3 Bucket as a Byte Array:
        try {
            S3Object object = s3.getObject(path, key);
            return IOUtils.toByteArray(object.getObjectContent());
        } catch (AmazonServiceException | IOException e) {
            throw new IllegalStateException("Failed To Download file To S3", e);
        }
    }
}
