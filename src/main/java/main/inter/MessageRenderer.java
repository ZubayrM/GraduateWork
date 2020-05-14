package main.inter;

public interface MessageRenderer {

    void rederer();

    void setMessageProvider(MessageProvider provider);

    MessageProvider getMessageProvider();

}
