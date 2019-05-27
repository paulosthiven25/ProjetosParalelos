package br.com.fiap.bean;

import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.com.fiap.TO.GastoTO;
import br.com.fiap.TO.TipoGasto;
import br.com.fiap.TO.TipoPagamento;
import br.com.fiap.exception.CommitException;
import br.com.fiap.repository.GastoRepository;
@RequestScoped
@ManagedBean
public class GastoBean {

	private GastoRepository gry;
	private GastoTO gasto;

	
	@PostConstruct
	public void init() {
		gry = new GastoRepository();
		gasto= new GastoTO();
		gasto.setDataGasto(Calendar.getInstance());
	}
	
	public TipoGasto[] getTipoGasto(){
		return TipoGasto.values();
	}
	
	public TipoPagamento[] getTipoPagamento(){
		return TipoPagamento.values();
	}
	
	
	public List<GastoTO> listar(){
		try {
			return gry.listar();
		} catch (Exception e) {
			e.printStackTrace();
			addMessage("Erro");
			return null;
			
		}
	}

	public String excluir(int codigo) {
		try {
			gry.remover(codigo);
			addMessage("Removido!");
		} catch (Exception e) {
			e.printStackTrace();
			addMessage("Erro");
		}
		return "listagem?faces-redirect=true";
	}
	
	public String cadastrar() {
		try {
			//if (gasto.getCodigo() == 0) {
				gry.cadastrar(gasto);
				addMessage("Cadastrado!");
			/*}else {
				dao.atualizar(onibus);
				dao.commit();
				addMessage("Atualizado!");
			}*/
			return "listagem?faces-redirect=true"; //navega para a página de cadastro (nome do arquivo)
		} catch (Exception e) {
			e.printStackTrace();
			addMessage("Erro..");
			return "cadastro";
		}
		
	}
	
	/*public void validaRepeticaoNome(FacesContext context, UIComponent component, Object value)
			throws ValidatorException{
		String valor = value.toString();
		List<Onibus> lista = dao.retornarPorNome(valor);
			if ((lista.size()>0)) { 
			throw new ValidatorException(new FacesMessage("Nome repetido"));
			}
			}*/
	
	private void addMessage(String mensagem) {
		FacesMessage msg = new FacesMessage(mensagem);
		FacesContext.getCurrentInstance().addMessage(null, msg);
		//manter as mensagens após redirect
		FacesContext.getCurrentInstance().getExternalContext()
									.getFlash().setKeepMessages(true);
	}

	

	public GastoTO getGasto() {
		return gasto;
	}

	public void setGasto(GastoTO gasto) {
		this.gasto = gasto;
	}
	
	
}
