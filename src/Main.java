import java.io.*;
import classes.*;
import classes.aircrafts.*;
import classes.weather.WeatherTower;

class Main {

    // Parse each line of aircrafts in scenario file to return an object Flyable
    // which pairs with the type of Aircraft
    public static Flyable createAircraft(AircraftFactory factory, String line) {
        String tmp = line;

        String type = tmp.substring(0, tmp.indexOf(" ")).replace(tmp + " ", "");
        tmp = tmp.replace(type + " ", "");
        String name = tmp.substring(0, tmp.indexOf(" ")).replace(tmp + " ", "");
        tmp = tmp.replace(name + " ", "");
        String longitude = tmp.substring(0, tmp.indexOf(" ")).replace(tmp + " ", "");
        tmp = tmp.replace(longitude + " ", "");
        String latitude = tmp.substring(0, tmp.indexOf(" ")).replace(tmp + " ", "");
        tmp = tmp.replace(latitude + " ", "");
        String height = tmp.replace(tmp + " ", "");
        return (factory.newAircraft(type, name, Integer.parseInt(longitude), Integer.parseInt(latitude), Integer.parseInt(height)));
    }

    public static Game parsing(String path) {
        Game game = new Game();

        try {
            File file = new File(path);
            String line;
            int count = 0;
            if (!file.exists() || !file.canRead()) {
                System.out.println("\033[91mError : File does'nt exist/not enough permissions : \"" + path + "\".\033[0m");
                return (null);
            }
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            AircraftFactory factory = new AircraftFactory();

            while ((line = br.readLine()) != null) {
                String tmp = line;
                if (line.length() == 0)
                    continue;
                // Parse first line (number of loops)
                if (count++ == 0) {
                    long nbLoops = Long.parseLong(line);
                    if (nbLoops < 0) {
                        System.out.println("\033[91mError (scenario file) : Invalid number of loops.\u001B[0m");
                        br.close();
                        return (null);
                    }
                    game.setCountLoop(nbLoops);
                    continue;
                }
                // Parse aircrafts names and coordinates
                if (!tmp.equalsIgnoreCase("Baloon") && !tmp.equalsIgnoreCase("JetPlane") && !tmp.equalsIgnoreCase("Helicopter") && tmp.contains(" ")) {
                    tmp = tmp.substring(0, tmp.indexOf(" "));
                    if (!tmp.equalsIgnoreCase("Baloon") && !tmp.equalsIgnoreCase("JetPlane") && !tmp.equalsIgnoreCase("Helicopter")) {
                        System.out.println("\u001B[91mError (scenario file) : Invalid name of aircraft. (" + tmp + ")\u001B[0m");
                        br.close();
                        return (null);
                    }
                    game.addAircraft(createAircraft(factory, line));
                }
            }
            br.close();
        } catch (Exception e) {
            System.out.println("\u001B[91mError (scenario file) " + e + ": Invalid number of loops.\u001B[0m");
            return (null);
        }
        return (game);
    }

    public static void simulation(Game game) {
        WeatherTower weatherTower = game.getWeatherTower();

        for (int loop = 0; loop < game.getCountLoops(); loop++)
           weatherTower.changeWeather();
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("\u001B[91mNumbers of parameters incorrect. (Need one scenario file)");
            return;
        }
        Game game = parsing(args[0]);
        if (game == null)
            return;
        simulation(game);
    }
}
