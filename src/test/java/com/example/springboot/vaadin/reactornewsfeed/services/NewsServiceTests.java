package com.example.springboot.vaadin.reactornewsfeed.services;

import com.example.springboot.vaadin.reactornewsfeed.domain.NewsMessage;
import org.junit.Before;
import org.junit.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.UnicastProcessor;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class NewsServiceTests {
    private final String NEWS_MSG_SEND = "Science Channel --> First-Ever Image of Black Hole Revealed";

    private NewsService newsService;
    private List<NewsMessage> newsMessageList;
    private UnicastProcessor<NewsMessage> publisher;
    private Flux<NewsMessage> newsMessageFlux;

    @Before
    public void setup(){
        publisher = UnicastProcessor.create();
        newsMessageFlux = publisher.replay(30).autoConnect();
        newsService = new NewsServiceImpl(publisher, newsMessageFlux);
        newsMessageList = new ArrayList<>();
    }

    @Test
    public void givenNewsMsg_whenNewsMsgSend_ThenTheReceiveNewsMsgIsTheSame(){

        // given a news message
        NewsMessage newsMessageSend = new NewsMessage(LocalDateTime.now(), NEWS_MSG_SEND);

        // when the news is send
        newsService.onNext(newsMessageSend);

        // then the receive news message is the same one
        newsService.subscribe(newsMessageList::add);
        NewsMessage newsMessageRecive = newsMessageList.get(0);

        assertEquals(newsMessageSend, newsMessageRecive);
    }

}
