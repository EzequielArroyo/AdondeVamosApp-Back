package com.adondevamos.adondevamos.Config;

import com.adondevamos.adondevamos.core.Category.Category;
import com.adondevamos.adondevamos.core.Category.CategoryRepository;
import com.adondevamos.adondevamos.core.Post.Post;

import com.adondevamos.adondevamos.core.Language.Language;
import com.adondevamos.adondevamos.core.User.User;
import com.adondevamos.adondevamos.core.Post.PostRepository;

import com.adondevamos.adondevamos.core.Language.LanguageRepository;
import com.adondevamos.adondevamos.core.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Component
public class DataInit implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private LanguageRepository languageRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {
        if (userRepository.count() == 0) {
            Language language1 = new Language(null, "English");
            Language language2 = new Language(null, "French");
            Language language3 = new Language(null, "Spanish");
            languageRepository.saveAll(List.of(language1, language2, language3));

            Category category1 = Category.builder().name("Sports").build();
            Category category2 = Category.builder().name("VideoGames").build();
            Category category3 = Category.builder().name("Partys").build();
            categoryRepository.saveAll(List.of(category1, category2, category3));

            User user1 = User.builder()
                    .username("juanperez")
                    .password(passwordEncoder.encode("contra"))
                    .email("juan@example.com")
                    .firstname("Juan")
                    .lastname("Pérez")
                    .birthdate(LocalDate.of(1990, 5, 15))
                    .sex("Male")
                    .phone("123456789")
                    .location("Chaco, Argentina")
                    .bio("Apasionado por la tecnología y los viajes.")
                    .occupation("Ingeniero de Software")
                    .languages(List.of(language1, language2)) // Asegúrate de tener instancias de Language
                    .categories(List.of(category1, category2)) // Asegúrate de tener instancias de Interest
                    .build();

            User user2 = User.builder()
                    .username("EZEarroyo")
                    .password(passwordEncoder.encode("contra"))
                    .email("eze@example.com")
                    .firstname("EZequiel")
                    .lastname("Arroyo")
                    .birthdate(LocalDate.of(1998, 11, 19))
                    .sex("Male")
                    .phone("4455566677")
                    .location("Buenos Aires, Argentina")
                    .bio("Apasionado por la tecnología y los viajes.")
                    .occupation("Ingeniero de Software")
                    .languages(List.of(language1, language3)) // Asegúrate de tener instancias de Language
                    .categories(List.of(category1, category3)) // Asegúrate de tener instancias de Interest
                    .build();
            userRepository.saveAll(List.of(user1, user2));

            Post activity1 = Post.builder()
                    .title("Torneo de Fútbol 5")
                    .datetime(LocalDateTime.of(2024, 3, 15, 18, 30))
                    .description("Partido amistoso de fútbol 5 en el club deportivo.")
                    .location("Buenos Aires, Argentina")
                    .owner(user1) // Asegúrate de tener una instancia de User
                    .participants(List.of(user2))
                    .cantParticipants(1)
                    .maxParticipants(10)
                    .category(category1)
                    .build();

            Post activity2 = Post.builder()
                    .title("Noche de Juegos de Mesa")
                    .datetime(LocalDateTime.of(2024, 3, 22, 20, 0))
                    .description("Evento de juegos de mesa en un café temático.")
                    .location("Córdoba, Argentina")
                    .owner(user2) // Asegúrate de tener una instancia de User
                    .participants(List.of(user1))
                    .cantParticipants(1)
                    .maxParticipants(8)
                    .category(category2)
                    .build();
            postRepository.saveAll(List.of(activity1, activity2));
            System.out.println("📌 Datos inicializados correctamente.");
        }
    }
}