import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Task5 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context= new ClassPathXmlApplicationContext("application_context2.xml");

        context.close();
    }
}
