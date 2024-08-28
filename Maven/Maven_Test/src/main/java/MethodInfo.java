import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
public @interface MethodInfo {
    String author() default "Ika";
    int dateOfCreation() default 2024;
    String purpose();
}
