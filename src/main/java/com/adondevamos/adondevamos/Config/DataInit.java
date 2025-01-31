package com.adondevamos.adondevamos.Config;

import com.adondevamos.adondevamos.Entities.Activity;
import com.adondevamos.adondevamos.Entities.Interest;
import com.adondevamos.adondevamos.Entities.Language;
import com.adondevamos.adondevamos.Entities.User;
import com.adondevamos.adondevamos.Repositories.ActivityRepository;
import com.adondevamos.adondevamos.Repositories.InterestRepository;
import com.adondevamos.adondevamos.Repositories.LanguageRepository;
import com.adondevamos.adondevamos.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
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
    private InterestRepository interestRepository;
    @Autowired
    private ActivityRepository activityRepository;

    @Override
    public void run(String... args) {
        if (userRepository.count() == 0) {
            Language language1 = new Language(null, "English");
            Language language2 = new Language(null, "French");
            Language language3 = new Language(null, "Spanish");
            languageRepository.saveAll(List.of(language1, language2, language3));

            Interest interest1 = Interest.builder().name("Sports").build();
            Interest interest2 = Interest.builder().name("VideoGames").build();
            Interest interest3 = Interest.builder().name("Partys").build();
            interestRepository.saveAll(List.of(interest1, interest2, interest3));

            User user1 = User.builder()
                    .username("juanperez")
                    .password("securepassword") // Recuerda encriptar contraseñas en producción
                    .email("juan@example.com")
                    .firstname("Juan")
                    .lastname("Pérez")
                    .birthdate(LocalDate.of(1990, 5, 15)) // Cambia a la fecha que necesites
                    .sex("Male")
                    .phone("123456789")
                    .location("Chaco, Argentina")
                    .bio("Apasionado por la tecnología y los viajes.")
                    .occupation("Ingeniero de Software")
                    .languages(List.of(language1, language2)) // Asegúrate de tener instancias de Language
                    .interests(List.of(interest1, interest2)) // Asegúrate de tener instancias de Interest
                    .build();

            User user2 = User.builder()
                    .username("EZEarroyo")
                    .password("securepassword") // Recuerda encriptar contraseñas en producción
                    .email("eze@example.com")
                    .firstname("EZequiel")
                    .lastname("Arroyo")
                    .birthdate(LocalDate.of(1998, 11, 19)) // Cambia a la fecha que necesites
                    .sex("Male")
                    .phone("4455566677")
                    .location("Buenos Aires, Argentina")
                    .bio("Apasionado por la tecnología y los viajes.")
                    .occupation("Ingeniero de Software")
                    .languages(List.of(language1, language3)) // Asegúrate de tener instancias de Language
                    .interests(List.of(interest1, interest3)) // Asegúrate de tener instancias de Interest
                    .build();
            userRepository.saveAll(List.of(user1, user2));

            Activity activity1 = Activity.builder()
                    .title("Torneo de Fútbol 5")
                    .datetime(LocalDateTime.of(2024, 3, 15, 18, 30))
                    .description("Partido amistoso de fútbol 5 en el club deportivo.")
                    .location("Buenos Aires, Argentina")
                    .owner(user1) // Asegúrate de tener una instancia de User
                    .participants(List.of(user2))
                    .maxParticipants(10)
                    .category("Deportes")
                    .build();

            Activity activity2 = Activity.builder()
                    .title("Noche de Juegos de Mesa")
                    .datetime(LocalDateTime.of(2024, 3, 22, 20, 0))
                    .description("Evento de juegos de mesa en un café temático.")
                    .location("Córdoba, Argentina")
                    .owner(user2) // Asegúrate de tener una instancia de User
                    .participants(List.of(user1))
                    .maxParticipants(8)
                    .category("Ocio")
                    .build();
            activityRepository.saveAll(List.of(activity1, activity2));

        }

            System.out.println("📌 Datos inicializados correctamente.");
    }
}