import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);

    public Main() {
    }

    public static void main(String[] args) {
        String choice = "";
        do {
            System.out.println();
            System.out.println("Let's play Hang The Man, what game do you want?");
            System.out.println("1. Colour Game");
            System.out.println("2. Movies Game");
            System.out.println("3. Movies Stars Game");
            System.out.println();
            System.out.println("Q. Quit");
            System.out.print(">");

            choice = sc.nextLine().toUpperCase();
            switch(choice.charAt(0)) {
                case '1':
                    PlayColorsGame();
                    break;
                case '2':
                    PlayMoviesGame();
                    break;
                case '3':
                    PlayMovieStarsGame();
                    break;
                default:
                    // Invalid input so try again
            }

        } while (!choice.equals("Q"));

        sc.close();
    }

    private static void GameLoop(ArrayList<String> words) {
        GameEngine game = new GameEngine(words);
        game.ChooseWord();

        while (!game.Over()) {
            System.out.print("Give me a letter>");
            String guess = sc.nextLine().toLowerCase();
            game.MakeGuess(guess);

            //Affiche le gibet et les messages
            String[] gallows = getGallows(game.getTrys());
            System.out.println();
            System.out.println(gallows[0] + "\t\tprevious guesses");
            System.out.println(gallows[1] + "\t\t" + game.getPreviousWrongGuesses());
            System.out.println(gallows[2]);
            System.out.println(gallows[3] + "\t\tcurrent status");
            System.out.println(gallows[4] + "\t\t" + game.getCurrentStatus());
            System.out.println(gallows[5]);
            System.out.println(gallows[6]);

            System.out.println(game.getMessage());
        }
    }

    private static String[] getGallows(int trys) {
        String[] gallows = new String[7];
        gallows[0] = "+====+ ";
        gallows[1] = "|/   | ";
        gallows[2] = String.format("|    %s ", trys > 0 ? "O" : " ");
        gallows[3] = String.format("|   %s%s%s", trys > 1 ? "-" : " ", trys > 2 ? "|" : " ", trys > 3 ? "-" : " ");
        gallows[4] = String.format("|   %s %s", trys > 4 ? "/" : " ", trys > 5 ? "\\" : " ");
        gallows[5] = "|      ";
        gallows[6] = "+======";
        return gallows;
    }

    private static void PlayColorsGame() {
        ArrayList<String> colors = new ArrayList<>() {
            {
                add("red");
                add("yellow");
                add("green");
                add("blue");
                add("purple");
                add("black");
                add("white");
                add("orange");
                add("grey");
                add("brown");
            }
        };

        System.out.println("Welcome to Hang the man,\nguess a colour");
        GameLoop(colors);
    }

    private static void PlayMoviesGame() {
        ArrayList<String> movies = new ArrayList<>() {
            {
                add("The Shawshank Redemption");
                add("The Godfather");
                add("The Dark Knight");
                add("Pulp Fiction");
                add("The Good the Bad and the Ugly");
                add("Forrest Gump");
                add("Fight Club");
                add("Inception");
                add("Star Wars");
                add("The Matrix");
                add("Goodfellas");
                add("Seven");
                add("Seven Samurai");
                add("The Silence of the Lambs");
                add("City of God");
                add("Saving Private Ryan");
                add("Life Is Beautiful");
                add("The Green Mile");
                add("Star Wars");
                add("Interstellar");
                add("Back to the Future");
                add("Spirited Away");
                add("Psycho");
                add("The Pianist");
                add("Leon");
                add("Parasite");
                add("The Lion King");
                add("Gladiator");
                add("American History X");
                add("The Usual Suspects");
                add("The Departed");
                add("The Prestige");
                add("Casablanca");
                add("Whiplash");
                add("Untouchable");
                add("Modern Times");
                add("Harakiri");
                add("Once Upon a Time in the West");
                add("Grave of the Fireflies");
                add("Rear Window");
                add("Alien");
                add("City Lights");
                add("Cinema Paradiso");
                add("Memento");
                add("Apocalypse Now");
                add("Everything Everywhere All at Once");
                add("Raiders of the Lost Ark");
                add("Django Unchained");
                add("The Lives of Others");
                add("Sunset");
                add("Paths of Glory");
                add("The Shining");
                add("The Great Dictator");
                add("Witness for the Prosecution");
                add("Aliens");
                add("American Beauty");
                add("The Dark Knight Rises");
                add("Joker");
                add("Oldboy");
                add("Braveheart");
                add("Amadeus");
                add("Toy Story");
                add("Coco");
                add("Das Boot");
                add("Inglourious Basterds");
                add("Princess Mononoke");
                add("Once Upon a Time in America");
                add("Good Will Hunting");
                add("Requiem for a Dream");
                add("Return of the Jedi");
                add("Reservoir Dogs");
                add("Eternal Sunshine of the Spotless Mind");
                add("High and Low");
                add("Citizen Kane");
                add("Capernaum");
                add("Lawrence of Arabia");
                add("The Hunt");
                add("North by Northwest");
                add("Vertigo");
                add("A Clockwork Orange");
            }
        };

        System.out.println("Welcome to Hang the man,\nguess a movie");
        GameLoop(movies);
    }

    private static void PlayMovieStarsGame() {
        ArrayList<String> stars = new ArrayList<>() {
            {
                add("robert de niro");
                add("jack nicholson");
                add("marlon brando");
                add("denzel washington");
                add("katharine hepburn");
                add("humphrey bogart");
                add("meryl streep");
                add("sidney poitier");
                add("clark gable");
                add("ingrid bergman");
                add("tom hanks");
                add("elizabeth taylor");
                add("bette davis");
                add("gregory peck");
                add("leonardo dicaprio");
                add("cate blanchett");
                add("audrey hepburn");
                add("spencer tracy");
                add("kate winslet");
            }
        };

        System.out.println("Welcome to Hang the man,\nguess the name of a movie star");
        GameLoop(stars);
    }
}
