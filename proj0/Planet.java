public class Planet{
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;
	public static final double G = 6.67e-11;

	public Planet(double xxPos, double yyPos, double xxVel,
				  double yyVel, double mass, String imgFileName){
		this.xxPos = xxPos;
		this.yyPos = yyPos;
		this.xxVel = xxVel;
		this.yyVel = yyVel;
		this.mass = mass;
		this.imgFileName = imgFileName;
	}

	public Planet(Planet p){
		this.xxPos = p.xxPos;
		this.yyPos = p.yyPos;
		this.xxVel = p.xxVel;
		this.yyVel = p.yyVel;
		this.mass = p.mass;
		this.imgFileName = p.imgFileName;
	}

	public double calcDistance(Planet p){
		return Math.sqrt((this.xxPos - p.xxPos) * (this.xxPos - p.xxPos) + 
			             (this.yyPos - p.yyPos) * (this.yyPos - p.yyPos));
	}

	public double calcForceExertedBy(Planet p){
		return G * this.mass * p.mass / (this.calcDistance(p) * this.calcDistance(p));
	}

	public double calcForceExertedByX(Planet p){
		return this.calcForceExertedBy(p) * (p.xxPos - this.xxPos) / this.calcDistance(p);
	}

	public double calcForceExertedByY(Planet p){
		return this.calcForceExertedBy(p) * (p.yyPos - this.yyPos) / this.calcDistance(p);
	}

	public double calcNetForceExertedByX(Planet[] p){
		double netForce = 0;
		for(int i = 0; i < p.length; i++){
			if(!this.equals(p[i])){
				netForce += this.calcForceExertedByX(p[i]);
			}
		}
		return netForce;
	}

	public double calcNetForceExertedByY(Planet[] p){
		double netForce = 0;
		for(int i = 0; i < p.length; i++){
			if(!this.equals(p[i])){
				netForce += this.calcForceExertedByY(p[i]);
			}
		}
		return netForce;
	}

	public void update(double dt, double fx, double fy){
		double ax = fx / this.mass;
		double ay = fy / this.mass;
		this.xxVel = this.xxVel + ax * dt;
		this.yyVel = this.yyVel + ay * dt;
		this.xxPos = this.xxPos + this.xxVel * dt;
		this.yyPos = this.yyPos + this.yyVel * dt;
	}

	public void draw(){
		String path = "images/" + this.imgFileName;
		StdDraw.picture(this.xxPos, this.yyPos, path);
		StdDraw.show();
	}
}