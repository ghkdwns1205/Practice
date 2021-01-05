package ClassArray;

public class B {
String str;
int c;

public B() {
	this.c = 0;
	this.str = "123";
}
public String[] substring(String str, String[] array) {
	
	for(int i = 0; i<str.length(); i++) {
	array[i] = str.substring(i,i+1);
	
	}
	return array;
}


}
