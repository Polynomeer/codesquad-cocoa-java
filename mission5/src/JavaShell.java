import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class JavaShell {

    public static final int MAX_CMD = 30;
    public static final int ERROR_CODE_01 = 1; // exceeed command length
    public static boolean EXIT_CODE = false;

    public static void main(String[] args) throws IOException, InterruptedException {
        JavaShell javaShell = new JavaShell();
        Scanner sc = new Scanner(System.in);

        while (!EXIT_CODE) {
            List<String> command = new ArrayList<>();
            String path = System.getProperty("user.dir");
            System.out.print(path + "> ");

            String input = sc.nextLine();
            StringTokenizer st = new StringTokenizer(input, " ");

            while (st.hasMoreTokens()) {
                String token = st.nextToken().toString();
                command.add(token);
            }

            int isError = javaShell.checkValidity(command);
            if (isError != 0) continue;
            if (EXIT_CODE == true) break;

            javaShell.runByProcessBuilder(command);
        }
    }

    public int checkValidity(List<String> command) {
        if (command.size() > MAX_CMD) {
            System.out.println("Exceeded command maximum length..");
            return ERROR_CODE_01;
        }
        if (command.get(0).equals("q")) EXIT_CODE = true;
        return 0; // no error
    }

    public void runByProcessBuilder(List<String> command) throws IOException, InterruptedException {
        ProcessBuilder builder = new ProcessBuilder(command);
        Process process = builder.start();
        printStream(process);
    }

    private void printStream(Process process) throws IOException, InterruptedException {
        process.waitFor();
        try (InputStream processOut = process.getInputStream()) {
            copyToOutput(processOut, System.out);
        }
    }

    public void copyToOutput(InputStream input, OutputStream output) throws IOException {
        byte[] buffer = new byte[1024];
        int n = 0;
        while ((n = input.read(buffer)) != -1) {
            output.write(buffer, 0, n);
        }
    }
}
