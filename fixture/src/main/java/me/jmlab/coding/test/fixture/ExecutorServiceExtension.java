package me.jmlab.coding.test.fixture;

import org.junit.jupiter.api.extension.*;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceExtension implements BeforeAllCallback, AfterAllCallback, ParameterResolver {

    private static final ExtensionContext.Namespace ns = ExtensionContext.Namespace.create(ExtensionContext.class);

    @Override
    public void beforeAll(ExtensionContext extensionContext) throws Exception {
        var store = extensionContext.getStore(ns);

        store.put(ExecutorService.class, Executors.newSingleThreadExecutor());
    }

    @Override
    public void afterAll(ExtensionContext extensionContext) throws Exception {
        var store = extensionContext.getStore(ns);

        var service = store.get(ExecutorService.class, ExecutorService.class);

        service.shutdown();
    }

    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return parameterContext.getParameter().getType() == ExecutorService.class;
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        var store = extensionContext.getStore(ns);

        return store.get(ExecutorService.class);
    }
}
