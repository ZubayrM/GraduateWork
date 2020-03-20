package main.dto.responseModel;

import com.wordnik.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InitResponseDto {
    private String title = "DevPut";
    private String subtitle = "Рассказы разработчиков";
    private String phone = "+7 996 420-81-88";
    private String email = "zubayr_@live.com";
    private String copyright = "Зубайр Мухтаров";
    private String copyrightFrom = "2020";
}
