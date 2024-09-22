import java.util.Scanner ;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean playAgain;

        do {

            System.out.println("Velkommen til gæt et tal");
            int dif = chooseDifficulty(input);

            int ans = generateRandomNumber(dif);

            System.out.println("Indtast dit gæt");

            checkAnswer(ans, input);

            System.out.println("Tillykke, du gættede tallet") ;

            playAgain = handlePlayAgain(input);
        } while (playAgain);

    }

    public static int chooseDifficulty(Scanner input) {
        System.out.println("Indtast sværhedsgrad; 1, 2 eller 3");
        return input.nextInt();
    }

    public static int generateRandomNumber(int difficulty) {
        if (difficulty == 1) {
            System.out.println("Gæt et tal mellem 0 og 10");
            return (int) (Math.random() * 11);
        } else if (difficulty == 2) {
            System.out.println("Gæt et tal mellem 0 og 20");
            return (int) (Math.random() * 21);
        } else {
            System.out.println("Gæt et tal mellem 0 og 100");
            return (int) (Math.random() * 101);
        }
    }

    public static void checkAnswer(int ans, Scanner input) {
        int guess = input.nextInt();

        while (guess != ans) {
            if (guess < ans) {
                System.out.println("Dit gæt er for lavt - prøv igen");
                guess = input.nextInt();
            } else {
                System.out.println("Dit gæt er for højt - prøv igen");
                guess = input.nextInt();
            }
        }
    }

    public static boolean handlePlayAgain(Scanner input) {
        System.out.println("Vil du spille igen - ja/nej");

        String play = input.next().toLowerCase();

        switch (play) {
            case "ja":
                System.out.println("Alrighty then");
                return true;


            case "nej":
                System.out.println("Farvel og tak");
                return false;

            default:
                System.out.println("Ugyldigt valg - farvel");
                return false;
        }
    }
}
