
public class Bot {
    private boolean isRunning;
    private boolean start;
    private boolean stepbystep;

    public Bot() {
        isRunning = true;
        start = false;
        stepbystep = false;
    }

    public boolean getisRunning() {
        return isRunning;
    }

    private boolean isInt(String a) {
        try {
            Integer.parseInt(a);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isDouble(String a) {
        try {
            Double.parseDouble(a);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public String start(String input) {

        if (input.equals("/simple")) {
            if (start == false) {
                stepbystep = false;
                start = true;
                return "write me line";
            }
            if (start)
                return "simple is on, write me line";
        }
        if (input.equals("/stepbystep")) {
            if (stepbystep == false) {
                start = false;
                stepbystep = true;
                return "write me line";
            }
            if (stepbystep) {
                return "stepbystep is on, write me line";
            }
        }
        if (input.equals("/stop")) {
            isRunning = false;
            return "bot stopped";
        }
        if (input.equals("/help"))
            return "commands: /simple, /stepbystep, /help, /stop\nI can say what type of thing you write to me\n/simple - check the whole line\n/stepbystep - check symbol by symbol";
        if (start) {
            if (isInt(input)) {
                return Integer.parseInt(input) + " - int";
            }
            if (isDouble(input)) {
                return Double.parseDouble(input) + " - double";
            }
            if (!input.isEmpty()) {
                return input + " - String";
            }
            return "commands: /simple, /stepbystep, /help, /stop";
        }
        if (stepbystep) {
            String numb = "";
            String str = "";
            int count = 0;
            String out = "";
            for (String i : input.split("")) {
                if (isInt(i)) {
                    numb += i;
                    continue;
                }
                if (i.equals(" ")) {
                    count += 1;
                    continue;
                }
                if (!i.isEmpty()) {
                    str += i;
                    continue;
                }
            }
            if (!numb.isEmpty())
                out += numb + " - int\n";
            if (!str.isEmpty())
                out += str + " - char\n";
            if (count > 0)
                out += "\" \" - " + count;
            if (!out.isEmpty())
                return out;
            return "commands: /simple, /stepbystep, /help, /stop";
        }
        return "commands: /simple, /stepbystep, /help, /stop";

    }
}