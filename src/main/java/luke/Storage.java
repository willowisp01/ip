package luke;

import java.io.*;
import java.util.ArrayList;

public class Storage implements Serializable {

    private ArrayList<Task> history;

    public Storage() {
        history = new ArrayList<>();
    }

    /**
     * Attempts to save history. (My reference: https://www.baeldung.com/java-serialization)
     * History is saved when exiting the program normally, by using "bye" command.
     *
     * @param file File object to locate the save file.
     * @param tasks An ArrayList of Tasks, as obtained from our TaskList.
     */
    public void saveHistory(File file, ArrayList<Task> tasks) {
        updateHistory(tasks);
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file));
            outputStream.writeObject(this);
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            System.out.println("oops!!!");
        }
    }

    /**
     * Updates the history with the new given tasks.
     *
     * @param tasks The new arrayList of tasks.
     */
    public void updateHistory(ArrayList<Task> tasks) {
        this.history = tasks;
    }

    public ArrayList<Task> getHistory() {
        return history;
    }

    //TODO: is loading history done by history class itself?
}
