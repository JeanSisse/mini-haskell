package br.unb.poo.mh;

public class TamanhoDasExpressoes implements Visitor {

	private int tamanho = 0;
	public int getTamanho() {
		return tamanho;
	}
	
	@Override
	public void visitar(ValorInteiro exp) {
		tamanho += 1;
	}

	@Override
	public void visitar(ValorBooleano exp) {
		tamanho += 1;
	}

	private void visitarBin(ExpressaoBinaria exp) {
		 exp.expEsquerda.aceitar(this);
		 exp.expDireita.aceitar(this);
		 tamanho += 1;
	}
	
	@Override
	public void visitar(ExpressaoSoma exp) {
		visitarBin(exp);
	}

	@Override
	public void visitar(Multiplicacao exp) {
		visitarBin(exp);
	}

	@Override
	public void visitar(ExpressaoAnd exp) {
		visitarBin(exp);
	}

	@Override
	public void visitar(ExpressaoOr exp) {
		visitarBin(exp);
	}

	@Override
	public void visitar(IfThenElse exp) {
		exp.condicao.aceitar(this);
		exp.clausulaThen.aceitar(this);
		exp.clausulaElse.aceitar(this);
		tamanho += 1;
	}

	@Override
	public void visitar(AplicacaoFuncao exp) {
		exp.parametros.stream().forEach(p -> { p.aceitar(this); });
		tamanho += 1;
		
//		for(Expressao p: exp.parametros) {
//			p.aceitar(this);
//		}
	}

	@Override
	public void visitar(Identificador exp) {
		tamanho += 1;
	}

}
