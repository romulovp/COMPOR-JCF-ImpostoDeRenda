package br.ufcg.ppgcc.compor.ir.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.ufcg.ppgcc.compor.ir.ExcecaoImpostoDeRenda;
import br.ufcg.ppgcc.compor.ir.FachadaExperimento;
import br.ufcg.ppgcc.compor.ir.FontePagadora;
import br.ufcg.ppgcc.compor.ir.Titular;

public class ImpostoDeRenda implements FachadaExperimento{
	private List<Titular> titulares = new ArrayList<Titular>();
	Map<Titular,List<FontePagadora>> fp = new HashMap<Titular,List<FontePagadora>>();
	
	
	public void criarNovoTitular(Titular titular){
		if(titular.getNome()==null){
			throw new ExcecaoImpostoDeRenda("O campo nome é obrigatório");
		}
		
		if(titular.getCpf()==null){
			throw new ExcecaoImpostoDeRenda("O campo CPF é obrigatório");
		}
		
		if(titular.getCpf().length()>14 || titular.getCpf().length()<14){
			throw new ExcecaoImpostoDeRenda("O campo CPF está inválido");
		}
		
		titulares.add(titular);
		fp.put(titular, new ArrayList<FontePagadora>());
	}
	public List<Titular> listarTitulares() {
		return titulares;
	}
	
	
	public void criarFontePagadora(Titular titular, FontePagadora fonte) {					
		fp.get(titular).add(fonte);
	}
	
	public List<FontePagadora> listarFontes(Titular titular) {		
		return fp.get(titular);
	}
}