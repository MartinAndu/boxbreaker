class Nodo{

	private Object valor;
	private  Nodo sig;
	
	public Nodo(){
		valor=null;
		sig=null;
	}


	//M�todos de seteo de Valor:
	public void setVal(Object val){//Permite modificar el valor del nodo actual
		valor=val;
	}
	//

	//Metodos de posicion
	public Nodo getSig(){//Retorna el siguiente nodo
		return sig;
	}
	//

	//Otros:
	public Object getVal(){//Retorna el valor del nodo actual
		 return valor;
	}

	public void newSNod(){//Inicializa el nodo siguiente
		sig=new Nodo();
	}

	public void setSig(Nodo nod){//
		sig=nod;
	}
	//
}
