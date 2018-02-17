package max.shamray.tee;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

public class TeeProcess {
    private static final int BUFFER_SIZE = 2048;
    private ITeeCommandObject teeCommand;
    private InputStream inputStream;

    public TeeProcess(ITeeCommandObject teeCommand, InputStream inputStream){

        this.teeCommand = teeCommand;
        this.inputStream = inputStream;
    }

    public void proceed() throws IOException {
        List<OutputStream> outputStreams = teeCommand.getFileStreams();
        outputStreams.add(System.out);

        byte[] buffer = new byte[BUFFER_SIZE];
        int len;
        while ((len = inputStream.read(buffer)) != -1) {
            for (OutputStream outputStream : outputStreams) {
                try {
                    outputStream.write(buffer, 0, len);
                } catch (IOException e) {
                    e.printStackTrace();
                    if (teeCommand.isIgnoreInterrupts())
                        continue;
                    throw e;
                }
            }
        }


        for (int i = 0; i < outputStreams.size() - 1; i++) {
            try {
                outputStreams.get(i).close();
            } catch (IOException e) {
                e.printStackTrace();
                if (teeCommand.isIgnoreInterrupts())
                    continue;
                throw e;
            }
        }
    }
}
