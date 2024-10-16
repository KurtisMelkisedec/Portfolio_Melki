package com.portoflio.back.web.dtos.request;

import com.portoflio.back.web.dtos.response.SkillResponseDto;
import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;
import java.util.List;
@Builder
@Getter
public class ProjectRequestDto implements Serializable {
    private Long id;
    private String title;
    private String description;
    private String story;
    private List<SkillResponseDto> techno;
    private String url;
    private String github;
    private String mainImage;
    private byte[] video;
    private List<String>images;

}
