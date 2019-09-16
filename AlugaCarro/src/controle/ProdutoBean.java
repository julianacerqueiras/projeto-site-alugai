package controle;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.chart.PieChartModel;

@SuppressWarnings("serial")
@ManagedBean(name = "MBProduto")
@ViewScoped
public class ProdutoBean implements Serializable{

	
	private PieChartModel modelo;

	public PieChartModel getModelo() {
		
		String carro = "Palio";
		String carro1 = "Celta";
		
		modelo.getData().put(carro, 10);
		modelo.getData().put(carro1,20);
		
		
		
		return modelo;
	}

	
	
	

}
