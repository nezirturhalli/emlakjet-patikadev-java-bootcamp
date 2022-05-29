package com.example.postapi.dto.response;

import com.example.postapi.entity.PostCategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdatePostResponse {

    private Long postId;
    private String author;
    private String title;
    private String text;
    private PostCategory category;
    private LocalDateTime updatedAt;
}
