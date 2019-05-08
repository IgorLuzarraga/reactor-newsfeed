package com.example.springboot.vaadin.reactornewsfeed.services;

import com.example.springboot.vaadin.reactornewsfeed.domain.NewsMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.UnicastProcessor;

import java.util.function.Consumer;

@Service
public class NewsServiceImpl implements NewsService {

    private final UnicastProcessor<NewsMessage> publisher;
    private final Flux<NewsMessage> newsMessageFlux;

    @Autowired
    public NewsServiceImpl(UnicastProcessor<NewsMessage> publisher,
                           Flux<NewsMessage> newsMessageFlux) {
        this.publisher = publisher;
        this.newsMessageFlux = newsMessageFlux;
    }

    @Override
    public void onNext(NewsMessage newsMessage){
        publisher.onNext(newsMessage);
    }

    @Override
    public void subscribe(Consumer<? super NewsMessage> onNext) {
        newsMessageFlux.subscribe(onNext);
    }
}
