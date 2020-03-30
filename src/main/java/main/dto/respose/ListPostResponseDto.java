package main.dto.respose;

import lombok.*;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListPostResponseDto {

    Integer count;

    @Singular
    List<PostResponseDto> posts;

}
