package me.jmlab.coding.test.fixture;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ExtensionContext.Namespace;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

public class MockStandardStreamExtension implements BeforeEachCallback, AfterEachCallback, ParameterResolver {

    private static final InputStream stdin = System.in;
    private static final PrintStream stdout = System.out;

    private static final List<Class<?>> SUPPORTED = Arrays.asList(PipedOutputStream.class, ByteArrayOutputStream.class);

    private static final Namespace ns = Namespace.create(MockStandardStreamExtension.class);

    private static final String STDIN_KEY = "stdin";
    private static final String STDOUT_KEY = "stdout";

    @Override
    public void beforeEach(ExtensionContext context) throws IOException {
        var mockedStdin = new PipedInputStream();
        System.setIn(mockedStdin);
        context.getStore(ns).put(STDIN_KEY, new PipedOutputStream(mockedStdin));

        var mockedStdout = new ByteArrayOutputStream();
        System.setOut(new PrintStream(mockedStdout));
        context.getStore(ns).put(STDOUT_KEY, mockedStdout);
    }

    @Override
    public void afterEach(ExtensionContext context) {
        System.setIn(stdin);
        System.setOut(stdout);
    }

    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext context) {
        return SUPPORTED.contains(parameterContext.getParameter().getType());
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext context) {
        if (parameterContext.getParameter().getType() == PipedOutputStream.class) {
            return context.getStore(ns).get(STDIN_KEY);
        } else if (parameterContext.getParameter().getType() == ByteArrayOutputStream.class) {
            return context.getStore(ns).get(STDOUT_KEY);
        }

        throw new ParameterResolutionException(String.format(
                "Unsupported parameter type '%s'",
                parameterContext.getParameter().getType()));
    }
}
