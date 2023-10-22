import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hi, i'm the most useful bot\n" +
                "For more information: \"/help\"\n" +
                "For start: \"/simple\" or \"/stepbystep\"\n" +
                "For stop: \"/stop\"");
        Bot bot = new Bot();
        Scanner scan = new Scanner(System.in);
        while (bot.getisRunning()) {
            System.out.println(bot.start(scan.nextLine()));
        }
        scan.close();
    }
}