package CalculusClient;

/**
 * Created by gorkaolalde on 10/2/16.
 */
class Principal {
    private CalculusClient client = new CalculusClient();
    public static void main(String[] args) {
        Principal principal = new Principal();
        principal.exec();
    }
    private void exec() {
        client.runClient();
    }
}
