#include <stdio.h>
int main(){ 
	int a,b,r=1;
	printf("mcd(a,b)\nIngrese a y b\n");
	scanf("%d",&a);
	scanf("%d",&b);
	if (a>b){
		int temp=b;
		b=a;
		a=temp;
	}
	while (r>0){
		r=b%a;
		b=a;
		a=r;
	}
	printf("%d\n", b);
}