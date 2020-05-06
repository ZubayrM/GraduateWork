package main.dto.respose;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {

    private Integer id;

    private Date time;

    private UserResponseDto userResponseDto;

    private String title;

    private String announce;
}
