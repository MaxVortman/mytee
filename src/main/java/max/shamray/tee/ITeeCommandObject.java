package max.shamray.tee;

import java.io.OutputStream;
import java.util.List;

public interface ITeeCommandObject {
    List<OutputStream> getFileStreams();
    boolean isAppend();
    boolean isIgnoreInterrupts();
}
