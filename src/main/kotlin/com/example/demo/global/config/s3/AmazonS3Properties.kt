package com.example.demo.global.config.s3

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties(prefix = "cloud.aws.credentials")
class AmazonS3Properties(
    accessKey: String,
    secretKey: String,
) {
    val accessKey: String
    val secretKey: String

    init {
        this.accessKey = accessKey
        this.secretKey = secretKey
    }
}