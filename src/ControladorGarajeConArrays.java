import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ControladorGarajeConArrays implements ControladorGaraje{

	@Override
	public void listarPlazasLibres() {
		
		List<Plaza> plazaslibres= new ArrayList<Plaza>();
		
		Plaza[] plazas=GarageMain.getGaraje().getPlazas();
		
		for (int i = 0; i < plazas.length; i++) {
			Plaza plaza = plazas[i];
			
			if(plaza.getLibre()) {
				plazaslibres.add(plaza);
			}
		}
		//listar por pantalla
		
		for (Plaza plaza : plazaslibres) {
			System.out.println(plaza);
		}
		
	}

	@Override
	public void listarPlazasOcupadas() {
		
		List<Plaza> plazasOcupadas= new ArrayList<Plaza>();
		
		Plaza[] plazas=GarageMain.getGaraje().getPlazas();
		
		for (int i = 0; i < plazas.length; i++) {
			Plaza plaza = plazas[i];
			
			if(!plaza.getLibre()) {
				plazasOcupadas.add(plaza);
			}
		}
		//listar por pantalla
		
		for (Plaza plaza : plazasOcupadas) {
			System.out.println(plaza);
		}
	
	}

	@Override
	public boolean reservarPlaza() {
		
		//logica de crear cliente
		
		Cliente cliente= new Cliente();
		
		
		//vasmoa a escribir por pantalla un mentodo para meter los datos del cliente

		Scanner in = new Scanner(System.in);
		

		System.out.println("Inserta su nif: ");
		String nif = in.nextLine();
		cliente.setNif(nif);
		System.out.println("Inserte su nombre completo: ");
		String nombreCompleto = in.nextLine();
		cliente.setNombreCompleto(nombreCompleto);
		
		System.out.println("Tipo de vehículo del cliente: ");
		System.out.println("1: Coche");
		System.out.println("2: Moto");
		System.out.println("3.Camion");
		
		in = new Scanner(System.in);
		
		Vehiculo vehiculo = null;

		switch (in.nextInt()) {
		case 1:
			vehiculo = new Coche();
			break;
		case 2:
			vehiculo = new Moto();
			break;
		case 3:
			vehiculo = new Camion();
			
		default:
			break;
		}
		
		System.out.println("inserte la matricula del vehiuclo: ");
		in =new Scanner(System.in);
		vehiculo.setMatricula(in.nextLine());
		
		
		if (vehiculo instanceof Coche) {
			
			((Coche)(vehiculo)).setMarca("");
			
		} 
		
		
		cliente.setVehiculo(vehiculo);
		
		

		
		
		//definimos una plaza ocupada y si esta libre que reserve

		boolean hayplaza=false;
		
		Garaje garaje = GarageMain.getGaraje();
		
		Plaza[] plazas=garaje.getPlazas();
		
		for (int i = 0; i < plazas.length; i++) {
			Plaza plaza = plazas[i];
			
			if (plaza.getLibre()&& vehiculo instanceof Aparcable) {
				plaza.setCliente(cliente);
				hayplaza=true;
				return hayplaza;
			}
		}
		return hayplaza;
		
		//si hay plazas libres seteamos un cliente a la plaza que queramos
		
		
	}

	
	
}
