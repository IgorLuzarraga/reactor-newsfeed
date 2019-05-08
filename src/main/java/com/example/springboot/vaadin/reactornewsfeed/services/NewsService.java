package com.example.springboot.vaadin.reactornewsfeed.services;

import com.example.springboot.vaadin.reactornewsfeed.domain.NewsMessage;

import java.util.function.Consumer;

public interface NewsService {
    public void onNext(NewsMessage newsMessage);
    public void subscribe(Consumer<? super NewsMessage> onNext);
}