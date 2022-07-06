package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);
//        CarService carService = context.getBean(CarService.class);

        Car car1 = new Car("aaaa", 1111);
        Car car2 = new Car("ssss", 2222);
        Car car3 = new Car("dddd", 2233);
        Car car4 = new Car("ffff", 4444);

//        userService.add(new User("User1", "Lastname1", "user1@mail.ru", car1));
//        userService.add(new User("User2", "Lastname2", "user2@mail.ru", car2));
//        userService.add(new User("User3", "Lastname3", "user3@mail.ru", car3));
//        userService.add(new User("User4", "Lastname4", "user4@mail.ru", car4));
        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println(user.toString());
//         System.out.println("Id = "+user.getId());
//         System.out.println("First Name = "+user.getFirstName());
//         System.out.println("Last Name = "+user.getLastName());
//         System.out.println("Email = "+user.getEmail());
            System.out.println();
        }
        System.out.println(userService.getUserByCar(car2).toString());
        context.close();
    }
}
