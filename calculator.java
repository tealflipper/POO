import java.util.Scanner;
public class calculator{
	//Atributos
	private float a;
	private float b;
	private float result;
	private int op;
	Scanner sc = new Scanner(System.in);
	//Metodos 

	//  set_a escanea y guarda el valor del primer sumando
	public  void set_a(){
		System.out.print("Ingrese el numero a: ");
		this.a=sc.nextFloat();
		System.out.println("");
	}
	//set_b escanea y guarda el valor del segundo sumando
	public  void set_b(){
		System.out.print("Ingrese el numero b: ");
		this.b=sc.nextFloat();
		System.out.println("");
	}
	//set_op escanea y guarda la operación
	public void set_op(){
		System.out.print("Elija la operacion.\n1: Suma\n2: Resta\n3: Multiplicacion\n4: Division\n");
		this.op=sc.nextInt();
		System.out.println("\n");
		if (op>4){
				System.out.println("Opcion no valida.\nIntente de nuevo.\n\n");
				set_op();					}
		}
	//set_result regresa el resultado de la operación 
	public void set_result(float a, float b){
		if (this.op==1){
			this.result=a+b;
		}else{
			if (this.op==2){
				this.result=a-b;
			}else{
				if (this.op==3){
					this.result=a*b;
				}else{
					if (this.op==4){
						this.result=a/b;
					}
				}
			}
		}
	}
	//get_a regresa el valor de a
	public float get_a(){
		return this.a;
	}
	//get_b regresa el valor de b
	public float get_b(){
		return this.b;
	}
	//get_op regresa la operación a hacer
	public int get_op(){
		return this.op;
	}
	//get_result regresa el valor del resultado
	public float get_result(){
		return this.result;
	}
	//Despliega los atributos de la clase 
	public void despliega(){
		System.out.println("\n");
		if (this.op==1){
			System.out.println(this.a+"+"+this.b+"="+this.result);
		}else{
			if (this.op==2){
				System.out.println(this.a+"-"+this.b+"="+this.result);
			}else{
				if (this.op==3){
					System.out.println(this.a+"*"+this.b+"="+this.result);
				}else{
					if (this.op==4){
						System.out.println(this.a+"/"+this.b+"="+this.result);
					}
				}
			}
		}
	}
	public int repeat(int i){
		System.out.println("\n\nDesea continuar con otra operación?");
		System.out.println("1: Si\n2: No");
		i=sc.nextInt();
		if (i!=1 && i!=2){
			System.out.println(" no valido. ");
			repeat(i);
		}
		return i;
	}
	//Ejecuta la calculadora
	public static void main(String[] args) {
		int i=1;
		float a,b;
		Scanner sc= new Scanner(System.in);
		while (i==1){
			calculator $calculator= new calculator();
			$calculator.set_op();
			$calculator.set_a();		
			$calculator.set_b();
			a=$calculator.get_a();
			b=$calculator.get_b();
			$calculator.set_result(a,b);

			$calculator.get_op();
			$calculator.get_result();
			$calculator.despliega();
			System.out.println("\n\nDesea continuar con otra operación?");
			System.out.println("1: Si\n2: No");
			i=sc.nextInt();

		}
	}

}