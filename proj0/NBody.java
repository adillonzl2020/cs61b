public class NBody {
	public static double readRadius(String filename) {
		In in = new In (filename);
		// in.readline();
		String firstItemInFile = in.readString();  // USE THIS to read the first line, doesn't matter use String or int
		return in.readDouble();

	}

	public static Planet[] readPlanets(String filename) {
		In in = new In (filename);
		int numberOfPlanets = in.readInt();	
		double firstIteminFile = in.readDouble(); // skip radius
		// Planet[] planets = new Planet[numberOfPlanets];
		// for (int i = 0; i < numberOfPlanets ; i ++ ) {
		// 	planets[i] = readPlanets(in);   // calling the method itself, recursive?
		// } 
		Planet[] planets = new Planet[numberOfPlanets];
        int i = 0;      // easiest way to ensure we read only relevant lines

        while(i != numberOfPlanets) {
            double xP = in.readDouble();
            double yP = in.readDouble();
            double xV = in.readDouble();
            double yV = in.readDouble();
            double m = in.readDouble();
            String img = in.readString();
            planets[i] = new Planet(xP, yP, xV, yV, m, img);
            i += 1;
        }

		return planets;

	}

	public static avoid main(String[] args) {
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];

		Planet[] planets = readPlanets(filename);
		double radius = readRadius(filename);

	}

	// draw background
	public static void drawBackground() {
		StdDraw.setScale(-radius, radius);
		StdDraw.clear();
		StdDraw.picture(0,0,"./images/startfield.jpg");
		
		for (Planet p : planets) {
			p.draw();
		}

	}


}


















