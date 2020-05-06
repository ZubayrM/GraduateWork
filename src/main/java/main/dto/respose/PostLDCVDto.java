package main.dto.respose;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostLDCVDto extends PostDto {

    private Integer liceCount;

    private Integer dislikeCount;

    private Integer commentCount;

    private Integer viewCount;

}
