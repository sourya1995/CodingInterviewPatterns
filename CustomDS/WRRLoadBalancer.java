import java.util.ArrayList;
import java.util.List;

class Server {
    String name;
    int weight;

    Server(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }
}

public class WRRLoadBalancer {
    private List<Server> servers;
    private int currentIndex;

    public WRRLoadBalancer() {
        servers = new ArrayList<>();
        currentIndex = 0;
    }

    public void addServer(Server server) {
        servers.add(server);
    }

    public Server getNextServer() {
        if (servers.isEmpty()) {
            return null;
        }

        int totalWeight = 0;
        for (Server server : servers) {
            totalWeight += server.weight;
        }

        int currentWeight = 0;
        Server selectedServer = null;

        while (selectedServer == null) {
            currentIndex = (currentIndex + 1) % servers.size();
            Server server = servers.get(currentIndex);
            currentWeight += server.weight;

            if (currentWeight >= totalWeight) {
                selectedServer = server;
            }
        }

        return selectedServer;
    }
}
