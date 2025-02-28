package com.app.springpowpow.domain;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Component
public class CommLikesDTO {

    private Long id;
    private Long memberId;
    private Long postId;
    private String memberFileName;
    private String memberFilePath;
    private String postContent;
    private String postFileName;
    private String postFilePath;
    private String memberNickName;
//    private String postImage1;
//    private String postImage2;
//    private String postImage3;
//    private String postImage4;
//    private String postImage5;

}
