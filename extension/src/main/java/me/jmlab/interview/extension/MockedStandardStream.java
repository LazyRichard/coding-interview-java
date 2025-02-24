package me.jmlab.interview.extension;

import java.lang.annotation.*;
import org.junit.jupiter.api.extension.ExtendWith;

@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@ExtendWith(MockedStandardInputStreamExtension.class)
@ExtendWith(MockedStandardOutputStreamExtension.class)
public @interface MockedStandardStream {}
