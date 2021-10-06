package ru.salavatdautov.util;

import java.io.IOException;

/**
 * Class for platform specific functions
 */
public class PlatformUtils {
    /**
     * Enumeration with operating systems
     */
    public enum OS {
        WINDOWS,
        LINUX,
        MAC,
        UNKNOWN
    }

    /**
     * Private constructor so you can't create an object.
     */
    private PlatformUtils() {
    }

    /**
     * Find out the current operating system
     *
     * @return result as one of PlatformUtils.OS enum value
     */
    public static OS getOS() {
        String osName = System.getProperty("os.name").toLowerCase();
        if (osName.contains("win")) {
            return OS.WINDOWS;
        } else if (osName.contains("nix") || osName.contains("nux") || osName.contains("aix")) {
            return OS.LINUX;
        } else if (osName.contains("mac")) {
            return OS.MAC;
        }
        return OS.UNKNOWN;
    }

    /**
     * Executes the command in OS and returns its result
     *
     * @param command line with command to be executed
     * @return result as a Tuple<String, String> std input, std error
     */
    public static Tuple<String, String> executeCommand(String command) throws IOException {
        Process process = Runtime.getRuntime().exec(command);
        return new Tuple<>(Streams.toString(process.getInputStream()), Streams.toString(process.getErrorStream()));
    }

    /**
     * Executes the command in OS and returns its result
     *
     * @param command line with command to be executed
     * @return result as a Tuple<String, String> std input, std error
     */
    public static Tuple<String, String> executeCommand(String[] command) throws IOException {
        Process process = Runtime.getRuntime().exec(command);
        return new Tuple<>(Streams.toString(process.getInputStream()), Streams.toString(process.getErrorStream()));
    }

    /**
     * Executes the command in Sh and returns its result
     *
     * @param command line with command to be executed
     * @return result as a Tuple<String, String> std input, std error
     */
    public static Tuple<String, String> executeCommandSh(String command) throws IOException {
        Process process = Runtime.getRuntime().exec(new String[]{"/bin/sh", "-c", command});
        return new Tuple<>(Streams.toString(process.getInputStream()), Streams.toString(process.getErrorStream()));
    }

    /**
     * Executes the command in Sh and returns its result
     *
     * @param command String[] with command to be executed
     * @return result as a Tuple<String, String> std input, std error
     */
    public static Tuple<String, String> executeCommandSh(String[] command) throws IOException {
        Process process = Runtime.getRuntime().exec((String[]) ArrayUtils.concatenate(new String[]{"/bin/sh", "-c"}, command));
        return new Tuple<>(Streams.toString(process.getInputStream()), Streams.toString(process.getErrorStream()));
    }

    /**
     * Executes the command in Cmd.exe and returns its result
     *
     * @param command line with command to be executed
     * @return result as a Tuple<String, String> std input, std error
     */
    public static Tuple<String, String> executeCommandCmd(String command) throws IOException {
        Process process = Runtime.getRuntime().exec(new String[]{"cmd", "/c", command});
        return new Tuple<>(Streams.toString(process.getInputStream()), Streams.toString(process.getErrorStream()));
    }

    /**
     * Executes the command in Cmd.exe and returns its result
     *
     * @param command String[] with command to be executed
     * @return result as a Tuple<String, String> std input, std error
     */
    public static Tuple<String, String> executeCommandCmd(String[] command) throws IOException {
        Process process = Runtime.getRuntime().exec((String[]) ArrayUtils.concatenate(new String[]{"cmd", "/c"}, command));
        return new Tuple<>(Streams.toString(process.getInputStream()), Streams.toString(process.getErrorStream()));
    }
}
