package main.controllers.api;
import main.dto.responseModel.InitResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiGeneralController {

    @GetMapping("/api/init/")
    public ResponseEntity getInfo(){
        return ResponseEntity.ok(new InitResponseDto());
    }

    @PostMapping("/api/moderation/")
    public void moderation(int postId, String decision){

    }

    @GetMapping("/api/settings")
    public ResponseEntity getSettings(){
        return null;
    }

    @PutMapping("/api/settings/")
    public ResponseEntity setSettings(){
        return null;
    }







}
