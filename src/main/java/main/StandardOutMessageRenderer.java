package main;

import main.inter.MessageProvider;
import main.inter.MessageRenderer;

import java.lang.reflect.Executable;

public class StandardOutMessageRenderer implements MessageRenderer {

    private MessageProvider provider;

    @Override
    public void rederer() {
        if (provider == null){
            throw new RuntimeException("no");
        }
        System.out.println(provider.getMessage());

    }

    @Override
    public void setMessageProvider(MessageProvider provider) {
        this.provider = provider;
    }

    @Override
    public MessageProvider getMessageProvider() {
        return this.provider;
    }
}
