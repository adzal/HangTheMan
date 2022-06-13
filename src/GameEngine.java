import java.util.ArrayList;

public class GameEngine {
    private ArrayList<String> words = new ArrayList<>();
    private String previousWrongGuesses = "";
    private String previousCorrectGuesses = "";
    private String selectedWord = "";
    private String currentStatus = "";
    private String message = "";
    private int trys = 0;
    private Boolean isGameOver = false;
    private Boolean isWinner;

    public Boolean getIsWinner() {
        return isWinner;
    }

    public String getMessage() {
        return message;
    }

    public boolean Over() {
        return isGameOver;
    }

    public GameEngine(ArrayList<String> words) {
        this.words = words;
    }

    public String getCurrentStatus() {
        return currentStatus;
    }

    public int getTrys() {
        return trys;
    }

    public void ChooseWord() {
        int index = (int) (Math.random() * words.size());
        selectedWord = words.get(index).toLowerCase().trim();
        UpdateStatus();
    }

    private void UpdateStatus() {
        char[] charArr = selectedWord.toCharArray();
        currentStatus = "";
        boolean isAnyWrong = false;
        for (char letter : charArr) {
            if (letter == ' ') {
                currentStatus += "  ";
            } else if (previousCorrectGuesses.indexOf(letter) >= 0) {
                currentStatus += letter + " ";
            } else {
                currentStatus += "_" + " ";
                isAnyWrong = true;
            }
        }

        if (!isAnyWrong) {
            gameOver(true, "You've won, Bravo!!");
        }
    }

    public String getPreviousWrongGuesses() {
        //Affiche les derniers essayes
        char[] charArr = previousWrongGuesses.toCharArray();
        String retVal = "";
        //mit un espace entre chaque lettre
        for (char element : charArr) {
            retVal += element + " ";
        }
        return retVal;
    }

    public void MakeGuess(String guessString) {
        char[] charArr = guessString.toCharArray();
        message = "";

        //On peut saisir plusieurs letters donc boucle jusqu'a la fin
        for (char guess : charArr) {
            int pos = selectedWord.indexOf(guess);

            //Si on a déjà fait cette lettre ignore la
            if ((previousWrongGuesses + previousCorrectGuesses).indexOf(guess) >= 0) {
                message = "you've already guessed that...";
            } else {
                //pas trouvé
                if (pos == -1) {
                    previousWrongGuesses += guess;
                    trys++;
                }

                if (pos >= 0) {
                    previousCorrectGuesses += guess;
                    UpdateStatus();
                }

                //Trop tard, on a perdu
                if (trys == 6) {
                    gameOver(false, "You've been hung.. answer was (" + selectedWord + ")");
                }

                //si le joue est fini sort la boucle
                if (isGameOver) {
                    break;
                }
            }
        }
    }

    private void gameOver(Boolean isWinner, String message) {
        isGameOver = true;
        this.isWinner = isWinner;
        this.message = message;
    }
}
