import java.lang.reflect.*;
class Sample {
    public void fastMethod() {
        for (int i = 0; i < 1000; i++);
    }
    public void slowMethod() {
        for (int i = 0; i < 1000000; i++);
    }
}
public class MethodExecutionTiming {
    public static void measureExecutionTime(Object obj, String methodName) throws Exception {
        Method method = obj.getClass().getMethod(methodName);
        long start = System.nanoTime();
        method.invoke(obj);
        long end = System.nanoTime();
        System.out.println(methodName + " execution time: " + (end - start) + " ns");
    }
    public static void main(String[] args) throws Exception {
        Sample sample = new Sample();
        measureExecutionTime(sample, "fastMethod");
        measureExecutionTime(sample, "slowMethod");
    }
}
