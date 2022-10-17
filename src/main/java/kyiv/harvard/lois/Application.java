/**
 * @author @liosyk
 * Project name: DataBase4
 * Package name: kyiv.harvard.lois
 * Class: Application
 **/

package kyiv.harvard.lois;

import kyiv.harvard.lois.view.MyView;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

    private final MyView view;

    public Application(MyView view) {
        this.view = view;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        view.show();
    }
}
