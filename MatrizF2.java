package trabajoa.p_punto2;

import java.util.Random;

/**
 *
 * @author Felipe
 */
public class MatrizF2 {

    private int[][] matrizNomal;
    private int[][] matrizTranpuesta;
    private int[][] nDatos;
    private Nodo punta;
    private Nodo puntaTranspuesta;
    private int[] promedioColumnas;

    // matriz en F2
    public MatrizF2() {
        this.matrizNomal = null;
        this.nDatos = null;
        this.punta = null;
    }

    public int[] getPromedioColumnas() {
        return promedioColumnas;
    }

    public void setPromedioColumnas(int[] promedioColumnas) {
        this.promedioColumnas = promedioColumnas;
    }

    public int[][] getMatrizNomal() {
        return matrizNomal;
    }

    public void setMatrizNomal(int[][] matrizNomal) {
        this.matrizNomal = matrizNomal;
    }

    public int[][] getnDatos() {
        return nDatos;
    }

    public void setnDatos(int[][] nDatos) {
        this.nDatos = nDatos;
    }

    public Nodo getPunta() {
        return punta;
    }

    public void setPunta(Nodo punta) {
        this.punta = punta;
    }

    public int[][] getMatrizTranpuesta() {
        return matrizTranpuesta;
    }

    public void setMatrizTranpuesta(int[][] matrizTranpuesta) {
        this.matrizTranpuesta = matrizTranpuesta;
    }

    public Nodo getPuntaTranspuesta() {
        return puntaTranspuesta;
    }

    public void setPuntaTranspuesta(Nodo puntaTranspuesta) {
        this.puntaTranspuesta = puntaTranspuesta;
    }

    //CREAR MATRIZ
    public int[][] CrearMatriz(int filas, int columnas) {

        // linea para crear variable tipo random
        Random aleatorio = new Random(System.currentTimeMillis());

        int matriz[][] = new int[filas][columnas];

        //Generando numero y posicion aleatoria
        for (int i = 0; i < (filas * columnas / 2); i++) {
            matriz[aleatorio.nextInt(filas)][aleatorio.nextInt(columnas)]
                    = aleatorio.nextInt(10);

        }

        matrizNomal = matriz;
        return matriz;
    }

    public void mostrarMatriz() {

        for (int i = 0; i < matrizNomal.length; i++) {
            for (int j = 0; j < matrizNomal[0].length; j++) {
                System.out.print(" " + matrizNomal[i][j]);

            }
            System.out.println("");

        }

    }

    public void mostrarMatrizTrans() {

        for (int i = 0; i < matrizTranpuesta.length; i++) {
            for (int j = 0; j < matrizTranpuesta[0].length; j++) {
                System.out.print(" " + matrizTranpuesta[i][j]);

            }
            System.out.println("");
        }

    }

    public Nodo pasarAForma2(int[][] matriz) {

        punta = new Nodo();

        punta.setFila(matriz[0].length);
        punta.setColumna(matriz.length);
        punta.setLF(punta);
        punta.setLC(punta);

        //System.out.println(matriz[0].length); // filas
        //System.out.println(matriz.length); // columnas        
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {

                if (matriz[i][j] != 0) {
                    Nodo nuevo = new Nodo();
                    nuevo.setDato(matriz[i][j]);
                    nuevo.setFila(i);
                    nuevo.setColumna(j);

                    Nodo puntaAux = punta.getLF();

                    while (puntaAux.getLF() != punta) {
                        puntaAux = puntaAux.getLF();
                    }

                    puntaAux.setLF(nuevo);
                    nuevo.setLF(punta);
                    nuevo.setLC(punta);

                    Nodo pAux = punta.getLF();
                    while (pAux != punta) {
                        //System.out.print(" " + pAux.getDato());
                        pAux = pAux.getLF();
                    }
                    //System.out.println("");

                }

            }

        }

        acomodarColumnas();

        return punta;
    }

    public Nodo pasarAForma2Trans(int[][] matriz) {

        puntaTranspuesta = new Nodo();

        puntaTranspuesta.setFila(matriz[0].length);
        puntaTranspuesta.setColumna(matriz.length);
        puntaTranspuesta.setLF(puntaTranspuesta);
        puntaTranspuesta.setLC(puntaTranspuesta);

        //System.out.println(matriz[0].length); // filas
        //System.out.println(matriz.length); // columnas        
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {

                if (matriz[i][j] != 0) {
                    Nodo nuevo = new Nodo();
                    nuevo.setDato(matriz[i][j]);
                    nuevo.setFila(i);
                    nuevo.setColumna(j);

                    Nodo puntaTranspuestaAux = puntaTranspuesta.getLF();

                    while (puntaTranspuestaAux.getLF() != puntaTranspuesta) {
                        puntaTranspuestaAux = puntaTranspuestaAux.getLF();
                    }

                    puntaTranspuestaAux.setLF(nuevo);
                    nuevo.setLF(puntaTranspuesta);
                    nuevo.setLC(puntaTranspuesta);

                    Nodo pAux = puntaTranspuesta.getLF();
                    while (pAux != puntaTranspuesta) {
                        //System.out.print(" " + pAux.getDato());
                        pAux = pAux.getLF();
                    }
                    //System.out.println("");

                }

            }

        }

        acomodarColumnas();

        return puntaTranspuesta;
    }

    public void acomodarColumnas() {

        Nodo puntaAux = punta;
        Nodo q = punta;
        Nodo aux = punta;

        int colActual = 0;
        int con = 0;
        boolean encontro = false;

        while (colActual < punta.getColumna()) {

            Nodo A = puntaAux.getLF(); // para saber cuantas de la misma colimna
            while (A != puntaAux) {
                if (A.getColumna() == colActual && A.getDato() != 0) {
                    con++;
                }
                A = A.getLF();
            }

            if (con != 0) {

                aux = puntaAux.getLF();
                while (con != 0) {

                    if (aux.getColumna() == colActual) {

                        puntaAux.setLC(aux);
                        puntaAux = puntaAux.getLC();
                        con--;

                    }
                    aux = aux.getLF();

                }

            }

            colActual++;

        }

    }

    public void mostrarF2() {

        System.out.print("Filas: " + punta.getFila());
        System.out.println("    columnas: " + punta.getColumna());

        Nodo pAux = punta.getLF();
        while (pAux != punta) {
            System.out.print(" " + pAux.getDato());
            pAux = pAux.getLF();
        }

    }

    public void mostrarF2(Nodo punta) {

        System.out.print("Filas: " + punta.getFila());
        System.out.println("    columnas: " + punta.getColumna());

        Nodo pAux = punta.getLF();
        while (pAux != punta) {
            System.out.print(" " + pAux.getDato());
            pAux = pAux.getLF();
        }

    }

    public void mostrarF2Trans() {

        System.out.print("Filas: " + puntaTranspuesta.getFila());
        System.out.println("    columnas: " + puntaTranspuesta.getColumna());

        Nodo pAux = puntaTranspuesta.getLF();
        while (pAux != puntaTranspuesta) {
            System.out.print(" " + pAux.getDato());
            pAux = pAux.getLF();
        }

    }

    public int[] promedioColumnas() {

        promedioColumnas = new int[punta.getColumna()];

        for (int i = 0; i < punta.getColumna(); i++) {

            Nodo puntaAux = punta.getLF();

            while (puntaAux != punta) {
                if (puntaAux.getColumna() == i) {
                    promedioColumnas[i] += puntaAux.getDato();
                }
                puntaAux = puntaAux.getLF();
            }

        }

        for (int i = 0; i < promedioColumnas.length; i++) {
            float a = promedioColumnas[i];
            float b = punta.getColumna();
            float aux = a / b;
            System.out.println("Col " + i + ": " + (aux) + " ");

        }

        return promedioColumnas;
    }

    public void GenerarTranspuesta() {
        // se se pasarria de nuevo a matriz normal y luego se hace la traspuesta
        // sigiente se genera nuevamente la forma 2

        int[][] matrizNueva = this.matrizNomal;

        int aux;
        for (int i = 0; i < punta.getColumna(); i++) {
            for (int j = 0; j < i; j++) {
                aux = matrizNueva[i][j];
                matrizNueva[i][j] = matrizNueva[j][i];
                matrizNueva[j][i] = aux;
            }
        }

        this.matrizTranpuesta = matrizNueva;

        pasarAForma2Trans(matrizNueva);

    }

    public void sumarMatF2(Nodo M1, Nodo M2) {
        //Se sumaran las MF2 normale, no las transpuesta

        Nodo pAux = M1.getLF();
        Nodo pAux2 = M2.getLF();
        int[][] mResultante = new int[M1.getFila()][M1.getColumna()];

        while (pAux != M1) {
            mResultante[pAux.getFila()][pAux.getColumna()]
                    += pAux.getDato();
            pAux = pAux.getLF();
        }

        while (pAux2 != M2) {
            mResultante[pAux2.getFila()][pAux2.getColumna()]
                    += pAux2.getDato();
            pAux2 = pAux2.getLF();
        }

        MatrizF2 mAux = new MatrizF2();
        mAux.setMatrizNomal(mResultante);
        mAux.pasarAForma2(mResultante);
        mAux.pasarAForma2(mResultante);
        mAux.mostrarF2();

    }

    public void multiplicarMatF2(Nodo M1, Nodo M2) {
        //Se sumaran las MF2 normale, no las transpuesta

        Nodo pAux = M1.getLF();
        Nodo pAux2 = M2.getLF();
        int[][] mResultante = new int[M1.getFila()][M1.getColumna()];

        while (pAux != M1) {
            pAux2 = M2.getLF();
            while (pAux2 != M2) {
                if ((pAux.getFila() == pAux2.getFila())
                        && ((pAux.getColumna() == pAux2.getColumna()))) {

                    //System.out.println(pAux.getFila() + " " + pAux2.getFila());
                    //System.out.println(pAux.getColumna() + " " + pAux2.getColumna());
                    //System.out.println("Dato pAux " + pAux.getDato());
                    //System.out.println("Dato pAux2 " + pAux2.getDato());
                    mResultante[pAux.getFila()][pAux.getColumna()]
                            += pAux.getDato() * pAux2.getDato();
                }
                pAux2 = pAux2.getLF();
            }
            pAux = pAux.getLF();
        }

        /*for (int i = 0; i < mResultante.length; i++) {
            for (int j = 0; j < mResultante[0].length; j++) {
                System.out.print(mResultante[i][j] + " ");
            }
            System.out.println("");
        }*/
        MatrizF2 mAux = new MatrizF2();
        mAux.setMatrizNomal(mResultante);
        mAux.pasarAForma2(mResultante);
        mAux.pasarAForma2(mResultante);
        mAux.mostrarF2();
    }

    public void comparaMatF2(Nodo M1, Nodo M2) {

        Nodo pAux = M1.getLF();
        Nodo pAux2 = M2.getLF();
        boolean iguales = true;

        while (pAux != M1) {
            if ((pAux.getFila() == pAux2.getFila())
                    && ((pAux.getColumna() == pAux2.getColumna()))
                    && (pAux.getDato() == pAux2.getDato())) {
                iguales = true;
            } else {
                iguales = false;
            }
            pAux = pAux.getLF();
        }

        if (iguales) {
            System.out.println("Las matrises son IGUALES ");
        } else {
            System.out.println("Las matrises son DIFERENTES ");
        }

    }
}
