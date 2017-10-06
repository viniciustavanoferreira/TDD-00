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
     * Objetivo - verificar o comportamento do sistema na inclusão de empresa com
     * sucesso.
     * Pré-condição - o CNPJ 89424232000180 não está cadastrado.
     */
	@Test
	public void CT01UC01FBCadastra_com_sucesso() {
		assertEquals(1,empresaDAO.adiciona(empresa));
	}
	
    /**
     * ID - CT02UC01FBCadastra_cnpj_invalido
     * Objetivo - verificar o comportamento do sistema na inclusão de CNPJ inválido.
     * Pré-condição - o CNPJ possui um formato inválido.
     */
	@Test
	public void CT02UC01FBCadastra_cnpj_invalido() {
		assertEquals("CNPJ inválido", empresa.setCnpj("87312"));
	}
	
    /**
     * ID - CT03UC01FBCadastra_cnpj_ja_cadastrado
     * Objetivo - verificar o comportamento do sistema na inclusão de CNPJ já cadastrado.
     * Pré-condição - o CNPJ 89424232000180 está cadastrado.
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



