
public class GarageMain {

	static Garaje garaje;
	
	public static void main(String[] args) {
		
		//inicializar los componentes de la aplicacion
		
		//4 clientes
		
		//5 vehiculos
		
		//30 plazas de garaje
		
		//1 garaje

		inicializarComponentes();
		
	}
	
	public static void inicializarComponentes() {
		
		garaje = new Garaje();
		
		Plaza[] plazas = new Plaza[30];
		
		for (int i = 0; i < plazas.length; i++) {
			Plaza plazaTemp = new Plaza();
			
			plazaTemp.setNumeroPlaza(i+1);
			
			if (i<10) {
				
				plazaTemp.setPrecio(50);
				
			} else if (i<20){
				
				plazaTemp.setPrecio(75);
				
			}else {
				
				plazaTemp.setPrecio(100);
				
			}
			plazas[i]=plazaTemp;
			
			
		}
		
		garaje.setPlazas(plazas);
		
		System.out.println("test");
		
		
		
	}
}
