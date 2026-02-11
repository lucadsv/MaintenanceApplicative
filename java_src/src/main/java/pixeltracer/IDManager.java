package main.java.pixeltracer;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Optional;

public class IDManager {
    public static final String ID_FILE = "id.txt";
    private static long currentId = 0L;

    public static synchronized long getNextId() {
        currentId++;
        return currentId;
    }

    public static synchronized void setId(long id) {
        currentId = id;
    }

    public static synchronized void saveId() throws IOException {
        Files.writeString(Path.of(ID_FILE), Long.toString(currentId), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
    }

    public static synchronized void loadId() {
        try {
            if (Files.exists(Path.of(ID_FILE))) {
                String s = Files.readString(Path.of(ID_FILE)).trim();
                if (!s.isEmpty()) {
                    currentId = Long.parseUnsignedLong(s);
                }
            }
        } catch (Exception e) {
            currentId = 0L;
        }
    }

    public static synchronized Optional<Long> getCurrentId() {
        return Optional.of(currentId);
    }
}