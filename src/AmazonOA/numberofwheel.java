package AmazonOA;

public class numberofwheel {

    public int[] findVehicles(int[] vehicles) {
        for(int i =0; i<vehicles.length;i++) {
            if(vehicles[i]%2 != 0) {
                vehicles[i] = 0;
                continue;
            }
            int numOfWays = vehicles[i]/4 + 1;
            vehicles[i] = numOfWays;
        }
        return vehicles;
    }
}
