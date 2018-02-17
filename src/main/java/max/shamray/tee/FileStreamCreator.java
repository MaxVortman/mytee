package max.shamray.tee;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileStreamCreator {
    public static List<OutputStream> Create(String[] fileStringPaths, boolean isAppend, boolean isIgnoreErrors) throws FileNotFoundException, InvalidPathException {

        List<Path> filePaths = ConvertToPath(fileStringPaths, isIgnoreErrors);
        List<OutputStream> outputStreams = new ArrayList<>();

        for (Path path : filePaths) {
            try {
                outputStreams.add(new FileOutputStream(path.toFile(), isAppend));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                if(isIgnoreErrors)
                    continue;
                throw e;
            }
        }
        return outputStreams;
    }

    private static List<Path> ConvertToPath(String[] filePaths, boolean isIgnoreErrors) throws InvalidPathException {
        List<Path> paths = new ArrayList<>();
        for (String path : filePaths) {
            try {

                paths.add(Paths.get(path));
            }
            catch (InvalidPathException e){
                e.printStackTrace();
                if(isIgnoreErrors)
                    continue;
                throw e;
            }
        }
        return paths;
    }
}
