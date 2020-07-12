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
	}
}