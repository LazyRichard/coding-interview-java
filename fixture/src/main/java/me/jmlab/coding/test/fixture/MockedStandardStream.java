package me.jmlab.coding.test.fixture;

import org.junit.jupiter.api.extension.ExtendWith;

import java.lang.annotation.*;

@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@ExtendWith(MockedStandardInputStreamExtension.class)
@ExtendWith(MockedStandardOutputStreamExtension.class)
public @interface MockedStandardStream {
}
