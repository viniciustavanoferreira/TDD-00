package br.sceweb.teste_unitario;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import br.sceweb.model.Empresa;
import br.sceweb.model.EmpresaDAO;

/**
 * Este script de teste verifica o comportamento do caso de uso ~ UC01CadastrarEmpresa.
 * @author Vinicius T. Ferreira
 *
 */
public class UC01CadastrarEmpresa {
	static EmpresaDAO empresaDAO;
	static Empresa empresa;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		empresaDAO = new EmpresaDAO();
		empresa = new Empresa();
		empresa.setNomeDaEmpresa("empresa x");
		empresa.setCnpj("89424232000180");
		empresa.setNomeFantasia("empresa x");
		empresa.setEndereco("rua taquari");
		empresa.setTelefone("2222");
	}
	
    /**
     * ID - CT01UC01FBCadastra_com_sucesso
     * Objetivo - verificar o comportamento do sistema na inclus�o de empresa com
     * sucesso.
     * Pr�-condi��o - o CNPJ 89424232000180 n�o est� cadastrado.
     */
	@Test
	public void CT01UC01FBCadastra_com_sucesso() {
		assertEquals(1,empresaDAO.adiciona(empresa));
	}
	
    /**
     * ID - CT02UC01FBCadastra_cnpj_invalido
     * Objetivo - verificar o comportamento do sistema na inclus�o de CNPJ inv�lido.
     * Pr�-condi��o - o CNPJ possui um formato inv�lido.
     */
	@Test
	public void CT02UC01FBCadastra_cnpj_invalido() {
		assertEquals("CNPJ inv�lido", empresa.setCnpj("87312"));
	}
	
    /**
     * ID - CT03UC01FBCadastra_cnpj_ja_cadastrado
     * Objetivo - verificar o comportamento do sistema na inclus�o de CNPJ j� cadastrado.
     * Pr�-condi��o - o CNPJ 89424232000180 est� cadastrado.
     */
	@Test
	public void CT03UC01FBCadastra_cnpj_ja_cadastrado() {
		empresaDAO.adiciona(empresa);
		assertEquals(0, empresaDAO.adiciona(empresa));
	}	

	@After                        
	public void tearDownAfterClass() throws Exception {
		empresaDAO.exclui("89424232000180");
	}
}



