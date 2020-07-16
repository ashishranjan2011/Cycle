package learnOOD;
import java.util.*;
interface Circular{
	int diameter();
}
class Wheel implements Circular{
	private int rim;
	private int tire;
	int rim() {
		return rim;
	}
	void rim(int rim){
		this.rim = rim;
	}
	int tire() {
		return tire;
	}
	void tire(int tire) {
		this.tire = tire;
	}
 	public Wheel(int rim,int tire){
		rim(rim);
		tire(tire);
	}
	public int diameter(){
		return rim()+2*tire();
	}
	public double circumference(){
		return diameter()*3.14;
	}
}
class Gear{
	private int chainring;
	private int cog;
	private Circular wheel;
	int cog() {
		return cog;
	}
	void cog(int cog) {
		this.cog = cog;
	}
	int chainring() {
		return chainring;
	}
	void chainring(int chainring) {
		this.chainring = chainring;
	}
	Circular wheel(){
		return wheel;
	}
	void wheel(Circular wheel) {
		this.wheel = wheel;
	}
	public Gear(Map<String,Object> params){
		chainring((int)params.get("chainring"));
		cog((int)params.get("cog"));
		wheel((Circular)params.get("wheel"));
	}
	public int diameter() {
		return wheel.diameter();
	}
	public double ratio(){
		return (double)chainring()/(double)cog();
	}
	public double gear_inches(){
		return ratio()*diameter();
	}
}
class Bicycle{
	private String size;
	private String type_color;
	public Bicycle(HashMap<String,Object> params){
		this.size=(String)params.get("size");
		// this.type_color=(String)params.get("type_color");
	}
	public HashMap<String,Object> spares(){
		HashMap<String,Object> output=new HashMap<>();
		output.put("chain","10-speed");
		output.put("tire_size",23);
		// output.put("type_color",this.type_color);
		return output;
	}
}
class RoadBicycle extends Bicycle{
	private String type_color;
	public RoadBicycle(HashMap<String,Object> params){
		super(params);
		this.type_color=(String)params.get("type_color");
	}
}
class MountainBicycle extends Bicycle{
	private String front_shock;
	private String rear_shock;
	public MountainBicycle(HashMap<String,Object> params){
		super(params);
		this.front_shock=(String)params.get("front_shock");
		this.rear_shock=(String)params.get("rear_shock");
	}
}
class ObjectOriented{
	public static void main(String[] args){
		Wheel wheel=new Wheel(26,2);
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("chainring",12);
		params.put("cog",7);
		params.put("wheel",wheel);
		Gear gear=new Gear(params);
		System.out.println(gear.ratio());
		System.out.println(gear.gear_inches());

		HashMap<String,Object> bicycle_params=new HashMap<>();
		bicycle_params.put("size","M");
		bicycle_params.put("type_color","red");
		RoadBicycle bicycle=new RoadBicycle(bicycle_params);
		System.out.println(bicycle.spares().get("chain"));
		HashMap<String,Object> bicycle_params2=new HashMap<>();

		bicycle_params2.put("size","S");
		bicycle_params2.put("front_shock","Monitau");
		bicycle_params2.put("rear_shock","Fox");
		MountainBicycle bicycle2=new MountainBicycle(bicycle_params2);
		System.out.println(bicycle2.spares().get("chain"));
	}
}