package chat.system;

public class interfaces {
    interface StringProducer
    {
        public void addConsumer(StringConsumer sc);
        public void removeConsumer(StringConsumer sc);
    }
    interface StringConsumer
    {
        public void consume(String str); //
    }
}