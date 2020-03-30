package main.controllers.api;
import main.dto.respose.InitResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
