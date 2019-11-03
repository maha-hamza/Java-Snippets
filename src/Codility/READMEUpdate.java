package Codility;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class READMEUpdate {
    public static void main(String[] args) throws IOException {

        var titles = parseFile("./src/Codility");
        updateReadMe("./README.md", titles);

    }

    private static List<String> parseFile(String path) throws IOException {
        return Files.list(Paths.get(path))
                .map(Path::getFileName)
                .map(Path::toString)
                .collect(Collectors.toList());
    }

    private static void updateReadMe(String path, List<String> titles) throws IOException {

        var formattedTitles = titles.stream()
                .map(title -> String.format("<li>%s</li>", title))
                .collect(Collectors.joining("\n"));

        var lines = Files.readAllLines(Paths.get(path));
        StringBuilder newContent = new StringBuilder();
        lines.forEach(line -> {
            if (!line.trim().startsWith("<li>")) {
                newContent.append(String.format("%s\n", line));
            } else {
                newContent.append("_");
            }
        });
        newContent.replace(
                newContent.indexOf("_"),
                newContent.lastIndexOf("_") + 1,
                String.format("%s\n", formattedTitles)
        );

        Files.write(Paths.get(path), newContent.toString().getBytes());
    }
}
