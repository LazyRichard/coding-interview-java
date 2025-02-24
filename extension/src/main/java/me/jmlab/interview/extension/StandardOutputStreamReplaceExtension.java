package me.jmlab.interview.extension;

import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

public class StandardOutputStreamReplaceExtension implements ParameterResolver {

    private static final PrintStream stdout = System.out;

    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext)
            throws ParameterResolutionException {
        return parameterContext.getParameter().getType() == OutputStreamReplacer.class;
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext context)
            throws ParameterResolutionException {

        return new OutputStreamReplacer() {

            private PrintStream stream;

            @Override
            public OutputStreamReplacer replace(OutputStream stream) {
                this.stream = new PrintStream(stream);

                System.setOut(this.stream);

                return this;
            }

            @Override
            public void close() {
                System.setOut(stdout);

                this.stream.close();
            }
        };
    }
}
