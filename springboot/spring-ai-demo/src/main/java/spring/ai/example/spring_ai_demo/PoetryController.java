package spring.ai.example.spring_ai_demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ai")
public class PoetryController {
    private final PoetryService poetryService;

    PoetryController(PoetryService poetryService) {
        this.poetryService = poetryService;
    }

    @GetMapping("/cathaiku")
    public ResponseEntity<String> generateHaiku() {
        return ResponseEntity.ok(poetryService.getCatHaiku());
    }
}
