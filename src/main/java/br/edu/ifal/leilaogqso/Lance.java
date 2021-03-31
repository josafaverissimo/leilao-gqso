package br.edu.ifal.leilaogqso;

public class Lance{

	private double valor;	
	private Usuario usuario;	

	public Lance(Usuario u, double v){
		this.usuario = u;
		this.valor = v;
	}

	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}

	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
