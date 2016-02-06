package djikstra;

public class Djikstra_Test {
	
	public static void main(String [] args){
		
		Djikstra d = new Djikstra();
		try{
			d.start();
		} catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		
	}
}
