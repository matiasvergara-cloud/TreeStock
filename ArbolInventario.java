public class ArbolInventario {
    private Producto raiz;

    public ArbolInventario() {
        this.raiz = null;
    }

    public void insertar(int id, String nombre) {
        raiz = insertarRecursivo(raiz, id, nombre);
    }

    private Producto insertarRecursivo(Producto actual, int id, String nombre) {
        if (actual == null) {
            return new Producto(id, nombre);
        }
        if (id < actual.id) {
            actual.izquierdo = insertarRecursivo(actual.izquierdo, id, nombre);
        } else if (id > actual.id) {
            actual.derecho = insertarRecursivo(actual.derecho, id, nombre);
        }
        return actual;
    }

    public void inorden() {
        inordenRecursivo(raiz);
    }

    private void inordenRecursivo(Producto actual) {
        if (actual != null) {
            inordenRecursivo(actual.izquierdo);
            System.out.println("ID: " + actual.id + " | Nombre: " + actual.nombre);
            inordenRecursivo(actual.derecho);
        }
    }

    public boolean buscar(int id) {
        return buscarRecursivo(raiz, id);
    }

    private boolean buscarRecursivo(Producto actual, int id) {
        if (actual == null) {
            return false;
        }
        if (id == actual.id) {
            return true;
        } else if (id < actual.id) {
            return buscarRecursivo(actual.izquierdo, id);
        } else {
            return buscarRecursivo(actual.derecho, id);
        }
    }
}