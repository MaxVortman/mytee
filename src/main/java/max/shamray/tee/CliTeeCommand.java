package max.shamray.tee;

import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.nio.file.InvalidPathException;
import java.util.List;

public class CliTeeCommand implements ITeeCommandObject {

    private boolean isAppend;
    private boolean isIgnore;
    private List<OutputStream> fileStreams;

    public CliTeeCommand(Cli cli) throws FileNotFoundException, InvalidPathException {
        isAppend = cli.hasAppendOption();
        isIgnore = cli.hasIgnoreOption();
        fileStreams = FileStreamCreator.create(cli.getFilePaths(), isAppend, isIgnore);

    }


    @Override
    public List<OutputStream> getFileStreams() {
        return fileStreams;
    }

    @Override
    public boolean isAppend() {
        return isAppend;
    }

    @Override
    public boolean isIgnoreInterrupts() {
        return isIgnore;
    }
}
