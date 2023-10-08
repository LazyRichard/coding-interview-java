package me.jmlab.coding.test.fixture;

import java.io.OutputStream;

public interface OutputStreamReplacer extends AutoCloseable {

    OutputStreamReplacer replace(OutputStream stream);

    @Override
    void close();
}
