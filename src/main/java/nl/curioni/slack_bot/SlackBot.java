package nl.curioni.slack_bot;

import com.slack.api.bolt.App;
import com.slack.api.bolt.servlet.SlackAppServlet;
import jakarta.servlet.annotation.WebServlet;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SlackBot {
    @Bean
    public App initSlackApp() {
        App app = new App();
        app.command("/hello", (req, ctx) -> ctx.ack("Hi there!"));
        return app;
    }
}

@WebServlet("/slack/events")
class SlackAppController extends SlackAppServlet {
    public SlackAppController(App app) {
        super(app);
    }
}