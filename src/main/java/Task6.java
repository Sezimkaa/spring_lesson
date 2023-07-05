import com.example.Dog;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Task6 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application_context.xml");
        Dog dog = context.getBean("myPet", Dog.class);
        dog.say();
    }
}
