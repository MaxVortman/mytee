package max.shamray.tee;

import java.io.OutputStream;

public class CliTeeCommand implements ITeeCommandObject {

    private Cli cli;

    public CliTeeCommand(Cli cli){
        this.cli = cli;
    }


    @Override
    public OutputStream[] getFileStreams() {
        return new OutputStream[0];
    }

    @Override
    public boolean isAppend() {
        return false;
    }

    @Override
    public boolean isIgnoreInterrupts() {
        return false;
    }
}
