


public class Planet {

	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;

	public Planet(double xP, double yP, double xV, double yV, double m, String img){
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m ;
		imgFileName = img;


	}

	public Planet(Planet p){
		xxPos = p.xxPos;
		yyPos = p.yyPos;
		xxVel = p.xxVel;
		yyVel = p.yyVel;
		mass = p.mass;
		imgFileName = p.imgFileName;
	}

	public double calcDistance(Planet p) {
		double dx = xxPos - p.xxPos;
		double dy = yyPos - p.yyPos;
		return Math.sqrt(dx * dx + dy * dy) ;
	}

	
	private static final double G = 6.67e-11;
	
	
	public double calcForceExertedBy(Planet p) {
		if (equals(p)) {
			return 0;
		}
		double r = calcDistance(p);
		return (G * mass * p.mass) /(r*r);

	}

	public double calcForceExertedByX(Planet p) {
		double dx = p.xxPos - xxPos;
		double f = calcForceExertedBy(p);
		double r = calcDistance(p);
		return  (f * dx)/r;
	}


	public double calcForceExertedByY(Planet p) {
		double dy = p.yyPos - yyPos;
		double f = calcForceExertedBy(p);
		double r = calcDistance(p);
		return  (f * dy)/r;
	}

	public double calcNetForceExertedByX(Planet[] planets) {
		double netForce = 0;
		for (Planet p : planets) {
			if (equals(p)){
				continue;
			}
			netForce += calcForceExertedByX(p);
		}
		return netForce;

	}
	
	public double calcNetForceExertedByY(Planet[] planets) {
			double netForce = 0;
			for (Planet p : planets) {
				if (equals(p)){
					continue;
				}
				netForce += calcForceExertedByY(p);
			}
			return netForce;

		}

	private double calcAcceleration(double f){
		return f/mass;

	}


	public void update(double dt, double fX, double fY) {
		double accelerationByX = calcAcceleration(fX);
		double accelerationByY = calcAcceleration(fY);
		xxVel = xxVel + accelerationByX * dt;
		yyVel = yyVel + accelerationByY * dt;
		xxPos += xxVel * dt;
		yyPos += yyVel * dt;

	}


	public  void draw() {
		// String filename  = './images/' + this.imgFileName;
		StdDraw.picture(this.xxPos, this.yyPos, "./images/" + imgFileName);
	}



}











