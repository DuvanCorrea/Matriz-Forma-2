package trabajoa.p_punto2;

public class TrabajoAP_punto2 {

    public static void main(String[] args) {

        int tam = 2;

        System.out.println("Matriz 1:");
        MatrizF2 matriz1 = new MatrizF2();
        matriz1.CrearMatriz(tam, tam);
        matriz1.mostrarMatriz();
        matriz1.pasarAForma2(matriz1.getMatrizNomal());

        System.out.println("\nMatriz1 Froma 2");
        matriz1.mostrarF2();
        System.out.println("");

        System.out.println("\nMatriz1 Transpuesta");
        matriz1.GenerarTranspuesta();
        matriz1.mostrarMatrizTrans();

        System.out.println("\nMatriz1 Transpuesta Forma 2");
        matriz1.pasarAForma2Trans(matriz1.getMatrizTranpuesta());
        matriz1.mostrarF2Trans();

        System.out.println("\n====================================================\n");

        System.out.println("Matriz 2:");
        MatrizF2 matriz2 = new MatrizF2();
        matriz2.CrearMatriz(tam, tam);
        matriz2.mostrarMatriz();
        matriz2.pasarAForma2(matriz2.getMatrizNomal());
        System.out.println("\nMatriz2 Froma 2");
        matriz2.mostrarF2();
        System.out.println("");
        System.out.println("\nMatriz2 Transpuesta");
        matriz2.GenerarTranspuesta();
        matriz2.mostrarMatrizTrans();
        System.out.println("\nMatriz1 Transpuesta Forma 2");
        matriz2.pasarAForma2Trans(matriz2.getMatrizTranpuesta());
        matriz2.mostrarF2Trans();

        System.out.println("\n====================================================\n");

        System.out.println("Suma de M1 con M2");
        matriz1.sumarMatF2(matriz1.getPunta(), matriz2.getPunta());
        System.out.println("");

        System.out.println("\nMultiplicar de M1 con M2");
        matriz1.multiplicarMatF2(matriz1.getPunta(), matriz2.getPunta());
        System.out.println("");

        System.out.println("\nComparacion");
        matriz1.comparaMatF2(matriz1.getPunta(), matriz2.getPunta());
        System.out.println("");
        
        System.out.println("\nPromedio columnas de Matriz 1");
        matriz1.promedioColumnas();

    }

}
