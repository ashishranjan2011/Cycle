package learnOOD;
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
	public Gear(int chainring,int cog,Circular wheel){
		chainring(chainring);
		cog(cog);
		wheel(wheel);
	}
	public double ratio(){
		return (double)chainring()/(double)cog();
	}
	public double gear_inches(){
		return ratio()*wheel.diameter();
	}
}
class ObjectOriented{
	public static void main(String[] args){
		Wheel wheel=new Wheel(26,2);
		Gear gear=new Gear(12,7,wheel);
		System.out.println(gear.ratio());
		System.out.println(gear.gear_inches());
	}
}