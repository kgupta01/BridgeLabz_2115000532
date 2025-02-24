import java.lang.annotation.*;
import java.lang.reflect.*;
@Retention(RetentionPolicy.RUNTIME)
@interface Inject {}
class Service {
    public void serve() {
        System.out.println("Service is running...");
    }
}
class Client {
    @Inject
    private Service service;
    public void execute() {
        service.serve();
    }
}
class DIContainer {
    public static void injectDependencies(Object obj) throws Exception {
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Inject.class)) {
                field.setAccessible(true);
                field.set(obj, field.getType().getDeclaredConstructor().newInstance());
            }
        }
    }
}
public class DependencyInjectionExample {
    public static void main(String[] args) throws Exception {
        Client client = new Client();
        DIContainer.injectDependencies(client);
        client.execute();
    }
}
