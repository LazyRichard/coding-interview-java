package me.jmlab.coding.test.fixture;

import org.junit.jupiter.api.extension.*;

import java.io.*;

public class MockedStandardStreamExtension implements BeforeEachCallback, AfterEachCallback, ParameterResolver {

    private static final InputStream stdin = System.in;
    private static final PrintStream stdout = System.out;

    private static final ExtensionContext.Namespace NS = ExtensionContext.Namespace.create(MockedStandardStreamExtension.class);

    @Override
    public void beforeEach(ExtensionContext context) throws Exception {
        var store = context.getStore(NS);

        var stdinFile = File.createTempFile("stdin", "");
        var userStdin = new FileOutputStream(stdinFile);
        var mockedStdin = new FileInputStream(stdinFile);
        System.setIn(mockedStdin);
        store.put("stdinFile", stdinFile);
        store.put("userStdin", userStdin);
        store.put("mockedStdin", mockedStdin);

        var stdoutFile = File.createTempFile("stdout", "");
        var userStdout = new FileInputStream(stdoutFile);
        var mockedStdout = new PrintStream(new FileOutputStream(stdoutFile));
        System.setOut(mockedStdout);
        store.put("stdoutFile", stdoutFile);
        store.put("userStdout", userStdout);
        store.put("mockedOutput", mockedStdout);
    }

    @Override
    public void afterEach(ExtensionContext context) throws Exception {
        var store = context.getStore(NS);

        System.setIn(stdin);
        var userStdin = store.get("userStdin", OutputStream.class);
        userStdin.close();
        var mockedStdin = store.get("mockedStdin", InputStream.class);
        mockedStdin.close();
        var stdinFile = store.get("stdinFile", File.class);
        if (!stdinFile.delete()) throw new IOException(String.format("failed to delete file '%s'", stdinFile.getName()));

        System.setOut(stdout);
        var userStdout = store.get("userStdout", InputStream.class);
        userStdout.close();
        var mockedStdout = store.get("mockedOutput", PrintStream.class);
        mockedStdout.close();
        var stdoutFile = store.get("stdoutFile", File.class);
        if (!stdoutFile.delete()) throw new IOException(String.format("failed to delete file '%s'", stdoutFile.getName()));
    }

    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return parameterContext.getParameter().getType().equals(InputStream.class) || parameterContext.getParameter().getType().equals(OutputStream.class);
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        var store = extensionContext.getStore(NS);
        if (parameterContext.getParameter().getType().equals(InputStream.class)) {
            return store.get("userStdout");
        } else if (parameterContext.getParameter().getType().equals(OutputStream.class)) {
            return store.get("userStdin");
        }

        throw new ParameterResolutionException("");
    }
}
