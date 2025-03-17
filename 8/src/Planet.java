public class Planet {
    private String name;
    private double mass;
    private double volume;
    private double density;
    private double radius;
    private boolean life;
    private long population;
    private boolean gasGiant;
    private double albedo;

    public Planet(String name, double mass, double volume, double density, double radius, boolean life, long population, boolean gasGiant, double albedo) {
        this.name = name;
        this.mass = mass;
        this.volume = volume;
        this.density = density;
        this.radius = radius;
        this.life = life;
        this.population = population;
        this.gasGiant = gasGiant;
        this.albedo = albedo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public double getDensity() {
        return density;
    }

    public void setDensity(double density) {
        this.density = density;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public boolean getLife() {
        return life;
    }

    public void setLife(boolean life) {
        this.life = life;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public boolean getGasGiant() {
        return gasGiant;
    }

    public void setGasGiant(boolean gasGiant) {
        this.gasGiant = gasGiant;
    }

    public double getAlbedo() {
        return albedo;
    }

    public void setAlbedo(double albedo) {
        this.albedo = albedo;
    }

    public double Acceleration()
    {
        double G = 6.67430e-11;
        return G * mass / (radius * radius);
    }

    public String toString() {
        return "Planet: name='" + name + "', mass=" + mass + " kg, volume=" + volume + " m^3, density=" + density + " kg/m^3, radius=" + radius + " m, life=" + life + ", population=" + population + ", gasGiant=" + gasGiant + ", albedo=" + albedo + "}";
    }
}
