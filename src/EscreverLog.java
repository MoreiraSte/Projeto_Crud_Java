import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

public class EscreverLog {

    public void escrever(ArrayList logs) throws IOException {

        Path log = Paths.get("cadastros.txt");
        if(Files.exists(log)) {
            Files.write(Paths.get("cadastros.txt"), logs, StandardCharsets.UTF_8, StandardOpenOption.APPEND);
        }
        else{
            Files.write(log,logs, StandardCharsets.UTF_8);
        }


    }

}