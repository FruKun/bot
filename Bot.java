import java.util.Scanner;

public class Bot {
    private boolean isRunning;
    private boolean start = false;
    private boolean stepbystep = false;

    public Bot() {
        isRunning = true;
    }

    public boolean getisRunning() {
        return isRunning;
    }

    public String start() {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        if (input.equals("/simple")) {
            if (start == false) {
                stepbystep = false;
                start = true;
                return "write me line";
            }
            if (start = true)
                return "bot is working, write me line";
        }
        if (input.equals("/stepbystep")) {
            if (stepbystep == false) {
                start = false;
                stepbystep = true;
                return "write me line";
            }
            if (stepbystep == true) {
                return "stepbystep is on, write me line";
            }
        }
        if (input.equals("/stop")) {
            isRunning = false;
            return "bot stopped";
        }
        if (input.equals("/help"))
            return "commands: /simple, /help, /stop\nI can say what type of thing you write to me\n/simple - check the whole line\n/stepbystep - check symbol by symbol";
        if (start == true) {
            if (new Scanner(input).hasNextLong() == true) {
                return input + " - int";
            }
            if (new Scanner(input).hasNextDouble() == true) {
                return input + " - float";
            }
            if (new Scanner(input).hasNextLine() == true) {
                return input + " - String";
            }
            return "commands: /simple, /stepbystep, /help, /stop";
        }
        if (stepbystep == true) {
            String numb = "";
            String str = "";
            int count = 0;
            String out = "";
            for (String i : input.split("")) {
                if (new Scanner(i).hasNextLong() == true) {
                    numb += i;
                    continue;
                }
                if (i.equals(" ")) {
                    count += 1;
                    continue;
                }
                if (new Scanner(input).hasNextLine() == true) {
                    str += i;
                    continue;
                }
            }
            if (numb.length() > 0)
                out += numb + " - int\n";
            if (str.length() > 0)
                out += str + " - char\n";
            if (count > 0)
                out += "\" \" - " + count;
            return out;
        }
        return "commands: /simple, /stepbystep, /help, /stop";

    }
}