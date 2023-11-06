public class Analizador {
    public boolean esMutante(String[][] adn) throws matrizInvalidaException {
        int n = adn.length;
        if (n == 0) {
            throw new matrizInvalidaException("La matriz es nula");  //valida si la matriz no es nula
        }
        for (int i = 0; i < n; i++) {
            if (adn[i].length != n) {
                throw new matrizInvalidaException("La matriz no es cuadrada");  //valida si la matriz es cuadrada
            }
            for (int j = 0; j < n; j++) {
                if (!adn[i][j].matches("[ATCG]")) {
                    throw new matrizInvalidaException("La matriz contiene caracteres invalidos");  //valida si la matriz contiene caracteres invalidos
                }
            }
        }
        int coincidencias = 0; //contador de coincidencias de genes mutantes
        coincidencias += recorridoHorizontal(adn);
        coincidencias += recorridoVertical(adn);
        coincidencias += recorridostDiagonales(adn);
        return coincidencias > 1; //si el contador de coincidencias de genes mutantes es mayor a 1, el adn analizado es mutante
    }

    //RECORRIDO HORIZONTAL DE LA MATRIZ DE ADN
    private int recorridoHorizontal(String[][] adn) {
        int contador = 0;
        for (int i = 0; i < adn.length; i++) {
            for (int j = 0; j < adn[i].length - 3; j++) {
                if (adn[i][j].equals(adn[i][j+1]) && adn[i][j].equals(adn[i][j+2]) && adn[i][j].equals(adn[i][j+3])) {
                    contador++;
                }
            }
        }
        return contador;
    }

    //RECORRIDO VERTICAL DE LA MATRIZ DE ADN
    private int recorridoVertical(String[][] adn) {
        int contador = 0;
        for (int i = 0; i < adn.length - 3; i++) {
            for (int j = 0; j < adn[i].length; j++) {
                if (adn[i][j].equals(adn[i+1][j]) && adn[i][j].equals(adn[i+2][j]) && adn[i][j].equals(adn[i+3][j])) {
                    contador++;
                }
            }
        }
        return contador;
    }

    private int recorridostDiagonales(String[][] adn) {
        int contador = 0;
        contador += recorridoDiagonal(adn);
        contador += recorridoContradiagonal(adn);
        return contador;
    }

    //RECORRIDO DIAGONAL DE LA MATRIZ DE ADN
    private int recorridoDiagonal(String[][] adn) {
        int contador = 0;
        for (int i = 0; i < adn.length - 3; i++) {
            for (int j = 0; j < adn[i].length - 3; j++) {
                if (adn[i][j].equals(adn[i+1][j+1]) && adn[i][j].equals(adn[i+2][j+2]) && adn[i][j].equals(adn[i+3][j+3])) {
                    contador++;
                }
            }
        }
        return contador;
    }

    //RECORRIDO CONTRADIAGONAL DE LA MATRIZ DE ADN
    private int recorridoContradiagonal(String[][] adn) {
        int contador = 0;
        for (int i = 3; i < adn.length; i++) {
            for (int j = 0; j < adn[i].length - 3; j++) {
                if (adn[i][j].equals(adn[i-1][j+1]) && adn[i][j].equals(adn[i-2][j+2]) && adn[i][j].equals(adn[i-3][j+3])) {
                    contador++;
                }
            }
        }
        return contador;
    }
}
