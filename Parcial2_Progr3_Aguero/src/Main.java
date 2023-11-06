
public class Main {
    public static void main(String[] args) {

        String[][] adnMutante1 = {
                {"C", "G", "T", "A", "C", "G"},
                {"C", "A", "G", "T", "G", "C"},
                {"T", "T", "A", "T", "G", "T"},
                {"A", "G", "A", "A", "G", "G"},
                {"C", "C", "C", "C", "T", "A"},
                {"T", "A", "A", "A", "A","G"}
        };
        String[][] adnMutante2 = {
                {"A", "C", "A", "T", "C", "G"},
                {"C", "A", "G", "T", "G", "C"},
                {"T", "T", "A", "T", "G", "T"},
                {"A", "G", "A", "T", "G", "G"},
                {"C", "C", "C", "C", "G", "A"},
                {"T", "C", "A", "C", "T", "G"}
        };
        String[][] adnMutante3 = {
                {"A", "A", "A", "A", "C", "G"},
                {"C", "A", "G", "T", "G", "G"},
                {"T", "T", "A", "T", "G", "G"},
                {"A", "G", "A", "A", "G", "G"},
                {"C", "C", "C", "C", "T", "A"},
                {"T", "C", "A", "C", "T", "T"}
        };
        String[][] adnMutante4 = {
                {"A", "A", "T", "A", "C", "G"},
                {"C", "A", "G", "T", "G", "G"},
                {"T", "T", "T", "T", "G", "G"},
                {"A", "G", "A", "C", "G", "G"},
                {"C", "A", "C", "C", "C", "C"},
                {"T", "C", "A", "C", "T", "G"}
        };
        String[][] adnMutante5 = {
                {"A", "T", "A", "A", "C", "G"},
                {"C", "A", "G", "T", "G", "C"},
                {"T", "T", "G", "T", "G", "T"},
                {"A", "G", "A", "G", "G", "G"},
                {"C", "A", "C", "C", "G", "A"},
                {"T", "C", "A", "C", "T", "G"}
        };
        String[][] adnNormal1 = {
                {"T", "T", "T", "C", "G", "A"},
                {"C", "C", "C", "A", "T", "C"},
                {"G", "G", "G", "C", "G", "A"},
                {"A", "A", "A", "C", "T", "A"},
                {"T", "T", "T", "G", "T", "C"},
                {"G", "G", "G", "C", "G", "A"}
        };
        String[][] adnNormal2 = {
                {"C", "T", "G", "A", "A", "A"},
                {"A", "C", "T", "C", "C", "C"},
                {"A", "T", "C", "G", "G", "G"},
                {"C", "G", "A", "T", "T", "T"},
                {"G", "C", "A", "C", "C", "C"},
                {"A", "C", "G", "T", "T", "T"}
        };
        String[][] adnNormal3 = {
                {"A", "T", "G", "C", "G", "A"},
                {"C", "A", "G", "T", "T", "C"},
                {"T", "T", "A", "T", "G", "T"},
                {"A", "T", "C","A", "A", "A"},
                {"C", "T", "G", "T", "T", "T"},
                {"A", "G", "C", "G", "G", "G"}
        };
        String[][] adnNormal4 = {
                {"A", "G", "C", "T", "T", "T",},
                {"C", "T", "A", "C", "C", "C"},
                {"A", "G", "C", "G", "G", "G"},
                {"A", "G", "C", "A", "G", "G"},
                {"C", "C", "T", "A", "T", "A"},
                {"T", "C", "A", "C", "T", "G"}
        };
        String[][] adnNormal5 = {
                {"A", "T", "G", "C", "G", "A"},
                {"C", "A", "G", "T", "T", "C"},
                {"T", "T", "A", "T", "G", "T"},
                {"A", "G", "C", "A", "G", "G"},
                {"C", "C", "T", "A", "T", "A"},
                {"T", "C", "A", "C", "T", "G"}
        };

        analisis(adnMutante1);
        analisis(adnMutante2);
        analisis(adnMutante3);
        analisis(adnMutante4);
        analisis(adnMutante5);
        analisis(adnNormal1);
        analisis(adnNormal2);
        analisis(adnNormal3);
        analisis(adnNormal4);
        analisis(adnNormal5);
    }
    //METODO PARA ANALIZAR SI LA MATRIZ DE ADN ES MUTANTE O NORMAL
    public static void analisis(String[][] matriz) {
        try {
            Analizador analizador = new Analizador();
            System.out.println("La siguiente matriz:");
            mostrarMatriz(matriz);
            if (analizador.esMutante(matriz))
                System.out.println("Es mutante\n");
            else
                System.out.println("No es mutante\n");
        } catch (matrizInvalidaException e) {
            System.out.println("Invalid matriz: " + e.getMessage());
        }
    }

    //METODO PARA MOSTRAR LA MATRIZ POR PANTALLA
    public static void mostrarMatriz(String[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println("");
        }
    }
}