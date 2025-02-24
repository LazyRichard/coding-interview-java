package me.jmlab.interview.extension;

import java.io.InputStream;
import org.junit.jupiter.api.extension.*;

public class StandardInputStreamReplaceExtension implements ParameterResolver {

    private static final InputStream stdin = System.in;

    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext)
            throws ParameterResolutionException {
        return parameterContext.getParameter().getType() == InputStreamReplacer.class;
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext)
            throws ParameterResolutionException {
        return new InputStreamReplacer() {

            @Override
            public InputStreamReplacer replace(InputStream stream) {
                System.setIn(stream);

                return this;
            }

            @Override
            public void close() {
                System.setIn(stdin);
            }
        };
    }
}
