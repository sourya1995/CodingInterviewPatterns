import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

class Server {
    String name;
    int weight;
    boolean isHealthy;

    Server(String name, int weight) {
        this.name = name;
        this.weight = weight;
        this.isHealthy = true;
    }

    boolean isHealthy() {
        return isHealthy;
    }

    void markUnhealthy() {
        isHealthy = false;
    }

    void markHealthy() {
        isHealthy = true;
    }
}

public class StatefulWRRLoadBalancer {
    private List<Server> servers;
    private AtomicInteger currentIndex;

    public StatefulWRRLoadBalancer() {
        servers = new ArrayList<>();
        currentIndex = new AtomicInteger(0);
    }

    public void addServer(Server server) {
        servers.add(server);
    }

    public Server getNextHealthyServer() {
        if (servers.isEmpty()) {
            return null;
        }

        int totalWeight = servers.stream().filter(Server::isHealthy).mapToInt(server -> server.weight).sum();

        int currentWeight = 0;
        Server selectedServer = null;

        while (selectedServer == null) {
            int index = currentIndex.getAndIncrement() % servers.size();
            Server server = servers.get(index);

            if (server.isHealthy()) {
                currentWeight += server.weight;
                if (currentWeight >= totalWeight) {
                    selectedServer = server;
                }
            }
        }

        return selectedServer;
    }

    public void markServerUnhealthy(Server server) {
        server.markUnhealthy();
    }

    public void markServerHealthy(Server server) {
        server.markHealthy();
    }
}