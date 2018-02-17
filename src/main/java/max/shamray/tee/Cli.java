package max.shamray.tee;

import org.apache.commons.cli.*;

public class Cli {


    private static final String HELP = "help";
    private static final String APPEND = "append";
    private static final String IGNORE = "ignore";

    private CommandLine line;
    private HelpFormatter helpFormatter = new HelpFormatter();
    private Options options;

    private static final String HELP_USAGE = "mytee [ -a ] [ -i ] [ File ... ]";
    private static final String HELP_HEADER = "Arguments:\n[ File ... ] One or more files that will receive the tee output";

    public Cli(){
        options = configureOptions();
    }

    private boolean tryPrintHelpOption() {
        if(line.hasOption(HELP)) {
            printHelp();
            return true;
        }
        return false;
    }

    private void printHelp(){
        helpFormatter.printHelp(HELP_USAGE, HELP_HEADER, options, null);
    }

    private Options configureOptions() {
        Options options = new Options();
        options.addOption("a", APPEND, false, "Appends the output to the end of File instead of writing over it.");
        options.addOption("i", IGNORE, false, "Ignores interrupts.");
        options.addOption(null, HELP, false, "Display help information.");
        return options;
    }

    public boolean tryParse(String[] args) {
        CommandLineParser parser = new DefaultParser();

        try {
            line = parser.parse(options, args);
            return !tryPrintHelpOption();
        } catch (ParseException e) {
            System.out.println("Wrong options!");
            printHelp();
            e.printStackTrace();
            return false;
        }
    }

    public boolean hasAppendOption(){
        return line.hasOption(APPEND);
    }

    public boolean hasIgnoreOption(){
        return line.hasOption(IGNORE);
    }

    public String[] getFilePaths(){
        return line.getArgs();
    }

}
