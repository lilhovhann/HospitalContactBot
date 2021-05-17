package hospital;

import hospital.controllers.DoctorController;
import hospital.domain.Doctor;
import hospital.services.DoctorService;
import java.util.Optional;
import java.util.logging.Level;
import javax.annotation.PostConstruct;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

/**
 *
 * @author lilith
 */
@Component
public class Bot extends TelegramLongPollingBot {

    @Autowired
    DoctorService doctorService;

    private static final Logger log = LoggerFactory.getLogger(Bot.class);

    @Override
    public String getBotToken() {
        return "1786560499:AAFMK2DVf8B5xjPgeN0Dx9DR-BJDxo75ZBw";
    }

    @Override
    public String getBotUsername() {
        return "hospitalContact_bot";
    }

    @Override
    public void onUpdateReceived(Update update) {
        System.out.println(update.getMessage().getText());
        long chat_id = update.getMessage().getChatId();
        if (update.hasMessage()) {
            Message message = update.getMessage();

            String messageText = update.getMessage().getText();

            if (messageText.startsWith("/contact")) {
                String doctorName = "";
                for (int i = 0; i < messageText.length(); i++) {
                    if (i >= 9) {
                        doctorName += messageText.charAt(i);
                        System.out.println(doctorName);
                    }
                }
                Optional<Doctor> doctor = doctorService.findByName(doctorName);
                if (doctor.isPresent()) {
                    Doctor exsistingDoctor = doctor.get();

                    sendMsg(doctorName + "'s phone number is " + exsistingDoctor.getPhone(), chat_id);
                }
                doctorName = "";

              


            }

        }

    }

    @SneakyThrows
    public synchronized void sendMsg(String s, long chat_id) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chat_id + "");
        sendMessage.setText(s);
        sendMessage.setReplyMarkup(null);
        execute(sendMessage);
    }

    @PostConstruct
    public void start() {
        log.info("Bot has started. Let's have fun");
    }

}
