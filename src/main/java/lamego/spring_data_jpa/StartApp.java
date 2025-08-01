package lamego.spring_data_jpa;

import lamego.spring_data_jpa.model.User;
import lamego.spring_data_jpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StartApp implements CommandLineRunner {
    @Autowired
    private UserRepository repository;

    @Override
    public void run(String... args) throws Exception {
        List<User> users = repository.filtrarPorNome("Andre");
        for (User u: users){
            System.out.println(u);
        }
    }

    private void insertUser() {
        User user = new User();
        user.setName("Andre");
        user.setUsername("lamego");
        user.setPassword("123456");

        repository.save(user);

        for (User u : repository.findAll()) {
            System.out.println(u);
        }
    }
}
