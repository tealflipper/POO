import java.util.Scanner;
public class calTrig{
	//Atributos
	private double x;
	private double xP=1;//Potencia de x^n, empieza en x^1 para el seno y en x^0 para coseno
	private double xF=1;//Factorial de n, empieza en 1!=1 para el seno y en 0!=1 para coseno
	private int n;
	private double resultS,resultC,resultT,resultSEC;
	private double resultCSC, resultCOT;	
	Scanner sc=new Scanner(System.in);
	//metodos
	//setX sets value of x
	public void setX(){
		System.out.print("Ingrese x (en radianes): ");
		this.x=sc.nextDouble();
		System.out.println("");
	}
	//setX returns value of x
	public double getX(){
		return this.x;
	}
	
	//Calcula el seno de un numero x 
	public void setSin(){
		this.resultS=0;
		this.n=1;
		//x^0=1
		int i;
		double termino;
		for (i=1;i<=100;++i){
				this.xP=this.x;
				this.xF=1;
				int j=1;
				//Calcula la potencia de x^n
				while (j<this.n){
					this.xP=this.xP*this.x;
					j++;
				}
				//System.out.println("x^"+this.n+"="+this.xP);
				//Calcula n!
				j=1;
				while (j<=this.n){
					this.xF=this.xF*j;
					j++;
				}
				//System.out.println(this.n+"!="+this.xF);
				//setInFact();
				//setInFact();
			termino=xP/xF;
			if (i%2==0){
				termino*=-1;
			}
			this.resultS+=termino;
			this.n+=2;
			//System.out.println("termino="+termino+"\nsen("+this.x+")=x^"+(this.n-2)+"("+this.xP+")/"+(this.n-2)+"!("+this.xF+")");
			//System.out.println("sen("+this.x+")="+this.result+"\n\n");
		}
	}
	public double getSin(){
		System.out.println("sen("+this.x+")="+this.resultS+"\n");
		return this.resultS;
	}
	public void setCos(){
		this.resultC=0;
		this.n=0;
		//x^0=1
		int i;
		double termino;
		for (i=1;i<=100;++i){
				this.xP=1;
				this.xF=1;
				int j=1;
				//Calcula la potencia de x^n
				while (j<=this.n){
					this.xP=this.xP*this.x;
					j++;
				}
			//	System.out.println("x^"+this.n+"="+this.xP);
				//Calcula n!
				j=1;
				while (j<=this.n){
					this.xF=this.xF*j;
					j++;
				}
				//System.out.println(this.n+"!="+this.xF);
				//setInFact();
				//setInFact();
			termino=xP/xF;
			if (i%2==0){
				termino*=-1;
			}
			this.resultC+=termino;
			this.n+=2;
			//System.out.println("termino="+termino+"\ncos("+this.x+")=x^"+(this.n-2)+"("+this.xP+")/"+(this.n-2)+"!("+this.xF+")");
			//System.out.println("cos("+this.x+")="+this.result+"\n\n");
		}
	}
	public double getCos(){
		System.out.println("cos("+this.x+")="+this.resultC+"\n");
		return this.resultC;
	}
	public void setTan(){
		this.resultT=0;
		//System.out.println(this.resultS);
		//System.out.println(this.resultT);
		double cos;
		double sin;
		setCos();
		setCos();
		setSin();
		setSin();
		this.resultT=this.resultS/this.resultC;
	}
	public double getTan(){
		System.out.println("Tan("+this.x+")="+this.resultT+"\n");
		return this.resultT;
	}
	public void setSec(){
		setCos();
		setCos();
		this.resultSEC=1/this.resultC;
	}
	public double getSec(){
		System.out.println("sec("+this.x+")="+this.resultSEC+"\n");
		return this.resultSEC;
	}
	public void setCsc(){
		setSin();
		setSin();
		this.resultCSC=1/this.resultS;
	}
	public double getCsc(){
		System.out.println("csc("+this.x+")="+this.resultCSC+"\n");
		return this.resultCSC;
	}
	public void setCot(){
		setTan();
		setTan();
		this.resultCOT=1/this.resultS;
	}
	public double getCot(){
		System.out.println("cot("+this.x+")="+this.resultCOT+"\n");
		return this.resultCOT;
	}
	public static void main(String[] args) {
		calTrig $calTrig= new calTrig();
		$calTrig.setX();
		$calTrig.getX();
		$calTrig.setSin();
		$calTrig.getSin();
		$calTrig.setCos();
		$calTrig.getCos();
		$calTrig.setTan();
		$calTrig.getTan();
		$calTrig.setSec();
		$calTrig.getSec();
		$calTrig.setCsc();
		$calTrig.getCsc();
		$calTrig.setCot();
		$calTrig.getCot();
	}
}