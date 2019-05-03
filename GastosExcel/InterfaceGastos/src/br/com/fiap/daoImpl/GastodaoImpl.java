package br.com.fiap.daoImpl;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import br.com.fiap.dao.GastoDAO;
import br.com.fiap.entity.Gasto;

public class GastodaoImpl extends GenericDAOImpl<Gasto,Integer> implements GastoDAO{
	public GastodaoImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Gasto> buscarTudo() {
		TypedQuery<Gasto> q = em.createQuery("from Gasto g",Gasto.class);
		List<Gasto> lista = q.getResultList();
		return lista;
	}
	
	
	/*@Override
	public void gerarPlanilha(List<Gasto> lista,String arquivo) {
		lista = buscarTudo();
		
		
		XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheetAlunos = workbook.createSheet("Gastos");
        SimpleDateFormat f1 = new  SimpleDateFormat("dd/MM/yy");
        XSSFCellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        style.setFont(font);

        
        int rownum = 0;
        for (Gasto g : lista) {
        	if(rownum==0) {
        		Row row = sheetAlunos.createRow(rownum++);
                int cellnum = 0;
                Cell cellDescricaoT = row.createCell(cellnum++);
                cellDescricaoT.setCellValue("Descrição");
                cellDescricaoT.setCellStyle(style);
                
                Cell cellDataT = row.createCell(cellnum++);
                cellDataT.setCellValue("Data");
                cellDataT.setCellStyle(style);
                
                Cell cellValorT = row.createCell(cellnum++);
                cellValorT.setCellValue("Valor");
                cellValorT.setCellStyle(style);
                
                Cell cellPagamentoT = row.createCell(cellnum++);
                cellPagamentoT.setCellValue("Pagamento");
                cellPagamentoT.setCellStyle(style);
        	}
            Row row = sheetAlunos.createRow(rownum++);
            int cellnum = 0;
            Cell cellDescricao = row.createCell(cellnum++);
            cellDescricao.setCellValue(g.getDescricao());
            Cell cellData = row.createCell(cellnum++);
            cellData.setCellValue(f1.format(g.getDataGasto().getTime()));
            Cell cellValor = row.createCell(cellnum++);
            cellValor.setCellValue(g.getValor());
            Cell cellPagamento = row.createCell(cellnum++);
            cellPagamento.setCellValue(g.getTipoPagamento().toString());
        }
        
        try {
        	
            FileOutputStream out = 
                    new FileOutputStream(arquivo);
            workbook.write(out);
            out.close();
            workbook.close();
            System.out.println("Arquivo Excel criado com sucesso!");
              
        } catch (FileNotFoundException e) {
            e.printStackTrace();
               System.out.println("Arquivo não encontrado!");
        } catch (IOException e) {
            e.printStackTrace();
               System.out.println("Erro na edição do arquivo!");
        }
        
        

	}*/

	@Override
	public List<Gasto> buscarPorMes(int mes) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
