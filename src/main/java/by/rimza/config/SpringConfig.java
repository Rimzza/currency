package by.rimza.config;

import by.rimza.bot.CurrencyBot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@ComponentScan("by.rimza")
@PropertySource("classpath:bot.properties")
public class SpringConfig {

    private final Environment environment;


    @Autowired
    public SpringConfig(Environment environment) {
        this.environment = environment;
    }

    @Bean
    public  CurrencyBot currencyBot () {
        return new CurrencyBot(environment.getProperty("bot_token"), environment.getProperty("bot_name"));
    }




}
