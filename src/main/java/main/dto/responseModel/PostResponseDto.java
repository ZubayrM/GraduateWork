package main.dto.responseModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Calendar;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostResponseDto {

    private Integer id;

    private Calendar time;

    private UserResponseDto userResponseDto;

    private String title;

    private String announce;

    private Integer liceCount;

    private Integer dislikeCount;

    private Integer commentCount;

    private Integer viewCount;

}
