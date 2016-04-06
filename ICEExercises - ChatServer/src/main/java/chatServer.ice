module chat {
    interface Listener {
        bool messageNotification(int msgNumber);
    };
    interface ChatServer {
        bool registerListener(Listener* listenerInstance);
        bool deleteListener(Listener* listenerInstance);
        void pushMessage(string message, Listener* associatedListener);
        bool getMessage(int msgNumber, out string message);
    };
};