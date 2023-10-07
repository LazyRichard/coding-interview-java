package me.jmlab.coding.test.fixture;

import org.junit.jupiter.api.extension.*;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class MockedStandardInputStreamExtension implements BeforeEachCallback, AfterEachCallback, ParameterResolver {

    private static final InputStream stdin = System.in;

    private static final ExtensionContext.Namespace NS = ExtensionContext.Namespace.create(MockedStandardInputStreamExtension.class);

    private int pipeSize = 1024;

    public void setPipeSize(int size) {
        this.pipeSize = size;
    }

    @Override
    public void beforeEach(ExtensionContext context) throws Exception {
        var store = context.getStore(NS);

        var pipedOutput = new PipedOutputStream();
        var pipedInput = new PipedInputStream(pipedOutput, pipeSize);
        System.setIn(pipedInput);

        store.put(PipedInputStream.class, pipedInput);
        store.put(PipedOutputStream.class, pipedOutput);
    }

    @Override
    public void afterEach(ExtensionContext context) throws Exception {
        var store = context.getStore(NS);

        System.setIn(stdin);

        var pipedOutput = store.get(PipedOutputStream.class, PipedOutputStream.class);
        var pipedInput = store.get(PipedInputStream.class, PipedInputStream.class);

        pipedOutput.close();
        pipedInput.close();
    }

    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return parameterContext.getParameter().getType() == OutputStream.class;
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext context) throws ParameterResolutionException {
        var store = context.getStore(NS);

        return store.get(PipedOutputStream.class);
    }
}
