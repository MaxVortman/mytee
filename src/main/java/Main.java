import max.shamray.tee.Cli;
import max.shamray.tee.CliTeeCommand;
import max.shamray.tee.ITeeCommandObject;

public class Main {
    public static void main(String[] args) {
        Cli cli = new Cli();
        if(cli.tryParse(args)) {
            ITeeCommandObject teeCommand = new CliTeeCommand(cli);
        }
    }
}
