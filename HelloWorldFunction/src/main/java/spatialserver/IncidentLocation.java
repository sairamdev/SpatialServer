package spatialserver;

public class IncidentLocation {
    private double incidentLongitude;
    private double incidentLatitude;
    private double maxQueryDistance;
    private double minQueryDistance;

    public double getIncidentLongitude() {
        return incidentLongitude;
    }

    public void setIncidentLongitude(double incidentLongitude) {
        this.incidentLongitude = incidentLongitude;
    }

    public double getIncidentLatitude() {
        return incidentLatitude;
    }

    public void setIncidentLatitude(double incidentLatitude) {
        this.incidentLatitude = incidentLatitude;
    }

    public double getMaxQueryDistance() {
        return maxQueryDistance;
    }

    public void setMaxQueryDistance(double maxQueryDistance) {
        this.maxQueryDistance = maxQueryDistance;
    }

    public double getMinQueryDistance() {
        return minQueryDistance;
    }

    public void setMinQueryDistance(double minQueryDistance) {
        this.minQueryDistance = minQueryDistance;
    }
}
