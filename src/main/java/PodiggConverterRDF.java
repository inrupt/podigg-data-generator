import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

public class PodiggConverterRDF {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        ArrayList<String> trip = new ArrayList<String>();
        ArrayList<String> stop = new ArrayList<String>();
        ArrayList<String> stopTime = new ArrayList<String>();


        trip(trip);
        stop(stop);
        stopTimes(stopTime);
        routes();

        index(trip,stop,stopTime);
    }



    public static ArrayList<String> trip(ArrayList<String> trip) throws IOException {

        String line;
        String tripURL;
        String routeID;
        String serviceID;
        String tripID;



        File myObj = new File("src/main/resources/output/turtle/trip.ttl");
        if (myObj.createNewFile()) {
            System.out.println("File created: " + myObj.getName());
        } else
            System.out.println("File already exists.");

        Path target = Paths.get("src/main/resources/output/turtle/trip.ttl");

        try(BufferedReader in = new BufferedReader(new FileReader("src/main/resources/input/trips.txt"))){

            Files.write(target, "".getBytes(), StandardOpenOption.TRUNCATE_EXISTING);
            while((line = in.readLine())!=null){

                trip.add(line);
                String[] pair = line.split(",");

                tripURL = String.format("<http://www.example/trip/trip.ttl#id=%s>", pair[0]);
                routeID = String.format("\"http://www.example/trip#route_id#%s"+'"', pair[0]);
                serviceID = String.format("\"http://www.example/trip#service_id#%s"+'"', pair[1]);
                tripID = String.format("\"http://www.example/trip#trip_id#%s"+'"', pair[2]);

                Files.write(target, (tripURL + " <http://www.example/trip#route_id> " + routeID + "." + System.lineSeparator()).getBytes(), StandardOpenOption.APPEND);
                Files.write(target, (tripURL + " <http://www.example/trip#service_id> " + serviceID + "." + System.lineSeparator()).getBytes(), StandardOpenOption.APPEND);
                Files.write(target, (tripURL + " <http://www.example/trip#trip_id> " + tripID + "." + System.lineSeparator()).getBytes(), StandardOpenOption.APPEND);
            }
        }
        return trip;
    }

    public static ArrayList<String> stop(ArrayList<String> stop) throws IOException {

        String line;
        String stopURL;
        String stopID;
        String stopName;
        String stopLat;
        String stopLong;

        File myObj = new File("src/main/resources/output/turtle/stop.ttl");
        if (myObj.createNewFile()) {
            System.out.println("File created: " + myObj.getName());
        } else
            System.out.println("File already exists.");

        Path target = Paths.get("src/main/resources/output/turtle/stop.ttl");

        try(BufferedReader in = new BufferedReader(new FileReader("src/main/resources/input/stops.txt"))){

            Files.write(target, "".getBytes(), StandardOpenOption.TRUNCATE_EXISTING);
            while((line = in.readLine())!=null){

                stop.add(line);
                String[] pair = line.split(",");

                stopURL = String.format("<http://www.example/stop/stop.ttl#id=%s>", pair[0]);
                stopID = String.format("\"http://www.example/stop#stop_id#%s"+'"', pair[0]);
                stopName = String.format("\"http://www.example/sto#stop_name#%s"+'"', pair[1]);
                stopLat = String.format("\"http://www.example/sto#stop_lat#%s"+'"', pair[2]);
                stopLong = String.format("\"http://www.example/sto#stop_lon#%s"+'"', pair[3]);

                Files.write(target, (stopURL + " <http://www.example/stop#stop_id> " + stopID + "." + System.lineSeparator()).getBytes(), StandardOpenOption.APPEND);
                Files.write(target, (stopURL + " <http://www.example/stop#stop_name> " + stopName + "." + System.lineSeparator()).getBytes(), StandardOpenOption.APPEND);
                Files.write(target, (stopURL + " <http://www.example/stop#stopLat> " + stopLat + "." + System.lineSeparator()).getBytes(), StandardOpenOption.APPEND);
                Files.write(target, (stopURL + " <http://www.example/stop#stopLong> " + stopLong + "." + System.lineSeparator()).getBytes(), StandardOpenOption.APPEND);
            }
        }
        return stop;
    }

    public static ArrayList<String> stopTimes(ArrayList<String> stopTime) throws IOException {

        String line;
        String tripID;
        String arrivalTime;
        String departureTime;
        String stopID;
        String stopSequence;
        String stopTimeURL;

        File myObj = new File("src/main/resources/output/turtle/stop_time.ttl");
        if (myObj.createNewFile()) {
            System.out.println("File created: " + myObj.getName());
        } else
            System.out.println("File already exists.");

        Path target = Paths.get("src/main/resources/output/turtle/stop_time.ttl");

        try(BufferedReader in = new BufferedReader(new FileReader("src/main/resources/input/stop_times.txt"))){

            Files.write(target, "".getBytes(), StandardOpenOption.TRUNCATE_EXISTING);
            while((line = in.readLine())!=null){

                stopTime.add(line);
                String[] pair = line.split(",");

                stopTimeURL = String.format("<http://www.example/stop_time/stop_time.ttl#id=%s>", pair[3]);
                stopID = String.format("\"http://www.example/stop_time#stop_time_id#%s"+'"', pair[3]);
                tripID = String.format("\"http://www.example/stop_time#time_trip_id#%s"+'"', pair[0]);
                arrivalTime = String.format("\"http://www.example/stop_time#arrival_time#%s"+'"', pair[1]);
                departureTime = String.format("\"http://www.example/stop_time#departure_time#%s"+'"', pair[2]);
                stopSequence = String.format("\"http://www.example/stop_time#stop_sequence#%s"+'"', pair[4]);


                Files.write(target, (stopTimeURL + " <http://www.example/stop_time#time_trip_id> " + tripID + "." + System.lineSeparator()).getBytes(), StandardOpenOption.APPEND);
                Files.write(target, (stopTimeURL + " <http://www.example/stop_time#arrival_time> " + arrivalTime + "." + System.lineSeparator()).getBytes(), StandardOpenOption.APPEND);
                Files.write(target, (stopTimeURL + " <http://www.example/stop_time#departure_time> " + departureTime + "." + System.lineSeparator()).getBytes(), StandardOpenOption.APPEND);
                Files.write(target, (stopTimeURL + " <http://www.example/stop_time#stop_time_id> " + stopID + "." + System.lineSeparator()).getBytes(), StandardOpenOption.APPEND);
                Files.write(target, (stopTimeURL + " <http://www.example/stop_time#stopLong> " + stopSequence + "." + System.lineSeparator()).getBytes(), StandardOpenOption.APPEND);
            }
        }
        return stopTime;
    }


    public static void routes() throws IOException {

        String line;
        String routeID;
        String agencyID;
        String routeShortName;
        String routeLongName;
        String routeType;
        String routeURL;

        File myObj = new File("src/main/resources/output/turtle/route.ttl");
        if (myObj.createNewFile()) {
            System.out.println("File created: " + myObj.getName());
        } else
            System.out.println("File already exists.");

        Path target = Paths.get("src/main/resources/output/turtle/route.ttl");

        try(BufferedReader in = new BufferedReader(new FileReader("src/main/resources/input/routes.txt"))){

            Files.write(target, "".getBytes(), StandardOpenOption.TRUNCATE_EXISTING);
            while((line = in.readLine())!=null){

                String[] pair = line.split(",");

                routeURL = String.format("<http://www.example/route/route.ttl#id=%s>", pair[0]);
                routeID = String.format("\"http://www.example/route#route_id#%s"+'"', pair[0]);
                agencyID = String.format("\"http://www.example/route#agency_id#%s"+'"', pair[1]);
                routeShortName = String.format("\"http://www.example/route#route_short_name#%s"+'"', pair[2]);
                routeLongName = String.format("\"http://www.example/route#route_long_name#%s"+'"', pair[3]);
                routeType = String.format("\"http://www.example/route#route_type#%s"+'"', pair[4]);


                Files.write(target, (routeURL + " <http://www.example/route#route_id> " + routeID + "." + System.lineSeparator()).getBytes(), StandardOpenOption.APPEND);
                Files.write(target, (routeURL + " <http://www.example/route#agency_id> " + agencyID + "." + System.lineSeparator()).getBytes(), StandardOpenOption.APPEND);
                Files.write(target, (routeURL + " <http://www.example/route#route_short_name> " + routeShortName + "." + System.lineSeparator()).getBytes(), StandardOpenOption.APPEND);
                Files.write(target, (routeURL + " <http://www.example/route#route_long_name> " + routeLongName + "." + System.lineSeparator()).getBytes(), StandardOpenOption.APPEND);
                Files.write(target, (routeURL + " <http://www.example/route#route_type> " + routeType + "." + System.lineSeparator()).getBytes(), StandardOpenOption.APPEND);
            }
        }

    }

    public static void index(ArrayList<String> trip,ArrayList<String> stop,ArrayList<String> stopTime) throws IOException {

        Path target = Paths.get("src/main/resources/output/website/index.html");

        File index = new File("src/main/resources/output/website/index.html");
        if (index.createNewFile()) {
            System.out.println("File created: " + index.getName());
        } else
            System.out.println("File already exists.");

        Files.write(target, "".getBytes(), StandardOpenOption.TRUNCATE_EXISTING);
        Files.write(target, ("<!DOCTYPE html>" + System.lineSeparator() + "<html>" + System.lineSeparator() + "<head>" + System.lineSeparator() + "<link rel=\"stylesheet\" href=style/styles.css>" + "<title>RDF</title>" + System.lineSeparator() + "</head>" + System.lineSeparator() + "<body>" + System.lineSeparator()).getBytes(), StandardOpenOption.APPEND);
        Files.write(target, ("<h1>Trips</h1>" + System.lineSeparator()).getBytes(), StandardOpenOption.APPEND);

        Files.write(target, ("<div class=\"withscroll\">" + System.lineSeparator()).getBytes(), StandardOpenOption.APPEND);
        Files.write(target, ("<table>" + System.lineSeparator()).getBytes(), StandardOpenOption.APPEND);

        Files.write(target, ("<tr>" + System.lineSeparator()).getBytes(), StandardOpenOption.APPEND);
        Files.write(target, ("<th colspan=\"2\">Trip Number</th>" + System.lineSeparator()).getBytes(), StandardOpenOption.APPEND);
        Files.write(target, ("<th colspan=\"8\">Stops</th>" + System.lineSeparator()).getBytes(), StandardOpenOption.APPEND);
        Files.write(target, ("</tr>" + System.lineSeparator()).getBytes(), StandardOpenOption.APPEND);

        for(String tripLine : trip)
        {
            String[] splitTrip = tripLine.split(",");
            String tripUrl = String.format("<td colspan=\"2\"><a href=trip%s.html>%s</a></td>", splitTrip[2],splitTrip[2]);

            Files.write(target, ("<tr>" + System.lineSeparator()).getBytes(), StandardOpenOption.APPEND);

            Files.write(target, (tripUrl + System.lineSeparator()).getBytes(), StandardOpenOption.APPEND);

            for(String stopTimeLine : stopTime)
            {
                String[] splitStopTime = stopTimeLine.split(",");

                if(splitTrip[2].equals(splitStopTime[0]))
                {

                    for(String stopLine : stop)
                    {
                        String[] splitStop = stopLine.split(",");

                        if(splitStopTime[3].equals(splitStop[0]))
                        {
                            Files.write(target, ("<td>" + splitStop[1] + System.lineSeparator()).getBytes(), StandardOpenOption.APPEND);
                            break;
                        }
                    }
                }
            }
            Files.write(target, ("</tr>" + System.lineSeparator()).getBytes(), StandardOpenOption.APPEND);
            Files.write(target, ("</th>" + System.lineSeparator()).getBytes(), StandardOpenOption.APPEND);

        }

        Files.write(target, ("</table>" + System.lineSeparator()).getBytes(), StandardOpenOption.APPEND);
        Files.write(target, ("</div>" + System.lineSeparator()).getBytes(), StandardOpenOption.APPEND);
        Files.write(target, ("</body>" + "</html>" + System.lineSeparator()).getBytes(), StandardOpenOption.APPEND);

        webpage(trip,stop,stopTime);


    }

    public static void webpage(ArrayList<String> trip,ArrayList<String> stop,ArrayList<String> stopTime) throws IOException {

        for(String tripLine : trip)
        {
            String[] splitTrip = tripLine.split(",");

            String webpageUrl = String.format("src/main/resources/output/website/trip%s.html",splitTrip[2]);
            Path target = Paths.get(webpageUrl);

            File index = new File(webpageUrl);
            if (index.createNewFile())
            {
                System.out.println("File created: " + index.getName());
            }
            else
                System.out.println("File already exists.");

            Files.write(target, "".getBytes(), StandardOpenOption.TRUNCATE_EXISTING);
            Files.write(target, ("<!DOCTYPE html>" + System.lineSeparator() + "<html>" + System.lineSeparator() + "<head>" + System.lineSeparator() + "<link rel=\"stylesheet\" href=style/styles.css>" + "<title>RDF</title>" + System.lineSeparator() + "</head>" + System.lineSeparator() + "<body>" + System.lineSeparator()).getBytes(), StandardOpenOption.APPEND);
            Files.write(target, ("<h1>Trip</h1>" + System.lineSeparator()).getBytes(), StandardOpenOption.APPEND);

            Files.write(target, ("<div class=\"withscroll\">" + System.lineSeparator()).getBytes(), StandardOpenOption.APPEND);
            Files.write(target, ("<table>" + System.lineSeparator()).getBytes(), StandardOpenOption.APPEND);

            Files.write(target, ("<tr>" + System.lineSeparator()).getBytes(), StandardOpenOption.APPEND);
            Files.write(target, ("<th>Stop Names</th>" + System.lineSeparator()).getBytes(), StandardOpenOption.APPEND);
            Files.write(target, ("<th>Arrival Time</th>" + System.lineSeparator()).getBytes(), StandardOpenOption.APPEND);
            Files.write(target, ("<th>Departure Time</th>" + System.lineSeparator()).getBytes(), StandardOpenOption.APPEND);
            Files.write(target, ("</tr>" + System.lineSeparator()).getBytes(), StandardOpenOption.APPEND);


            for(String stopTimeLine : stopTime)
            {
                String[] splitStopTime = stopTimeLine.split(",");

                if(splitTrip[2].equals(splitStopTime[0]))
                {
                    for(String stopLine : stop)
                    {
                        String[] splitStop = stopLine.split(",");

                        if(splitStopTime[3].equals(splitStop[0]))
                        {
                            Files.write(target, ("<tr>" + System.lineSeparator()).getBytes(), StandardOpenOption.APPEND);
                            Files.write(target, ("<td>" + splitStop[1] + "</td>" + System.lineSeparator()).getBytes(), StandardOpenOption.APPEND);
                            Files.write(target, ("<td>" + splitStopTime[1] + "</td>" + System.lineSeparator()).getBytes(), StandardOpenOption.APPEND);
                            Files.write(target, ("<td>" + splitStopTime[2] + "</td>" + System.lineSeparator()).getBytes(), StandardOpenOption.APPEND);
                            Files.write(target, ("</tr>" + System.lineSeparator()).getBytes(), StandardOpenOption.APPEND);

                            break;
                        }
                    }
                }
            }

            Files.write(target, ("</tr>" + System.lineSeparator()).getBytes(), StandardOpenOption.APPEND);
            Files.write(target, ("</th>" + System.lineSeparator()).getBytes(), StandardOpenOption.APPEND);
            Files.write(target, ("</table>" + System.lineSeparator()).getBytes(), StandardOpenOption.APPEND);
            Files.write(target, ("</div>" + System.lineSeparator()).getBytes(), StandardOpenOption.APPEND);
            Files.write(target, ("</body>" + "</html>" + System.lineSeparator()).getBytes(), StandardOpenOption.APPEND);
        }
    }
}

