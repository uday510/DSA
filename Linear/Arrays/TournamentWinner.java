import java.util.ArrayList;
import java.util.HashMap;

public class TournamentWinner {
    public static int HOME_TEAM_WON = 1;
    public static void main(String[] args) {

        ArrayList<ArrayList<String>> competitions = new ArrayList<>();
        ArrayList<Integer> results = new ArrayList<>();

        System.out.println(tournamentWinner(competitions, results));
    }
    public static String tournamentWinner(ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {
        String currentBestTeam = "";

        HashMap<String, Integer> scores = new HashMap<>();
        scores.put(currentBestTeam, 0);
        for(int idx = 0; idx < competitions.size(); idx++) {
            ArrayList<String> competition =  competitions.get(idx);
            int result = results.get(idx);

            String homeTeam = competition.get(0);
            String awayTeam = competition.get(1);

            String winningTeam = (result == HOME_TEAM_WON) ? homeTeam: awayTeam;
            updateScores(winningTeam, 3, scores);
        }
        return currentBestTeam;
    }
    public static void updateScores(String team, int points, HashMap<String, Integer> scores) {
        if(!scores.containsKey(team)) scores.put(team, 0);

        scores.put(team, scores.get(team) + points);
    }
}
