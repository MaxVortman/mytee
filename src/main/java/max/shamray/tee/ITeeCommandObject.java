package max.shamray.tee;

import java.io.OutputStream;

public interface ITeeCommandObject {
    public OutputStream[] getFileStreams();
    public boolean isAppend();
    public boolean isIgnoreInterrupts();
}
