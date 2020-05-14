package main;

import main.inter.MessageProvider;

public class HelloWorldMessageProvider implements MessageProvider {
    @Override
    public String getMessage() {
        return "hello";
    }
}
