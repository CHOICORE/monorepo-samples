package me.choicore.samples.monorepo.test.context.container;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static org.springframework.boot.test.context.SpringBootTest.UseMainMethod;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@SpringBootTest
@Import(ContainerTestImportSelector.class)
public @interface ContainerTest {
    @AliasFor("containers")
    ContainerType[] value() default {};

    @AliasFor("value")
    ContainerType[] containers() default {};

    @AliasFor(annotation = SpringBootTest.class, attribute = "webEnvironment")
    WebEnvironment webEnvironment() default WebEnvironment.MOCK;

    @AliasFor(annotation = SpringBootTest.class, attribute = "properties")
    String[] properties() default {};

    @AliasFor(annotation = SpringBootTest.class, attribute = "args")
    String[] args() default {};

    @AliasFor(annotation = SpringBootTest.class, attribute = "classes")
    Class<?>[] classes() default {};

    @AliasFor(annotation = SpringBootTest.class, attribute = "useMainMethod")
    UseMainMethod useMainMethod() default UseMainMethod.NEVER;
}
