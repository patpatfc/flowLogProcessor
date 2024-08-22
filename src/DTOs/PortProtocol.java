package DTOs;

public class PortProtocol {
    String port;
    String protocol;

    public PortProtocol(String port, String protocol) {
        this.port = port;
        this.protocol = protocol;
    }

    @Override
    public boolean equals(Object o) {
        PortProtocol portProtocol = (PortProtocol) o;
        if (portProtocol.port.equals(port) && portProtocol.protocol.equals(protocol)) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return port.hashCode() * protocol.hashCode();
    }

    @Override
    public String toString() {
        return port + "," + protocol;
    }
}
