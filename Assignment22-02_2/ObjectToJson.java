import java.lang.reflect.*;
class Person {
    private String name = "Kanhaiya";
    private int age = 22;
}
public class ObjectToJson {
    public static String toJson(Object obj) throws Exception {
        StringBuilder json = new StringBuilder("{");
        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            fields[i].setAccessible(true);
            json.append("\"").append(fields[i].getName()).append("\":\"").append(fields[i].get(obj)).append("\"");
            if (i < fields.length - 1) json.append(",");
        }
        json.append("}");
        return json.toString();
    }
    public static void main(String[] args) throws Exception {
        Person person = new Person();
        System.out.println(toJson(person));
    }
}
