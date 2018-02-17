package max.shamray.tee;

import org.apache.commons.cli.*;

public class Cli {


    private final String HELP = "help";
    private final String APPEND = "append";
    private final String IGNORE = "ignore";

    private CommandLine line;
    private HelpFormatter helpFormatter = new HelpFormatter();

    private final String HELP_USAGE = "mytee [ -a ] [ -i ] [ File ... ]";
    private final String HELP_HEADER = "Arguments:\n[ File ... ] One or more files that will receive the tee output";


    public Cli(String[] args){


        Options options = ConfigureOptions();
        Parse(args, options);
        CheckForHelpOption(options);
    }

    private void CheckForHelpOption(Options options) {
        if(line.hasOption(HELP))
            PrintHelp(options);
    }

    private void PrintHelp(Options options){
        helpFormatter.printHelp(HELP_USAGE, HELP_HEADER, options, null);
    }

    private Options ConfigureOptions() {
        Options options = new Options();
        options.addOption("a", APPEND, false, "Appends the output to the end of File instead of writing over it.");
        options.addOption("i", IGNORE, false, "Ignores interrupts.");
        options.addOption(null, HELP, false, "Display help information.");
        return options;
    }

    private void Parse(String[] args, Options options) {
        CommandLineParser parser = new DefaultParser();

        try {
            line = parser.parse(options, args);

        } catch (ParseException e) {
            System.out.println("Wrong options!");
            PrintHelp(options);
            e.printStackTrace();
        }
    }

    
}
