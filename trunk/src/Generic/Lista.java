package Generic;

import java.io.Serializable;


public class Lista implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Nodo pri;
	private Nodo actual;

	public Lista(){
		pri=new Nodo();
	}

	public void add(Object num){
		Nodo aux=pri;
		if(pri.getVal()==null){
			pri.setVal(num);
		}else{
			while(aux.getSig()!=null){
				aux=aux.getSig();
			}
			aux.setSig(new Nodo(num));
		}
	}

	public void add(int pos,Object num){
		int cont=1;
		Nodo aux=pri;
		while(cont!=pos && aux!=null){
			aux=aux.getSig();
			cont++;
		}
		if(aux!=null){
			Nodo nuevo=new Nodo(num);
			nuevo.setSig(aux.getSig());
			aux.setSig(nuevo);
		}
	}

	public void modificate(int pos,Object val){
		int cont=1;
		Nodo aux=pri;
		while(cont!=pos && aux!=null){
			aux=aux.getSig();
			cont++;
		}
		if(aux!=null){
			aux.setVal(val);
		}
	}

	public void delete(int pos) {
		Nodo aux=pri;
		int cont=1;
		if(pos!=1){
			while(cont!=pos-1 && aux.getSig()!=null){
				aux=aux.getSig();
				cont=cont+1;
			}
			if(aux.getSig()!=null){
				try{
					actual=aux;
					if(aux.getSig().getSig()==null){
						aux.setSig(null);
					}else{
						aux.setSig(aux.getSig().getSig());
					}
				}catch(NullPointerException e){
						e.printStackTrace();
					System.out.println("Lista.delNod Error:No se puede acceder a la posicion deseada "+pos);
				}
			}else{System.out.println("Lista.delNod Error:No se puede acceder a la posicion deseada "+ pos);}
		}else{pri=pri.getSig();}
	}

	public Object getData(int pos){
		int cont=1;
		Nodo aux=pri;
		while(cont!=pos && aux!=null){
			aux=aux.getSig();
			cont++;
		}
		if(aux!=null){
			actual=aux;
			return aux.getVal();
		}else{
			return null;
		}
	}

	public Object getNext(){
		if(actual.getSig()!=null){
			actual=actual.getSig();
			return actual.getVal();
		}else{
			return null;
		}
	}
}

