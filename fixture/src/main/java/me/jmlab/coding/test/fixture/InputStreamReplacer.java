package me.jmlab.coding.test.fixture;

import java.io.InputStream;

public interface InputStreamReplacer extends AutoCloseable {

    InputStreamReplacer replace(InputStream stream);

    @Override
    void close();
}
