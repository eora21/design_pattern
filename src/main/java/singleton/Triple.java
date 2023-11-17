package singleton;

public enum Triple {
    ALPHA,
    BETA,
    GAMMA;

    public Triple getInstance(String instanceName) {
        return Triple.valueOf(instanceName);
    }
}
