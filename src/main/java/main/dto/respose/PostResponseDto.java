package main.dto.respose;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Calendar;
import java.util.Date;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostResponseDto {

    private Integer id;

    private Date time;

    private UserResponseDto userResponseDto;

    private String title;

    private String announce;

    private Integer liceCount;

    private Integer dislikeCount;

    private Integer commentCount;

    private Integer viewCount;

}
