public class SecurityAgent {
    private Combination secret;
    private DoorLock lock;

    public SecurityAgent() {
        secret = new Combination(1, 2, 3);
        lock = new DoorLock(secret);
    }

    public DoorLock getDoorLock() {
        return lock;
    }
    
    public void activateDoorLock() {
        lock.activate(secret);
    }
}
