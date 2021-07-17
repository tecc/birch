package me.tecc.birch.core.appenders;

import me.tecc.birch.core.logger.Log;

import java.io.OutputStream;
import java.util.function.Supplier;

public abstract class OutputStreamAppender implements Appender {
    private OutputStream stream;
    private Supplier<OutputStream> supplier;
    
    public OutputStreamAppender(Supplier<OutputStream> supplier) {
        this.supplier = supplier;
    }

    @Override
    public void open() {
        try {
            this.stream = supplier.get();
        } catch (Throwable t) {

        }
    }

    @Override
    public void append(Log line) {

    }

    @Override
    public void close() {

    }
}
