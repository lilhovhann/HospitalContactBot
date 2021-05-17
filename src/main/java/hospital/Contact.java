package hospital;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.telegram.telegrambots.meta.TelegramBotsApi;

import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

/**
 *
 * @author lilit
 */
@SpringBootApplication
@EnableMongoRepositories("hospital.repositories")
@ComponentScan(basePackages = {"hospital"})
@EntityScan("hospital.domain")
@EnableAsync
public class Contact {

    public static void main(String[] args) {
        
        SpringApplication.run(Contact.class, args);
      
//       
//            TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
//        try {
//            telegramBotsApi.registerBot(new Bot());
//          
//        } catch (TelegramApiException e) {
//            e.printStackTrace();
//        }
    }

}
