import max.shamray.tee.Cli;
import max.shamray.tee.CliTeeCommand;
import max.shamray.tee.ITeeCommandObject;
import max.shamray.tee.TeeProcess;
import java.io.IOException;
import java.nio.file.InvalidPathException;

public class Main {
    public static void main(String[] args) {
        Cli cli = new Cli();
        if(cli.tryParse(args)) {
            try {
                ITeeCommandObject teeCommand = new CliTeeCommand(cli);
                TeeProcess teeProcess = new TeeProcess(teeCommand, System.in);
                teeProcess.proceed();
            } catch (InvalidPathException | IOException e) {
                e.printStackTrace();
                System.out.print(e.getMessage());
            }
        }
    }
}
