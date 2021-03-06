package com.jmsql.starter;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.PosixParser;

public class CLIOptionsUtils {
    public static final Options options     = new Options();
    public static CommandLine   commandLine = null;

    public static Options createOptions() {
        options.addOption("help","help", false, "prints help");
        Option u = OptionBuilder.withArgName("u").withLongOpt("user").hasArg().withDescription("username for database e.g. root").create("u");
        Option h = OptionBuilder.withArgName("h").withLongOpt("ip").hasArg().withDescription("ip address for database").create("h");
        Option p = OptionBuilder.withArgName("p").withLongOpt("password").hasArg().withDescription("password").create("p");
        Option P = OptionBuilder.withArgName("P").withLongOpt("port").hasArg().withDescription("Port ").create("P");
        Option d = OptionBuilder.withArgName("d").withLongOpt("dbname").hasArg().withDescription("database name").create("d");
        options.addOption(u);
        options.addOption(h);
        options.addOption(p);
        options.addOption(P);
        options.addOption(d);
        return options;

    }

    public static void addOptions(Option option) {
        options.addOption(option);
    }

    public static void outputCommandLineHelp(final Options options) {
        final HelpFormatter formater = new HelpFormatter();
        formater.printHelp("This will show the arguments you can provide.", options);
    }

    public static CommandLine parseCLIArgs(String[] args) throws ParseException {
        CommandLineParser parser = new PosixParser();
        commandLine = parser.parse(options, args, true);
        return commandLine;
    }

}
