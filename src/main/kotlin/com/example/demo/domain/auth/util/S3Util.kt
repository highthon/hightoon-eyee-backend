package com.example.demo.domain.auth.util

import com.amazonaws.services.s3.AmazonS3
import com.amazonaws.services.s3.model.ObjectMetadata
import com.example.demo.domain.auth.exception.BusinessException
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import org.springframework.web.multipart.MultipartFile
import java.util.*

@Component
class S3Util(
    private val amazonS3: AmazonS3,
) {
    val bucket: String = "hehe-s3"

    private val log get() = LoggerFactory.getLogger(this::class.java)

    fun fileUpload(multipartFile: MultipartFile?): String {
        var fileName = ""
        try {
            fileName = UUID.randomUUID().toString()
            val metadata = ObjectMetadata()
            metadata.contentLength = multipartFile!!.size
            amazonS3.putObject(bucket, fileName, multipartFile.inputStream, metadata)
        } catch (e: Exception) {
            throw BusinessException()
        }
        log.info("File Uploaded Successfully : {}", fileName)
        return fileName
    }
}