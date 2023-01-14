package com.example.demo.global.config.s3

import com.amazonaws.auth.AWSStaticCredentialsProvider
import com.amazonaws.auth.BasicAWSCredentials
import com.amazonaws.services.s3.AmazonS3
import com.amazonaws.services.s3.AmazonS3ClientBuilder
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Primary

class AmazonS3Config(
    private val amazonS3Properties: AmazonS3Properties
) {

    @Value("\${cloud.aws.region.static}")
    var REGION: String? = ""

    @Primary
    @Bean
    fun amazonS3Client(): AmazonS3? {
        return AmazonS3ClientBuilder.standard().withRegion(REGION)
            .withCredentials(AWSStaticCredentialsProvider(BasicAWSCredentials(amazonS3Properties.accessKey, amazonS3Properties.secretKey)))
            .build()
    }
}