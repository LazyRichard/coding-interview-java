package me.jmlab.interview.extension;

import java.io.OutputStream;

public interface OutputStreamReplacer extends AutoCloseable {

    OutputStreamReplacer replace(OutputStream stream);

    @Override
    void close();
}
