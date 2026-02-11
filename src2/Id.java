import java.io.*;

public class IdManager {

    private static final String ID_FILE = "id.txt";

    private static long currentId = 0;

    // === get_next_id ===
    public static long getNextId() {
        currentId++;
        return currentId;
    }

    // === set_id ===
    public static void setId(long id) {
        currentId = id;
    }

    // === save_id ===
    public static void saveId() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ID_FILE))) {
            bw.write(Long.toString(currentId));
        } catch (IOException e) {
            System.err.println("Error saving ID: " + e.getMessage());
        }
    }

    // === load_id ===
    public static void loadId() {
        File f = new File(ID_FILE);

        if (!f.exists()) {
            currentId = 0;
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line = br.readLine();
            if (line != null && !line.isEmpty()) {
                currentId = Long.parseLong(line.trim());
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error loading ID: " + e.getMessage());
            currentId = 0;
        }
    }
}
