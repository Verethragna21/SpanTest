import com.channels.span.Main;
import org.junit.Test;

public class MainTest {

    @Test
    public void readFileTest() {
        String data = "C:\\Users\\jlpca\\Desktop\\games.txt";
        Main.readFile(data);
    }

}
