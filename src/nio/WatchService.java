package nio;

import java.io.IOException;
import java.nio.file.*;

public class WatchService {
    private static final String HOME_DIR = "D:\\Java\\javacore-trainning\\Java7Feature";
    public static void main(String[] args) throws IOException, InterruptedException {
        directoryWatchService();
    }

    private static void directoryWatchService() throws IOException, InterruptedException {
        java.nio.file.WatchService tracker = FileSystems.getDefault().newWatchService();
        Path path = Paths.get(HOME_DIR);
        path.register(tracker, StandardWatchEventKinds.ENTRY_CREATE,
                StandardWatchEventKinds.ENTRY_DELETE, StandardWatchEventKinds.ENTRY_MODIFY);
        boolean poll = true;
        WatchKey key = tracker.take();
        System.out.println("Tracking Java7Feature directory...");
        while (poll){

            for(WatchEvent<?> event : key.pollEvents()) {
                System.out.println("Event kind : " + event.kind() + " - for the file : " + event.context());
            }
            poll = key.reset();
        }
    }
}
