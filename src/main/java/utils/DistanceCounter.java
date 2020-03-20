package utils;

import model.users.User;

public class DistanceCounter {
    private static double EARTH_RADIUS = 6378.14;

    public static double dagreesToRadian(double angle){
        return (angle * Math.PI) / 180.0;
    }
    public static double getDistance(double dag_latitude_1 ,double dag_longitude_1, double dag_latitude_2, double dag_longitude_2  ){
        double lat_1 = dagreesToRadian( dag_latitude_1 );
        double lng_1 = dagreesToRadian( dag_longitude_1 );
        double lat_2 = dagreesToRadian( dag_latitude_2 );
        double lng_2 = dagreesToRadian( dag_longitude_2 );

        double part_1 =
                ( Math.pow(Math.sin((lat_2 - lat_1) / 2 ), 2) ) +
                        (Math.cos(lat_1) * Math.cos(lat_2) * Math.pow(Math.sin((lng_2 - lng_1) / 2), 2));
        double part_2 = 2 * Math.atan2(Math.sqrt(part_1), Math.sqrt((1 - part_1)));
        return EARTH_RADIUS * part_2;
    }
    public static double getDistance(User user1, User user2 ){
        return getDistance(
                user1.getAddress().getGeo().getLat(),
                user1.getAddress().getGeo().getLng(),
                user2.getAddress().getGeo().getLat(),
                user2.getAddress().getGeo().getLng()
                );
    }
}

