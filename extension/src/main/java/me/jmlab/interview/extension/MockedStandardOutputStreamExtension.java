package me.jmlab.interview.extension;

import java.io.*;
import org.junit.jupiter.api.extension.*;

public class MockedStandardOutputStreamExtension implements BeforeEachCallback, AfterEachCallback, ParameterResolver {

    private static final PrintStream stdout = System.out;

    private static final ExtensionContext.Namespace NS =
            ExtensionContext.Namespace.create(MockedStandardOutputStreamExtension.class);

    @Override
    public void beforeEach(ExtensionContext context) throws Exception {
        var store = context.getStore(NS);

        var file = File.createTempFile("stdout", "");
        var share = new FileInputStream(file);
        var print = new PrintStream(new FileOutputStream(file));
        System.setOut(print);
        store.put(InputStream.class, share);
        store.put(PrintStream.class, print);
    }

    @Override
    public void afterEach(ExtensionContext context) throws Exception {
        var store = context.getStore(NS);

        System.setOut(stdout);

        var print = store.get(PrintStream.class, PrintStream.class);
        var share = store.get(InputStream.class, InputStream.class);

        print.close();
        share.close();
    }

    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext)
            throws ParameterResolutionException {
        return parameterContext.getParameter().getType() == InputStream.class;
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext context)
            throws ParameterResolutionException {
        var store = context.getStore(NS);

        return store.get(InputStream.class);
    }
}
