import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.com.fiap.entity.Gasto;
import br.com.fiap.repository.GastoRepository;
@ManagedBean
@RequestScoped
public class GastoBean implements Serializable {
	private GastoRepository gry;
	private Gasto gasto;
	
	@PostConstruct
	public void init() {
		gasto = new Gasto();
		gry = new GastoRepository();
	}
	
	public void cadastrar() {
		FacesMessage msg;
		try {
			gry.cadastrar(gasto);
			msg = new FacesMessage("Cadastrado!");
		} catch (Exception e) {
			e.printStackTrace();
			msg = new FacesMessage("Erro...");
		}
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	public List<Gasto> listar(){
		try {
			return gry.listar();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	

	public Gasto getGasto() {
		return gasto;
	}

	public void setGasto(Gasto gasto) {
		this.gasto = gasto;
	}
	
	
}
