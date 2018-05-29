import java.util.Scanner;
public class Alumno{
	private String nombre;
	private long matricula;
	private int edad;
	private float promedio;
	private int creditos;
	//Constructor para la clase Alumno
	//Los atrinutos los lee dentro del metodo
	private Alumno(String n,long a, int b,float c,int d){
		nombre=n;
		matricula=a;
		edad=b;
		promedio=c;
		creditos=d;
	}
	Scanner sc= new Scanner(System.in);

	//lee elementos y crea una instancia para cada elemento del arreglo
	public void readArray(Alumno[] array){
		 int i;
		 String n;
		 float c;
		 String seperator;
		 long a; 
		 int b,d;
		 int sizeofArray=sc.nextInt();
		 seperator=sc.next();
		 for (i=0;i<sizeofArray;i++){
		 	
			//System.out.printf("Nombre: ");
			n=sc.next();
			//System.out.printf("Matricula: ");
			a=sc.nextLong();
			//System.out.printf("Edad: ");
			b=sc.nextInt();
			//System.out.printf("Promedio: ");
			c=sc.nextFloat();
			//System.out.printf("creditos: ");
			d=sc.nextInt();
			array[i] = new Alumno(n,a,b,c,d);
			seperator=sc.next();
		 }

	}
	//Muestra el objeto Alumno
	//String s es el separador entre alumnos
	public void mostrar(String s){
		
		//System.out.printf("Nombre: ");
		System.out.println(this.nombre);
		//System.out.printf("Matricula: ");
		System.out.println(this.matricula);
		//System.out.printf("Edad: ");
		System.out.println(this.edad);
		//System.out.printf("Promedio: ");
		System.out.println(this.promedio);
		//System.out.printf("creditos: ");
		System.out.println(this.creditos);
		System.out.println(s);
	}
	//Calcula y regresa el promedio de edad
	public float PromEdad(Alumno[] array, int sizeofArray){
		int i=0;
		float sumaTotal=0;
		for (i=0;i<sizeofArray;i++){
			sumaTotal+=array[i].edad;
		}
		float promedioEdad=sumaTotal/sizeofArray;
		return promedioEdad;
	}
	//Calcula y regresa el promedio máximo
	public void maxProm (Alumno[] array, int sizeofArray){
		int i=0;
		int promMax=0;
		for (i=1;i<sizeofArray;i++){
			if (array[promMax].promedio<array[i].promedio){
				promMax=i;
			}
		}
		array[promMax].mostrar("---");
	}
	//Calcula y regresa el promedio general
	public float Promedio(Alumno[] array, int sizeofArray){
		int i=0;
		float sumaTotal=0;
		for (i=0;i<sizeofArray;i++){
			sumaTotal+=array[i].promedio;
		}
		float promedioG=sumaTotal/sizeofArray;
		return promedioG;
	}
	/*Imprime el registro del alumno con el promedio mas cercano
	al promedio general de todos los alumnos*/
	public void alumnoPromedio(Alumno[] array, int sizeofArray){
		int i=0;
		float prom=array[0].Promedio(array,100);
		float promR=prom-array[0].promedio;
		float promL;
		int promProm=0;
		for (i=1;i<sizeofArray;i++){
			promL=prom-array[i].promedio;

			if(promR<0){
				promR*=-1;
			}
			if(promL<0){
				promL*=-1;
			}
			if (promL<promR){
				promR=promL;
				promProm=i;
			}
			//System.out.println(promR);

		}
		array[promProm].mostrar("---");
	}
	//Calcula y regresa el promedio de los alumnos de 20 años
	public float Promedio20(Alumno[] array, int sizeofArray){
		int i=0,j=0;
		float sumaTotal=0;
		for (i=0;i<sizeofArray;i++){
			if (array[i].edad==20){
				sumaTotal+=array[i].promedio;
				j++;
			}
		}
		float promedioG=sumaTotal/j;
		return promedioG;
	}
	/*Imprime el registro del alumno con el promedio más alto en 
	el archivo y que tenga mas de 50 y menos de 70 creditos cursados*/
	public void maxProm50y70 (Alumno[] array, int sizeofArray){
		int i=0;
		int promMax=99;
		for (i=sizeofArray-1;i>=0;i--){
			//array[promMax].mostrar("---");
			if (array[i].creditos>50 && array[i].creditos<70){

				if (array[promMax].promedio<array[i].promedio){
					promMax=i;
					//array[promMax].mostrar("---");
				}
			}	
		}
		array[promMax].mostrar("---");
	}
	public static void main(String[] args) {
		/*Inicializa los variables para crear una nueva instancia 
		  *del objeto Alumno */
		Scanner sc= new Scanner(System.in);
		String n;
		float c;
		String seperator="---";
		long a; 
		int b,d,i;
		float promedioEdad;
		float promedioGeneral;
		float promedioDe20;
		Alumno[]  array = new Alumno[100];
		
		Alumno $b=new Alumno("a",1,3213,6,5);
		$b.readArray(array);
		promedioEdad=$b.PromEdad(array, 100);
		promedioGeneral=$b.Promedio(array, 100);
		promedioDe20=$b.Promedio20(array,100);
		System.out.println(100);
		System.out.println("---");
		for (i=0;i<100;i++){
			array[i].mostrar(seperator);
		}
		System.out.println("Promedio de edad: "+promedioEdad);
		System.out.println("Promedio general: "+promedioGeneral);
		System.out.println("Promedio general de alumnos de 20: "+promedioDe20);
		System.out.println("------------\nAlumno con el promedio mas alto:");
		$b.maxProm(array, 100);
		System.out.println("------------\nAlumno con el promedio mas cercano al promedio general:");
		$b.alumnoPromedio(array,100);
		System.out.println("------------\nAlumno con el promedio mas alto con mas de 50 creditos \ny menos de 70 creditos:");
		$b.maxProm50y70(array, 100);


	}

}