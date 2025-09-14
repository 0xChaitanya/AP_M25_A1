public interface CargoCarrier {
    public void loadCargo(double weight);
    public void unloadCargo(double weight);
    public double getCargoCapacity();
    public double getCurrentCargo();
}
