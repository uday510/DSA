package design;


import java.util.ArrayDeque;

class BrowserHistory {

    ArrayDeque<String> future;
    ArrayDeque<String> history;
    String current;

    public BrowserHistory(String homepage) {
        future = new ArrayDeque<>();
        history = new ArrayDeque<>();
        current = homepage;
    }

    public void visit(String url) {
        history.push(current);
        current = url;
        future = new ArrayDeque<>();
    }

    public String back(int steps) {
        while (steps > 0 && !history.isEmpty()) {
            future.push(current);
            current = history.pop();
            steps--;
        }

        return current;
    }

    public String forward(int steps) {
        while (steps > 0 && !future.isEmpty()) {
            history.push(current);
            current = future.pop();
            steps--;
        }

        return current;
    }
}


public class DesignBrowserHistory {

}
