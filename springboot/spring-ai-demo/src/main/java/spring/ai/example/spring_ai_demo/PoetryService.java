package spring.ai.example.spring_ai_demo;

public interface PoetryService {
    String getCatHaiku();

    PoetryDto getPoetryByGenreAndTheme(String genre, String theme);
}
