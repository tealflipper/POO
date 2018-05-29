import java.util.Scanner;
public class racional{
	private int numerador, denominador;
	private int numeradorS, denominadorS;
	private int numeradorR, denominadorR;
	private int numeradorM, denominadorM;
	private boolean comp;
	Scanner sc=new Scanner(System.in);
	public int MCD(int a,int b){
		int r;
		if (a>b){
			int temp=b;
			b=a;
			a=temp;
		}
		r=1;
		while (r>0 ){
			r=b%a;
			b=a;
			a=r;
		}
		return b;
	}
	public racional(int a,int b){
		//int mcd=MCD(a,b);
		numerador=a;//mcd;
		denominador=b;//mcd;
	}
	public int scanX(int x){
		x=sc.nextInt();
		return x;
	}
	public void mostrar(){
		System.out.printf("%d/%d\n",this.numerador,this.denominador);
		System.out.printf("\n");
	}
	public void setSuma(racional a,racional b){
		//System.out.println("suma racionales a/b y c/d");
		/*la suma de a/b+c/d es ((a*d)+(c*b))/(b*d)*/
		this.numeradorS=(a.numerador*b.denominador)+(b.numerador*a.denominador);
		this.denominadorS=a.denominador*b.denominador;
		//System.out.println(this.numeradorS);
		//System.out.println(this.denominadorS);

	}
	public racional getSuma(racional n){
		n.numerador=this.numeradorS;
		n.denominador=this.denominadorS;
		//System.out.println(this.numeradorS);
		//System.out.println(this.denominadorS);
		int mcd=MCD(n.numerador,n.denominador);
		n.numerador= n.numerador/mcd;
		n.denominador=n.denominador/mcd;
		return n;
	}
	public racional negativo(racional a){
		a.numerador=0-a.numerador;
		return a;
	}
	public void setResta(racional a, racional b){
		//System.out.println("resta racionales a/b y c/d");
		racional c=negativo(b);
		setSuma(a,c);
	}
	public racional getResta(racional n){
		n.numerador=this.numeradorS;
		n.denominador=this.denominadorS;
		return n;
	}
	public void setMultiplicacion(racional a, racional b){
		//System.out.println("multiplica racionales a/b y c/d");
		this.numeradorM=a.numerador*b.numerador;
		this.denominadorM=a.denominador*b.denominador;
	}
	public racional getMultiplicacion(racional m){
		m.numerador=this.numeradorM;
		m.denominador=this.denominadorM;
		return m;
	}
	
	public racional simplificar(racional a){
		//System.out.println("simplifica racional a/b ");
		int maxcd;
		
		maxcd=MCD(a.numerador,a.denominador);
		a.numerador=a.numerador/maxcd;
		a.denominador=a.denominador/maxcd;
		return a;
	}
	public boolean esIgual(racional a, racional b){
		//System.out.println("dice si las racionales a/b y c/d son iguales");
		boolean comparacion;
		a=simplificar(a);
		b=simplificar(b);
		//System.out.println(a.numerador+"  "+b.numerador);
		if(a.numerador==b.numerador && a.denominador==b.denominador){
			return comparacion=true;
		}else{
			return comparacion=false;
		}
	}
	public static void main(String[] args) {
		boolean comp;
		int a,b,c,d;
		racional $a,$b,$c;
		Scanner sc=new Scanner(System.in);
		System.out.printf("ingresa numerador del primer racional:");
		a=sc.nextInt();
		System.out.printf("ingresa denominadordel primer racional:");
		b=sc.nextInt();
		$a= new racional(a,b);
		
		//muestra racional a/b
		System.out.printf("Primer racional: ");
		$a.mostrar();
		System.out.printf("\n\n");

		System.out.printf("ingresa numerador del segundo racional:");
		c=sc.nextInt();
		System.out.printf("ingresa denominador del segundo racional:");
		d=sc.nextInt();
		$b= new racional(c,d);

		//muestra racional c/d
		$b.mostrar();

		$a= new racional(a,b);
		$b= new racional(c,d);
		//Hace la suma de dos racionales
		$a.setSuma($a,$b);
		$c=new racional (1,1);
		$c=$a.getSuma($c);
		System.out.printf("(%d/%d)+(%d/%d)=",$a.numerador,$a.denominador,$b.numerador,$b.denominador);
		$c.mostrar();
		$a= new racional(a,b);
		$b= new racional(c,d);
		//Muestra -a/b
		$c=$a.negativo($a);
		System.out.printf("El negativo del primer racional es: ");
		$c.mostrar();
		$c=$a.negativo($a);
		$a= new racional(a,b);
		$b= new racional(c,d);
		//realiza la operación (a/b)-(c/d)
		System.out.printf("(%d/%d)-(%d/%d)=",$a.numerador,$a.denominador,($b.numerador),$b.denominador);
		$a.setResta($a,$b);
		$c=$a.getResta($c);
		//System.out.printf("\na=%d",$a.numerador);
		$c.mostrar();

		$a= new racional(a,b);
		$b= new racional(c,d);
		//realiza la multiplicación de (a/b)*(c/d)
		System.out.printf("(%d/%d)*(%d/%d)=",$a.numerador,$a.denominador,($b.numerador),$b.denominador);
		$a.setMultiplicacion($a,$b);
		$c=$a.getMultiplicacion($c);
		$c.mostrar();

		$a= new racional(a,b);
		$b= new racional(c,d);
		//simplifica a/b a (c/d)*(K/K)
		System.out.printf("(%d/%d) simplificado=",$a.numerador,$a.denominador); 
		$a.simplificar($a);
		$a.mostrar();
		System.out.printf("(%d/%d) simplificado=",$b.numerador,$b.denominador);
		$b.simplificar($b);
		$b.mostrar();
		//no hace nada dado que ya esta implementada la funcion dentro de los metodos
		//dice si dos radicales son iguales
		$a= new racional(a,b);
		$b= new racional(c,d);
		comp=$a.esIgual($a,$b);
		if (comp==true){
			System.out.println("son iguales");
		}else{
			System.out.println("No son iguales");
		}
	}

}