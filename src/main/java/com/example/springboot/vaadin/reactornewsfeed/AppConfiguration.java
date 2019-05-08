package com.example.springboot.vaadin.reactornewsfeed;

import com.example.springboot.vaadin.reactornewsfeed.domain.NewsMessage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;
import reactor.core.publisher.UnicastProcessor;

import java.time.LocalDateTime;

@Configuration
public class AppConfiguration {
    private final String NEWS_MSG_1 = "Science Channel --> First-Ever Image of Black Hole Revealed";
    private final String NEWS_MSG_2 = "Science Channel --> A 2014 meteor may have come from another solar system";
    private final String NEWS_MSG_3 = "Tech Channel --> PlayStation 5: Sony reveals first details of next-gen console";

    @Bean
    UnicastProcessor<NewsMessage> publisher(){
        UnicastProcessor<NewsMessage> publisher = UnicastProcessor.create();

        // send some news as example
        publisher.onNext(new NewsMessage(LocalDateTime.now(), NEWS_MSG_1));
        publisher.onNext(new NewsMessage(LocalDateTime.now(), NEWS_MSG_2));
        publisher.onNext(new NewsMessage(LocalDateTime.now(), NEWS_MSG_3));

        return  publisher;
    }
    @Bean
    Flux<NewsMessage> newsMessageFlux(UnicastProcessor<NewsMessage> publisher) {
        return publisher.replay(30).autoConnect();
    }
}